<?php
if (isset($_GET['id'])) $idbrg = $_GET['id'];
if (isset($_GET['qtt'])) $qtty = $_GET['qtt'];
include "koneksi.inc.php";
	$sql="SELECT * FROM barang WHERE id = '".$idbrg."'";
	$result = mysql_query($sql,$koneksi);
	//id barang ditemukan
	if(mysql_num_rows($result)==1){
		//cek quantity di database
		$row = mysql_fetch_array($result);
		echo $row['jumlah'];
	}
?>
