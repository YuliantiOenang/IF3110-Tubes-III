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
if(isset($_FILES['foto'])){
    $file_name = $_FILES['foto']['name'];
    $file_tmp =$_FILES['foto']['tmp_name'];
}
if(file_exists("images/".$_FILES["foto"]["name"])){
	echo $_FILES["foto"]["name"] . " already exists. ";
}else{
    move_uploaded_file($_FILES["foto"]["tmp_name"],"images/". $_FILES["foto"]["name"]);
}
$perintah="update anggota set password='$password',nama='$nama',nomorhp='$nomorhp',alamat='$alamat',provinsi='$provinsi',kota='$kota',kodepos='$kodepos',email='$email',foto='$file_name'
		where username='$username'";
if(!empty($username) and !empty($password)){
	$hasil=mysql_query($perintah,$koneksi);
	if($hasil){
		echo "<html><body>Profile berhasil diedit!<br><a href='profile.php'>Kembali ke halaman profile</a></body></html>";
	}else{
		echo "<html><body>Edit profile gagal.<br><a href='editprofile.php'>Edit ulang</a> atau <a href='index.php'>Kembali ke halaman utama</a></body></html>";
	}
}else{
	echo "<html><body>Your username or password is incorrect!<br><a href='editprofile.php'>Edit ulang</a> atau <a href='index.php'>Kembali ke halaman utama</a></body></html>";
}
?>
