<%-- 
    Document   : wronglogin
    Created on : Dec 1, 2013, 1:20:34 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Wrong Password</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<script type="text/javascript" src="../scripts/register.js"></script>
	</head>
	<body>
		<!--Header-->
			<div id="header">
				<jsp:include page="header.jsp" />
                        </div>
			<!--Body-->
			<div id="task-page-body">
				
				<%
                                    String namabarang = request.getParameter("namabarang");
                                    if (namabarang == null) {
                                        out.println("<h1>Kombinasi Username/Password Salah</h1>");
                                        out.println("Email dan kata sandi yang Anda masukkan tidak cocok. Silakan ulangi input.");
                                    } else {
                                        out.println("<h1>Anda Belum Login</h1>");
                                        out.println("Untuk membeli barang silakan login terlebih dahulu");
                                        //out.println("Barang = " + namabarang);
                                    };
                                %>
                                
                                
				<br />
				<br />
				<form enctype="multipart/form-data" action="checklogin?namabarang=<% out.println(namabarang); %>" method="post">
				<div>
					<label for="login">Username :</label>
					<input type="text" id="loginusername" value="" name="username"/>
				</div>
				<div>
					<label for="asignee">Password : </label>
					<input type="password" id="loginPassword" value="" name="password"/>
				</div>
				<div>
					<input type="submit" value="Login"/>
					<a href="register.jsp">Register</a>
				</div>
				</form>
			</div>
			
			
	</body>
</html>
