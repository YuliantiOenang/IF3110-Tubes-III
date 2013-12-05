package adminController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class EditBarang
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/admin/editbarang"})
@MultipartConfig
public class EditBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBarang() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		//out.println("ID : "+request.getParameter("id"));
		HttpSession session = request.getSession();
		
		boolean isLogin;
		if (session.getAttribute("isLogin")!=null)
			isLogin = (boolean)session.getAttribute("isLogin");
		else
			isLogin = false;
		if (isLogin)
		{
			DBA.executeQuery("select * from barang where id="+request.getParameter("id"));
			request.setAttribute("edit",DBA.getQueryResult());
			request.setAttribute("id", request.getParameter("id"));

			request.setAttribute("includeJspContent","/view/adminEditBarang.jsp");
			request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
		}else response.sendRedirect("/ruserba/admin/login");
	}

	private String getFileName(Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		boolean isLogin;
		if (session.getAttribute("isLogin")!=null)
			isLogin = (boolean)session.getAttribute("isLogin");
		else
			isLogin = false;
		
		response.setContentType("text/html;charset=UTF-8");

	    // Create path components to save the file
		String path = Config.GlobalConfig.Path+ "/WebContent/images/barang/";
		
	    Part filePart = request.getPart("file");
	    System.out.println(request.getParameter("nama_barang")+request.getParameter("stok"));
	    
	    String nama_barang = request.getParameter("nama_barang");
	    String harga_barang = request.getParameter("harga_barang");
	    
	    String fileName = getFileName(filePart);
	    
	    boolean isUpload = false;
	    if (isLogin)
	    {
		    if (fileName != null)
		    {
			    OutputStream out = null;
			    InputStream filecontent = null;
		
			    try {
			        out = new FileOutputStream(new File(path + File.separator
			                + fileName));
			        filecontent = filePart.getInputStream();
		
			        int read = 0;
			        final byte[] bytes = new byte[1024];
		
			        while ((read = filecontent.read(bytes)) != -1) {
			            out.write(bytes, 0, read);
			        }
			        System.out.println("Bisaaa");
			        //writer.println("New file " + fileName + " created at " + path);
			        isUpload = true;
			    } catch (FileNotFoundException fne) {
			    	
			        System.out.println("You either did not specify a file to upload or are "
			                + "trying to upload a file to a protected or nonexistent "
			                + "location.");
			        System.out.println("<br/> ERROR: " + fne.getMessage());
			        
			    } finally {
			        if (out != null) {
			            out.close();
			        }
			        if (filecontent != null) {
			            filecontent.close();
			        }
			        
			        String Query;
			        if (isUpload)
			        	Query = "UPDATE barang SET gambar='"+fileName+"', nama='"+nama_barang+"', harga='"+harga_barang+"'";
			        else
			        	Query = "UPDATE barang SET nama='"+nama_barang+"', harga='"+harga_barang+"'";
			        
			        Query = Query + " WHERE id="+request.getParameter("id")+" ";
			        System.out.println(Query);
			        DBA.insertQuery(Query);
			    }
		    }
		    else System.out.println("filename null");
	    }
	    response.sendRedirect("/ruserba/admin/");
	}

}
