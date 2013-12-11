import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
//import org.apache.tomcat.util.http.fileupload.FileItem;

public class UploadImage extends HttpServlet {
    private String databaseURL, username, password;
    String namabarang, harga, kategori, stok;
    String saveImage;
    String filename;
    @Override
   public void init(ServletConfig config) throws ServletException {
      // Retrieve the database-URL, username, password from webapp init parameters
      super.init(config);
      ServletContext context = config.getServletContext();
      databaseURL = context.getInitParameter("databaseURL");
      username = context.getInitParameter("username");
      password = context.getInitParameter("password");
   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        Connection conn = null;
        Statement stmt = null;
        try {
           namabarang = request.getParameter("namabarang");
           harga = request.getParameter("harga");
           stok = request.getParameter("stok");
           String namefile = request.getParameter("image");
           kategori = request.getParameter("kategori");
           out.println(namabarang);
           out.println(harga);
           out.println(stok);
           out.println(kategori);
           saveImage="/assets/img/";//="/img/"+kategori;
           
           
           try {
                Class.forName("com.mysql.jdbc.Driver");
            }catch(Exception e) {
                out.println("Unable to load Driver");
            }
            // Step 1: Create a database "Connection" object
            conn = DriverManager.getConnection(databaseURL, username, password);
            
            // Step 2: Create a "Statement" object inside the "Connection"
            stmt = conn.createStatement();

            // Step 3: Execute a SQL SELECT query
            String image = "img/"+namefile;
            String sqlStr = "INSERT INTO produk(nama,harga,sold,stok,image,kategori) VALUES ('"+namabarang+"','"+harga+"','0','"+stok+"','"+image+"','"+kategori+"')";
                
            stmt.executeUpdate(sqlStr); // Send the query to the server

            // Step 4: Process the query result
            response.sendRedirect("index.jsp");
           
           boolean ismultipart = ServletFileUpload.isMultipartContent(request);
           if(!ismultipart){
            
           }
           else{
               FileItemFactory factory = new DiskFileItemFactory();
               ServletFileUpload upload = new ServletFileUpload(factory);
              List items = null;
               try{
                   items = upload.parseRequest(request);
               }catch(Exception e){
                   
               }
               Iterator itr = items.iterator();
               while(itr.hasNext()){
                   FileItem item = (FileItem)itr.next();
                   if(item.isFormField()){
                       
                   }
                   else{
                       String itemname = item.getName();
                       if(itemname == null || itemname.equals("")){
                           continue;
                       }
                       //String appPath = application.getRealPath("/");
                       String absoluteDiskPath = getServletContext().getRealPath("/");
                       filename = FilenameUtils.getName(itemname);
                       File f = new File(absoluteDiskPath + saveImage+"/"+filename);
                       out.println(absoluteDiskPath);
                       
                        if(f.exists()){
                            StringBuffer sb = new StringBuffer(filename);
                            sb.insert(sb.lastIndexOf("."),"-Copy");
                            f = new File(absoluteDiskPath + saveImage+"/"+ sb.toString());
                            //f = new File(saveImage+ "/"+ sb.toString());
                        }
                       item.write(f);
                       //INSERT
                       
                   }
               }
           }
        }  
        catch(Exception e){
            
        }
        finally {            
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
