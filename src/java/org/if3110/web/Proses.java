/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.if3110.web;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Setyo Legowo <setyo.legowo@live.com>
 */
public class Proses {
    private int __id_num;
    public void pendaftaranNew(String nama_pengguna, String kata_sandi,
        String nama_lengkap, String email) throws Exception
    {
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT (user_id + 1) AS num "
            + "FROM pelanggan_id GROUP BY user_id DESC LIMIT 0, 1");
        res.next();
        int new_number = res.getInt("num");
        
        // save to DB
        String sql = "INSERT INTO pelanggan_id VALUES (";
        sql += new_number + ", '" + nama_lengkap + "', '" + email + "');";
        st.executeUpdate(sql);
        
        Authentication ologin = new Authentication(nama_pengguna, kata_sandi);
        ologin.save(new_number);
        
        __id_num = new_number;
        con.close();
    }
    
    public int getUserID() {
        return __id_num;
    }
    
    public JSONObject showKategoriNonFilter(
        String kategori_id, String parameter) throws Exception
    {
        JSONObject json_result = new JSONObject();
        String params = parameter.substring(1);
        String[] elemen = params.split("=");
        int page = Integer.valueOf(elemen[1]);
        
        int limit = 10;
        int base = (page - 1)*limit;
        if(base < 0) base = 0;
        
        // select category name from DB
        String sql = "SELECT kategori_nama FROM barang_kategori WHERE kategori_id = " + kategori_id + ";";
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);
        res.next();
        json_result.put("nama_kategori", res.getString("kategori_nama"));
        
        sql = "SELECT barang_id, nama, harga, image_url "
            + "FROM barang_data WHERE kategori_id = " + kategori_id
            + " LIMIT " + base + "," + limit + ";";
        res = st.executeQuery(sql);
        JSONArray json_result2 = new JSONArray();
        JSONObject json_return;
        while(res.next())
        {
            json_return = new JSONObject().put("barang_id", res.getString("barang_id"));
            json_return.put("nama", res.getString("nama"));
            json_return.put("harga", res.getString("harga"));
            json_return.put("image_url", res.getString("image_url"));
            json_result2.put(json_return);
        }
        json_result.put("data", json_result2);
        con.close();
        return json_result;
    }
    
    public HashMap<String, String> showBarang(String barang)
    {
        HashMap<String, String> ret_map = null;
        try {
            String sql = "SELECT barang_id, nama, harga, image_url, deskripsi "
                + "FROM barang_data WHERE barang_id = " + barang + ";";
            DBConnector dbCon = DBConnector.getInstance();
            Connection con = dbCon.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            res.next();
            ret_map = new HashMap<String, String>();
            ret_map.put("barang_id", res.getString("barang_id"));
            ret_map.put("nama", res.getString("nama"));
            ret_map.put("harga", res.getString("harga"));
            ret_map.put("image_url", res.getString("image_url"));
            ret_map.put("deskripsi", res.getString("deskripsi"));
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Proses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret_map;
    }
    
    public JSONObject showKategoriWithFilter(String kategori_id, String parameter) throws Exception
    {
        JSONObject json_result = new JSONObject();
        
        String params = parameter.substring(1);
        String[] each = params.split("&");
        String[] elemen = each[0].split("=");
        String by = elemen[1];
        elemen = each[1].split("=");
        String sort = elemen[1];
	elemen = each[2].split("=");
	int page = Integer.valueOf(elemen[1]);
        
        int limit = 10;
        int base = (page - 1)*limit;
        if(base < 0) base = 0;
        
        // select category name from DB
        String sql = "SELECT kategori_nama FROM barang_kategori "
            + "WHERE kategori_id = " + kategori_id + ";";
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);
        res.next();
        json_result.put("nama_kategori", res.getString("kategori_nama"));
        
        sql = "SELECT barang_id, nama, harga, image_url FROM barang_data "
            + "WHERE kategori_id = " + kategori_id
            + " ORDER BY " + by + " " + sort + " LIMIT " + base
            + "," + limit + ";";
        res = st.executeQuery(sql);
        JSONObject temp_ret;
        JSONArray json_result2 = new JSONArray();
        while(res.next())
        {
            temp_ret = new JSONObject().put("barang_id", res.getString("barang_id"));
            temp_ret.put("nama", res.getString("nama"));
            temp_ret.put("harga", res.getString("harga"));
            temp_ret.put("image_url", res.getString("image_url"));
            json_result2.put(temp_ret);
        }
        json_result.put("data", json_result2);
        
        con.close();
        return json_result;
    }
    
    public JSONObject showShoppingBag(String param) throws Exception
    {   
        JSONObject json_result = null;
        if(param != null && !param.equalsIgnoreCase("{}"))
        {
            json_result = new JSONObject();
            JSONObject temp_barang = new JSONObject(param);
            JSONArray temp_barang_ari = temp_barang.getJSONArray("data");
            String ids_barang;
            JSONObject temp_barang_el = temp_barang_ari.getJSONObject(0);
            ids_barang = temp_barang_el.getString("id_barang");
            for(int i = 1; i < temp_barang_ari.length(); i++)
            {
                temp_barang_el = temp_barang_ari.getJSONObject(i);
                ids_barang += ", " + temp_barang_el.getString("id_barang");
            }
            
            String sql = "SELECT barang_id, nama, harga, image_url, deskripsi "
                + "FROM barang_data WHERE barang_id IN (" + ids_barang
                + ") GROUP BY barang_id ASC;";
            DBConnector dbCon = DBConnector.getInstance();
            Connection con = dbCon.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            JSONArray json_result2 = new JSONArray();
            JSONObject temp_result;
            double total = 0;
            for(int i = 0; res.next(); i++)
            {
                temp_result = new JSONObject().put("barang_id", res.getString("barang_id"));
                temp_result.put("nama", res.getString("nama"));
                temp_result.put("harga", res.getString("harga"));
                temp_result.put("image_url", res.getString("image_url"));
                temp_result.put("deskripsi", res.getString("deskripsi"));
                for(int j = 0; j < temp_barang_ari.length(); j++)
                {
                    temp_barang_el = temp_barang_ari.getJSONObject(j);
                    if(res.getString("barang_id").equals(temp_barang_el.getString("id_barang")))
                    {
                        temp_result.put("qty", temp_barang_el.getInt("qty"));
                        temp_result.put("detail_tambahan", temp_barang_el.getString("detail_tambahan"));
                    }
                }
                json_result2.put(i, temp_result);
                total += res.getDouble("harga")*temp_result.getInt("qty");
            }
            json_result.put("data", json_result2);
            json_result.put("total", total);
            
            con.close();
        }
        
        return json_result;
    }
    
    public void daftarKartuKredit(String user_id, 
        String nomor_kartu, String pemilik, String bulan_exp,
        String tahun_exp) throws Exception
    {
        Date date = Date.valueOf(tahun_exp + "-" + bulan_exp + "-01");
        
        // Check udah ada atua belum
        String sql = "SELECT user_id FROM pelanggan_card WHERE user_id = "
            + user_id + ";";
        DBConnector dbCon = DBConnector.getInstance();
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);
        
        if(!res.next())
        {
            sql = "INSERT INTO pelanggan_card VALUES (";
            sql += user_id + ", '" + nomor_kartu + "', ";
            sql += "'" + pemilik + "', '" + date + "');";
        } else {
            sql = "UPDATE pelanggan_card SET ";
            sql += "card_number = '" + nomor_kartu + "', ";
            sql += "card_name = '" + pemilik + "', ";
            sql += "card_expiry = '" + date + "'";
            sql += "WHERE user_id = " + user_id + ";";
        }
        
        st.execute(sql);
        
        con.close();
    }
    
    public String getBannerShoppingBag(String shoppinBagString) throws Exception
    {
        String tag = "";
        if(shoppinBagString == null) {
            JSONObject json_result = new JSONObject(shoppinBagString);
            JSONArray json_array = json_result.getJSONArray("data");
            tag = String.valueOf(json_array.length());
        }
        
        return tag;
    }
}
