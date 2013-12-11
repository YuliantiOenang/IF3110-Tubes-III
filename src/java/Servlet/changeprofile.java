/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Class.GetConnection;
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
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mahdan Ahmad F A
 */
public class changeprofile extends HttpServlet {

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

            String profil_name	= "";
            String profil_password = "";
            String profil_address = "";
            String profil_province = "";
            String profil_district = "";
            String profil_mobile = "";
            String profil_zipcode = "";
            
            
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
                            if(fileItem.getFieldName().toString().equals("textgantinama")) {
                                profil_name = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textgantipassword")) {
                                profil_password = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textalamat")) {
                                profil_address = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textprovinsi")) {
                                profil_province = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textkabupaten")) {
                                profil_district = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textHP")) {
                                profil_mobile = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("textpos")) {
                                profil_zipcode = fileItem.getString();
                            }
                    } else {

                    }
            }
            
            GetConnection getCon = new GetConnection();
            Connection conn = getCon.getConnection();
            
            String query =  "UPDATE userprofil " +
                                "SET " + 
                                "profil_name        ='" + profil_name + "', " + 
                                "profil_password    ='" + profil_password + "', " + 
                                "profil_address     ='" + profil_address + "', " + 
                                "profil_province    ='" + profil_province + "', " + 
                                "profil_district    ='" + profil_district + "', " + 
                                "profil_zipcode     ='" + profil_zipcode + "', " + 
                                "profil_mobile      ='" + profil_mobile + "'" +
                            "WHERE " +
                                "profil_ID          ='" + user_check + "'";

            Statement stt = conn.createStatement();
            
/*            out.println(profil_name);
            out.println(profil_password);
            out.println(profil_address);
            out.println(profil_province);
            out.println(profil_district);
            out.println(profil_zipcode);
            out.println(profil_mobile); // */
            
            stt.execute(query);
                
            response.sendRedirect("profile.jsp");
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
