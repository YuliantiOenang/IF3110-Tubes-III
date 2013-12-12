/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
public class uploadimage extends HttpServlet {

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
            
            String ID = request.getParameter("ID");
            String image = "";
            
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
                        
                    } else {
                            String fileName = fileItem.getName().toString();
                            int index = fileName.lastIndexOf('.') + 1;
                            String extension = fileName.substring(index);
                            image = ID+"."+extension;
                            
                            out.println("Filename : " + fileName + "<br />");
                            out.println("Image : " + image + "<br />");
                            
                            byte [] arByte = fileItem.get();
                            String dir = request.getRealPath("../../web/image/goods");
                            String build_dir = request.getRealPath("image/goods");
                            //dir = dir.replaceFirst("build\\", "");
                            
                            FileOutputStream fileOutStream = new FileOutputStream(dir+"/"+image);
                            fileOutStream.write(arByte);
                            fileOutStream.close();
                            
                            FileOutputStream fileOutStream_build = new FileOutputStream(build_dir+"/"+image);
                            fileOutStream_build.write(arByte);
                            fileOutStream_build.close();
                            
                            
                            
                            out.println("Dir : " + dir + "<br />");
                    }
            }
            
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
