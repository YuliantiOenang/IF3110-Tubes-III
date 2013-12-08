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
 * Servlet implementation class ajaxadminbarang
 */
public class ajaxadminbarang extends HttpServlet {
	/*private static final long serialVersionUID = 1L;
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost/wbd1";
	//  Database credentials
	final String USER = "root";
	final String PASS = "";*/    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxadminbarang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String sort;
		String kategori;
		String sql;
		int page;
		if(request.getParameter("sort")!=null){
			sort = request.getParameter("sort");
		}else{
			sort = "nama";
		}
		if(request.getParameter("page")!=null){
			page = (Integer.parseInt(request.getParameter("page"))-1)*10;
		}else{
			page = 0;
		}
		if(request.getParameter("kategori")!=null){
			kategori = request.getParameter("kategori");
			sql = "select * from barang where kategori='"+kategori+"' order by "+sort+" limit "+page+",10";
		}else{
			kategori = null;
			sql = "select * from barang order by "+sort+" limit "+page+",10";
		}
		try{
			
	       	// Open a connection
		    DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
	        // Execute SQL query
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()){
	        	out.println("<div class='view'>");
		        	out.println("<div class='imgattr'>");
						out.println("<img src="+rs.getString("gambar")+" width='120' height=100'/>");
						out.println("<div class='attribute'>");
							out.println("ID : "+rs.getString("id")+"<br>");
							out.println(rs.getString("nama")+"<br>");
							out.println("Rp "+rs.getString("harga")+"<br>");
							out.println("Jml "+rs.getString("jumlah"));
							out.println("</div>");
					out.println("</div>");
					out.println("<div class='tools'>");
						out.println("<input type='checkbox' name='"+rs.getString("id")+"' id='"+rs.getString("id")+"'>"+"<br>"); 
						out.println("<a href='editbarang.jsp?id="+rs.getString("id")+"'>"
							+ "<img src=images/Edit.jpg id='edit'></a>"+"<br>");
						out.println("<input type='image' src=images/Delete.png id='delete' onclick='submitdelete2(document.forms[\"check\"],0,\""+rs.getString("id")+"\")'>");
						out.println("</div>");
					out.println("<div class='description'>");
						out.println(rs.getString("keterangan"));
					out.println("</div>");
				out.println("</div>");
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
