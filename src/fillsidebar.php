<?php
if (isset($_POST['data'])) $tabel = json_decode($_POST['data'],true);
include "koneksi.inc.php";
	$content = array();
	for($i=0;$i<sizeof($tabel);$i++){
		if($tabel[$i]>0){
			$sql="SELECT * FROM barang WHERE id = '".($i)."'";
			$result = mysql_query($sql,$koneksi);
			$row = mysql_fetch_array($result);
			array_push($content, array("id"=>($i),"nama"=>$row['nama'],"harga"=>$row['harga'],"jumlah"=>$row['jumlah'],"dibeli"=>$tabel[$i]));
		}
	}
	echo json_encode($content);
?>