<?php
/*
if(isset($_POST['username'])){
	$username = $_POST['username']; 
}else{
	echo "Gagal mengambil data user!";
}
include "koneksi.inc.php";
$perintah = "select * from anggota where username = '".$username."'";
$hasil = mysql_query($perintah,$koneksi);
if($hasil){
	while($row = mysql_fetch_array($hasil)){
		echo $row['nama']."||";
		echo $row['nomorhp']."||";
		echo $row['alamat']."||";
		echo $row['provinsi']."||";
		echo $row['kota']."||";
		echo $row['kodepos']."||";
		echo $row['email']."||";	
		echo $row['username']."||";
		echo $row['password']."||";
		echo $row['foto']."||";
		echo $row['jmlhtransaksi'];
	}
}else{
	echo "Gagal koneksi ke database";
}*/



//meminta daftar barang dengan REST
$service_url = 'restprofile.php';
$curl = curl_init($service_url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
$curl_response = curl_exec($curl);
if ($curl_response === false) {
	$info = curl_getinfo($curl);
	curl_close($curl);
	die('error occured during curl exec. Additional info: ' . var_export($info));
}
curl_close($curl);
$row = json_decode($curl_response);
for($i=0;$i<sizeof($row);$i++){
	echo $row['nama']."||";
	echo $row['nomorhp']."||";
	echo $row['alamat']."||";
	echo $row['provinsi']."||";
	echo $row['kota']."||";
	echo $row['kodepos']."||";
	echo $row['email']."||";	
	echo $row['username']."||";
	echo $row['password']."||";
	echo $row['foto']."||";
	echo $row['jmlhtransaksi'];
}
?>