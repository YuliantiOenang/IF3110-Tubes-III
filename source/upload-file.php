<?php
if ($_FILES["file"]["error"] > 0)
{
	echo "Error: " . $_FILES["file"]["error"] . "<br>";
}
else
{
	echo "nama barang:".$_POST['namabarang']."<br>";
	echo "Harga:".$_POST['harga']."<br>";
	echo "Stok:".$_POST['stok']."<br>";
	echo "Kategori:".$_POST['kategori']."<br>";
	echo "Upload: " . $_FILES["file"]["name"] . "<br>";
	echo "Type: " . $_FILES["file"]["type"] . "<br>";
	echo "Size: " . ($_FILES["file"]["size"] / 1024) . " kB<br>";
	$namafile = $_FILES["file"]["name"];
	if (file_exists($_POST['kategori']."/" . $_FILES["file"]["name"]))
    {
		echo $_FILES["file"]["name"] . " already exists. ";
    }
    else
    {
		move_uploaded_file($_FILES["file"]["tmp_name"], "images/".$_POST['kategori']."/" . $_FILES["file"]["name"]);
		echo "Stored in: " . "images/" . $_FILES["file"]["name"];
		
		include('conn.php');
		//INSERT NEW MEMBER INTO DATABASE
		pg_query ("INSERT INTO barang (nama_barang, harga_barang, stok_barang, gambar_barang, kategori) VALUES ('$_POST[namabarang]', '$_POST[harga]', '$_POST[stok]', '$namafile', '$_POST[kategori]')");
		echo "<meta http-equiv=\"refresh\"
			content=\"1; URL = index.php\">";
    }
}
?> 