<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.php"
			}
			
			function AJAXaddBarang() {
				var nama=document.forms["addBarang"]["nama"].value;
						var kategori=document.forms["addBarang"]["kategori"].value;
						var harga=document.forms["addBarang"]["harga"].value;
						var stok=document.forms["addBarang"]["stok"].value;
						var deskripsi=document.forms["addBarang"]["deskripsi"].value;
						var xmlhttp;
						if (window.XMLHttpRequest)
							{// code for IE7+, Firefox, Chrome, Opera, Safari
							xmlhttp=new XMLHttpRequest();
						}
						else
							{// code for IE6, IE5
							xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
						}
						xmlhttp.open("GET","AJAXaddBarang.php?nama="+nama+"&kategori="+kategori+"&harga="+harga+"&stok="+stok+"&deskripsi="+deskripsi,false);
						xmlhttp.send();
						
						if (xmlhttp.responseText.trim()=="true") {
							window.location = "uploaderadmin.php?nama=" + nama;
						}
						else {
							alert("Terjadi Kesalahan, silakan coba lagi");
				}
			}
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middleadmin.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Tambah Barang</h2>
		<form name="addBarang">
			Nama Barang: <br><input type="text" name="nama" size="40"><br>
			Kategori: <br><select name="kategori">
				<option value="beras" selected>Beras</option>
				<option value="daging">Daging</option>
				<option value="ikan">Ikan</option>
				<option value="sayur">Sayur</option>
				<option value="buah">Buah</option>
			</select><br>
			Harga: <br><input type="text" name="harga" size="40"><br>
			Stok: <br><input type="text" name="stok" size="40"><br>
			Deskripsi: <br><input type="text" name="deskripsi" size="40"><br>
			
			<button id="submit" type="button" onclick="AJAXaddBarang()">Tambah</button>
		</form><br>
		
</form>
	</div>
	</div>
	</body>
</html>