<?php
		
	//$namabarang = $_POST['nama_barang'];
	$url="http://limitless-earth-2748.herokuapp.com/REST/getInputAdmin/".urlencode($_POST['nama_barang']);
	$response=json_decode(file_get_contents($url),true);
    
	if($response['jumlah']>0)
	{
		$message1 = "Nama Barang telah Dipakai, Silahkan Gunakan Nama Barang Lain.";
		echo "<script type='text/javascript'>alert('$message1');</script>";
	}
	else
	{
		$url="http://limitless-earth-2748.herokuapp.com/REST/getUpdateAdmin/".urlencode($_POST['nama_barang'])."/".$_POST['kategori_barang']."/".$_POST['jumlah_barang']."/".$_POST['harga_barang']."/".urlencode($_POST['deskripsi_barang'])."/".urlencode($_POST['nama_barang'])."/".$_POST['idBarang']."";
		$response=json_decode(file_get_contents($url));
		if (!$response)
		{
			echo "gagal";
		}
		else
		{
		$message = "Barang Berhasil diupdate !";
		echo "<script type='text/javascript'>alert('$message');window.location='index.php'</script>";
		
		}
	}


	//header('Location: upload.php');
?>