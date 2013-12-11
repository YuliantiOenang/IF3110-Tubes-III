<?php
if (isset($_POST['data'])) $tabel = json_decode($_POST['data'],true);
if(isset($_POST['username'])) $username = $_POST['username'];
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