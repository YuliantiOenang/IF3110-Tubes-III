<?php
if(isset($_GET['username'])){
	$username = $_GET['username']; 
}else{
	echo "Gagal mengambil data user!";
}
include "koneksi.inc.php";
$info_anggota = array();
$perintah = "select * from anggota where username = '".$username."'";
$hasil = mysql_query($perintah,$koneksi);
if($hasil){
	while($row = mysql_fetch_array($hasil)){
		array_push($info_anggota, $row['nama']);
		array_push($info_anggota, $row['nomorhp']);
		array_push($info_anggota, $row['alamat']);
		array_push($info_anggota, $row['provinsi']);
		array_push($info_anggota, $row['kota']);
		array_push($info_anggota, $row['kodepos']);
		array_push($info_anggota, $row['email']);
		array_push($info_anggota, $row['username']);
		array_push($info_anggota, $row['password']);
		array_push($info_anggota, $row['foto']);
		array_push($info_anggota, $row['jmltransaksi']);
		echo json_encode($info_anggota);
	}
}else{
	echo "Gagal koneksi ke database";
}
?>