<!DOCTYPE html>
<html>
	<head>
		<title>Resistrasi</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="register.js"></script>
	</head>
	<body>
		<!--Header-->
			<div id="header">
				<?php
					include("header.php");
				?>
			</div>
			<!--Body-->
			<div id="task-page-body">
				<h1>REGISTRASI: 
                <?php 
				//	require('../php/init_function.php');
				//	$categoryid = $_GET['categoryid'];
				//	echo getCategoryName($categoryid);
				?>
                </h1>
				<div id="register">
					Username:<br><br>
					Nama Lengkap:<br><br>
					No HP:<br><br>
					Alamat:<br><br>
					Provinsi:<br><br>
					Kabupaten:<br><br>
					Kode Pos:<br><br>
					Password:<br><br>
					Confirm Password:<br><br>
					Email:
				</div>
				<div id="register-form">
				<form  method="post" action="database\insertprofil.php">
					<!--UserName-->
					<div id="spacing-username">
					<input type="text" id="username" onKeyUp="checker()" name="textusername" value="qweqweqweq"/><br /><br /><br />
					</div>
					<!--Name-->
					<div id="spacing-nama">
					<input type="text" id="namalengkap" onKeyUp="checker()" name="textnamalengkap" value="qweqweqweq adfasdasf"/> <br /><br />
					</div>
					<!--HP-->
					<div id="spacing-hp">
					<input type="text" id="HP" onKeyUp="checker()" name="textHP" value="213123122"/> <br /><br />
					</div>
					<!--Alamat-->
					<div id="spacing-alamat">
					<input type="text" id="alamat" onKeyUp="checker()" name="textalamat" value="asdasdfasf"/> <br /><br />
					</div>
					<!--Provinsi-->
					<div id="spacing-provinsi">
					<input type="text" id="provinsi" onKeyUp="checker()" name="textprovinsi" value="adsasdasd"/> <br /><br />
					</div>
					<!--Kabupaten-->
					<div id="spacing-kabupaten">
					<input type="text" id="kabupaten" onKeyUp="checker()" name="textkabupaten" value="qwdesqadasd"/> <br /><br />
					</div>
					<!--Pos-->
					<div id="spacing-pos">
					<input type="text" id="pos" onKeyUp="checker()" name="textpos" value="1231321"/> <br /><br />
					</div>
					<!--Password-->
					<div id="spacing-password">
					<input type="password" id="password" onKeyUp="checker()" name="textpassword"value="123456789"/> <br /><br /><br />
					</div>
					<!--Confirm Password-->
					<div id="spacing-confirmpassword">
					<input type="password" id="confirmpassword" onKeyUp="checker()" name="textconfirmpassword" value="123456789"/><br /><br />
					</div>
					<!--Email-->
					<div id="spacing-email">
					<input type="text" id="email" onKeyUp="checker()" name="textemail" value="asdasdas@asdadas.asdas"/><br />
					</div>
					<div id="warning-message"></div>
					<button id="create">REGISTER</button>
				</form>
				</div>
			</div>
	</body>
</html>