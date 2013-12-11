<?php
include "koneksi.inc.php";
if (isset($_GET['data'])) $tabel = json_decode($_GET['data'],true);
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