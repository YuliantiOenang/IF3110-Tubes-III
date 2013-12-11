<?php 
	
	$username=$_GET["username"];
	$email=$_GET["email"];
	
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_user WHERE username='$username' OR email='$email'";
	$url.= rawurlencode($sqlquery2);
	$result=json_decode(file_get_contents($url),true);
	
	$count=count($result);
	
	if ($result!=false) {
		echo "false";
	} else {
		$nama=$_GET["nama"];
		$nohp=$_GET["nohp"];
		$alamat=$_GET["alamat"];
		$provinsi=$_GET["provinsi"];
		$kota=$_GET["kota"];
		$kodepos=$_GET["kodepos"];
		$password=$_GET["password"];
		
		$sql2 = "INSERT INTO data_user (username,nama,nohp,alamat,provinsi,kota,kodepos,email,password, transaksi) VALUES ('$username','$nama','$nohp','$alamat','$provinsi','$kota','$kodepos','$email','$password',0)"; 
		
		$client = new SoapClient(null, array(
		  'location' => "http://boiling-meadow-3341.herokuapp.com/soap/SoapServer.php",
		  'uri'      => "urn://boiling-meadow-3341.herokuapp.com"));

		$return = $client->__soapCall("query",array($sql2));

		echo "true"; 
	} 
?>