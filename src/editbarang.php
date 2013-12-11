<?php include('headeradmin.php'); ?>
<?php include "sidebar.php";?>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />

<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto;">
	<article id="featured" class="body">
	<?php $id = $_GET['id'] ?>
	<form method="post" action="AJAXeditbarang.php">
		<h2>Edit</h2>
		<?php
		include "koneksi.inc.php";
		$sql = "select * from barang where id = ".$id;
		$result = mysql_query($sql,$koneksi);
				
		while($row = mysql_fetch_array($result)) {
			$nama = $row['nama'];
			$harga = $row['harga'];
			echo '
			<input type="hidden" name="id" value='.$row['id'].'>
			<pre>Nama Barang	: <input type="text" name="nama" value='.$row['nama'].'></pre>
            <pre>Kategori		: <input type="text" name="kategori" value='.$row['kategori'].'></pre>
            <pre>Harga			: <input type="text" name="harga" value='.$row['harga'].'></pre>
            <pre>Jumlah		: <input type="text" name="jumlah" value='.$row['jumlah'].'></pre>
            <pre id="addedrequest">Deskripsi		: <textarea name="deskripsi" cols="25" rows="5">'.$row['keterangan'].'</textarea></pre>
            <pre>Link Gambar	: <input type="text" name="gambar" value='.$row['gambar'].'></pre>
			';
		}
		?>
	<input type="submit" value="Edit">
	</form>
	</body>
</html>