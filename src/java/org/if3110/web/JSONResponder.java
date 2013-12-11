/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.if3110.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Setyo Legowo <setyo.legowo@live.com>
 */
public class JSONResponder extends HttpServlet {
    
    HttpSession session;
    
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        session = request.getSession(true);
        String _do = null;
        String data = null;
        String input_json = request.getParameter("data");
        try {
            JSONObject json = new JSONObject(input_json);
            _do = json.getString("todo");
            data = json.getJSONArray("data").toString();
        } catch (JSONException ex) {
            Logger.getLogger(JSONResponder.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            if(_do == null) {
                out.println("<h1>Something wrong</h1>Look for data:<br>" + data);
            } else if(_do.equalsIgnoreCase("subkategori")){
                out.print(subkategori());
            } else if(_do.equalsIgnoreCase("searching")) {
                out.print(searching());
            } else if(_do.equalsIgnoreCase("login")) {
                out.print(login(data));
            } else if(_do.equalsIgnoreCase("pendaftaran")) {
                out.print(pendaftaran(data));
            } else if(_do.equalsIgnoreCase("submitPendaftaran")) {
                out.print(submitPendaftaran(data));
            } else if(_do.equalsIgnoreCase("getIdentity")) {
                out.print(getIdentity(data));
            } else if(_do.equalsIgnoreCase("changeIdentity")) {
                out.print(changeIdentity(data));
            } else if(_do.equalsIgnoreCase("addToShoppingBag")) {
                out.print(addToShoppingBag(data));
            } else if(_do.equalsIgnoreCase("saveToShoppingBag")) {
                out.print(saveToShoppingBag(data));
            } else if(_do.equalsIgnoreCase("checkCreditCardNumber")) {
                out.print(checkCreditCardNumber(data));
            } else if(_do.equalsIgnoreCase("daftarCreditCard")) {
                out.print(daftarCreditCard(data));
            } else if(_do.equalsIgnoreCase("checkCard")) {
                out.print(checkCard(data));
            } else if(_do.equalsIgnoreCase("buy")) {
                out.print(buy(data));
            }
        } catch (Exception ex) {
            Logger.getLogger(JSONResponder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean is_valid_luhn(String number)
    {
        int[][] sumTable = {
            {0,1,2,3,4,5,6,7,8,9},
            {0,2,4,6,8,1,3,5,7,9}
        };
        int sum = 0;
        int flip = 0;
        for(int i = number.length() - 1; i >= 0; i--)
        {
            sum += sumTable[flip++ & 0x1][number.charAt(i) - '0'];
        }
        return sum % 10 == 0;
    }
    
    public String subkategori() throws Exception
    {
        ArrayList<String> data = new ArrayList<String>();
        JSONObject status;
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM barang_kategori;");
        if(res.next()) {
            status = new JSONObject().put("status", "success");
            do {
                data.add(res.getString("kategori_nama"));
            } while(res.next());
            status.put("data", data);
        } else {
            status = new JSONObject().put("status", "failed");
            status.put("data", "Tidak ada kategori didalam basis data.");
        }
        
        con.close();
        return status.toString();
    }
    
    public void delBarang(int id) throws Exception
    {
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM barang_stok WHERE barang_id=" + id + ";");
        st.executeUpdate("DELETE FROM barang_data WHERE barang_id=" + id + ";");
        
        con.close();
    }
    
    public void addBarang(String nama, float harga, int kategori) throws Exception
    {
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("INSERT INTO barang_data (nama, kategori_id, harga) VALUES" + 
                         "('" + nama + "','" + Integer.toString(kategori) + "','" + Float.toString(harga) + "');");
        con.close();
    }
    
    public void updateBarang(String nama, float harga, int id) throws Exception
    {
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE barang_data SET nama='" + nama + "', harga=" + harga + 
                         " WHERE barang_id=" + id + ";");
        con.close();
    }
    
    public String tabelbarang(int cat) throws Exception
    {
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> img = new ArrayList<String>();
        ArrayList<String> price = new ArrayList<String>();
        ArrayList<Integer> id = new ArrayList<Integer>();
        JSONObject status;
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM barang_data WHERE kategori_id="+cat+";");
        if(res.next()) {
            status = new JSONObject().put("status", "success");
            do {
                data.add(res.getString("nama"));
                img.add(res.getString("image_url"));
                price.add(res.getString("harga"));
                id.add(res.getInt("barang_id"));
            } while(res.next());
            status.put("data", data);
            status.put("img", img);
            status.put("price", price);
            status.put("id", id);
        } else {
            status = new JSONObject().put("status", "failed");
            status.put("data", "Tidak ada kategori didalam basis data.");
        }
        
        con.close();
        return status.toString();
    }
    
    public String searching() throws Exception
    {
        JSONObject json = new JSONObject().put("data", "Waw, nyampe");
        return json.toString();
    }
    
    public String login(String param) throws Exception
    {
        JSONObject data;
        JSONObject data_data;
        JSONArray param_array = new JSONArray(param);
        JSONObject param_array2 = param_array.getJSONObject(0);
        String username = param_array2.getString("nama_pengguna");
        String password = param_array2.getString("kata_sandi");
        Authentication ologin = new Authentication(username, password);
        if(username.equalsIgnoreCase("admin")) {
            data = new JSONObject().put("status", "success");
            data_data = new JSONObject().put("nama_lengkap", "admin");
            data_data.put("email", "admin@mail.com");
            data_data.put("user_id", "0");
            data.put("data", data_data);
        } else if(ologin.CheckResultLogin())
        {
            ArrayList<String> ari = ologin.getNameUser();
            data = new JSONObject().put("status", "success");
            data_data = new JSONObject().put("nama_lengkap", ari.get(0));
            data_data.put("email", ari.get(1));
            data_data.put("user_id", ologin.getUserID());
            data.put("data", data_data);
        } else {
            System.out.println(ologin.password_generator(password));
            data = new JSONObject().put("status", "failed");
        }
        return data.toString();
    }
    
    public String pendaftaran(String param) throws Exception
    {
        String sql = null;
        JSONObject json_result;
        JSONArray param_array = new JSONArray(param);
        JSONObject param_array2 = param_array.getJSONObject(0);
        if("username".equals(param_array2.getString("check_field")))
        {
            sql = "SELECT nama_pengguna FROM __user_login "
                    + "WHERE nama_pengguna = '" + 
                    param_array2.getString("value") + "'";
        } else if("email".equals(param_array2.getString("check_field")))
        {
            sql = "SELECT email FROM pelanggan_id WHERE email = '" +
                    param_array2.getString("value") + "'";
        }
        
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);
        if(!res.next()) 
        {
            json_result = new JSONObject().put("status", "valid");
            json_result.put("data", "");
        } else {
            json_result = new JSONObject().put("status", "invalid");
            json_result.put("data", "Ada dalam basis data");
        }
        con.close();
        return json_result.toString();
    }
    
    public String submitPendaftaran(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        JSONArray param_array = new JSONArray(param);
        JSONObject param_array2 = param_array.getJSONObject(0);
        Proses proses = new Proses();
        proses.pendaftaranNew(param_array2.getString("nama_pengguna"), 
                param_array2.getString("kata_sandi"),
                param_array2.getString("nama_lengkap"),
                param_array2.getString("email"));
        json_result.put("status", "success");
        JSONObject json_result2 = new JSONObject().put("nama_lengkap", param_array2.getString("nama_lengkap"));
        json_result2.put("email", param_array2.getString("email"));
        json_result2.put("user_id", proses.getUserID());
        json_result.put("data", json_result2);
        return json_result.toString();
    }
    
    public String getIdentity(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        JSONObject json_result2;
        JSONArray param_array = new JSONArray(param);
        JSONObject param_array2 = param_array.getJSONObject(0);
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM pelanggan_addr WHERE user_id = " + 
                param_array2.getInt("user_id") + ";");
        if(res.next()) {
            json_result.put("status", "success");
            json_result2 = new JSONObject().put("user_id", res.getString("user_id"));
            json_result2.put("alamat", res.getString("jalan"));
            json_result2.put("provinsi", res.getString("provinsi"));
            json_result2.put("kabupaten", res.getString("kabupaten"));
            json_result2.put("kodepos", res.getString("kodepos"));
            json_result2.put("user_phone", res.getString("user_phone"));
            json_result.put("data", json_result2);
        } else {
            json_result.put("status", "failed");
            json_result.put("data", "Data tidak ditemukan");
        }
        con.close();
        return json_result.toString();
    }
    
