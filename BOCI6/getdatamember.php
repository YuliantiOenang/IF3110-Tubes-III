<?php  

session_start();

require_once("databaseconnect.php");   //memanggil file databaseconnect.php  

connect_db();       // memanggil fungsi connect_db yang adadi  file databaseconnect.php  

$username = $_COOKIE['username'];
$password = $_COOKIE['password'];

$data = mysql_query("SELECT * FROM user where username='$username'") 
 or die(mysql_error()); 
 $num=mysql_numrows($data);
$data3 = mysql_query("select count(*) from transactionlog where username='$username';");
$data2=mysql_fetch_array($data3);
$i=0;
while ($i < $num) {

$email=mysql_result($data,$i,"email");
$namalengkap=mysql_result($data,$i,"namalengkap");
$nohp=mysql_result($data,$i,"nohp");
$provinsi=mysql_result($data,$i,"provinsi");
$kotakabupaten=mysql_result($data,$i,"kotakabupaten");
$alamat=mysql_result($data,$i,"alamat");
$kodepos=mysql_result($data,$i,"kodepos");
$cardnumber=mysql_result($data,$i,"nocredit");
$i++;
}
$_SESSION['username']=$username;
$_SESSION['password']=$password;
$_SESSION['cardnumber']=$cardnumber;
$_SESSION['email']=$email;
$_SESSION['namalengkap']=$namalengkap;
$_SESSION['nohp']=$nohp;
$_SESSION['provinsi']=$provinsi;
$_SESSION['kotakabupaten']=$kotakabupaten;
$_SESSION['alamat']=$alamat;
$_SESSION['kodepos']=$kodepos;
$_SESSION['jumlahtransaksi']=$data2[0];

header('location: edit-profile.php');  

 ?> 