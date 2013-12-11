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
public class register extends HttpServlet {

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
        String username2 = request.getParameter("username");
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
            String sqlStr = "INSERT INTO user(username, nama, nohp, alamat, provinsi, kota, kodepos, email, password) VALUES ("
                    + "'" + username2 + "'" + ","
                    + "'" + nama + "'" + ","
                    + "'" + noHP + "'" + ","
                    + "'" + alamat + "'" + ","
                    + "'" + provinsi + "'" + ","
                    + "'" + kota + "'" + ","
                    + "'" + kodepos + "'" + ","
                    + "'" + email + "'" + ","
                    + "'" + password2 + "'" + ")";
            
            try {
            stmt.executeUpdate(sqlStr); // Send the query to the server
            }catch (SQLException ex) {
                out.print(ex.toString());
            }
            // Step 4: Set cookie and session
           HttpSession session = request.getSession();
            session.setAttribute("user", username2);
            session.setAttribute("role", "user");
            //setting session to expiry in 30 mins
            //session.setMaxInactiveInterval(30 * 60);
            Cookie cookie = new Cookie("user", username2);
            cookie.setMaxAge(2592000);
            response.addCookie(cookie);
            Cookie cookie2 = new Cookie("role", "user");
            cookie2.setMaxAge(2592000);
            response.addCookie(cookie2);
            response.sendRedirect("registerkredit.jsp");
            
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
