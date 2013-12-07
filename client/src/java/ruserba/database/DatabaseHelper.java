/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Fauzan
 */
public class DatabaseHelper {
    
    static String DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/ruserba";
    static String DB_USER = "root";
    static String DB_PASS = "";
    static Connection conn;
    static Statement smt;
    
    public static void Connect() { 
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet executeQuery(String sql) {
        try {
            smt = conn.createStatement();
            ResultSet result = smt.executeQuery(sql);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean execute(String sql) {
        try {
            System.out.println("HASIL");
            smt = conn.createStatement();
            smt.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("GAGAL");
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }     
    }
    
    public static void Disconnect() {
        if(conn != null) {
            try {
                if(smt != null)
                    smt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
