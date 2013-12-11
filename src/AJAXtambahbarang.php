<?php
include "koneksi.inc.php";
$sql = "insert into barang (nama, gambar, harga, kategori, jumlah, keterangan, terjual)
	values ('".$_POST['nama'].", '".$_POST['img'].", ".$_POST['harga'].", ".$_POST['kategori'].", ".$_POST['jumlah'].", ".$_POST['deskripsi'].",0)";
$hasil = mysql_query($query,$koneksi);
echo '
<html>
<body>
Selamat, Item "'.$_GET['nama'].'" telah berhasil ditambahkan"
<br><br><a href="adminbarang.php">Kembali ke halaman admin</a></body></html>';
?>