<?php

	if(!isset($_SESSION)){
		session_start();
	}

	if (!function_exists('getConnection')) {
		function getConnection(){
			// Create connection
			$con = mysql_connect("us-cdbr-east-04.cleardb.com","b9f4a8d8753ebe","ce0c24cb");
	
			// Check connection
			if (mysql_errno($con)){
				echo "Failed to connect to MySQL: " . mysql_error();
			} else {
				mysql_select_db("heroku_2dbe2b028d56fd8");
			}

			return $con;
		}
	}
?>