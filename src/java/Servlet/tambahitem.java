/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Class.GetConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mahdan Ahmad F A
 */
public class tambahitem extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            String goods_ID         = "";
            String goods_category   = "";
            String goods_name       = "";
            String goods_price      = "";
            String goods_detail     = "";
            String goods_available  = "";
            String goods_image      = "";
            
            GetConnection getCon = new GetConnection();
            Connection conn = getCon.getConnection();
            Statement stt = conn.createStatement();
            
            ResultSet rs_ID;
            
            String query_ID = "SELECT * FROM goods WHERE 1 ORDER BY goods_ID ASC";
            
            rs_ID = stt.executeQuery(query_ID);
            
            String last_ID = "";
            if(rs_ID.last()) {
                if (rs_ID.getRow() > 1) {
                    last_ID = rs_ID.getString("goods_ID");
                    
                    last_ID = last_ID.substring(5);
                    
                    int id = Integer.parseInt(last_ID) + 1;
                    
                    if (id >= 100) {
                        goods_ID = "goods" + id;
                    } else if (id >= 10) {
                        goods_ID = "goods0" + id;
                    } else {
                        goods_ID = "goods00" + id;
                    }
                    
                    
                } else {
                    goods_ID = "goods001";
                }
            }
            
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
                            if(fileItem.getFieldName().toString().equals("newnama")) {
                                goods_name = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("newkategori")) {
                                goods_category = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("newharga")) {
                                goods_price = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("newketerangan")) {
                                goods_detail = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("newjumlah")) {
                                goods_available = fileItem.getString();
                            } 
                    } else {
                            String fileName = fileItem.getName().toString();
                            int index = fileName.lastIndexOf('.') + 1;
                            String extension = fileName.substring(index);
                            goods_image = goods_ID+"."+extension;
                            
/*                            out.println("Filename : " + fileName + "<br />");
                            out.println("Image : " + goods_image + "<br />"); // */
                            
                            byte [] arByte = fileItem.get();
                            String dir = request.getRealPath("../../web/image/goods");
                            String build_dir = request.getRealPath("image/goods");
                            //dir = dir.replaceFirst("build\\", "");
                            
                            FileOutputStream fileOutStream = new FileOutputStream(dir+"/"+goods_image);
                            fileOutStream.write(arByte);
                            fileOutStream.close();
                            
                            FileOutputStream fileOutStream_build = new FileOutputStream(build_dir+"/"+goods_image);
                            fileOutStream_build.write(arByte);
                            fileOutStream_build.close();
                    }
            }

            int mode = Integer.parseInt(goods_category);
            
            switch(mode) {
                case 1:
                    goods_category = "Makanan";
                    break;
                case 2:
                    goods_category = "Minuman";
                    break;
                case 3:
                    goods_category = "Perawatan Anak-Anak";
                    break;
                case 4:
                    goods_category = "Perawatan Pribadi";
                    break;
                case 5:
                    goods_category = "Perlengkapan Rumah";
                    break;
                                        
            }
            
            
            String query =  "INSERT INTO goods " +
                                "(goods_ID, goods_name, goods_price, goods_detail, goods_category, goods_available) " +
                            "VALUES " +
                                "('" + goods_ID + "', '" + goods_name + "', " + goods_price  + ", '" + goods_detail + "', '" + goods_category + "', " + goods_available  + ")"; // */

            //out.println(query);
            stt.execute(query);

            out.println("Goods ID : " + goods_ID + "<br />");
            out.println("Goods Name : " + goods_name + "<br />");
            out.println("Goods Price : " + goods_price + "<br />");
            out.println("Goods Detail : " + goods_detail + "<br />");
            out.println("Goods Kategori : " + goods_category + "<br />");
            out.println("Goods Available : " + goods_available + "<br />");
            
            
                
            response.sendRedirect("adminpage.jsp");
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
}
