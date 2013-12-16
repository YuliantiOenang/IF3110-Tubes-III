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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static boolean EditBarang(int id,String nama, int harga, String gambar, int tersedia, int dibeli) {
        try {
            JSONObject returnObj = GetResponse(address+"services/barang.php?id_barang="+id+"&nama="+nama
                    +"&harga="+harga+"&gambar="+gambar+"&tersedia="+tersedia+"&dibeli="+dibeli);
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
}
