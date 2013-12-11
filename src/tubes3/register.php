<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user=="admin") {
				window.location = "indexadmin.php"
			}
		</script>
		<script>
			if (localStorage.user!=null) {
				window.location = "index.php"
			}
			function validateForm() {
				var valid=true;
				//validasi username
				var x=document.forms["registrasi"]["username"].value;
				if (x.length<5) {
					valid=false;
					document.getElementById("submit").disabled = true;
					return;
				}
				//validasi nama lengkap
				var x=document.forms["registrasi"]["nama"].value;
				x.trim();
				if (x.search(" ")==-1) {
					valid=false;
					document.getElementById("submit").disabled = true;
					return;
				}
				//validasi email
				var x=document.forms["registrasi"]["email"].value;
				var atpos=x.indexOf("@");
				var dotpos=x.lastIndexOf(".");
				if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
					valid=false;
					document.getElementById("submit").disabled = true;
					return;
				}
				//validasi password
				var x=document.forms["registrasi"]["password"].value;
				var uname=document.forms["registrasi"]["username"].value;
				var email=document.forms["registrasi"]["email"].value;
				if ((x==uname)||(x==email)) {
					valid=false;
					document.getElementById("submit").disabled = true;
					return;
				}
				//validasi confirm password
				var x=document.forms["registrasi"]["confpassword"].value;
				var passw=document.forms["registrasi"]["password"].value;
				if ((x!=passw)||(x.length<8)) {
					valid=false;
					document.getElementById("submit").disabled = true;
					return;
				}
				document.getElementById("submit").disabled = false;
			}
			function AJAXregister() {
				var username=document.forms["registrasi"]["username"].value;
				var nama=document.forms["registrasi"]["nama"].value;
				var nohp=document.forms["registrasi"]["nohp"].value;
				var alamat=document.forms["registrasi"]["alamat"].value;
				var provinsi=document.forms["registrasi"]["provinsi"].value;
				var kota=document.forms["registrasi"]["kota"].value;
				var kodepos=document.forms["registrasi"]["kodepos"].value;
				var email=document.forms["registrasi"]["email"].value;
				var password=document.forms["registrasi"]["password"].value;
				var xmlhttp;
				if (window.XMLHttpRequest)
					{// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp=new XMLHttpRequest();
				}
				else
					{// code for IE6, IE5
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.open("GET","AJAXregister.php?username="+username+"&nama="+nama+"&nohp="+nohp+"&alamat="+alamat+"&provinsi="+provinsi+"&kota="+kota+"&kodepos="+kodepos+"&email="+email+"&password="+password,false);
				xmlhttp.send();
				if (xmlhttp.responseText.trim()=="true") {
					localStorage.user=username;
					alert("Registrasi berhasil! Selanjutnya masukkan data kartu kredit anda.");
					window.location = "card.php";
				}
				else {
					alert("Username / password sudah pernah digunakan");
				}
			}
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middle.php'); ?>
	<div id="container-left">
	<div id="container">
		<script type="text/javascript" src="checking.js"></script>
		<h2>Registrasi Akun</h2>
		<form name="registrasi" action="register.php" method="get">
			Username: <br><input type="text" name="username" size="40" onkeyup="userHint(this.value,password.value)" onchange="validateForm()"/> <small><span id="userHint" ></span> </small> <br>
			Nama lengkap: <br><input type="text" name="nama" size="40" onkeyup="namaHint(this.value)" onchange="validateForm()"><small> <span id="namaHint" > </small><br>
			Nomor handphone: <br><input type="text" name="nohp" size="40" onchange="validateForm()"><br>
			Alamat: <br><input type="text" name="alamat" size="40" onchange="validateForm()"><br>
			Kota/Kabupaten: <br><input type="text" name="kota" size="40" onchange="validateForm()"><br>
			Provinsi: <br><input type="text" name="provinsi" size="40" onchange="validateForm()"><br>
			Kode Pos: <br><input type="text" name="kodepos" size="40" onchange="validateForm()"><br>
			Email: <br><input type="text" name="email" size="40" onkeyup="emailHint(this.value,password.value)" onchange="validateForm()">
			<small> <span id="txtHint" ></span> </small>
			<br>
			Password: <br><input type="password" name="password" size="40" onkeyup="passHint(this.value,username.value)" onchange="validateForm()"><small> <span id="passHint" ></span> </small><br>
			Confirm password: <br><input type="password" name="confpassword" size="40" onkeyup="cpassHint(this.value,password.value)" onchange="validateForm()"><small> <span id="cpassHint" ></span> </small><br>
			<button id="submit" type="button" onclick="AJAXregister()" disabled>Register</button>
		</form>
		</div>
	</div>
	</body>
</html>