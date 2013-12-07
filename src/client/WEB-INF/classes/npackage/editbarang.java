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
public class editbarang extends HttpServlet {
  
    private static final long serialVersionUID = 205242440643911308L;
     
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private String UPLOAD_DIR = "res/img/product";
      
    protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		UserBean user = new UserBean();
		user.setType("insertdata");
		user.setQuery("UPDATE barang SET namabarang='"+
		request.getParameter("enamabarang")+"', harga='"+
		request.getParameter("ehargabarang")+"', jumlah='"+
		request.getParameter("ejumlahbarang")+"', deskripsi='"+
		request.getParameter("edeskripsibarang")+"' WHERE namabarang='"+
		request.getParameter("enamabarangtemp")+"'");
		
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
		String new1 =fileSaveDir.getAbsolutePath()+"\\"+request.getParameter("enamabarangtemp")+".jpg";
		String new2 =fileSaveDir.getAbsolutePath()+"\\"+request.getParameter("enamabarang")+".jpg";
		System.out.println("new1="+new1);
		 File file1 = new File(new1);
		 File file2 = new File(new2);
		
		
	try { 
     boolean b; 
     b=file1.renameTo(file2); 
	} catch (SecurityException ex) { 
		 System.out.println("SecurityException") ;
		 ex.printStackTrace (); 
	} catch (NullPointerException npe) { 
		 System.out.println("NullPointerException") ;
		 npe.printStackTrace (); 
	} 
			
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
         
        String fileName = null;
		fileName = getFileName(request.getPart("efilebarang"));
        //Get all the parts from request and write it to the file on server
		String namab = request.getParameter("enamabarang");
		if (!fileName.equals("")){
		request.getPart("efilebarang").write(uploadFilePath + File.separator + namab + ".jpg"); 
	
        request.setAttribute("message", fileName + " File uploaded successfully!");
		}
        response.sendRedirect("getadmin");
    }
  
    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
      
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










