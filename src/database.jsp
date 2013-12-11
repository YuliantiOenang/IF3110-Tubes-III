<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>SELECT Operation</title>
</head>
<body>
 
<h1>JDBC Connection example</h1>

<%
  String db = request.getParameter("db");
  String user = db; // assumes database name is the same as username
  Connection conn = null;
  Statement  stmt = null;
  ResultSet   rs = null;
  try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
    out.println (db+ "database successfully opened.");
	out.println("Create statement.");
	stmt = conn.createStatement();
	
	out.println("Do database process.");
	rs = stmt.executeQuery("select NamaBarang from barang");
	
	while(rs.next()) {
		out.print("Nama : " + rs.getString("NamaBarang"));
		out.print("<BR/>");
	}
  }
  catch(SQLException e) {
    out.println("SQLException caught: " +e.getMessage());
  }
%>	
 
</body>
</html>