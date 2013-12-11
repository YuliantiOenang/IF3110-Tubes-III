<?php
include "koneksi.inc.php";
if(isset($_GET['username'])){ 
	$perintah = "select * from kartu_kredit where owner = '".$_GET['username']."'";
	$hasil = mysql_query($perintah,$koneksi);
	if(mysql_num_rows($hasil)>0){
		$row = mysql_fetch_array($hasil);
		echo $row['card_number'];
	}else{
		echo "notregistered";
	}
}else{
	echo "error";
}
?>