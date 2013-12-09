<?php
	    
	$sql="DELETE FROM peralatan WHERE no_alat= ".$_GET['idBarang']."";
	$url="http://limitless-earth-2748.herokuapp.com/REST/update/".urlencode($sql);
	$response=json_decode(file_get_contents($url),true);

	echo "\n1 record deleted";
		
	$message = "Barang Berhasil didelete !";
	echo "<script type='text/javascript'>alert('$message');</script>";

	echo "<center> <a href=\"edit.php\">Klik disini</a> untuk kembali ke halaman sebelumnya </center>";	
	
?>