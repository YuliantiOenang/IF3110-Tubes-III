<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/AJS_style.css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/modal.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/verify.js"></script>
<script type="text/javascript" src="login.js"></script>
<title>RuserBa</title>
</head>
<body>
<div id="AJS_body_wrapper">
	<div id="AJS_wrapper">
		<div id="AJS_header">
			<% 
			HttpSession sesi = request.getSession(true);
			if((sesi== null)|| (sesi.getAttribute("username")==null)) {
			%>
				<div id='site_title'><h1><a href='index.jsp'>Ruko Serba Ada</a></h1></div>
			<%
			}
			else{
			out.print("<div id='site_title'><h1><a href='index.jsp'>Welcome</a>, <a href='profile.jsp'>"+ sesi.getAttribute("username")+"</a></h1></div>");
			}
			%>
		</div>
		<div id="AJS_menubar">
			<div id="top_nav" class="ddsmoothmenu">
				<ul>
				<% 
				if((sesi== null)|| (sesi.getAttribute("username")==null)) {
				%>
					<li><a href="register.jsp">Sign Up</a></li>
					<li><a href="#login_form">Log in </a></li>
				<%
				}
				else{
				%>
					<li><a href="registercreditcard.jsp"> Register Credit Card </a></li>
					<li><a href="shoppingbag.jsp"> Shopping Bag </a></li>
					<li><a href="profile.jsp">Profile</a></li>
					<%
						if(sesi.getAttribute("username").equals("admin")){
							out.print("<li><a href='kategori.jsp?laman=1&id=1'>Admin Barang</a></li>");
						}
					%>
					<li><a href="logout.jsp">Log out</a></li>
				<%
				}
				%>
				</ul>
				<br style="clear: left" />
			</div> <!-- end of ddsmoothmenu -->	
    	</div> <!-- END of AJS_menubar -->
		<a href="#x" class="overlay" id="login_form" ></a>
        <div class="popup">
            <h2>Welcome Guest!</h2>
            <p>Please enter your login and password here</p>
            <form name="login" action="javascript:verLogin();" method="post">
	            
	                Username : <input type="text" name="username"><br>
	                Password : <input type="password" name="password"><br>
	                <div id="err_login"></div><br>
	            	<input type="submit" value="Log In" />
	        </form>
            <a class="close" href="#close"></a>
        </div>
        
<div id="AJS_main">
	<div id="sidebar" class="float_r">
		<div class="sidebar_box"><span class="bottom"></span>
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
	                	<div class="content"> 
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
						</div>
		</div>
	</div>
