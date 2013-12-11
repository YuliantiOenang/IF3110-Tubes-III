/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author A46CB
 */
public class editprofile extends HttpServlet {

   private String databaseURL, username, password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // Retrieve the database-URL, username, password from webapp init parameters
        super.init(config);
        ServletContext context = config.getServletContext();
        databaseURL = context.getInitParameter("databaseURL");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username2 = request.getParameter("userlama");
		String nama = request.getParameter("namalengkap");
		String noHP = request.getParameter("nomor");
		String alamat = request.getParameter("alamat");
		String provinsi = request.getParameter("provinsi");
		String kota = request.getParameter("kota");
		String kodepos = request.getParameter("kodepos");
		String email = request.getParameter("email");
		String password2 = request.getParameter("password1");
                
         PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;
        try {
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
            String sqlStr = "UPDATE user SET nama='"+nama+"', nohp='"+noHP
                    +"', alamat='"+alamat+"', provinsi='"+provinsi+"', kota='"
                    +kota+"', kodepos='"+kodepos+"', email='"+email+"', password='"
                    +password2+"' WHERE username='"+username2+"'";

            
            try {
            stmt.executeUpdate(sqlStr); // Send the query to the server
            }catch (SQLException ex) {
                out.print(ex.toString());
            }

            response.sendRedirect("profil.jsp");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            out.println("Unable to connect to database");
        } finally {
            out.close();
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
        }
    }
}
