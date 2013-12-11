package tubes2wbd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexslideservlet
 */
public class indexslideservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexslideservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		int slideid = 0;
		try{
        	// Open a connection
		    DbConnector dbconnector = new DbConnector();
	        Connection conn = dbconnector.mySqlConnection(response);;
            // Execute SQL query
          	Statement stmt = conn.createStatement();
          	String sql = "select * from barang group by kategori";
          	ResultSet rs = stmt.executeQuery(sql);
          	// Extract data from result set
          	while(rs.next()){
          		int rank=1;
          		Statement stmt2 = conn.createStatement();
    			String sql2 = "select * from barang where kategori='"+rs.getString("kategori")+"' order by terjual desc limit 0,3";
    			ResultSet rs2 = stmt2.executeQuery(sql2);
    			while(rs2.next()){
    				slideid++;
    				rank++;
    			}
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
		
		out.print(slideid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
