<?php
	ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
	ini_set("display_errors", "On"); // disabling WSDL cache
	$client = new SoapClient("service.wsdl",array('location' => 'http://localhost/soap2/'));
	//$return = $client->createBarang("setyo", 1000, 5, "1", "ganteng");	
	//print_r(simplexml_load_string($return));
	$return = $client->createKartu(6,"1242434242343","Habibie","2013-12-12");	
	print_r(simplexml_load_string($return));
	//$return = $client->createUser("setyo2","setyo2", "setyo@setyo.com", "Setyo Legowo", "Jl. abcde","jabar", "bekasi", 17124, "08656");	
	//print_r(simplexml_load_string($return));
?>
