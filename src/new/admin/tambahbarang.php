<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>RuSerBa</title>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />
</head>
<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
	<?php include file="header.php" ?>
	<?php include file="middle.php" ?>
	<article id="featured" class="body">
	<form method="post" action="tambahbarang">
		<h2>Tambah Barang Baru</h2>
		<pre>Nama Barang	: <input type="text" name="nama"></pre>
		<pre>Kategori		: <input type="text" name="kategori"></pre>
		<pre>Harga		: <input type="text" name="harga"></pre>
		<pre>Jumlah		: <input type="text" name="jumlah"></pre>
		<pre id="addedrequest">Deskripsi		: <textarea name="deskripsi" cols="25" rows="5"></textarea></pre>
		<pre>Link Gambar	: <input type="text" name="img"></pre>
		<input type="submit" value="Tambah">
	</form>
	</article><!-- /#featured -->
	</div>
</body>
</html>