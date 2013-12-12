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
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mahdan Ahmad F A
 */
public class checklogin extends HttpServlet {

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
            
            String namabarang = request.getParameter("namabarang");
            
            String profil_ID = "";
            String profil_password = "";
            
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> fields = upload.parseRequest(request);
            
            
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
                            if(fileItem.getFieldName().toString().equals("username")) {
                                profil_ID = fileItem.getString();
                            } else if(fileItem.getFieldName().toString().equals("password")) {
                                profil_password = fileItem.getString();
                            }
                    } else {

                    }
            }
       
            
            GetConnection getCon = new GetConnection();
            Connection conn = getCon.getConnection();
            
            String query =  "SELECT * FROM userprofil WHERE profil_ID='" + profil_ID + "' and profil_password='" + profil_password+ "'";

            Statement stt = conn.createStatement();
            
            ResultSet rs;
            
            rs = stt.executeQuery(query);

            if (rs.next()) {
                //out.println("Login Succes");
                
                String profil_name = rs.getString("profil_name");
                String profil_role = rs.getString("profil_role");
                
                HttpSession session = request.getSession();
                session.setAttribute("user_check", profil_ID);
                session.setAttribute("user_name", profil_name);
                session.setAttribute("user_role", profil_role);
                session.setMaxInactiveInterval(30*24*60*60);
                
                //out.println(namabarang);
                
                if (profil_role.equals("user")) {
                    if (namabarang == null) {
                        response.sendRedirect("profile.jsp");
                    } else {
                        response.sendRedirect("detailbarang.jsp?namabarang="+ namabarang + "&hasil=");
                    }
                } else {
                    response.sendRedirect("adminpage.jsp");
                }
                
            } else {
                //out.println("Login Fail");
                
                response.sendRedirect("wronglogin.jsp");
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
}
