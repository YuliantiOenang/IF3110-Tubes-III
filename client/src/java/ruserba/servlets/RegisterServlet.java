package ruserba.servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ruserba.beans.User;
import ruserba.database.DatabaseHelper;

/**
 *
 * @author Ahmad Fauzan
 */
public class RegisterServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");
        String name = request.getParameter("name");
        String alamatEmail = request.getParameter("email");
        
        DatabaseHelper.Connect();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        Date expDate = cal.getTime();
        
        String key = username + formatter.format(new Date());
        key = encodeText(key, "SHA-1");
        
        System.out.println(key);
        if(DatabaseHelper.execute("insert into user values ('"+username+"','"+password+"','"+key+"','"+ formatter.format(expDate) +"')")) {
            if(DatabaseHelper.execute("insert into user_profile (username,nama,email) values ('"+ username +"','"+ name +"','"+ alamatEmail +"')")) {
                // Registrasi Berhasil
                
                User user = new User();
                user.setUsername(username);
                user.setName(name);
                user.setEmail(alamatEmail);
                
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("registerkartu");
                dispatcher.forward(request, response);
            } else {
                // Registrasi Gagals
                RequestDispatcher dispatcher = request.getRequestDispatcher("register");
                dispatcher.forward(request, response);
            }
        } else {
            // Registrasi Gagal
            RequestDispatcher dispatcher = request.getRequestDispatcher("register");
            dispatcher.forward(request, response);
        }
        DatabaseHelper.Disconnect();
    }
    
    public static String encodeText(String text, String algorithm) {
        byte[] unencodedPassword = text.getBytes();
        MessageDigest md = null;
        try {
        // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            return text;
        }
        md.reset();
        // call the update method one or more times
        // (useful when you don't know the size of your data, e.g. stream)
        md.update(unencodedPassword);
        // now calculate the hash
        byte[] encodedPassword = md.digest();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < encodedPassword.length; i++) {
            if (((int) encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
        }
        return buf.toString();
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
        processRequest(request, response);
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
