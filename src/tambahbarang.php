<?php include("headeradmin.php"); ?>
<?php include "sidebar.php";?>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />

<html>
<body id="index" class="home">
	<div>
	<article id="featured" class="body">
	<form method="post" action="client.php">
		<h2>Tambah Barang Baru</h2>
		<pre>Nama Barang	: <input type="text" name="nama"></pre>
		<pre>Kategori		: <input type="text" name="kategori"></pre>
		<pre>Harga			: <input type="text" name="harga"></pre>
		<pre>Jumlah		: <input type="text" name="jumlah"></pre>
		<pre id="addedrequest">Deskripsi		: <textarea name="deskripsi" cols="25" rows="5"></textarea></pre>
		<pre>Link Gambar	: <input type="text" name="gambar"></pre>
		<input type="submit" value="Tambah">
	</form>
	</article>
	</div>
</body>
</html>

<?php include ("footer.php"); ?>