package tubes2wbd;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tambahbarang
 */
public class editbarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost/wbd1";
	//  Database credentials
	final String USER = "root";
	final String PASS = "";*/  
    
	String username,password,nama,nomorhp,alamat,provinsi,kota,kodepos,email,file_name;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editbarang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    Statement stmt = null;
	    PrintWriter out = response.getWriter();
	    String nama, gambar, harga, kategori, jumlah, keterangan;
	    nama=request.getParameter("nama");
	    gambar=request.getParameter("img");
	    harga=request.getParameter("harga");
	    kategori=request.getParameter("kategori");
	    jumlah=request.getParameter("jumlah");
	    keterangan=request.getParameter("deskripsi");
	    try {
	    	DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
			stmt = conn.createStatement();
			String sql;
            sql = "update barang set nama='"+nama+"', gambar='"+gambar+"', harga="+harga+", kategori='"+kategori+"', jumlah="+jumlah+", keterangan='"+keterangan
            	+"' where id="+request.getParameter("id");
			stmt.executeUpdate(sql);
            out.println("<html><body> Selamat, Item "+request.getParameter("nama")+" telah berhasil diedit"
            		+ "<br><br><a href='adminbarang.jsp'>Kembali ke halaman admin</a></body></html>");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