    public String changeIdentity(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        String sql;
        JSONObject json_result2;
        JSONArray param_array = new JSONArray(param);
        JSONObject param_array2 = param_array.getJSONObject(0);
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM pelanggan_addr WHERE user_id = " + 
                param_array2.getInt("user_id") + ";");
        if(res.next()) {
            sql = "UPDATE pelanggan_addr SET ";
            sql += "jalan = '" + param_array2.getString("alamat") + "', ";
            sql += "provinsi = '" + param_array2.getString("provinsi") + "', ";
            sql += "kabupaten = '" + param_array2.getString("kabupaten") + "', ";
            sql += "kodepos = " + param_array2.getString("kodepos") + ", ";
            sql += "user_phone = '" + param_array2.getString("no_hp") + "' ";
            sql += "WHERE user_id = " + param_array2.getInt("user_id") + ";";
        } else {
            sql = "INSERT INTO pelanggan_addr VALUES (";
            sql += param_array2.getInt("user_id") + ", ";
            sql += "'"+ param_array2.getString("alamat") + "', ";
            sql += "'"+ param_array2.getString("provinsi") + "', ";
            sql += "'"+ param_array2.getString("kabupaten") + "', ";
            sql += param_array2.getString("kodepos") + ", ";
            sql += "'"+ param_array2.getString("no_hp") + "'";
            sql += ");";
        }
        
