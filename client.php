<?php //client.php
ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
$client = new SoapClient("http://gentle-ocean-7553.herokuapp.com/service.wsdl");
$return = $client->createUser('ayam100','12341234','ayam100@budie.com','ayam3 budie','0','-','-','-','0',' '); //coba implement soap create user
echo $return;
?>