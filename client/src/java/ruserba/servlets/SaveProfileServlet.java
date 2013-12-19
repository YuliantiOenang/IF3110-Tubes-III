/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class SaveProfileServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String alamat = request.getParameter("alamat");
        String kotakabupaten = request.getParameter("kotakabupaten");
        String kodepos = request.getParameter("kodepos");
        String provinsi = request.getParameter("provinsi");
        String nohp = request.getParameter("nohp");
        
        
        if(name != null && user != null) {
            String query = "update user set password='"+ password +"' where username='" + user.getUsername() + "'";
            DatabaseHelper.Connect();
            DatabaseHelper.execute(query);
            query = "update user_profile set nama='"+ name +
                    "', alamat='"+ alamat 
                    +"', kota='" + kotakabupaten + 
                    "', kode_pos='"+ kodepos +
                    "', provinsi='"+provinsi+
                    "', nomor_ponsel='"+ nohp +"' where username='" + user.getUsername() + "'";
            user.setName(name);
            user.setAlamat(alamat);
            user.setKota(kotakabupaten);
            user.setKodepos(kodepos);
            user.setProvinsi(provinsi);
            user.setPonsel(nohp);
            
            DatabaseHelper.execute(query);
            DatabaseHelper.Disconnect();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("profile");
        dispatcher.forward(request, response);
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
