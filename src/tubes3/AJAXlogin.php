<?php 	
	$username=$_GET["username"];
	$password=$_GET["password"];
	
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	
	if ($username=="admin") {
		$sqlquery2 = "SELECT * FROM data_admin WHERE username='$username' AND password='$password'";
		$url.= rawurlencode($sqlquery2);
		$result=json_decode(file_get_contents($url),true);
		
		if ($result!=false) 
			echo "true";
		else 
			echo "false";
	} else { 
		$sqlquery2 = "SELECT * FROM data_user WHERE username='$username' AND password='$password'";
		$url.= rawurlencode($sqlquery2);
		$result=json_decode(file_get_contents($url),true);
		
		if ($result!=false) 
			echo "true";
		else 
			echo "false";
	
	}
?>
