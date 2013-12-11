	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Registrasi Identitas</title>
	</head>
	<body onLoad ="load()">
		<?php include('header.php'); ?>		
		<div id="content">
		</div>
		<script type="text/javascript">
			var xmlhttp;
			if (window.XMLHttpRequest)
  			{// code for IE7+, Firefox, Chrome, Opera, Safari
  				xmlhttp=new XMLHttpRequest();
  			}
			else
  			{// code for IE6, IE5
  				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  			}
  			function username_check () {
  				var username = document.getElementById('username').value;
  				if(username.length > 4)//if the lenght greater than 3 characters
				{
					xmlhttp.open("POST","ajax_check.php",true);
					xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xmlhttp.send("username="+username);

					xmlhttp.onreadystatechange = function () {
						if (xmlhttp.readyState==4 && xmlhttp.status==200)
						{
							if (xmlhttp.responseText == '0') {
								valid = true;
								document.getElementById("status").innerHTML='<img src="available.png" align="absmiddle"> <font color="Green"> Username tersedia </font>';
							} else {
								document.getElementById("status").innerHTML='<img src="not_available.png" align="absmiddle"> <font color="red">Username sudah dipakai </font>';
							}
						}
					}
				}
				else
				{
					document.getElementById("status").innerHTML='<font color="#cc0000">Username harus lebih dari 4 karakter</font>';
				}
				this.validasi();
			}
  			function password_check () {
  				var password = document.getElementById('password').value;
  				var email = document.getElementById('email').value;
  				var username = document.getElementById('username').value;
  				if(password == email || password == username) {
					document.getElementById("status2").innerHTML='<font color="#cc0000">Password tidak boleh sama dengan email maupun username</font>';
  				}
  				else if(password.length > 7)//if the lenght greater than 3 characters
				{
					valid = true;
					document.getElementById("status2").innerHTML='<font color="Green"></font>';
				}
				else
				{
					document.getElementById("status2").innerHTML='<font color="#cc0000">Password harus lebih dari 7 karakter</font>';
				}
				this.validasi();
			}
  			function password2_check () {
  				var password = document.getElementById('password').value;
  				var password2 = document.getElementById('password2').value;
  				if(password == password2) {
					valid = true;
					document.getElementById("status3").innerHTML='<font color="Green"></font>';
  				}
				else
				{
					document.getElementById("status3").innerHTML='<font color="#cc0000">Masukkan ulang sama dengan password</font>';
				}
				this.validasi();
			}
  			function nama_lengkap_check () {
  				var nama_lengkap = document.getElementById('nama_lengkap').value;
				var sppos=nama_lengkap.trim().indexOf(" ");
				if (sppos==-1)
				{
					document.getElementById("status4").innerHTML='<font color="#cc0000">Format nama salah</font>';
				}
				else
				{
					valid = true;
					document.getElementById("status4").innerHTML='<font color="Green"></font>';
				}
				this.validasi();
			}
			function validasi () {
				if (valid) {
					document.getElementById("reg_btn").disabled = false;
				}
			}
			var username = localStorage.getItem('username');
			function load () {
				xmlhttp.open("POST","json-decode.php",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send("username4="+username);

				xmlhttp.onreadystatechange = function () {
					if (xmlhttp.readyState==4 && xmlhttp.status==200)
					{
						document.getElementById("content").innerHTML=xmlhttp.responseText;
					}
				}				
			}
		</script>
	</body>
</html>
