// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;

import java.io.File;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/EditDagang")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
 
public class AddDagang extends HttpServlet{ 
	private static final long serialVersionUID = 205242440643911308L;
	private static final String UPLOAD_DIR = "res/img/product";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String newnama = request.getParameter("newnama");
		String newharga = request.getParameter("newharga");
		String newkategori = request.getParameter("newkategori");
		String newjumlah = request.getParameter("newjumlah");
		boolean valid = false;
		int count = 0;
		String namabarang;
		PrintWriter out = response.getWriter();
		ResultSet  rs = null;
		
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
		
		request.getPart("fileName").write(uploadFilePath + File.separator + newnama + ".jpg");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			rs = s.executeQuery("SELECT * FROM barang;");
			response.setContentType("text/html"); 
			while(rs.next()) {
				namabarang = rs.getString("NamaBarang");
				if (namabarang == newnama) {
					count++;
				}
			}
			Statement s2 = (Statement) con.createStatement();
			if (count <2) {
				valid = true;
				s2.executeUpdate("INSERT INTO barang (NamaBarang, Harga, Kategori, Jumlah) VALUES("+"'"+newnama+"'"+","+newharga+", '"+newkategori+"'"+","+newjumlah+");");
			}
			
			response.setContentType("text/html"); 
			s.close();
			s2.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}
		if (valid) 
			out.println("Change success <a href = home.jsp> back to home </a>");
		else
			out.println("Change failed, nama sudah ada <a href = home.jsp> back to home </a>");
	} 
}