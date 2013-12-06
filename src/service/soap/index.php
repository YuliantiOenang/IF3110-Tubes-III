<?php 

/*** SOAP server ***/

require_once "../model/barang.php";
require_once "../model/user.php";

function getXMLRetval($retval){
	$xml = "<retval>";
	foreach($retval as $key => $value){
		$xml .= "<$key>$value</$key>";
	}
	$xml .= "</retval>";
	
	return $xml;
}

function createUser($username, $email, $nama_lengkap, $alamat, $provinsi, $kota, $kodepos, $telepon){
	$response["status"] = "ok";
	return getXMLRetval($response);
}

function createBarang($token, $nama_barang, $harga, $stok, $kategori, $deskripsi){
	$desc = add_barang($token, $nama_barang, $harga, $stok, $kategori, $deskripsi);

	if($desc==""){
		$response["status"] = "ok";
	}else{
		$response["status"] = "error";
		$response["detail"] = $desc;
	}
	
	return getXMLRetval($response);
}

ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
$server = new SoapServer("service.wsdl");
$server->addFunction("createUser");
$server->addFunction("createBarang");
$server->handle();


?>