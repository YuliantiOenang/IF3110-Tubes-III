<?php

function createUser($username, $password,$email,$namalengkap,$nohp,$provinsi,$kotakabupaten,$alamat,$kodepos,$nocredit){
	$dbconn = pg_connect("host=ec2-174-129-21-42.compute-1.amazonaws.com port=5432 dbname=d38nf6s0hs1vt2 user=cxebbwvchsgibe password=fAHejbAEaq2jW-Kaa8ej74FK3S sslmode=require options='--client_encoding=UTF8'") or die('Could not connect: ' . pg_last_error());
	//in reality, this data would be coming from a database
	$query="INSERT INTO user_ VALUES ('$username', '$password','$email','$namalengkap','$nohp','$provinsi','$kotakabupaten','$alamat','$kodepos','$nocredit')";
	$result=pg_query($query); 
	$response="ok";
	return $response;
}

function createBarang($idbarang,$namabarang,$harga,$kategori,$jumlah,$deskripsi){
	$dbconn = pg_connect("host=ec2-174-129-21-42.compute-1.amazonaws.com port=5432 dbname=d38nf6s0hs1vt2 user=cxebbwvchsgibe password=fAHejbAEaq2jW-Kaa8ej74FK3S sslmode=require options='--client_encoding=UTF8'") or die('Could not connect: ' . pg_last_error());
	//in reality, this data would be coming from a database
	$query="INSERT INTO barang_ VALUES ('$idbarang', '$namabarang','$harga','$kategori','$jumlah','$deskripsi')";
	$result=pg_query($query); 

	$response="ok";
	return $response;
}

function createTransaction($namabarang,$harga,$jumlah,$username,$kategori,$detailpesanan){
	$dbconn = pg_connect("host=ec2-174-129-21-42.compute-1.amazonaws.com port=5432 dbname=d38nf6s0hs1vt2 user=cxebbwvchsgibe password=fAHejbAEaq2jW-Kaa8ej74FK3S sslmode=require options='--client_encoding=UTF8'") or die('Could not connect: ' . pg_last_error());
	//in reality, this data would be coming from a database
	$query="INSERT INTO transactionlog_ VALUES ('$namabarang','$harga','$jumlah','$username','$kategori','$detailpesanan')";
	$result=pg_query($query);	
	$response="ok";
	return $response;
}

ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
$server = new SoapServer("service.wsdl");
$server->addFunction("createUser");
$server->addFunction("createBarang");
$server->addFunction("createTransaction");

$server->handle();
?>