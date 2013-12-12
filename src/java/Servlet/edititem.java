/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Class.GetConnection;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class edititem extends HttpServlet {

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
        try {
            
            String namabarang       = request.getParameter("namabarang");
            
            String goods_name       = "";
            String goods_detail     = "";
            String goods_price      = "";
            String goods_available  = "";
            
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
                            if(fileItem.getFieldName().toString().equals("editnama")) {
                                goods_name = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("editketerangan")) {
                                goods_detail = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("editharga")) {
                                goods_price = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("editjumlah")) {
                                goods_available = fileItem.getString();
                            } 
                    } else {

                    }
            }
            
            GetConnection getCon = new GetConnection();
            Connection conn = getCon.getConnection();
            
            String query =  "UPDATE goods " +
                                "SET " + 
                                "goods_name      ='" + goods_name + "', " + 
                                "goods_detail    ='" + goods_detail + "', " + 
                                "goods_price     =" + goods_price + ", " + 
                                "goods_available =" + goods_available + " " +
                            "WHERE " +
                                "goods_name          ='" + namabarang + "'";

            //out.println(query);
            
            Statement stt = conn.createStatement(); 
            stt.execute(query); // */
            
/*            out.println("Nama sebelum : " + namabarang + "<br/><br/>");
            out.println("Nama baru : " + goods_name + "<br/>");
            out.println("Keterangan : " + goods_detail + "<br/>");
            out.println("Harga : " + goods_price + "<br/>");
            out.println("Jumlah : " + goods_available + "<br/>");// */
            
            response.sendRedirect("adminpage.jsp");
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
  
}
