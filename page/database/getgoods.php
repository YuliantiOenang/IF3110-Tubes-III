<?php

	if (!function_exists('getConnection')) {
		function getConnection(){
			// Create connection
			$con = mysql_connect("us-cdbr-east-04.cleardb.com","b5830ec07ba4dd","5de126cd","heroku_19d5f7fc44e1595");
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
		
		$path	= '../img/goods/'.$row["goods_name"].'.jpg';

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