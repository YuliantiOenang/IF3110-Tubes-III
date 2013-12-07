/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import ruserba.beans.User;
import ruserba.database.DatabaseHelper;

/**
 *
 * @author ize
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String generateToken() {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String token = "";
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            token += alphabet.charAt(rand.nextInt(alphabet.length() - 1));
        }
        return token;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        User user = null;
        
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            String query = "select token, last_login from user where username='" + request.getParameter("username") + "' and password='" + request.getParameter("password") + "'";
            DatabaseHelper.Connect();
            ResultSet result = DatabaseHelper.executeQuery(query);
            try {
                if (result.next()) {
                    String newToken = generateToken();
                    query = "select token from user where token='" + newToken + "'";
                    ResultSet token;
                    do {
                        token = DatabaseHelper.executeQuery(query);
                    } while (token.next());
                    token.close();
                    query = "update user set token='" + newToken + "', last_login='" + new java.sql.Date(new java.util.Date().getTime()).toString() + "' where username='" + request.getParameter("username") + "'";
                    DatabaseHelper.execute(query);
                    json.put("token", newToken);
                    json.put("status", "success");
                    
                    
                    user = new User();
                    user.setUsername(request.getParameter("username"));
                    user.setPassword(request.getParameter("password"));

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                }
                else {
                    json.put("status", "failed");
                }
                result.close();
                out.println(json.toString());
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            DatabaseHelper.Disconnect();
        } else if (request.getParameter("token") != null) {
            String query = "select username, token, last_login, password from user where token='" + request.getParameter("token") + "'";
            DatabaseHelper.Connect();
            ResultSet result = DatabaseHelper.executeQuery(query);
            try {
                if (result.next()) {
                    Date dNow = new Date();
                    Date dLast = result.getDate("last_login");
                    int diff = (int) ((dNow.getTime() - dLast.getTime()) / 1000 / 60 / 60 / 24);
                    if (diff > 30) {
                        query = "update user set token=null, last_login=null where token='" + request.getParameter("token") + "'";
                        json.put("status", "failed");
                    }
                    else {
                        query = "update user set last_login='" + new java.sql.Date(new java.util.Date().getTime()).toString() + "' where token='" + request.getParameter("token") + "'";
                        json.put("status", "success");
                        
                        user = new User();
                        user.setUsername(result.getString("username"));
                        user.setPassword(result.getString("password"));

                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                    }
                    DatabaseHelper.execute(query);
                }
                else {
                    json.put("status", "failed");
                }
                result.close();
                out.println(json.toString());
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            DatabaseHelper.Disconnect();
        } else {
            json.put("status", "failed");
            out.println(json.toString());
        }
        
        if(user != null) {
            try {
                String query = "SELECT * FROM user_profile WHERE username='" + user.getUsername() + "'";
                DatabaseHelper.Connect();
                ResultSet result = DatabaseHelper.executeQuery(query);
                if(result.next()) {
                    
                    user.setAlamat(result.getString("alamat"));
                    user.setEmail(result.getString("alamat"));
                    user.setKodepos(result.getString("kode_pos"));
                    user.setKota(result.getString("kota"));
                    user.setName(result.getString("nama"));
                    user.setPonsel(result.getString("nomor_ponsel"));
                    user.setProvinsi("provinsi");
                    
                }
                DatabaseHelper.Disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        out.close();
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