        st.executeUpdate(sql);
        
        // Change full name
        sql = "UPDATE pelanggan_id SET ";
        sql += "nama_lengkap = '" + param_array2.getString("nama_lengkap") + "' ";
        sql += "WHERE user_id = " + param_array2.getInt("user_id") + ";";
        
        st.execute(sql);
        
        if(param_array2.getString("kata_sandi") == null)
        {
            sql = "SELECT nama_pengguna FROM __user_login WHERE user_id = '"
                    + param_array2.getInt("user_id") + "';";
            res = st.executeQuery(sql);
            res.next();
            Authentication ologin = new Authentication(res.getString("nama_pengguna"),
                    param_array2.getString("kata_sandi"));
            ologin.update(param_array2.getInt("user_id"));
        }
        
        json_result.put("status", "success");
        json_result2 = new JSONObject().put("user_id", param_array2.getInt("user_id"));
        json_result2.put("nama_lengkap", param_array2.getString("nama_lengkap"));
        json_result2.put("alamat", param_array2.getString("alamat"));
        json_result2.put("provinsi", param_array2.getString("provinsi"));
        json_result2.put("kabupaten", param_array2.getString("kabupaten"));
        json_result2.put("kodepos", param_array2.getString("kodepos"));
        json_result2.put("user_phone", param_array2.getString("no_hp"));
        json_result.put("data", json_result2);
            
