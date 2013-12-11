/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myfunction;
import java.io.*;
import java.sql.*;

/**
 *
 * @author A46CB
 */
public class function {
    private Connection conn;
    String output2 = "";
    public function() {
        
        String databaseURL = "jdbc:mysql://localhost:3306/tes";
        String username = "root";
        String password = "";
        try {
             try {
                    Class.forName("com.mysql.jdbc.Driver");
                }catch(Exception e) {
                    System.out.println("Unable to load Driver");
                    output2 = output2 + "drivernya";
                }
            // Step 1: Create a database "Connection" object
            conn = DriverManager.getConnection(databaseURL, username, password);
       
        } catch (SQLException ex) {
            ex.printStackTrace();
            output2 = output2 + ex.toString();
            System.out.println("Unable to connect to database");
        } 
        /* finally {
            System.out.close();
            try {
                // Step 5: Close the Statement and Connection
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        } */
    }
    
    public String get_list_product(String cat) {
        Statement stmt = null;
        String output = "";
        int num = 0;
        try {
            stmt = conn.createStatement();
            String sqlStr = "SELECT * FROM `produk` WHERE kategori ="
                   + "'" + cat + "'" + " ORDER BY `sold` DESC";
            ResultSet rset = stmt.executeQuery(sqlStr); 
            while (rset.next()) {
            String id = (String) rset.getString("id");
            String name = rset.getString("nama");
            String img = rset.getString("image");
            String harga = (String) rset.getString("harga");

                if (num < 4) {

                output = output + "<li>";
                output = output + "<a href=\"product.jsp?id=" + id + "\">";
                output = output + "<img src=\"" + img + "\" alt=\"" + name + "\">";
                output = output + "<p>" + name + " <br />" + harga + " </p>";
                output = output + "</a>";
                output = output + "</li>";
                num++;
                }
            }
                 
        } catch (SQLException ex) {
            ex.printStackTrace();
            output2 = output2 + ex.toString();
        } 
        return output;
    }
    
    public String getAllProducts(String cat) {
        Statement stmt = null;
        String output = "";
        int num = 0;
        try {
            stmt = conn.createStatement();
            String sqlStr = "SELECT * FROM `produk` WHERE kategori ="
                   + "'" + cat + "'";
            ResultSet rset = stmt.executeQuery(sqlStr); 
            while (rset.next()) {
            String id = (String) rset.getString("id");
            String name = rset.getString("nama");
            String img = rset.getString("image");
            String harga = (String) rset.getString("harga");

                output = output + "<li>";
                output = output + "<a href=\"product.jsp?id=" + id + "\">";
                output = output + "<img src=\"" + img + "\" alt=\"" + name + "\">";
                output = output + "<p>" + name + " <br />" + harga + " </p>";
                output = output + "</a>";
                output = output + "</li>";
                num++;
                
            }
                 
        } catch (SQLException ex) {
            ex.printStackTrace();
            output2 = output2 + ex.toString();
        } 
        return output;
    }
    
    public product getProduct(int id) {
        Statement stmt = null;
        product output = new product();
        
        try {
            stmt = conn.createStatement();
            String sqlStr = "SELECT * FROM `produk` WHERE id ="
                   + "'" + id + "'";
            ResultSet rset = stmt.executeQuery(sqlStr); 
            while (rset.next()) {
            
            String name = rset.getString("nama");
            String sold = rset.getString("sold");
            String stok = rset.getString("stok");
            String kategori = rset.getString("kategori");
            String img = rset.getString("image");
            String harga = (String) rset.getString("harga");
            String keterangan = rset.getString("keterangan");

               output.id = id;
               output.nama = name;
               output.harga = Integer.parseInt(harga);
               output.sold = Integer.parseInt(sold);
               output.stok = Integer.parseInt(stok);
               output.kategori = kategori;
               output.image = img;
               output.keterangan = keterangan;
               
            }
                 
        } catch (SQLException ex) {
            ex.printStackTrace();
            output2 = output2 + ex.toString();
        } 
        return output;
    }
    
    public user getProfil(String username) {
        Statement stmt = null;
        user output = new user();
        
        try {
            stmt = conn.createStatement();
            String sqlStr = "SELECT * FROM `user` WHERE username ="
                   + "'" + username + "'";
            ResultSet rset = stmt.executeQuery(sqlStr); 
            while (rset.next()) {
            
            output.id = Integer.parseInt(rset.getString("id"));
            output.username = username;
            output.nama = rset.getString("nama");
            output.nohp = rset.getString("nohp");
            output.alamat = rset.getString("alamat");
            output.provinsi = rset.getString("provinsi");
            output.kota = rset.getString("kota");
            output.kodepos = rset.getString("kodepos");
            output.email = rset.getString("email");
            output.password = rset.getString("password");
            output.transaksi = Integer.parseInt(rset.getString("transaksi"));
            output.balance = Integer.parseInt(rset.getString("balance"));

            }
                 
        } catch (SQLException ex) {
            ex.printStackTrace();
            output2 = output2 + ex.toString();
        } 
        return output;
    }
    
    public String search(String key) {
        Statement stmt = null;
        String output = "";
       
        try {
            stmt = conn.createStatement();
            String sqlStr = "SELECT * FROM `produk` WHERE nama LIKE "
                   + "'" + key + "'";
            ResultSet rset = stmt.executeQuery(sqlStr); 
            while (rset.next()) {
            String id = (String) rset.getString("id");
            String name = rset.getString("nama");
            String harga = (String) rset.getString("harga");

                output = output + "<li>";
                output = output + "<a href=\"product.jsp?id=" + id + "\">";
                output = output + "<p>" + name +  " </p>";
                output = output + "</a>";
                output = output + "</li>";
                
                
            }
                 
        } catch (SQLException ex) {
            ex.printStackTrace();
            output2 = output2 + ex.toString();
        } 
        return output;
    }
}
