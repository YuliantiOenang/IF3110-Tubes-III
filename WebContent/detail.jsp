<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<%
try {
	  //Load the JDBC driver
			String uname = "root";
			String pass = "";
			String url = "jdbc:mysql://localhost/progin_13511059";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	        Connection con = DriverManager.getConnection (url, uname, pass);
		
		  
	  //Create a Statement object and call its executeUpdate 
	  //method to insert a record
	  Statement s = con.createStatement();
	  String id_barang = request.getParameter("id");
	  System.out.println(id_barang);
	  String sql = "SELECT * FROM `progin_13511059`.barang WHERE id_barang ="+ id_barang;
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
	    out.println("<h1>"+rs.getString(2)+"</h1><br>");
	    out.println("<img src='"+rs.getString(3)+"' width='300px' height='300px'/><br>");
		out.println("<br><h2>Deskripsi :</h2><p>"+rs.getString(7)+"</p><br>");
		out.println("Request tambahan 	: <br>");
		out.println("<form action='addCart' method='post' id='usrform'>");
		out.println("<textarea rows='4' cols='50'  name='request_tambahan' form='usrform'></textarea><br>");
		out.println("<input type='hidden' name='id_barang' value='"+rs.getString(1)+"'>");
		out.println("Quantity : <input type='text' name='qt' style='width: 20px; text-align: right' /><br>");
		out.println("<input type='submit' value='Add to cart'></form>");
	  }
	  rs.close();
	  s.close();
	  con.close();
	}
	catch (ClassNotFoundException e1) {
	  // JDBC driver class not found, print error message to the console
	  System.out.println(e1.toString());
	}
	catch (SQLException e2) {
	  // Exception when executing java.sql related commands, print error message to the console
	  System.out.println(e2.toString());
	}
	catch (Exception e3) {
	  // other unexpected exception, print error message to the console
	  System.out.println(e3.toString());
	}
%>

<%@ include file= "./footer.jsp" %>