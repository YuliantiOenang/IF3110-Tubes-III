<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<%
if((sesi== null)|| (sesi.getAttribute("username")==null))
	out.print("<script>window.location='register.jsp';</script>");
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
	  String sql = "SELECT * FROM user WHERE username ='"+session.getAttribute("username")+"'";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
	    out.println("<h3> "+rs.getString(2)+"</h3><br>");
	    out.println("<p>username : "+rs.getString(1)+"</p><br>");
		out.println("<p>email : "+ rs.getString(4)+"</p><br>");
		out.println("<p>Mobile : "+ rs.getString(5)+"</p><br>");
		out.println("<p>Address : "+ rs.getString(6)+"</p><br>");
		out.println("<p>Province : "+ rs.getString(7)+"</p><br>");
		out.println("<p>State : "+ rs.getString(8)+"</p><br>");
		out.println("<p>Postal Code : "+ rs.getString(9)+"</p><br>");
		out.println("<p>Jumlah Transaksi : "+ rs.getString(10)+"</p><br>");
		out.println("<a href='editprofile.jsp'> Edit Profile </a>");
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