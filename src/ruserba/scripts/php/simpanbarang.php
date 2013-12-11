<?php
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	$ch = curl_init($rest."/barang/".$_POST['id_barang']);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
	curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
	curl_setopt($ch, CURLOPT_POSTFIELDS, 'nama_barang='.$_POST['nama']);
	curl_exec($ch);
	$ch = curl_init($rest."/barang/".$_POST['id_barang']);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
	curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
	curl_setopt($ch, CURLOPT_POSTFIELDS, 'harga_barang='.$_POST['harga']);
	curl_exec($ch);
	$ch = curl_init($rest."/barang/".$_POST['id_barang']);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
	curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
	curl_setopt($ch, CURLOPT_POSTFIELDS, 'tersedia='.$_POST['tersedia']);
	curl_exec($ch);
	$ch = curl_init($rest."/barang/".$_POST['id_barang']);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
	curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
	curl_setopt($ch, CURLOPT_POSTFIELDS, 'gambar='.$_POST['gambar']);
	curl_exec($ch);
	curl_close($ch);
	header("location:../../pages/listbarang.php?kategori=".$_POST['kategori']);
?>