/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Class.GetConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahdan Ahmad F A
 */
public class cancelcart extends HttpServlet {

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
        String user_check = "";
        if(request.getSession().getAttribute("user_check")==null){
            user_check = "";
        }else{
            user_check  = request.getSession().getAttribute("user_check").toString();
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
            String namabarang = request.getParameter("namabarang");
            
            if (namabarang == null) {
                GetConnection getCon = new GetConnection();
                Connection conn = getCon.getConnection();
            
                ResultSet rs;
                
                Statement stt = conn.createStatement();
        
                String query = "SELECT * FROM cart WHERE profil_ID = '" + user_check + "'";
                
                rs = stt.executeQuery(query);
                
                while (rs.next()) {
                    cancelGood(rs.getString("cart_goods"), request, response);
                }
                
            } else {
                cancelGood(namabarang, request, response);
            }
            
            response.sendRedirect("cart.jsp");
        } catch (Exception exc){
            out.print("Error : ");
            out.print(exc.toString());
        } finally {            
            out.close();
        }
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

    protected void cancelGood(String namabarang, HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        PrintWriter out = response.getWriter();
        
        String user_check = "";
        if(request.getSession().getAttribute("user_check")==null){
            user_check = "";
        }else{
            user_check  = request.getSession().getAttribute("user_check").toString();
        }    
        
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
            
        ResultSet rs_cart;
        ResultSet rs_goods;
        
        Statement stt = conn.createStatement();

        String query_cart   = "SELECT * FROM cart WHERE profil_ID = '" + user_check + "' AND cart_goods = '" + namabarang + "'";
        String query_goods  = "SELECT * FROM goods WHERE goods_name = '" + namabarang + "'"; 
        
        out.println(query_cart);
        rs_cart     = stt.executeQuery(query_cart);

        int item_cart   = 0;
        
        if (rs_cart.next()) {
            item_cart   = rs_cart.getInt("cart_count");
        }
        
        out.println(query_goods);
        rs_goods    = stt.executeQuery(query_goods);
        
        int item_goods  = 0;
        
        if (rs_goods.next()) {
            item_goods  = rs_goods.getInt("goods_available");
        }
        
        int totalrestore = item_cart + item_goods;
        
        String query_restore = "UPDATE goods SET goods_available = " + totalrestore + " WHERE goods_name = '" + namabarang + "'";
        String query_delete  = "DELETE FROM cart WHERE profil_ID = '" + user_check + "' AND cart_goods = '" + namabarang + "'";
        
        out.println(query_restore);
        stt.execute(query_restore);
        out.println(query_delete);
        stt.execute(query_delete);
        
    }

}
