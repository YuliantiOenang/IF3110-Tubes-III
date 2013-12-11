<?php
include "koneksi.inc.php";
$info_barang = array();
$barang = array();
if(isset($_GET['sort'])){ $sort=$_GET['sort']; }else{ $sort="nama"; }
if(isset($_GET['page'])){ $page=($_GET['page']-1)*10; }else{ $page=0; }
if(isset($_GET['kategori'])){ 
	$kategori=$_GET['kategori']; 
	$query2 = "select * from barang where kategori='$kategori' order by $sort limit $page,10";
}else{
	$kategori=null;
	$query2 = "select * from barang order by $sort limit $page,10";
}
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