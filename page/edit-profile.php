<?php
	require('database\getprofil.php');
	
	if(!isset($_SESSION)){
		session_start();
	}
	if(isset($_SESSION['login_user'])) {
		$user_check = $_SESSION['login_user'];
	} else {
		$user_check = "";
	}
	
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Profile</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="edit-profile.js"></script>
	</head>
	<body>
		<!--Header-->
			<div id="header">
				<?php
					include("header.php");
				?>
			</div>
			<!--Body-->
			<div id="profile-page-body">
				<h1>Edit Profil
                </h1>
				<div id="profil">
					Nama:<br><br>
					Ganti Password:<br><br>
					Konfirmasi Password:<br><br>
					Alamat:<br><br>
					Provinsi:<br><br>
					Kabupaten:<br><br>
					Kode Pos:<br><br>
					No HP:<br><br>
				</div>
				<div id="register-form">
				<form enctype="multipart/form-data" method="post" action="database\changeprofil.php">
					<!--Name-->
					<div id="spacing-nama">
					<input type="text" id="gantinama" onKeyUp="check_nama('<?php echo $profil_name; ?>')" name="textgantinama" value="<?php echo $profil_name;?>" /> <div id="warning-nama"></div> <br><br>
					</div>
					<!--Name-->
					<div id="spacing-password">
					<input type="password" id="gantipassword" onKeyUp="check_password('<?php echo $profil_password; ?>')" name="textgantipassword" value="<?php echo $profil_password;?>" /><div id="warning-password"></div> <br><br>
					</div>
					<!--HP-->
					<div id="spacing-konfirmasipassord">
					<input type="password" id="konfirmasigantipassword" onKeyUp="check_confirmpassword()" name="textkonfirmasigantipassword"/><div id="warning-konfirmasi"></div> <br><br>
					</div>
					<!--Alamat-->
					<div id="spacing-alamat">
					<input type="text" id="alamat" onKeyUp="check_alamat('<?php echo $profil_address; ?>')" name="textalamat" value="<?php echo $profil_address;?>" /><div id="warning-alamat"></div> <br><br>
					</div>
					<!--Provinsi-->
					<div id="spacing-provinsi">
					<input type="text" id="provinsi" onKeyUp="check_provinsi('<?php echo $profil_province; ?>')" name="textprovinsi" value="<?php echo $profil_province;?>" /><div id="warning-provinsi"></div> <br /><br>
					</div>
					<!--Kabupaten-->
					<div id="spacing-kabupaten">
					<input type="text" id="kabupaten" onKeyUp="check_kabupaten('<?php echo $profil_district; ?>')" name="textkabupaten" value="<?php echo $profil_district;?>" /><div id="warning-kabupaten"></div> <br /><br>
					</div>
					<!--Pos-->
					<div id="spacing-pos">
					<input type="text" id="pos" onKeyUp="check_pos('<?php echo $profil_zipcode; ?>')" name="textpos" value="<?php echo $profil_zipcode;?>" /><div id="warning-pos"></div> <br /><br>
					</div>
					<div id="spacing-HP">
					<input type="text" id="HP" onKeyUp="check_HP('<?php echo $profil_mobile; ?>')" name="textHP" value="<?php echo $profil_mobile;?>" /><div id="warning-HP"></div> <br /><br>
					</div>
					<button id="create">Confirm Edit</button>
				</form>
				<form method="post" action="profile.php"><input type="submit" value="Back" ></form>
				</div>
				
				<?php /*
				echo $profil_ID; echo "<br>";
				echo $profil_name; echo "<br>";
				echo $profil_password; echo "<br>";
				echo $profil_email; echo "<br>";
				echo $profil_address; echo "<br>";
				echo $profil_province; echo "<br>";
				echo $profil_district; echo "<br>";
				echo $profil_zipcode; echo "<br>";
				echo $profil_mobile; echo "<br>"; // */
				?>
			</div>
	</body>
</html>