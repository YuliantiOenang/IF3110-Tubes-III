<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.frexesc.model.*"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="layout.jsp" />
	<div id='content_frame' name='page' onLoad="RefreshCartandShow()">
		<div class="center">
			<div class="register_div">
				<h1 class='header'>Profil</h1>
				<div class="per_form">
					<label>Nama Lengkap:</label>
					<p>${user.getNama()}</p>
				</div>
				<div class="per_form">
					<label>Username:</label>
					<p>${user.getUsername()}</p>
				</div>
				<div class="per_form">
					<label>Email:</label>
					<p>${user.getEmail()}</p>
				</div>
				<div class="per_form">
					<label>Alamat:</label>
					<p>${user.getAlamat()}</p>
				</div>
				<div class="per_form">
					<label>Provinsi:</label>
					<p>${user.getProvinsi()}</p>
				</div>
				<div class="per_form">
					<label>Kota:</label>
					<p>${user.getKota()}</p>
				</div>
				<div class="per_form">
					<label>Kode Pos:</label>
					<p>${user.getKodepos()}</p>
				</div>
				<div class="per_form">
					<label>Telepon:</label>
					<p>${user.getHandphone()}</p>
				</div>
				<div class="per_form">
					<label>Transaksi:</label>
					<p>${user.getTransaksi()}</p>
				</div>
				<a href="user?action=edit&id=<%=request.getAttribute("id")%>"
					class="btn">Edit Profile</a>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<!--  <button onclick="location.href='creditcard.jsp'">CC</button> -->
</body>
</html>