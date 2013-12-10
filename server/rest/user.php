<?php


function login($username,$password){
	
	$dbconn = pg_connect("host=ec2-174-129-21-42.compute-1.amazonaws.com port=5432 dbname=d38nf6s0hs1vt2 user=cxebbwvchsgibe password=fAHejbAEaq2jW-Kaa8ej74FK3S sslmode=require options='--client_encoding=UTF8'") or die('Could not connect: ' . pg_last_error());
		
	$query = "SELECT * FROM user_ WHERE username='$username' AND password='$password'";
	$result=pg_query($query);
	$row = pg_fetch_assoc($result);
	$response = $row;	
	return $response;
}

function getprofile($username){
	$dbconn = pg_connect("host=ec2-174-129-21-42.compute-1.amazonaws.com port=5432 dbname=d38nf6s0hs1vt2 user=cxebbwvchsgibe password=fAHejbAEaq2jW-Kaa8ej74FK3S sslmode=require options='--client_encoding=UTF8'") or die('Could not connect: ' . pg_last_error());
	$query = "SELECT * FROM user_ WHERE username='$username'";
	$result=pg_query($query);
	$response = pg_fetch_assoc($result);
	return $response;
}

?>