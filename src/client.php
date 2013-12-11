<?php
    ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
    $client = new SoapClient("http://[path to service]/inventory.wsdl");
    $return = $client->getItemCount('12345');
    print_r($return);
?>