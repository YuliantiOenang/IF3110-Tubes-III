<?php
	require_once "config.php";
	
	ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
	$client = new SoapClient($WSDL_URL);
	$return = $client->createBarang("nama_barang", 1000, 0, "abcde", "");
	
	print_r(simplexml_load_string($return));
?>