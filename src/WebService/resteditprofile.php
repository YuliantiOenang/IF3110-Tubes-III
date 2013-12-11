<?php
include "koneksi.inc.php";
if(isset($_POST['username'])){$username=$_POST['username'];}
if(isset($_POST['password'])){$password=$_POST['password'];}
if(isset($_POST['nama'])){$nama=$_POST['nama'];}
if(isset($_POST['nomorhp'])){$nomorhp=$_POST['nomorhp'];}
if(isset($_POST['alamat'])){$alamat=$_POST['alamat'];}
if(isset($_POST['provinsi'])){$provinsi=$_POST['provinsi'];}
if(isset($_POST['kota'])){$kota=$_POST['kota'];}
if(isset($_POST['kodepos'])){$kodepos=$_POST['kodepos'];}
if(isset($_POST['email'])){$email=$_POST['email'];}
if(isset($_POST['foto'])){$foto=$_POST['foto'];}

$perintah="update anggota set password='$password',nama='$nama',nomorhp='$nomorhp',alamat='$alamat',provinsi='$provinsi',kota='$kota',kodepos='$kodepos',email='$email',foto='$foto'
		where username='$username'";
$hasil=mysql_query($perintah,$koneksi);
if($hasil){
	echo "<html><body>Profile berhasil diedit!<br><a href='profile.php'>Kembali ke halaman profile</a></body></html>";
}else{
	echo "<html><body>Edit profile gagal.<br><a href='editprofile.php'>Edit ulang</a> atau <a href='index.php'>Kembali ke halaman utama</a></body></html>";
}
?>
