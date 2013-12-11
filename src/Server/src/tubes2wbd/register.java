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
 * Servlet implementation class registrasi
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost/wbd1";
	//  Database credentials
	final String USER = "root";
	final String PASS = "";*/   
	String username,password,nama,nohp,alamat,provinsi,kota,kodepos,email;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		PrintWriter out = response.getWriter();
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String nama = request.getParameter("nama");
	    String nohp = request.getParameter("nohp");
	    String alamat = request.getParameter("alamat");
	    String provinsi = request.getParameter("provinsi");
	    String kota = request.getParameter("kota");
	    String kodepos = request.getParameter("kodepos");
	    String email = request.getParameter("email");
	    try{
			// Register JDBC driver
		    
	       	// Open a connection
		    DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
	        // Execute SQL query
	        Statement stmt = conn.createStatement();
	        String sql = "INSERT INTO anggota(username,password,nama,nomorhp,alamat,provinsi,kota,kodepos,email,foto) "
	        		+ "values ('"+username+"','"+password+"','"+nama+"','"+nohp+"','"+alamat+"','"+provinsi+"','"+kota+"','"+kodepos+"','"+email+"','user.png')";
	        stmt.executeUpdate(sql);
	        //if(rs.next()){
	        	out.println("<html>	<head><script>if(typeof(Storage)!==\"undefined\"){"
	        	+ " localStorage.wbduser=\""+username+"\"; localStorage.wbdlogintime=new Date().getTime(); "
	        	+ "window.location=\"registercardform.jsp\";}else{document.write(\"Maaf, browser kamu tidak support localStorage sehingga informasi username tidak dapat disimpan...\");"
	        	+ "document.write(\"<a href='index.jsp'>Kembali ke halaman utama</a>\");}</script></head><body></body></html>");
	        //}
	    	//else{
	    		//out.println("<html><body>Pendaftaran gagal.<br><a href='registerform.jsp'>Daftar ulang</a> atau <a href='index.jsp'>Kembali ke halaman utama</a></body></html>");
	        //}
	        // Clean-up environment
	        stmt.close();
	        conn.close();
      	}catch(SQLException se){
         	//Handle errors for JDBC
         	out.println(se.toString());
      	}catch(Exception e){
       	//Handle errors for Class.forName
         	out.println(e.toString());
      	}//end try
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
