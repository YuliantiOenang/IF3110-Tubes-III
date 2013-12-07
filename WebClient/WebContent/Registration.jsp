<!DOCTYPE html>
<html>
	
	<!-- Head -->
	<head>
		<script src="FormValidation.js"></script>
		<script src="UserAJAX.js"></script>
	</head>
	
	<!-- Body -->
	<body onload = "LogoutRedirection()">
		<div class="page_container">
			<!-- JSP Script -->
			<%@ include file="template/template.jsp" %>
			
			<div class="contents">
				<!-- Form Pendaftaran -->	
				<h2>Registrasi User Baru</h2><br>
				<form method="post" action="Registration.jsp" name="registration" >
					<span>Username:<input id='id' type="text" name="username" onkeyup='validate("username")' required><label id = "username"></label></span>
					<span><br>Nama Lengkap: <input id="fname" type="text" name="fullname" onkeyup='validate("fullname")' required > <label id = "fullname"></label></span> 
					<span><br>Nomor Handphone:* <input type="text" name="hp" id="nohp"></span>
					<span><br>Email: <input id='mail' type="text" name="email" onkeyup='validate("email")' required><label id = "email"></label></span>
					<span><br>Alamat:* <input type="text" name="alamat"id="alamat"></span>
					<span><br>Provinsi:* <input type="text" name="provinsi"id="provinsi"></span>
					<span><br>Kota/Kabupaten:* <input type="text" name="kota" id="kota"></span>
					<span><br>Kodepos:* <input type="text" name="kodepos"id="kodepos"></span>
					<span><br>Password: <input id="pass" type="password" name="password" onkeyup='validate("password")' required><label id ="password2"></label></span> 
					<span><br>Confirm Password: <input type="password" name="confirm" onkeyup='validate("confirm")' required><label id = "confirm"></label></span> 
					<br><br><input type="button" id="submitbutton" onclick = "SubmitRegistration()" value="Register">
					<p>*optional</p>
				</form>
			</div>
		</div>
	</body>
</html>