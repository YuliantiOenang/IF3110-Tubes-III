<?php
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	$ch = curl_init($rest."/kategori/".$_POST['id']);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
	curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
	curl_setopt($ch, CURLOPT_POSTFIELDS, 'nama_kategori='.$_POST['nama']);
	curl_exec($ch);
	curl_close($ch);
	header("location:../../pages/listkategori.php");
?>