package tubes2wbd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class indexservlet
 */
public class indexservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int slideid = 0;
		try{
        	// Open a connection
		    DbConnector dbconnector = new DbConnector();
	        Connection conn = dbconnector.mySqlConnection(response);
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
    				out.println("<li id ='slide-"+slideid+"'>");
    				out.println("<img src='"+rs2.getString("gambar")+"'/>");
    				out.println("<div class='description'>");
    				out.println("<input type='checkbox' id='show-description-"+slideid+"'/>");
    				out.println("<label for='show-description-"+slideid+"' class='show-description-label'>");
    				out.println(""+rs.getString("kategori")+" #"+rank+"</label>");
    				out.println("<div class='description-text'><a href='detailbarang.jsp?id="+rs2.getString("id")+"'>"+rs2.getString("nama")+"</a>");
    				out.println("<p>"+rs2.getString("keterangan")+"</p>");
    				out.println("</div></div></li>"); 
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
