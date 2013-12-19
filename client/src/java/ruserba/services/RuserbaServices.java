/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

/**
 *
 * @author Ahmad Fauzan
 */
public class RuserbaServices {
    public static String address = "http://azon04.ap01.aws.af.cm/";
    
    public static JSONObject GetBarangByKategori(int id) {
        try {
            return GetResponse(address+"services/barang.php?kategori="+id);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static JSONObject GetBarangByKategori(int id, int limit) {
        try {
            return GetResponse(address+"services/barang.php?kategori="+id+"&limit="+limit);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static JSONObject GetBarangByKategori(int id, int limit, int idx) {
        try {
            return GetResponse(address+"services/barang.php?kategori="+id+"&limit="+limit+"&idx="+idx);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static JSONObject GetKategori(int id) {
        try {
            return GetResponse(address+"services/kategori.php?id="+id);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static JSONObject GetKategori() {
        try {
            return GetResponse(address+"services/kategori.php");
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static JSONObject GetBarangByKategori(int id, int limit, int idx, String sortby, int sortType) {
        try {
            return GetResponse(address+"services/barang.php?kategori="+id+"&limit="+limit+"&idx="+idx+"&sortby="
                    +sortby+"&sorttype="+(sortType == 0 ? "asc" : "desc"));
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static boolean DeleteBarang(int id) {
        try {
            JSONObject returnObj = GetResponse(address+"services/barang.php?delete_id="+id);
            return returnObj.getString("status").equalsIgnoreCase("success");
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public static boolean EditBarang(int id,String nama, int harga, String gambar, int tersedia) {
        try {
            JSONObject returnObj = GetResponse(address+"services/barang.php?id_barang="+id+"&nama="+nama
                    +"&harga="+harga+"&gambar="+gambar+"&tersedia="+tersedia);
            return returnObj.getString("status").equalsIgnoreCase("success");
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public static boolean AddBarang(String nama_barang, int category, int harga, String imageName, int tersedia) {
        
            ArrayList<String> params = new ArrayList<String>();
            params.add(nama_barang);
            params.add(""+category);
            params.add(""+harga);
            params.add(imageName);
            params.add(""+tersedia);
            JSONObject returnObj = SOAPConnect(address+"/services/soap_server.php", "create_barang", params);
            return returnObj.getString("status").equalsIgnoreCase("success");
        
    }
    public static boolean EditBarang(int id,String nama, int harga, int tersedia) {
        try {
            JSONObject returnObj = GetResponse(address+"services/barang.php?id_barang="+id+"&nama="+nama
                    +"&harga="+harga+"&tersedia="+tersedia);
            return returnObj.getString("status").equalsIgnoreCase("success");
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public static JSONObject GetBarang(int id) {
        try {
            return GetResponse(address+"services/barang.php?id_barang="+id);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    private static JSONObject GetResponse(String address) throws ParseException {
        String res = "";
        try {
            URL url = new URL(address);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            for(String line; (line = reader.readLine()) != null;) {
                res += line;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(RuserbaServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RuserbaServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RuserbaServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new JSONObject(res);
    }
    
    private static JSONObject SOAPConnect(String uri, String funcName, ArrayList<String> parameter) {
         try {
            // First create the connection
              SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
              SOAPConnection connection = soapConnFactory.createConnection();

              // Next, create the actual message
              MessageFactory messageFactory = MessageFactory.newInstance();
              SOAPMessage message = messageFactory.createMessage();

              SOAPPart soapPart = message.getSOAPPart();
              SOAPEnvelope envelope = soapPart.getEnvelope();
              
               // Create and populate the body
                SOAPBody body = envelope.getBody();

                // Create the main element and namespace
                SOAPElement bodyElement = body.addChildElement(envelope.createName(funcName,"ns1", "urn:framework"));

                for(int i=0; i < parameter.size(); i++) {
                    bodyElement.addChildElement("in"+i).addTextNode(parameter.get(i));
                }
                

          // Save the message
          message.saveChanges();


          // Send the message and get the reply
          SOAPMessage reply = connection.call(message, uri);
          
          // Retrieve the result - no error checking is done: BAD!
          soapPart = reply.getSOAPPart();
          envelope = soapPart.getEnvelope();
          body = envelope.getBody();
          
          System.out.println("Body : " + body.getTextContent());
         
          // Close the connection           
          connection.close();
          
          return new JSONObject(body.getTextContent());
          
        } catch (SOAPException ex) {
            Logger.getLogger(RuserbaServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperationException ex) {
            Logger.getLogger(RuserbaServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RuserbaServices.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         JSONObject result = new JSONObject();
         result.put("status", "failed");
         return result;
    }
}
