/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import ruserba.beans.Item;
import ruserba.database.DatabaseHelper;

/**
 *
 * @author Ahmad Fauzan
 */
@MultipartConfig
public class SaveItemServlet extends HttpServlet {

    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
         filePath = 
             getServletContext().getInitParameter("file-upload"); 
    }

    
    private static String getFilename(Part part) {
    for (String cd : part.getHeader("content-disposition").split(";")) {
        if (cd.trim().startsWith("filename")) {
            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
        }
    }
    return null;
    }
    
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
        String id_barang = request.getParameter("id_barang");
        String nama_barang = request.getParameter("nama_barang");
        String category = request.getParameter("category");
        String harga = request.getParameter("harga");
        String tersedia = request.getParameter("tersedia");
        Part fileGambar = request.getPart("gambar");
        
        
        String imageName = null;
        if(fileGambar != null) {
            System.out.println(getFilename(fileGambar));
            String fileName = getFilename(fileGambar);
            InputStream fileGambarStream = fileGambar.getInputStream();
            if(id_barang == null || id_barang.equalsIgnoreCase("null")) {
                imageName = fileName;
            } else
                imageName = id_barang + fileName.substring(fileName.lastIndexOf("."));
            file = new File(filePath + imageName) ;
            System.out.println(file.getAbsolutePath());
            if(!file.exists()) {
                FileOutputStream fileStream = new FileOutputStream(file);
                IOUtils.copy(fileGambarStream, fileStream);
                fileStream.flush();
                fileStream.close();
            }
            //fileGambarStream
        }
        
        // Gambar

        System.out.println("Nama Barang : " + nama_barang);
        DatabaseHelper.Connect();
        String query = "Update barang set nama_barang='" + nama_barang
                + "', id_kategori=" + category
                + ", harga_barang=" + harga + ", tersedia=" + tersedia + " where id_barang=" + id_barang;
        if(imageName != null ) {
           query = "Update barang set nama_barang='" + nama_barang
                + "', id_kategori=" + category
                + ", harga_barang=" + harga + ", tersedia=" + tersedia + ", gambar='"+imageName+"' where id_barang=" + id_barang; 
        }
        
        if(id_barang == null || id_barang.equalsIgnoreCase("null")) {
            query = "insert into barang (nama_barang,id_kategori,harga_barang,dibeli,tersedia) values"
                    + "('"+nama_barang+"',"+category+","+harga+",0,"+tersedia+")";
            if(imageName != null) {
                query = "insert into barang (nama_barang,id_kategori,harga_barang,gambar,dibeli,tersedia) values"
                    + "('"+nama_barang+"',"+category+","+harga+",'"+imageName+"',0,"+tersedia+")";
            }
        }
        
        System.out.println(query);
        if (DatabaseHelper.execute(query)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("barang", new Item());
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminedit");
            dispatcher.forward(request, response);
        }
        DatabaseHelper.Disconnect();

        // Upload File
        
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
