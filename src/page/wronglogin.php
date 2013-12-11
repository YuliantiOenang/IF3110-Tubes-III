<?php

?>
<!DOCTYPE html>
<html>
	<head>
		<title>Wrong Password</title>
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
				<h1>Kombinasi Username/Password Salah</h1>
				Email dan kata sandi yang Anda masukkan tidak cocok. Silakan ulangi input.
				<br>
				<br>
				<form action="database\checklogin.php" method="post">
				<div>
					<label for="login">Username :</label>
					<input type="text" id="loginusername" value="" name="username"/>
				</div>
				<div>
					<label for="asignee">Password : </label>
					<input type="password" id="loginPassword" value="" name="password"/>
				</div>
				<div>
					<input type="submit" value="Login"/>
					<a href="register.php">Register</a>
				</div>
				</form>
			</div>
			
			
	</body>
</html>