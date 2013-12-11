<?php
	require_once "nusoap.php";
	function getHello($nama) {
        return join(",", array(
            "The WordPress Anthology",
            "PHP Master: Write Cutting Edge Code",
            "Build Your Own Website the Right Way",$nama));
	}
 
	$server = new soap_server();
	$server->register("getHello");
	$server->service($HTTP_RAW_POST_DATA);
?>