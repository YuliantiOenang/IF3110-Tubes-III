<?php 
	if(!isset($_SESSION)){
		session_start();
	}
	if(isset($_SESSION['login_user'])) {
		$user_check = $_SESSION['login_user'];
	} else {
		$user_check = "";
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
	
	$profil_name		= $_POST["textgantinama"];
	$profil_password	= $_POST["textgantipassword"];
	$profil_address		= $_POST["textalamat"];
	$profil_province	= $_POST["textprovinsi"];
	$profil_district	= $_POST["textkabupaten"];
	$profil_zipcode		= $_POST["textpos"];
	$profil_mobile		= $_POST["textHP"];
	
	$sql = "UPDATE userprofil 
			SET
				profil_name		= '$profil_name',
				profil_password	= '$profil_password',
				profil_address	= '$profil_address',
				profil_province	= '$profil_province',
				profil_district	= '$profil_district',
				profil_zipcode	= '$profil_zipcode',
				profil_mobile	= '$profil_mobile'
			WHERE
				profil_ID		= '$user_check'";

	if (!mysql_query($sql))
	  {
	  die('Error: ' . mysql_error($con));
	  }

	  // */

	  mysql_close($con);
	  
	  header('Location: ..\profile.php');
?>