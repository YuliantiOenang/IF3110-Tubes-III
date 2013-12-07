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
public class beli extends HttpServlet {

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
        String user_check;
        if(request.getSession().getAttribute("user_check")==null){
            user_check = "";
        }else{
            user_check  = request.getSession().getAttribute("user_check").toString();
        }
        
        String barang = request.getParameter("namabarang");
        if (user_check.isEmpty()) {
            response.sendRedirect("wronglogin.jsp?namabarang=" + barang);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                /* TODO output your page here. You may use following sample code. */


                String jumlah_beli	= "";
                String cart_note = "";



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
                                if(fileItem.getFieldName().toString().equals("textjumlah")) {
                                    jumlah_beli = fileItem.getString();
                                } else if(fileItem.getFieldName().toString().equals("textnotes")) {
                                    cart_note = fileItem.getString();
                                }
                        } else {

                        }
                }

                GetConnection getCon = new GetConnection();
                Connection conn = getCon.getConnection();

                String query =  "SELECT * FROM goods WHERE goods_name='" + barang + "'";

                //out.println(query);

                Statement stt = conn.createStatement();

                ResultSet rs;

                rs = stt.executeQuery(query);

                if (rs.next()) {
                    int beli        = Integer.parseInt(jumlah_beli);
                    int tersedia    = Integer.parseInt(rs.getString("goods_available"));
                    if (beli <= tersedia) {
                        int sisa = tersedia - beli;

                        String query2 = "UPDATE goods SET goods_available = '" + sisa + "' WHERE goods_name = '" + barang + "'";
                        stt.execute(query2);

                        String query3 = "INSERT INTO cart " + 
                                            "(profil_ID, cart_goods, cart_count, cart_note) " + 
                                        "VALUES " + 
                                            "('" + user_check + "', '" + barang + "', '" + jumlah_beli + "', '" + cart_note + "')";
                        stt.execute(query3);

                        response.sendRedirect("detailbarang.jsp?namabarang="+ barang +"&hasil=berhasil ditambahkan dalam cart");

                        //out.println("Bisa beli");
                    } else {
                        int sisa = beli - tersedia;
                        
                        response.sendRedirect("detailbarang.jsp?namabarang="+ barang +"&hasil=barang kurang " + sisa +".");
                        //out.println("Ga bisa beli");
                    }
                }



    /*            out.println(barang);
                out.println(jumlah_beli);
                out.println(cart_note); // */

                //response.sendRedirect("profil.jsp");
            } catch (Exception exc){
                out.print("Error : ");
                out.print(exc.toString());
            }finally {            
                out.close();
            }
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
