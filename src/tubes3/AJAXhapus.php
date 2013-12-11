<?php 
	
	$nama=$_GET["nama"];

	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_barang WHERE nama='$nama'";
	$url.= rawurlencode($sqlquery2);
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);

	
	if ($sqlresult2==false) {
		echo "false";
	} else {
	
		$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
		$sqlquery3 = "DELETE FROM data_barang WHERE nama='$nama'";
		$url.= rawurlencode($sqlquery3);
		$sqlresult3=json_decode(file_get_contents($url),true);
		
		
		$gambar = "images/";
		$gambar .= $nama;
		$gambar .= ".jpg";
		unlink($gambar);
		
		$deskripsi = "deskripsi/";
		$deskripsi .= $nama;
		$deskripsi .= ".txt";
		unlink($deskripsi);
		
		
		echo "true";
	}
?>