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
		$sql="UPDATE `peralatan` SET `nama`='$_POST[nama_barang]',`kategori`='$_POST[kategori_barang]',`jumlah`= '$_POST[kategori_barang]',`harga`='$_POST[harga_barang]',`deskripsi`='$_POST[deskripsi_barang]',`foto`= 'images/$_POST[nama_barang].jpg',`status`='tersedia' WHERE `no_alat`= 66";
	
		if (!mysql_query($sql,$con))
		{
			die('Error: ' . mysql_error($con));
		}
		echo "\n1 record updated";
		
		$message = "Barang Berhasil diupdate !";
		echo "<script type='text/javascript'>alert('$message');</script>";
	}

	echo "<center> <a href=\"edit.php\">Klik disini</a> untuk kembali ke halaman edit barang </center>";	
	
	mysql_close($con);
	//header('Location: upload.php');
?>