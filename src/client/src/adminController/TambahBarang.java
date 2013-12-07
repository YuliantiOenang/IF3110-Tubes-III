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
 * Servlet implementation class TambahBarang
 */
@WebServlet("/admin/addbarang")
@MultipartConfig
public class TambahBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TambahBarang() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isLogin;
		HttpSession session = request.getSession();
		if (session.getAttribute("isLogin")!=null)
			isLogin = (boolean)session.getAttribute("isLogin");
		else
			isLogin = false;
		
		if (isLogin)
		{
			DBA.executeQuery("select * from kategori");
			request.setAttribute("listK", DBA.getQueryResult());
			request.setAttribute("includeJspContent", "/view/adminAddBarang.jsp");
			request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
		}else response.sendRedirect("/ruserba/admin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private String getFileName(Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isLogin;
		HttpSession session = request.getSession();
		if (session.getAttribute("isLogin")!=null)
			isLogin = (boolean)session.getAttribute("isLogin");
		else
			isLogin = false;
		
		response.setContentType("text/html;charset=UTF-8");
		if (isLogin)
		{
		    // Create path components to save the file
		    String path = Config.GlobalConfig.Path+ "/WebContent/images/barang/";
		    System.out.println(path);
		    Part filePart = request.getPart("file");
		    System.out.println(request.getParameter("nama_barang")+request.getParameter("stok"));
		    
		    String nama_barang = request.getParameter("nama_barang");
		    String kategori = request.getParameter("kategori");
		    String harga_barang = request.getParameter("harga_barang");
		    String stok = request.getParameter("stok");
		    String keterangan = request.getParameter("keterangan");
		    
		    String fileName = getFileName(filePart);
		    
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
			    } catch (FileNotFoundException fne) {
			    } finally {
			        if (out != null) {
			            out.close();
			        }
			        if (filecontent != null) {
			            filecontent.close();
			        }
			        String Query = "insert into barang (id_kategori,gambar," +
			        		"nama,harga,keterangan," +
			        		"stok) values ("+kategori+",\""+fileName+"\",\""+nama_barang+"\",\""+
			        		harga_barang+"\",\""+keterangan+"\",\""+stok+"\")";
			        DBA.insertQuery(Query);
			    }
		    }
		    else System.out.println("filename null");
		    response.sendRedirect("/ruserba/admin/");
		}
		else response.sendRedirect("/ruserba/admin/login");
	}
}
