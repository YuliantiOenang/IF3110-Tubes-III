<?php
		
	//$namabarang = $_POST['nama_barang'];
	$url="http://if3110tubes3.herokuapp.com/REST/getInputAdmin/".urlencode($_POST['nama_barang']);
	$response=json_decode(file_get_contents($url),true);
    
	if($response['jumlah']>0)
	{
		$message1 = "Nama Barang telah Dipakai, Silahkan Gunakan Nama Barang Lain.";
		echo "<script type='text/javascript'>alert('$message1');</script>";
	}
	else
	{
		$sql="UPDATE peralatan SET nama='".$_POST['nama_barang']."',kategori='".$_POST['kategori_barang']."',jumlah= '".$_POST['jumlah_barang']."',harga='".$_POST['harga_barang']."',deskripsi='".$_POST['deskripsi_barang']."',foto='".$_POST['nama_barang'].".jpg',status='tersedia' WHERE no_alat=".$_POST['idBarang']."";
		
		$url="http://if3110tubes3.herokuapp.com/REST/update/".urlencode($sql);
		$response=json_decode(file_get_contents($url));
		if (!$response)
		{
			
		}
		echo "\n1 record update";
		
		$message = "Barang Berhasil diupdate !";
		echo "<script type='text/javascript'>alert('$message');</script>";
	}

	echo "<center> <a href=\"edit.php\">Klik disini</a> untuk kembali ke halaman edit barang </center>";	
	
	//header('Location: upload.php');
?>