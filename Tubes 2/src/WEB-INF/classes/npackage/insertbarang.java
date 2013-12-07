package npackage;
  
import java.io.File;
import java.io.IOException;
  
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
  
@WebServlet("/FileUploadServlet")
@MultipartConfig(
				fileSizeThreshold=1024*1024*10,    // 10 MB 
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100)      // 100 MB
public class insertbarang extends HttpServlet {
  
    private static final long serialVersionUID = 205242440643911308L;
     
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "res/img/product";
      
    protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		UserBean user = new UserBean();
		user.setType("insertdata");
		user.setQuery("INSERT INTO barang (idbarang, namabarang,harga,kategori,jumlah,deskripsi) VALUES('0', '"+
		request.getParameter("namabarang")+"', '"+
		request.getParameter("hargabarang")+"', '"+
		request.getParameter("kategoribarang")+"', '"+
		request.getParameter("jumlahbarang")+"', '"+
		request.getParameter("deskripsibarang")+"')");

		user = UserDAO.login(user);
			
			
        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
          
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
         
        String fileName = null;
		fileName = getFileName(request.getPart("filebarang"));
        //Get all the parts from request and write it to the file on server
		String namab = request.getParameter("namabarang");
		request.getPart("filebarang").write(uploadFilePath + File.separator + namab + ".jpg"); 
  
        request.setAttribute("message", fileName + " File uploaded successfully!");
        response.sendRedirect("getadmin");
    }
  
    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
	@Override
	
public void doGet(HttpServletRequest request,
				  HttpServletResponse response)
	throws IOException, ServletException
{
	doPost(request, response);
}
}










