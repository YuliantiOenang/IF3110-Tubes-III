/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ruserba.beans.Item;
import ruserba.database.DatabaseHelper;

/**
 *
 * @author Ahmad Fauzan
 */
public class EditItemServlet extends HttpServlet {

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
        
        DatabaseHelper.Connect();
        if(request.getParameter("id_barang") == null) {
             Item barang = new Item();
             barang.setCategory(Integer.parseInt(request.getParameter("id_kategori")));
             request.setAttribute("barang", barang);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminadd");
            dispatcher.forward(request, response);
        } else {        
            String query = "SELECT * FROM barang WHERE id_barang=" + request.getParameter("id_barang");
            ResultSet res = DatabaseHelper.executeQuery(query);
            try {
                if(res.next()) {
                    Item barang = new Item();
                    barang.setId(res.getInt("id_barang"));
                    barang.setName(res.getString("nama_barang"));
                    barang.setCategory(res.getInt("id_kategori"));
                    barang.setPrice(res.getInt("harga_barang"));
                    barang.setTersedia(res.getInt("tersedia"));
                    request.setAttribute("barang", barang);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("adminedit");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditItemServlet.class.getName()).log(Level.SEVERE, null, ex);
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin");
                dispatcher.forward(request, response);
            }
        }
        DatabaseHelper.Disconnect();
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
