/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class kartukredit extends HttpServlet {
     private String databaseURL, username, password;
    String nokartu,namakartu,tglkadaluwarsa;
    @Override
   public void init(ServletConfig config) throws ServletException {
      // Retrieve the database-URL, username, password from webapp init parameters
      super.init(config);
      ServletContext context = config.getServletContext();
      databaseURL = context.getInitParameter("databaseURL");
      username = context.getInitParameter("username");
      password = context.getInitParameter("password");
   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        Connection conn = null;
        Statement stmt = null;
        try {
           nokartu = request.getParameter("nokartu");
           namakartu = request.getParameter("namakartu");
           tglkadaluwarsa = request.getParameter("tglkadaluwarsa");
           try {
                Class.forName("com.mysql.jdbc.Driver");
            }catch(Exception e) {
                out.println("Unable to load Driver");
            }
            // Step 1: Create a database "Connection" object
            conn = DriverManager.getConnection(databaseURL, username, password);
            
            // Step 2: Create a "Statement" object inside the "Connection"
            stmt = conn.createStatement();

            // Step 3: Execute a SQL SELECT query
            String sqlStr = "INSERT INTO kartukredit(nokartu,namakartu,tglkadaluwarsa) VALUES ('"+nokartu+"','"+namakartu+"','"+tglkadaluwarsa+"')";
                
            stmt.executeUpdate(sqlStr); // Send the query to the server

            // Step 4: Process the query result
            response.sendRedirect("index.jsp");
        } catch(Exception e){
            
        } finally {            
            out.close();
        }
    }    
}
