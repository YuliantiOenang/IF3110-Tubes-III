package databaseLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Config.GlobalConfig;

public class DatabaseAdapter {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public DatabaseAdapter() {
        // Koneksiin ke MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
            GlobalConfig.init();
            con = DriverManager.getConnection(GlobalConfig.URLSQL, GlobalConfig.SQLUser, GlobalConfig.SQLPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String Query) {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertQuery(String Query) {
        try {
            stmt = con.createStatement();
            stmt.execute(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuery(String Query) {
        // khusus delete
        try {
            stmt = con.createStatement();
            stmt.execute(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   public void endQuery() {
        try { 
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// end finally try
        }
    }

    public ResultSet getQueryResult() {
        if (rs == null) {
            System.out.println("Keanehan");
            return null;
        } else
            return rs;
    }

}
