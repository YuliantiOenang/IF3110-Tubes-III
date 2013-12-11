package tubes2wbd;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registercard
 */
public class registercard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost/wbd1";
	//  Database credentials
	final String USER = "root";
	final String PASS = "";*/      
	private String cardnumber,name,username,expired;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registercard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String ret = "not valid";
		//mengambil parameter request
		if(request.getParameter("cardnumber")!=null){
			cardnumber = request.getParameter("cardnumber");
		}
		if(request.getParameter("name")!=null){
			name = request.getParameter("name");
		}
		if(cardnumber!=null && name!=null){
			String pattern = "^([A-Za-z]{1,10})+([ ][A-Za-z]{1,20})+$";
			if(name.matches(pattern) && cardnumber.length()==16){
				ret = "valid";
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(ret);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("cardnumber")!=null){
			cardnumber = request.getParameter("cardnumber");
		}
		if(request.getParameter("name")!=null){
			name = request.getParameter("name");
		}
		if(request.getParameter("username")!=null){
			username = request.getParameter("username");
		}
		if(request.getParameter("expired")!=null){
			expired = request.getParameter("expired");
		}
		try{
			// Register JDBC driver
		    
	       	// Open a connection
		    DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
	        // Execute SQL query
	        Statement stmt = conn.createStatement();
	        String sql = "INSERT INTO kartu_kredit(owner,card_number,nama,expired) values ('"+username+"','"+cardnumber+"','"+name+"','"+expired+"')";
	        int rs = stmt.executeUpdate(sql);
	        if(rs>0){
	        	out.println("<html><head><script>alert('Pendaftaran kartu kredit berhasil!');window.location.href='index.jsp';</script></head><body></body></html>");
	        }else{
	    		out.println("<html><body>Pendaftaran kartu kredit gagal.<br><a href='registercardform.jsp?username="+username+"'>Kembali</a> atau <a href='index.php'>Kembali ke halaman utama</a></body></html>");
	        }
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
	}

}
