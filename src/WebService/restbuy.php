<?php
if (isset($_GET['data'])) $tabel = json_decode($_GET['data'],true);
if(isset($_GET['username'])) $username = $_GET['username'];
include "koneksi.inc.php";
	$contents = array();
	for($i=0;$i<sizeof($tabel);$i++){
		if($tabel[$i]>0){
			$sql="UPDATE barang SET jumlah = jumlah - '$tabel[$i]',terjual = terjual +'$tabel[$i]' WHERE id = '$i'";
			mysql_query($sql,$koneksi);
		}
	}
	$sql4="UPDATE anggota SET jmlhtransaksi = jmlhtransaksi+1 WHERE username = '$username'";
	if(mysql_query($sql4,$koneksi)){}else{ echo "Gagal transaksi"; }
?>