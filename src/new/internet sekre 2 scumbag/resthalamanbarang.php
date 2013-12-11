<?php
	if(isset($_GET['sort'])){ $sort=$_GET['sort']; }else{ $sort="nama"; }
	if(isset($_GET['page'])){ $page=($_GET['page']-1)*10; }else{ $page=0; }
	if(isset($_GET['kategori'])){ 
		$kategori=$_GET['kategori']; 
		$query2 = "select * from barang where kategori='$kategori' order by $sort limit $page,10";
	}else{
		$kategori=null;
		$query2 = "select * from barang order by $sort limit $page,10";
	}
	echo "<h3>Barang-barang $kategori yang kami jual</h3><hr>";
	if(isset($_GET['kategori'])){ 
		echo "<div style='text-align:right'>Sort by <a href='halamanbarang.php?kategori=$kategori&sort=nama'>Name</a> | <a href='halamanbarang.php?kategori=$kategori&sort=harga'>Harga</a></div>";
	}else{
		echo "<div style='text-align:right'>Sort by <a href='halamanbarang.php?sort=nama'>Name</a> | <a href='halamanbarang.php?sort=harga'>Harga</a></div>";
	}
	include "koneksi.inc.php";
	$info_barang = array();
	$barang = array();
	$hasil2 = mysql_query($query2,$koneksi);
	while($row = mysql_fetch_array($hasil2)){
		array_push($info_barang, $row["gambar"]);
		array_push($info_barang, $row["id"]);
		array_push($info_barang, $row["nama"]);
		array_push($info_barang, $row["harga"]);
		array_push($barang, $info_barang);
		$info_barang = array();
	}
	echo json_encode($barang);
?>