<?php
$con=mysqli_connect("localhost","root","","ruserba");
// Check connection
if (mysqli_connect_errno()) {
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

// Query from database
$sql = "insert into barang (nama, gambar, harga, kategori, jumlah, keterangan, terjual)
	+ "VALUES ('".$_POST['nama']." + "," + '".$_POST['img']."+ "," 
	+ ".$_POST['harga']." + "," + ".$_POST['kategori']. + "," +".$_POST['jumlah']. + ","
   	+ ".$_POST['deskripsi']." + ",0" + "'")"";

mysqli_query($con,$ sql);
<html><body> Selamat, Item "+$_GET['nama']+" telah berhasil ditambahkan"
            		+ "<br><br><a href='adminbarang.php'>Kembali ke halaman admin</a></body></html>
mysqli_close($con);
?>