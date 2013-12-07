<?php //client.php
ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
$client = new SoapClient("http://gentle-ocean-7553.herokuapp.com/service.wsdl");
$return = $client->createUser('ayam10000000','12341234','ayam100@budie.com','ayam3 budie','0','-','-','-','0',' ');
echo $return;
?>