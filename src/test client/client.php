<?php //client.php
ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
$client = new SoapClient("http://gentle-ocean-7553.herokuapp.com/service.wsdl");
$return = $client->createUser('ayam10000000','12341234','ayam100@budie.com','ayam3 budie','0','-','-','-','0',' '); //test soap
echo $return;


/////test rest
/*
$postdata = http_build_query(
    array(
        'username' => 'coba'
	)
);

$opts = array('http' =>
    array(
        'method'  => 'POST',
        'header'  => "Content-type: application/x-www-form-urlencoded\r\n"
		. "Content-Length: " . strlen($postdata) . "\r\n",
        'content' => $postdata
    )
);

$context  = stream_context_create($opts);

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest', false, $context);
echo $result;*/
?>