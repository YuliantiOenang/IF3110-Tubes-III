<?php 

	$username=$_GET["username"];
	$email=$_GET["email"];
	$nama=$_GET["nama"];
	$nohp=$_GET["nohp"];
	$alamat=$_GET["alamat"];
	$provinsi=$_GET["provinsi"];
	$kota=$_GET["kota"];
	$kodepos=$_GET["kodepos"];
	$password=$_GET["password"];
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
		
	$sqlquery2 = "UPDATE data_user SET username='$username', nama='$nama', nohp='$nohp', alamat='$alamat', provinsi='$provinsi', kota='$kota', kodepos='$kodepos', email='$email', password='$password' WHERE username='$username'";
	$url.= rawurlencode($sqlquery2);
	$sqlresult2=json_decode(file_get_contents($url),true);
	
	echo "true";
	
?>
