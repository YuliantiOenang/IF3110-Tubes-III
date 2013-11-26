<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="javascript/text" src="verify.js"></script>
<%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/ruserba.css" /> --%>
<title>RuserBa</title>
</head>
<body>
<% 
HttpSession sesi = request.getSession(true);
if((sesi== null)|| (sesi.getAttribute("username")==null)) {
%>
<a href="register.jsp">Sign Up</a><br>
Login<br>
<form action="verifyLogin" method="post">
Username : <input type="text" name="username"/><br>
Password : <input type="password" name="password"/><br>
<input type="submit" value="Login" />
</form>
<%
}
else{
%>
<a href="logout.jsp">Log Out</a><br>
<a href="shoppingbag.jsp">Shopping Bag</a><br>
<a href="profile.jsp">Profile</a><br>
<a href="registercreditcard.jsp">Register Credit Card</a><br>
<%
}
%>
<h3>Search Option : </h3>
	        		<form name="search" action="search.jsp" method="get">
						<input type="hidden" name="laman" value="1">
						<input type="text" name="searched" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
						<input type="submit" value="Cari" alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
		        		<p>Kategori : </p>
		        		<select name="s_kategori">
							<option value="1">Pangan</option>
							<option value="2">Pakaian</option>
							<option value="3">Elektronik</option>
							<option value="4">Rumah Tangga</option>
							<option value="5">Olah Raga</option>
						</select><br>
						<p>Harga kurang dari : </p>
						<input type="text" name="s_harga" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
					</form>

	            	<h3>Kategori</h3>   
	                	<ul class="sidebar_list">
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
	  String sql = "SELECT DISTINCT kategori_barang FROM `progin_13511059`.barang";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
	    int idkat = Integer.parseInt(rs.getString(1));
	    String nama="";
	    int laman =1;
	    if(idkat==1){
			nama = "Pangan";
		}
		else if(idkat==3){
			nama = "Elektronik";
		}
		else if(idkat==2){
			nama = "Pakaian";
		}
		else if(idkat==4){
			nama = "Rumah Tangga";
		}
		else if(idkat==5){
			nama = "Olah Raga";
		}
		out.println("<li> <a href='kategori.jsp?id="+rs.getString(1)+"&laman=1'>"+nama+"</a></li>");
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
	                    </ul>