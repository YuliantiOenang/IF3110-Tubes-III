<?php 
	include "koneksi.inc.php";
	$kategori = array();
	$query2 = "select * from barang group by kategori";
	$hasil2 = mysql_query($query2,$koneksi);
	while($row = mysql_fetch_array($hasil2)){
		array_push($kategori, $row["kategori"]);
	}
	echo json_encode($kategori);
?>