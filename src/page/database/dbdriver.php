<?php

	if(!isset($_SESSION)){
		session_start();
	}

	if (!function_exists('getConnection')) {
		function getConnection(){
			// Create connection
			$con = mysql_connect("us-cdbr-east-04.cleardb.com","b5830ec07ba4dd","5de126cd");
	
			// Check connection
			if (mysql_errno($con)){
				echo "Failed to connect to MySQL: " . mysql_error();
			} else {
				mysql_select_db("heroku_19d5f7fc44e1595");
			}

			return $con;
		}
	}
?>