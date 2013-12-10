<?php  

session_start();

require_once("databaseconnect.php");   //memanggil file databaseconnect.php  

connect_db();       // memanggil fungsi connect_db yang ada di file databaseconnect.php  

$username=mysql_real_escape_string($_POST['username']);
$password=mysql_real_escape_string($_POST['password']);
$email=mysql_real_escape_string($_POST['email']);
$namalengkap=mysql_real_escape_string($_POST['namalengkap']);
$nohp=mysql_real_escape_string($_POST['nohp']);
$provinsi=mysql_real_escape_string($_POST['provinsi']);
$kotakabupaten=mysql_real_escape_string($_POST['kotakabupaten']);
$alamat=mysql_real_escape_string($_POST['alamat']);
$kodepos=mysql_real_escape_string($_POST['kodepos']);

$_SESSION['email']=$email;
$_SESSION['namalengkap']=$namalengkap;
$_SESSION['nohp']=$nohp;
$_SESSION['provinsi']=$provinsi;
$_SESSION['kotakabupaten']=$kotakabupaten;
$_SESSION['alamat']=$alamat;
$_SESSION['kodepos']=$kodepos;

$query = "UPDATE user SET password = '$password', email = '$email', namalengkap = '$namalengkap', nohp = '$nohp', provinsi = '$provinsi', kotakabupaten = '$kotakabupaten', alamat = '$alamat' ,kodepos='$kodepos' WHERE username = '$username'";
$result =mysql_query($query) or die (mysql_error());

header('location: edit-profile.php');  


 ?> 