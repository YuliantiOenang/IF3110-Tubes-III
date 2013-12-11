package javafiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class UploadServlet extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:/Users/RANGGA Y.MANGINDAAN/workspace/EE/Ruserba/WebContent/assets/img";
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
		// memproses multipart file
        if(ServletFileUpload.isMultipartContent(request)){
        	String name = "";
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
           
               
               request.setAttribute("message", "Penambahan file sukses");
               request.setAttribute("filenameservletadd", name);
            } catch (Exception ex) {
               request.setAttribute("message", "Penambahan file gagal karena " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Maaf, servlet ini hanya untuk upload");
        }
    
        request.getRequestDispatcher("/admintambah.jsp").forward(request, response);
     
    }
	
}
