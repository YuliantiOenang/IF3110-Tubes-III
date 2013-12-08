package tubes2wbd;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class uploadsave
 */
public class uploadfoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 5000 * 1024;
    private int maxMemSize = 5000 * 1024;
    private File file;
    private String file_name;
	/*final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost/wbd1";
	//  Database credentials
	final String USER = "root";
	final String PASS = "";*/  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadfoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		filePath = getServletContext().getInitParameter("images");
		isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			 // maximum size that will be stored in memory
		      factory.setSizeThreshold(maxMemSize);
		      // Location to save data that is larger than maxMemSize.
		      factory.setRepository(new File("c:\\temp"));

		      // Create a new file upload handler
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      // maximum file size to be uploaded.
		      upload.setSizeMax( maxFileSize );
		      
			try {
				List fileItems = upload.parseRequest(request);
			    Iterator i = fileItems.iterator();
			    
			    while (i.hasNext()) {
			    	FileItem fi = (FileItem)i.next();
			    	if (!fi.isFormField()) {
			    		 // Get the uploaded file parameters
			            String fieldName = fi.getFieldName();
			            String fileName = fi.getName();
			            String contentType = fi.getContentType();
			            boolean isInMemory = fi.isInMemory();
			            long sizeInBytes = fi.getSize();
			            // Write the file
			            if( fileName.lastIndexOf("\\") >= 0 ){
			               file = new File( filePath + 
			               fileName.substring( fileName.lastIndexOf("\\"))) ;
			            }else{
			               file = new File( filePath + 
			               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
			            }
			            fi.write( file ) ;
			            file_name = fileName;
			    	}
			    }
			 // New location to be redirected
			      String site = new String("updatedb.jsp?filename="+file_name);
			      response.setStatus(response.SC_MOVED_TEMPORARILY);
			      response.setHeader("Location", site);
			    
			} catch (FileUploadException e) {} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			Connection conn = null;
		    Statement stmt = null;
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				stmt = conn.createStatement();
				String sql = "update anggota set foto='"+file_name+"' where username='"+username+"'";
				stmt.executeUpdate(sql);
				
			} catch (ClassNotFoundException e) {	
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		}
	}

}
