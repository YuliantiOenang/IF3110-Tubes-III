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
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mahdan Ahmad F A
 */
public class checkkreditvalid extends HttpServlet {

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
        // Get Session
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

            String card_nomor   = "";
            String card_nama    = "";
            String card_bulan   = "";
            String card_tahun   = "";
                        
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> fields = upload.parseRequest(request);
            
            //out.println("Number of fields: " + fields.size());
            
            Iterator<FileItem> it = fields.iterator();
            if (!it.hasNext()) {
                    out.println("No fields found");
                    return;
            }
            while (it.hasNext()) {
                    FileItem fileItem = it.next();
                    boolean isFormField = fileItem.isFormField();
                    if (isFormField) {
                            //out.print("<br />"+fileItem.getFieldName());
                            if(fileItem.getFieldName().toString().equals("textnomor")) {
                                card_nomor = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textnamalengkap")) {
                                card_nama = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textexpbulan")) {
                                card_bulan = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textexptahun")) {
                                card_tahun = fileItem.getString();
                            }
                    } else {

                    }
            }
            
            GetConnection getCon = new GetConnection();
            Connection conn = getCon.getConnection();
            
            ResultSet rs;
            
            String query =  "SELECT * FROM kartukredit WHERE username = '" + user_check + "'";
           
            Statement stt = conn.createStatement();
            rs = stt.executeQuery(query);
            
            if (rs.next()) {
                String data_nomor   = rs.getString("nomor");
                String data_nama    = rs.getString("nama");
                String data_bulan   = rs.getString("month");
                String data_tahun   = rs.getString("year");
                
                if (data_nomor.equals(card_nomor) && 
                    data_nama.equals(card_nama) &&
                    data_bulan.equals(card_bulan) &&
                    data_tahun.equals(card_tahun)) {
                    
                    ResultSet rs_select;
                    
                    String query_select = "SELECT * FROM cart WHERE profil_ID = '" + user_check + "'";
                    rs_select = stt.executeQuery(query_select);
                    
                    while (rs_select.next()){
                        buyItem(request, rs_select.getString("cart_goods"));
                    }
                    response.sendRedirect("cart.jsp");
                } else {
                    response.sendRedirect("validasikredit.jsp");
                }
            }
            
            
        } catch (Exception exc){
            out.print("Error : ");
            out.print(exc.toString());
        }finally {            
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
    
    protected void buyItem(HttpServletRequest request, String namabarang) 
            throws SQLException, ClassNotFoundException {
        String user_check = "";
        if(request.getSession().getAttribute("user_check")==null){
            user_check = "";
        }else{
            user_check  = request.getSession().getAttribute("user_check").toString();
        }
        
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        
        ResultSet rs_cart;
        ResultSet rs_goods;
        ResultSet rs_profil;

        int cart_count = 0;
        int goods_sold = 0;
        
        int profil_transaction = 0;
        
        String query_profile = "SELECT * FROM userprofil where profil_ID = '" + user_check + "' ";
        rs_profil = stt.executeQuery(query_profile);
        
        if (rs_profil.next()) {
            profil_transaction = rs_profil.getInt("profil_transaction");
        }
        
        String query_cart =  "SELECT * FROM cart WHERE profil_ID = '" + user_check + "' AND cart_goods = '" + namabarang + "'";
        rs_cart = stt.executeQuery(query_cart);
        
        if(rs_cart.next()) {
            cart_count = rs_cart.getInt("cart_count");
        }
        
        String query_goods = "SELECT * FROM goods WHERE goods_name = '" + namabarang + "'";
        rs_goods = stt.executeQuery(query_goods);
        
        if(rs_goods.next()) {
            goods_sold = rs_goods.getInt("goods_sold");
        }
        
        int total = cart_count + goods_sold;
        
        String query_update = "UPDATE goods SET goods_sold = " + total + " WHERE goods_name = '" + namabarang + "'";
        stt.execute(query_update);
        
        String query_transactionupdate = "UPDATE userprofil SET profil_transaction = '" + profil_transaction + "'+1 WHERE profil_ID = '" + user_check + "'";
        stt.execute(query_transactionupdate);
        
        String query_delete = "DELETE FROM cart WHERE profil_ID = '" + user_check + "' AND cart_goods = '" + namabarang + "'";
        stt.execute(query_delete);
    }
}
