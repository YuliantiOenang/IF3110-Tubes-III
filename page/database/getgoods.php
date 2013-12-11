<?php

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
	
/*	function findPicture($ID){ 
		$con 	= getConnection();
		
		$sql 	= "SELECT goods_name FROM goods WHERE goods_ID = '$ID'";
		
		$result = mysql_query($sql);
		
		$row	= mysql_fetch_array($result);
		
		$path	= '../image/goods/'.$row["goods_name"].'.jpg';

		mysql_close($con);
		
		return $path;
	} 
	
	$URL = findPicture('goods002'); // */
	
//	echo $URL;

	$con	= getConnection();
	
	$sql	= "SELECT * FROM goods WHERE goods_detail LIKE '%a%'";
	
	$result	= mysql_query($sql);
	
	while($row = mysql_fetch_array($result)){
		echo $row["goods_ID"].'<br>';
	}
	
	
?>