<?php # HelloServer.php
# Copyright (c) 2005 by Sir Muhammad Furqan Habibi
#
function hello($someone) { 
   return "Hellololo " . $someone . "!";
} 
function hai($int) {
	return "Hai ".$int." !";
}
function query($args) {
	// Establish connection
	$pg_connection_string = "dbname=d5216j2nufkt99 host=ec2-54-235-99-46.compute-1.amazonaws.com port=5432 user=nulxwejlynnksi password=J17_WbbObzQJuwEGmDoR7avViM sslmode=require";
	$con = pg_connect($pg_connection_string);
	// Check connection
	if (!$con) {
		return "Failed to connect to MySQL: " . pg_last_error($con);
	}
	// Query
	$result = pg_query($con,$args);
	// Close connection
	pg_close($con);
	// Return value
	return pg_fetch_all ($result);
}

   $server = new SoapServer(null, array('uri' => "urn://boiling-meadow-3341.herokuapp.com"));
   $server->addFunction("hello"); 
   $server->addFunction("hai");
   $server->addFunction("query");
   $server->handle(); 
?>