<!DOCTYPE html>
<html>
	<head>
		<title>Profile</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body onload="select()">
		<!--Header-->
			<div id="header">
				<?php
					include("header.php");
				?>
			</div>
			<!--Body-->
			<div id="profile-page-body">
				<div id="profil">
					<?php 
					echo "Nama Lengkap<br><br>";
					echo "No HP<br><br>";
					echo "Alamat<br><br>";
					echo "Provinsi<br><br>";
					echo "Kabupaten<br><br>";
					echo "Kode Pos<br><br>";
					echo "Email<br><br>";
					echo "Transaksi<br><br>";
					?>
					<form method="post" action="edit-profile.php?username=a"><input type="submit" value="Edit" ></form>
				</div>
				<div id="profil">
					<?php 
					echo "  : ".$profil_name."<br><br>";
					echo "  : ".$profil_mobile."<br><br>";
					echo "  : ".$profil_address."<br><br>";
					echo "  : ".$profil_province."<br><br>";
					echo "  : ".$profil_district."<br><br>";
					echo "  : ".$profil_zipcode."<br><br>";
					echo "  : ".$profil_email."<br><br>";
					echo "  : ".$profil_transaction."<br><br>";
					?>
				</div>
			</div>
	</body>
</html>