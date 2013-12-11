package tubes2wbd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class savingImage
 */
public class savingImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savingImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out = response.getWriter();
	Statement stmt;
	if(request.getParameter("username")!=null){
		try{
			DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
            // Execute SQL query
          	stmt = conn.createStatement();
          	String sql = "update anggota set foto='"+request.getParameter("filename")+"' where username='"+request.getParameter("username")+"'";
    		stmt.executeUpdate(sql);
    		out.print("<script>function delay(){document.write(\"<p>Foto berhasil di upload!</p><a href='profile.jsp'>Kembali ke halaman profile</a>\");}</script>");
          	stmt.close();
          	conn.close();
       	}catch(SQLException se){
          	//Handle errors for JDBC
          	out.println(se.toString());
       	}catch(Exception e){
        	//Handle errors for Class.forName
          	out.println(e.toString());
       	}//end try
	}else{
		out.print("<script>var username = localStorage.wbduser;document.getElementById(\"username\").value=username;document.getElementById(\"filename\").value=\""+request.getParameter("filename")+"\";</script>");
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
