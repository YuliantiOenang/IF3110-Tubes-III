<?php

	
	$url="http://if3110tubes3.herokuapp.com/REST/getInputAdmin/".$_POST['nama_barang'];
	$response=json_decode(file_get_contents($url),true);
    
	if($response['jumlah']>0)
	{
		$message1 = "Nama Barang telah Dipakai, Silahkan Gunakan Nama Barang Lain.";
		echo "<script type='text/javascript'>alert('$message1');</script>";
	}
	else
	{
		$sql="INSERT INTO peralatan(nama, kategori, jumlah, harga, deskripsi, foto, status) 
		VALUES ('$_POST[nama_barang]','$_POST[kategori_barang]','$_POST[jumlah_barang]','$_POST[harga_barang]','$_POST[deskripsi_barang]','images/$_POST[nama_barang].jpg','tersedia')";
		$url="http://if3110tubes3.herokuapp.com/REST/update/".$sql;
		$response=json_decode(file_get_contents($url));
		if (!$response)
		{
			
		}
		echo "\n1 record added";
		
		$message = "Barang Berhasil ditambahkan !";
		echo "<script type='text/javascript'>alert('$message');</script>";
	}

	echo "<center> <a href=\"upload.php\">Klik disini</a> untuk kembali ke halaman upload barang </center>";	

	//header('Location: upload.php');
?>