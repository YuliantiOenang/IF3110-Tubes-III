<?php
require_once "nusoap.php";
$client = new nusoap_client("http://wbd032.ap01.aws.af.cm/SimpleSOAPServer.php");
$result = $client->call("getHello", array("nama" => "Adhitya"));
if ($client->fault) {
    echo "<h2>Fault</h2><pre>";
    print_r($result);
    echo "</pre>";
}
else {
    $error = $client->getError();
    if ($error) {
        echo "<h2>Error</h2><pre>" . $error . "</pre>";
    }
    else {
        echo "<h2>HELLO</h2><pre>";
        echo $result;
        echo "</pre>";
    }
}