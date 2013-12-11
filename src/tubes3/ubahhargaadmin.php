<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.php"
			}
			
			function AJAXubahhargaBarang() {
				
						var nama=document.forms["ubahharga"]["nama"].value;
						var harganew=document.forms["ubahharga"]["harganew"].value;
						
						var xmlhttp;
						if (window.XMLHttpRequest)
							{// code for IE7+, Firefox, Chrome, Opera, Safari
							xmlhttp=new XMLHttpRequest();
						}
						else
							{// code for IE6, IE5
							xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
						}
						xmlhttp.open("GET","AJAXubahharga.php?nama="+nama+"&harganew="+harganew,false);
						xmlhttp.send();
						if (xmlhttp.responseText.trim()=="true") {
						alert("Harga Berhasil Diubah");
							
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
		<h2>Ubah Harga Barang</h2>
		<form name="ubahharga">
			Nama Barang: <br><input type="text" name="nama" size="40"><br>
			Harga Baru Barang: <br><input type="text" name="harganew" size="40"><br>
			
		
			<button id="submit" type="button" onclick="AJAXubahhargaBarang()">Ubah</button>
		</form>
		</div>
		</div>
	</body>
</html>