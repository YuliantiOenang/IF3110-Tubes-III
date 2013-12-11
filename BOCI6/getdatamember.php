<?php  

session_start();
    // memanggil fungsi connect_db yang adadi  file databaseconnect.php  

$username = $_COOKIE['username'];
$password = $_COOKIE['password'];

$postdata = http_build_query(
    array(
        'username' => $username,
		'password' => $password
	)
	);

$opts = array('http' =>
    array(
        'method'  => '.GET',
        'header'  => "Content-type: application/x-www-form-urlencoded",
        'content' => json_encode($postdata)
    )
);

$context  = stream_context_create($opts);

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/getprofile', false, $context);

$result=json_decode($result,true);

$email=$result["email"];
$namalengkap=$result["namalengkap"];
$nohp=$result["nohp"];
$provinsi=$result["provinsi"];
$kotakabupaten=$result["kotakabupaten"];
$alamat=$result["alamat"];
$kodepos=$result["kodepos"];

$_SESSION['username']=$username;
$_SESSION['password']=$password;
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