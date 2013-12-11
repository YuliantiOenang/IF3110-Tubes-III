<?php  

session_start();


$username=$_POST['username'];
$password=mysql_real_escape_string($_POST['password']);
$email=mysql_real_escape_string($_POST['email']);
$namalengkap=mysql_real_escape_string($_POST['namalengkap']);
$nohp=mysql_real_escape_string($_POST['nohp']);
$provinsi=mysql_real_escape_string($_POST['provinsi']);
$kotakabupaten=mysql_real_escape_string($_POST['kotakabupaten']);
$alamat=mysql_real_escape_string($_POST['alamat']);
$kodepos=mysql_real_escape_string($_POST['kodepos']);

$postdata = http_build_query(
    array(
        'username' => $username,
		'password' => $password,
		'namalengkap' => $namalengkap,
		'nohp' => $nohp,
		'provinsi' => $provinsi,
		'kotakabupaten' => $kotakabupaten,
		'alamat' => $alamat,
		'kodepos' => $kodepos
		
	)
	);

$opts = array('http' =>
    array(
        'method'  => '.PUT',
        'header'  => "Content-type: application/x-www-form-urlencoded",
        'content' => json_encode($postdata)
    )
);

$context  = stream_context_create($opts);

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/editprofile', false, $context);
$result=json_decode($result,true);

$_SESSION['email']=$email;
$_SESSION['namalengkap']=$namalengkap;
$_SESSION['nohp']=$nohp;
$_SESSION['provinsi']=$provinsi;
$_SESSION['kotakabupaten']=$kotakabupaten;
$_SESSION['alamat']=$alamat;
$_SESSION['kodepos']=$kodepos;

header('location: edit-profile.php');  


 ?> 