<?php 
	//$db2=mysql_connect("localhost","root",null) or die("cannot connect");
	//mysql_select_db("ruserba")or die("cannot select DB");
	
	$nama=$_GET["nama"];
	$harganew=$_GET["harganew"];
	
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_barang WHERE nama='$nama'";
	$url.= rawurlencode($sqlquery2);
	//$sqlresult2 = mysql_query($sqlquery2,$db2 ) or die ('Unable to run query:'.mysql_error());
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);
	
	if ($sqlresult2==false) {
		echo "false";
	} else {
		$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
		$sqlquery3 = "UPDATE data_barang SET harga='$harganew' WHERE nama='$nama'";
		$url.= rawurlencode($sqlquery3);
		//$sqlresult3 = mysql_query($sqlquery3,$db2 ) or die ('Unable to run query:'.mysql_error());
		$sqlresult3=json_decode(file_get_contents($url),true);
		echo "true";
	}
	
	//mysql_close($db2);
?>