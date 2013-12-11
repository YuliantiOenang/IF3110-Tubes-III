<?php
	if(isset($_GET['id'])){ $id=$_GET['id']; }
	include "koneksi.inc.php";
	$detail_barang = array();
	$query2 = "select * from barang where id='$id'";
	$hasil2 = mysql_query($query2,$koneksi);
	while($row = mysql_fetch_array($hasil2)){
		array_push($detail_barang, $row["gambar"]);
		array_push($detail_barang, $row["nama"]);
		array_push($detail_barang, $row["keterangan"]);
		array_push($detail_barang, $row["id"]);
	}
	echo json_encode($detail_barang);
?>