package com.ruserba.web;

import com.ruserba.model.Database;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
public class DatabaseInit implements ServletContextListener {
 	
    public void contextInitialized(ServletContextEvent event) {
    	ServletContext sc = event.getServletContext();
 
    	String db_url = sc.getInitParameter("db_url");
    	String db_username = sc.getInitParameter("db_username");
    	String db_password = sc.getInitParameter("db_password");
    	String db_name = sc.getInitParameter("db_name");
    	Database db = new Database(db_url + db_name, db_username, db_password);
    	sc.setAttribute("db", db);
     }
 
    public void contextDestroyed(ServletContextEvent arg0) {

    }
 
}
