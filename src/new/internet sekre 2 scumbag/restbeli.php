<?php
if (isset($_POST['id'])) $idbrg = $_POST['id'];
if (isset($_POST['qtt'])) $qtty = $_POST['qtt'];
include "koneksi.inc.php";
	$jumlah = array();
	$sql="SELECT * FROM barang WHERE id = '".$idbrg."'";
	$result = mysql_query($sql,$koneksi);
	//id barang ditemukan
	if(mysql_num_rows($result)==1){
		//cek quantity di database
		$row = mysql_fetch_array($result);
		array_push($jumlah, $row["jumlah"]);
		echo json_encode($jumlah);
	}
?>
