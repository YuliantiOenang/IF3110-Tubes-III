<?php
require_once('lib/nusoap.php');

$server = new soap_server();
$server->configureWSDL('soap','urn:soap');
$server->register('hello', 
	array('name' => 'xsd:string'), 
	array('return' => 'xsd:string'), 
	'urn:soap', 
	'urn:soap#hello', 
	'rpc', 
	'encoded', 
	'Says hello'
);

$server->register('registerGan',
        array('userReg'=>'xsd:string', 'pwdReg'=>'xsd:string','namaReg'=>'xsd:string','emailReg'=>'xsd:string','alamatReg'=>'xsd:string','kotaReg'=>'xsd:string','provinsiReg'=>'xsd:string','kodeposReg'=>'xsd:string','nohpReg'=>'xsd:string'),
        array('return' => 'xsd:string'), 
        'urn:soap', 
        'urn:soap#registerGan', 
        'rpc', 
        'encoded', 
        'Register'        
        );


function hello($name)
{
	return 'Hello, '. $name;
}

function registerGan($userReg,$pwdReg,$namaReg,$emailReg,$alamatReg,$kotaReg,$provinsiReg,$kodeposReg,$nohpReg){
    include 'database.php';

    // post data 
	mysqli_query($con,"INSERT INTO `user` (username,password) VALUES ('$userReg','$pwdReg')");
    mysqli_close($con);
    mysqli_query($con,"INSERT INTO `user_profile` (username,nama,email,alamat,kota,provinsi,kode_pos,nomor_ponsel,jumlah_transaksi) 
                    VALUES ('$userReg',$namaReg,'$emailReg','$alamatReg','$kotaReg','$provinsiReg','$kodeposReg','$nohpReg',0)");
    mysqli_close($con);
}

$POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';
$server->service($POST_DATA);
?>