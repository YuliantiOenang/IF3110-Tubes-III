<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.php"
			}
			
		
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middleadmin.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Ubah Informasi Barang</h2>
		<form name="hapus">
			<a href="ubahNamaadmin.php"><button type="button">Ubah Nama</button></a>
			<a href="ubahGambaradmin.php"><button type="button">Ubah Gambar</button></a>
			<a href="ubahhargaadmin.php"><button type="button">Ubah Harga</button></a>
			
		</form>
		</div>
		</div>
	</body>
</html>