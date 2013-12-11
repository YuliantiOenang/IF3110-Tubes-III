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
	
	$con 	= getConnection();
	
	$sql	= "DELETE FROM `cart` WHERE 1";
	
	if (!mysql_query($sql))
	{
	  die('Error: ' . mysql_error($con));
	}
	
	mysql_close($con);
	
	header('Location: ..\cart.php');
?>