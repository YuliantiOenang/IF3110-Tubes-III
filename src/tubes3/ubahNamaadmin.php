<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.php"
			}
			function AJAXubahnamaBarang() {
				
						var nama=document.forms["ubahnama"]["nama"].value;
						var namanew=document.forms["ubahnama"]["namanew"].value;
						
						var xmlhttp;
						if (window.XMLHttpRequest)
							{// code for IE7+, Firefox, Chrome, Opera, Safari
							xmlhttp=new XMLHttpRequest();
						}
						else
							{// code for IE6, IE5
							xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
						}
						xmlhttp.open("GET","AJAXubahnama.php?nama="+nama+"&namanew="+namanew,false);
						xmlhttp.send();
						if (xmlhttp.responseText.trim()=="true") {
						alert("Nama Berhasil Diubah");
							
								window.location = "indexadmin.php";
							
						}
						else {
							alert("Terjadi kesalahan, silakan mencoba lagi");
							
						}
			}
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middleadmin.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Ubah Nama Barang</h2>
		<form name="ubahnama">
			Nama Barang: <br><input type="text" name="nama" size="40"><br>
			Nama Baru Barang: <br><input type="text" name="namanew" size="40"><br>
			
		
			<button id="submit" type="button" onclick="AJAXubahnamaBarang()">Ubah</button>
		</form>
		</div>
		</div>
	</body>
</html>