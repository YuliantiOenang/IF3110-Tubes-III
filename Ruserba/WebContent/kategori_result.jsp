<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/header.js"></script>
<title>Hasil pencarian kategori</title>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="header.jsp"/>



	<%
	String namakategori = request.getParameter("namakategori");
	String driver = "com.mysql.jdbc.Driver";
	
	
	Class driver_class = Class.forName(driver);
	Driver d = (Driver) driver_class.newInstance();
	DriverManager.registerDriver(d);
	
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waserda", "java", "java");
	Statement st= con.createStatement();
	
	String value = "'%" + namakategori + "%'";
	
	ResultSet rs=st.executeQuery("select * from data_barang where kategori LIKE " + value + ";");
	/* if(rs.next())
	{
		if(rs.getString(2).equals(pwd))
		{
			out.println("welcome"+userid);
		
		}
		else
		{
			out.println("Invalid password try again");
		}
	} */
	
	if (rs.next()){
		do {
			out.println("<img src=\"" + rs.getString("img_dir") + "\">" + "<br>");
			out.println("Nama: " + rs.getString("nama") + "<br/>");	
			out.println("Harga: " + rs.getString("harga") + "<br/>");	
			out.println("Stok: " + rs.getString("stok") + "<br/>");	
			out.println("<br/>");
		} while (rs.next());
	}
	else {
		out.println("Kategori yang dicari tidak ada");
	}
	
	con.close();
	
	%>

	<jsp:include page="footer.jsp"/>

</body>
</html>