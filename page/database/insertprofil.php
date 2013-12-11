<?php 
	if(!isset($_SESSION)){
		session_start();
	}
	
	if (!function_exists('getConnection')) {
		function getConnection(){
			// Create connection
			$con = mysql_connect("us-cdbr-east-04.cleardb.com","b9f4a8d8753ebe","ce0c24cb","heroku_2dbe2b028d56fd8");
			// Check connection
			if (mysql_errno($con))
			{
				echo "Failed to connect to MySQL: " . mysql_error();
			}
			return $con;
		}
	}
	
	$con = getConnection();
	
	$profil_ID			= $_POST["textusername"];
	$profil_name		= $_POST["textnamalengkap"];
	$profil_password	= $_POST["textpassword"];
	$profil_email		= $_POST["textemail"];
	$profil_address		= $_POST["textalamat"];
	$profil_province	= $_POST["textprovinsi"];
	$profil_district	= $_POST["textkabupaten"];
	$profil_zipcode		= $_POST["textpos"];
	$profil_mobile		= $_POST["textHP"];
	
	$sql = "INSERT INTO userprofil 
			(profil_ID, profil_name, profil_password, profil_email, profil_address, profil_province, profil_district, profil_zipcode, profil_mobile)
	VALUES
			('$profil_ID', '$profil_name', '$profil_password', '$profil_email', '$profil_address', '$profil_province', '$profil_district', $profil_zipcode, $profil_mobile)";

	if (!mysql_query($sql))
	  {
	  die('Error: ' . mysql_error($con));
	  }

	  // */

	  mysql_close($con);
	
	$_SESSION['login_user'] = $profil_ID;
	
	header('Location: ..\profile.php');
?>