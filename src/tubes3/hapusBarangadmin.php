<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.php"
			}
			
			function AJAXhapusBarang() {
				alert("Anda akan menghapus barang bernama " + document.forms["hapus"]["nama"].value);
				var nama=(document.forms["hapus"]["nama"].value).split(";");
				for (var i = 0; i < nama.length; i++) {
					var xmlhttp;
					if (window.XMLHttpRequest)
						{// code for IE7+, Firefox, Chrome, Opera, Safari
						xmlhttp=new XMLHttpRequest();
					}
					else
						{// code for IE6, IE5
						xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
					xmlhttp.open("GET","AJAXhapus.php?nama="+nama[i],false);
					xmlhttp.send();
					
					if (xmlhttp.responseText.trim()=="true") {
						alert(nama[i]+" berhasil dihapus");	
					}
					else {
						alert("Tidak ada barang bernama " + nama[i]);
					}
				}
				window.location = "indexadmin.php";
			}
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middleadmin.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Hapus Barang</h2>
		<form name="hapus">
			Nama Barang: <br><input type="text" name="nama" size="40"><br>
		
			<button id="submit" type="button" onclick="AJAXhapusBarang()">Hapus</button>
		</form>
		</div>
		</div>
	</body>
</html>