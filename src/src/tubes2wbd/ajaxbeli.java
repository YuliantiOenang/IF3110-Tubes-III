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
 * Servlet implementation class ajaxbeli
 */
public class ajaxbeli extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
	/*static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	static final String DB_URL="jdbc:mysql://localhost/wbd1";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";*/
	
	private String id;
	private String jumlah;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxbeli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
		}else{
			id="0";
		}
		
		
	    Statement stmt = null;
	    PrintWriter out = response.getWriter();
	    try {
			
			DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM barang WHERE id = " + id;
			ResultSet rs = stmt.executeQuery(sql);
			
			int size = 0;
			while (rs.next()) {
				size++;
				jumlah = rs.getString("jumlah");
			}
			
			if (size == 1) {
				out.print(jumlah);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
