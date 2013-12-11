<?php 
	$username=$_GET["username"];
	$cardno=$_GET["cardno"];
	$nameoncard=$_GET["nameoncard"];
	$expdate=$_GET["expdate"];
	
	$sqlquery2 = "SELECT * FROM data_user WHERE cardno='$cardno' OR nameoncard='nameoncard'";
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$url.= rawurlencode($sqlquery2);
	$result=json_decode(file_get_contents($url),true);
	
	if ($result!=false) {
		echo "false";
	} else {

		$sql2 = "UPDATE data_user SET cardno='$cardno', nameoncard='$nameoncard', expdate='$expdate' WHERE username='$username'";
		$url2 = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
		$url2.= rawurlencode($sql2);
		$result=json_decode(file_get_contents($url2),true);
		echo "true";
	}
	
?>