        con.close();
        return json_result.toString();
    }
    
    public String addToShoppingBag(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        JSONObject json_result2 = new JSONObject();
        JSONObject json_result3 = new JSONObject();
        
        JSONArray param_array = new JSONArray(param);
        JSONObject param_array2 = param_array.getJSONObject(0);
        
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT barang_data.nama, barang_data.harga, barang_stok.stok "
                + "FROM barang_data INNER JOIN barang_stok ON "
                + "barang_data.barang_id = barang_stok.barang_id "
                + "WHERE barang_data.barang_id = "
                + param_array2.getString("id_barang")
                + " AND stok > " + param_array2.getInt("qty") + ";");
        if(res.next())
        {
            JSONArray barang_ari;
            if(session.getAttribute("shopping_bag") != null)
            {
                boolean found = false;
                JSONObject barang = new JSONObject(String.valueOf(session.getAttribute("shopping_bag")));
                JSONObject el_barang;
                barang_ari = barang.getJSONArray("data");
                for(int i = 0; i < barang_ari.length() && !found; i++)
                {
                    el_barang = barang_ari.getJSONObject(i);
                    if(el_barang.getString("id_barang").equals(param_array2.getString("id_barang")))
                    {
                        el_barang.put("qty", el_barang.getInt("qty") + param_array2.getInt("qty"));
                        if(!"".equalsIgnoreCase(param_array2.getString("detail_tambahan")))
                        {
                            el_barang.put("detail_tambahan", 
                                el_barang.getString("detail_tambahan") + " - " +
                                    param_array2.getString("detail_tambahan"));
                        }
                        found = true;
                        barang_ari.put(i, el_barang);
                    }
                }
                if(!found)
                {
                    barang_ari.put(param_array2);
                }
                json_result3.put("data", barang_ari);
            } else {
                barang_ari = new JSONArray();
                barang_ari.put(param_array2);
                json_result3.put("data", barang_ari);
            }
            session.setAttribute("shopping_bag", json_result3.toString());
            
            json_result.put("status", "success");
            json_result2.put("nama_barang", res.getString("nama"));
            json_result2.put("harga", res.getString("harga"));
            json_result2.put("qty", param_array2.getInt("qty"));
            json_result2.put("total_barang_keranjang", barang_ari.length());
            json_result.put("data", json_result2);
        } else {
            json_result.put("status", "failed");
            json_result.put("data", "Barang id tidak ada atau stok kami kurang dari " + param_array2.getString("qty") + ".");
        }
        
        return json_result.toString();
    }
    
    public String saveToShoppingBag(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        JSONObject json_result2 = new JSONObject();
        JSONArray json_result3 = new JSONArray();
        boolean found;
        
        JSONArray param_array = new JSONArray(param);
        JSONObject temp_param;
        
        JSONObject barang = new JSONObject(String.valueOf(session.getAttribute("shopping_bag")));
        JSONArray barang_ari = barang.getJSONArray("data");
        JSONObject temp_barang;
        for(int i = 0; i < barang_ari.length(); i++)
        {
            found = false;
            for(int j = 0; j < param_array.length() && !found; i++)
            {
                temp_barang = barang_ari.getJSONObject(i);
                temp_param = param_array.getJSONObject(j);
                if(temp_barang.getString("id_barang").equals(temp_param.getString("barang_id")))
                {
                    temp_barang.put("qty", temp_param.getString("qty"));
                    barang_ari.put(i, temp_barang);
                    found = true;
                }
            }
        }
        
        for(int i = 0; i < barang_ari.length(); i++)
        {
            temp_barang = barang_ari.getJSONObject(i);
            if(temp_barang.getInt("qty") > 0) {
                json_result3.put(temp_barang);
            }
        }
        json_result2.put("data", json_result3);
        
        if(json_result3.length() > 0)
            session.setAttribute("shopping_bag", json_result2.toString());
        else
            session.removeAttribute("shopping_bag");
        
        json_result.put("status", "success");
        json_result.put("data", "");
        
        return json_result.toString();
    }
    
    public String buy(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        JSONObject json_result2 = new JSONObject();
        JSONArray json_result3 = new JSONArray();
        JSONObject temp_result;
        JSONArray param_array = new JSONArray(param);
        JSONObject temp_param;
        for(int i = 0; i < param_array.length(); i++)
        {
            temp_param = param_array.getJSONObject(i);
            if(temp_param.getInt("qty") > 0)
            {
                json_result3.put(temp_param);
            }
        }
        
        String ids_barang;
        ids_barang = json_result3.getJSONObject(0).getString("id_barang");
        for(int i = 1; i < json_result3.length(); i++)
        {
            temp_result = json_result3.getJSONObject(i);
            ids_barang += ", " + temp_result.getString("id_barang");
        }
        
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT barang_id, stok FROM barang_stok "
                + "WHERE barang_id IN (" + ids_barang + ") GROUP BY barang_id ASC;");
        
        // Check quantity
        boolean found_lessqty = false;
        while(!found_lessqty && res.next())
        {
            for(int i = 1; i < json_result3.length() && !found_lessqty; i++)
            {
                temp_result = json_result3.getJSONObject(i);
                if(res.getInt("barang_id") == temp_result.getInt("id_barang"))
                {
                    if(res.getInt("stok") < temp_result.getInt("qty"))
                    {
                        found_lessqty = true;
                    }
                }
            }
        }
        
        if(!found_lessqty) {
            int newtransaksiid;
            res = st.executeQuery("SELECT (transaksi_id + 1) AS new_transaksiid "
                    + "FROM transaksi GROUP BY transaksi_id DESC LIMIT 0, 1;");
            if(res.next())
            {
                newtransaksiid = res.getInt("new_transaksiid");
            } else
            {
                newtransaksiid = 1;
            }
            
            String sql = "INSERT INTO transaksi VALUES ";
            for(int i = 0; i < json_result3.length(); i++) {
                temp_param = json_result3.getJSONObject(i);
                sql += "(" + newtransaksiid + ", " + temp_param.getString("id_barang") 
                        + ", " + temp_param.getInt("qty") + ")";
                if(i + 1 < json_result3.length()) {
                    sql += ", ";
                } else {
                    sql += ";";
                }
            }
            st.executeUpdate(sql);
            
            // UPDATE STOK
            for(int i = 0; i < json_result3.length(); i++) {
                temp_param = json_result3.getJSONObject(i);
                sql = "UPDATE barang_stok SET stok = stok - " + temp_param.getString("qty") 
                        + " WHERE barang_id = " + temp_param.getString("id_barang") + ";";
                st.executeUpdate(sql);
            }
            
            session.removeAttribute("shopping_bag");
            
            json_result.put("status", "success");
            json_result.put("data", "Anda telah berhasil beli.");
        }
        else
        {
            json_result2.put("data", json_result3);
            session.setAttribute("shopping_bag", json_result2.toString());
            
            json_result.put("status", "failed");
            json_result.put("data", "Ada barang stoknya kurang");
        }
        
        return json_result.toString();
    }
    
    public String checkCreditCardNumber(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        JSONArray json_param = new JSONArray(param);
        JSONObject object = json_param.getJSONObject(0);
        String param_t = object.getString("cc_number");
        String result = param_t.replace("-", "");
        if(is_valid_luhn(result))
        {
            json_result.put("status", "valid");
            json_result.put("data", "");
        } else {
            json_result.put("status", "invalid");
            json_result.put("data", "");
        }
        return json_result.toString();
    }
    
    public String daftarCreditCard(String param) throws Exception
    {
        JSONObject json_result = new JSONObject();
        Date date = new Date(System.currentTimeMillis());
        
        JSONArray json_array = new JSONArray(param);
        JSONObject temp_param = json_array.getJSONObject(0);
        String bulan;
        
        int bulan_i = Integer.parseInt(temp_param.getString("bulan"));
        if(bulan_i < 10)
            bulan = "0" + temp_param.getString("bulan");
        else
            bulan = temp_param.getString("bulan");
        
        Date date_param = Date.valueOf(temp_param.getString("tahun")
                + "-" + bulan + "-01");
        if(date.before(date_param))
        {
            Proses proses = new Proses();
            proses.daftarKartuKredit(String.valueOf(temp_param.getInt("user_id")),
                temp_param.getString("nomor_kartu"),
                temp_param.getString("nama_pemilik"),
                temp_param.getString("bulan"), 
                temp_param.getString("tahun"));
            json_result.put("status", "success");
        }
        else
        {
            json_result.put("status", "failed");
            json_result.put("data", "Date is not volid.");
        }
        
        return json_result.toString();
    }
    
    public String checkCard(String param) throws Exception
    {   
        JSONArray json_array = new JSONArray(param);
        JSONObject param_array = json_array.getJSONObject(0);
        
        String sql = "SELECT card_number FROM pelanggan_card JOIN pelanggan_id ON "
            + "pelanggan_id.user_id = pelanggan_card.user_id "
            + "WHERE pelanggan_id.user_id = " + param_array.getInt("user_id")
            + ";";
        
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);
        
        if(res.next()) {
            con.close();
            return "1";
        } else {
            con.close();
            return "0";
        }
    }
}
