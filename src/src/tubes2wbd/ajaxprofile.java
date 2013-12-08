package tubes2wbd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class profile
 */
public class ajaxprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost/wbd1";
	//  Database credentials
	final String USER = "root";
	final String PASS = "";*/   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxprofile() {
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
	    if(username==null){
	    	out.print("Gagal mengambil data user!");;
	    }else{
	    	try{
				// Register JDBC driver
			    
		       	// Open a connection
			    DbConnector dbconnector = new DbConnector();
				Connection conn = dbconnector.mySqlConnection(response);
		        // Execute SQL query
		        Statement stmt = conn.createStatement();
		        String sql = "SELECT * FROM anggota where username='"+username+"'";
		        ResultSet rs = stmt.executeQuery(sql);
		        while(rs.next()){
		        	out.print(rs.getString("nama")+"||");
		        	out.print(rs.getString("nomorhp")+"||");
		        	out.print(rs.getString("alamat")+"||");
		        	out.print(rs.getString("provinsi")+"||");
		        	out.print(rs.getString("kota")+"||");
		        	out.print(rs.getString("kodepos")+"||");
		        	out.print(rs.getString("email")+"||");
		        	out.print(rs.getString("username")+"||");
		        	out.print(rs.getString("password")+"||");
		        	out.print(rs.getString("foto")+"||");
		        	out.print(rs.getString("jmlhtransaksi"));
		        }
		        // Clean-up environment
		        rs.close();
		        stmt.close();
		        conn.close();
	      	}catch(SQLException se){
	         	//Handle errors for JDBC
	         	out.println(se.toString());
	      	}catch(Exception e){
	       	//Handle errors for Class.forName
	         	out.println(e.toString());
	      	}//end try
	    }
	}

}
