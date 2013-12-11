<!DOCTYPE html>
<html>
	<!-- Head -->
	<head>
		<script src="FormValidation.js"></script>
		<script src="UserAJAX.js"></script>
	</head>
	
	<!-- Body -->
	<body onload="LoginRedirection(); InitializeValue()">
		<div class="page_container">
			<!-- JSP Script -->
			<%@ include file="template/template.jsp" %>
			
			<div class="contents">
			<!-- Form Pendaftaran -->
				<h2>Edit Profile</h2>
				<form name="registration" >
					<label>Username: </label><label id="username2"></label> <br>
					<span>Nama Lengkap: <input type="text" name="fullname" onkeyup='validatep("fullname")' required> <label id = "fullname"></label></span><br> 
					<span>Nomor Handphone:* <input type="text" name="hp" id='nohp'> <br></span>
					<label>Email: </label><label id="email"></label> <br>
					<span>Alamat:* <input type="text" name="alamat"id='alamat'> <br></span>
					<span>Provinsi:* <input type="text" name="provinsi"id='provinsi'> <br></span>
					<span>Kota/Kabupaten:* <input type="text" name="kota"id='kota'> <br></span>
					<span>Kodepos:* <input type="text" name="kodepos"id='kodepos'> <br></span>
					<span>Password: <input type="password" name="password" onkeyup='validatep("password")' required><label id = "password2"></label></span><br> 
					<span>Confirm Password: <input type="password" name="confirm" onkeyup='validatep("confirm")'required><label id = "confirm"></label></span><br>
					<label>Jumlah Transaksi: </label><label id="transaksi"></label><br><br>
					<input type="button" onclick="SubmitNewProfile()" id="submitbutton" value="Edit Profile">
					<p>*optional</p>	
				</form>
			</div>	
		</div>
	</body>
</html>