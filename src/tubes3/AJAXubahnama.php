<?php 
	
	$nama=$_GET["nama"];
	$namanew=$_GET["namanew"];
	
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_barang WHERE nama='$namanew'";
	$url.= rawurlencode($sqlquery2);
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);
	
	if ($sqlresult2!=false) {
		echo "false";
	} else {
		$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
		$sqlquery3 = "SELECT * FROM data_barang WHERE nama='$nama'";
		$url.= rawurlencode($sqlquery3);
		$sqlresult3=json_decode(file_get_contents($url),true);
		$count2=count($sqlresult3);
		
		if ($sqlresult3==false) {
			echo "false";
		} else {
			for ($i=0;$i<$count2;$i++) {
				$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
				$sqlquery4 = "UPDATE data_barang SET nama='$namanew' WHERE nama='$nama'";
				$url.= rawurlencode($sqlquery4);
				$sqlresult4=json_decode(file_get_contents($url),true);
				
				$gambar = "images/";
				$gambar .= $nama;
				$gambar .= ".jpg";
				
				$gambarnew = "images/";
				$gambarnew .= $namanew;
				$gambarnew .= ".jpg";
				
				rename($gambar, $gambarnew);
				
				$deskripsi = "deskripsi/";
				$deskripsi .= $nama;
				$deskripsi .= ".txt";
				
				$deskripsinew = "deskripsi/";
				$deskripsinew .= $namanew;
				$deskripsinew .= ".txt";
				
				rename($deskripsi, $deskripsinew);
				
				echo "true";
			}
		}
	}
	

?>
