<?php 
	//$db2=mysql_connect("localhost","root",null) or die("cannot connect");
	//mysql_select_db("ruserba")or die("cannot select DB");
	
	
	$nama=$_GET["nama"];
	$kategori=$_GET["kategori"];
	$harga=$_GET["harga"];
	$deskripsi=$_GET["deskripsi"];
	$stok=$_GET["stok"];
	
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_barang WHERE nama='$nama'";
	$url.= rawurlencode($sqlquery2);
	//$sqlresult2 = mysql_query($sqlquery2,$db2 ) or die ('Unable to run query:'.mysql_error());
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);

	
	if ($sqlresult2!=false) {
		echo "false";
	} else {
		$sqlquery3 = "INSERT INTO data_barang (nama,harga,stok,kategori,terjual) VALUES ('$nama','$harga','$stok','$kategori',0)";
		$client = new SoapClient(null, array(
		  'location' => "http://boiling-meadow-3341.herokuapp.com/soap/SoapServer.php",
		  'uri'      => "urn://boiling-meadow-3341.herokuapp.com"));

		$return = $client->__soapCall("query",array($sqlquery3));
		
		$strPath = "c:\\xampp\\htdocs\\tubes3\\deskripsi\\";
		$strPath .= $nama;
		$strPath .= ".txt";
		
		$fp = fopen($strPath, 'w');
		fwrite($fp, $deskripsi);
		fclose($fp);
		
		echo "true";	
	}
	
	//mysql_close($db2);
?>

