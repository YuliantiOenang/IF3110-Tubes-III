<?php
	require 'dbdriver.php';
	
	$con = getConnection();

	$profil_ID			= $_POST["username"];
	$profil_password	= $_POST["password"];
	
	$profil_ID			= stripslashes($profil_ID);
	$profil_password	= stripslashes($profil_password);
	
	$profil_ID			= mysql_real_escape_string($profil_ID);
	$profil_password	= mysql_real_escape_string($profil_password);
	
	$sql = "SELECT * FROM userprofil WHERE profil_ID='$profil_ID' and profil_password='$profil_password'";
	$result	= mysql_query($sql);
	$count	= mysql_num_rows($result);

	if ($count == 1) {
		$_SESSION['login_user'] = $profil_ID;
		
		mysql_free_result($result);
		mysql_close($con);
		
		header('Location: ..\profile.php');
	} else {
		
		mysql_close($con);
		
		header('Location: ..\wronglogin.php');
	}
	
?>