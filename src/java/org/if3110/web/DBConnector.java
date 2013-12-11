/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.if3110.web;

import java.sql.Connection;
import javax.naming.Context;
import java.net.URI;
import java.sql.*;
import java.net.URISyntaxException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Setyo Legowo <setyo.legowo@live.com>
 */
public class DBConnector {
    private static DBConnector connector_ = null;
    public static DBConnector getInstance()
            throws Exception {
        if(connector_ == null) {
            connector_ = new DBConnector();
        }
        return connector_;
    }
    public Connection getConnection()
            throws Exception {
    	//URI dbUri = new URI(System.getenv("postgres://vipduorpwbfnzo:YYtNSv3tcPGJs7YUyAOiiW0KxO@ec2-54-225-124-205.compute-1.amazonaws.com:5432/d86coev9sq2g1b"));
        try{
            Class.forName("org.postgresql.Driver");     
       }

       catch(ClassNotFoundException e)
       {
          e.printStackTrace();
       }
        String username = "vipduorpwbfnzo";
        String password = "YYtNSv3tcPGJs7YUyAOiiW0KxO";
        String dbUrl = "jdbc:postgresql://" + "ec2-54-225-124-205.compute-1.amazonaws.com:5432" + "/d86coev9sq2g1b";
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        return connection;
    }
    //postgres://vipduorpwbfnzo:YYtNSv3tcPGJs7YUyAOiiW0KxO@ec2-54-225-124-205.compute-1.amazonaws.com:5432/d86coev9sq2g1b
}
