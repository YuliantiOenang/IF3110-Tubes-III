<?php
	require_once "config.php";
	
	ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
	$client = new SoapClient($WSDL_URL);
	
	$return = $client->createUser("lalala", "lilili", "", "", "", "", "", "", "");
	
	header("Content-Type: text/plain");
	print_r($return);
?>