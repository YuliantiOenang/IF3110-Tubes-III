<?php
	$dbhost  = 'localhost';
	$dbname  = 'tubes2';
	$dbuser  = 'root';
	$dbpass  = ''; 

	$con = mysql_connect($dbhost, $dbuser, $dbpass);
	
	// Check connection
	if($con == FALSE)
	{
		echo 'Cannot connect to database' . mysql_error();
	}
	else
	{
		echo 'Connected to database';
	}

	mysql_select_db($dbname, $con);
		
	//$namabarang = $_POST['nama_barang'];
	$result = mysql_query("SELECT `nama` FROM `peralatan` WHERE `nama` ='$_POST[nama_barang]'");
    
	if($row = mysql_fetch_array($result))
	{
		$message1 = "Nama Barang telah Dipakai, Silahkan Gunakan Nama Barang Lain.";
		echo "<script type='text/javascript'>alert('$message1');</script>";
	}
	else
	{
		$sql="INSERT INTO `peralatan`(`nama`, `kategori`, `jumlah`, `harga`, `deskripsi`, `foto`, `status`) 
		VALUES ('$_POST[nama_barang]','$_POST[kategori_barang]','$_POST[jumlah_barang]','$_POST[harga_barang]','$_POST[deskripsi_barang]','images/$_POST[nama_barang].jpg','tersedia')";
	
		if (!mysql_query($sql,$con))
		{
			die('Error: ' . mysql_error($con));
		}
		echo "\n1 record added";
		
		$message = "Barang Berhasil ditambahkan !";
		echo "<script type='text/javascript'>alert('$message');</script>";
	}

	echo "<center> <a href=\"upload.php\">Klik disini</a> untuk kembali ke halaman upload barang </center>";	
	
	mysql_close($con);
	//header('Location: upload.php');
?>