<?php

session_start();  

require_once("databaseconnect.php");   //memanggil file databaseconnect.php  

connect_db();  


$username=$_POST['username'];
$password=$_POST['password'];
$email=$_POST['email'];
$namalengkap=$_POST['namalengkap'];
$nohp=$_POST['nohp'];
$provinsi=$_POST['provinsi'];
$kotakabupaten=$_POST['kotakabupaten'];
$alamat=$_POST['alamat'];
$kodepos=$_POST['kodepos'];

// Insert data into db
ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
$client = new SoapClient("http://gentle-ocean-7553.herokuapp.com/service.wsdl");
$return = $client->createUser($username,$password,$email,$namalengkap,$nohp,$provinsi,$kotakabupaten,$alamat,$kodepos,' ');
echo $return;
 $_SESSION['username']=$username;  
 $_SESSION['password']=$password;  
 $Expire = time() +60*60*24*30;
 setcookie('username', $username, $Expire);
setcookie('password', $password, $Expire);

		
 
 header('location: credit-card.php'); 
exit;  

?>