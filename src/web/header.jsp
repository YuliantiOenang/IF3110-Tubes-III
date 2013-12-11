<%-- 
    Document   : header
    Created on : Nov 26, 2013, 4:27:23 PM
    Author     : A46CB
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${param.pageTitle}</title>
        <link rel="stylesheet" href="assets/css/style.css" type="text/css" />
	<link rel="shortcut icon" href="favicon.ico" />
	<script type="text/javascript" src="json2.js"></script>
	<script type="text/javascript" src="xhr.js"></script>
	<script type="text/javascript" src="validate.js"></script>
</head>
<body>
    <div class="header">
		<div class="wrapper">
			<div class="top-header">
				<h1 class="branding-title"><a href="index.jsp">Ruserba</a></h1>
				<div class="top-right">
                                    <%
                                        String userName = null;
                                        String sessionID = null;
                                        String role = null;
                                        Cookie[] cookies = request.getCookies();
                                        if (cookies != null) {
                                                for (Cookie cookie : cookies) {
                                                    if (cookie.getName().equals("user")) {
                                                        userName = cookie.getValue();
                                                    }
                                                    if (cookie.getName().equals("JSESSIONID")) {
                                                        sessionID = cookie.getValue();
                                                    }
                                                     if (cookie.getName().equals("role")) {
                                                        role = cookie.getValue();
                                                    }
                                                }
                                            }
                                        if ((session.getAttribute("user") != null) || (userName != null)) {
                                   
                                            if (session.getAttribute("user") == null) {
                                                session.setAttribute("user", userName);
                                                session.setAttribute("role", role);
                                            }
                                            %> 
                                           
                                            <p> Welcome, <a href="profil.jsp"><%= session.getAttribute("user") %></a>
						<a href="logout.jsp"> Log out</a>
                                                <br />
                                                 <% String therole = (String) session.getAttribute("role");
                                                if(therole.equals("admin")) {
                                            %>
                                            <a href="#popupupload" onclick="upload">Upload</a>   
                                            <% } %>
                                            <a href="search.jsp"> Search</a>
                                            </p>
                                    <%    } else { %>
                                            <a href="register.jsp" class="menutop"> Register </a>
					<a href="javascript:void(0)" onclick="login()" class="menutop"> Login </a> <br />
                                         <a href="search.jsp"> Search</a>
                                    <%    } %>
                                        
				</div>
			</div>
                                    
                                    <div id="popupupload">
                                        <div class="windowupload">
                                            <a href="#" class="close-button" title="Close">X</a>
                                            <h1>Upload Barang</h1>
                                            <form action="UploadImage" method="POST" name="formupload">
                                                <table border=0 align="center">
                                                    <tr><td><label>Nama Barang </label></td><td><input type="text" name="namabarang" id="namabarang"></td></tr>
                                                    <tr><td align="left"><label>Harga Satuan </label></td><td><input type="text" name="harga" id="harga"></td></tr>
                                                    <tr><td align="left"><label>Stok </label></td><td><input type="text" name="stok" id="stok"></td></tr>
                                                    <tr><td align="left"><label>Image </label></td><td><input type="file" name="image" id="image" size="50" /></td></tr>
                                                    <tr><td align="left"><label>Kategori </label></td><td>
                                                            <select name="kategori" id="kategori">
                                                                <option value="snack" name="kategori" id="kategori">Snack</option>
                                                                <option value="minuman" name="kategori" id="kategori">Minuman</option>
                                                                <option value="makanan" name="kategori" id="kategori">Makanan</option>
                                                                <option value="properti" name="kategori" id="kategori">Properti</option>
                                                                <option value="buah" name="kategori" id="kategori">Buah</option>
                                                            </select> 
                                                        </td></tr>
                                                    <tr><td></td><td><input class="submit" type="submit" name="submit" value="Upload"></td></tr>
                                                </table>
                                            </form>

                                        </div>
                                    </div>
                                
			<ul class="cat">
				<li class="menu">Kategori</li>
				<li class="menucat"><a href="products.jsp?category=snack">Snack</a></li>
				<li class="menucat"><a href="products.jsp?category=minuman">Minuman</a></li>
				<li class="menucat"><a href="products.jsp?category=makanan">Makanan</a></li>
				<li class="menucat"><a href="products.jsp?category=properti">Properti</a></li>
				<li class="menucat"><a href="products.jsp?category=buah">Buah</a></li>
			</ul>
		</div>
	</div>

	<div id="content">