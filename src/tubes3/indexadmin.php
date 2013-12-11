<?php
require_once('header.php'); ?>
<html>
	<head>
		<link rel="stylesheet" href="layout.css">
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.php"
			}
		</script>
	</head>
	<?php
	require_once('middleadmin.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Home</h2>
		<p>Selamat Datang di Mode Admin</p>
		</div>
		</div>
	</body>
</html>