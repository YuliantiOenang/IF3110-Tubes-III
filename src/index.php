<?php
	require_once "config.php";
	
	$imgdata = "";
	
	ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
	$client = new SoapClient($WSDL_URL, array("location" => $SOAP_URL));
	
	$return = $client->createBarang("12345", "soto padang", 5000, 20, "makanan", "", $imgdata);
	
	header("Content-Type: text/plain");
	print_r($return);
?>