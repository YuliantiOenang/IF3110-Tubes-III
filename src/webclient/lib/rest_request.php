<?php

require_once dirname(__FILE__)."/../config.php";

function sendRestRequest($method, $resource, $data){
	global $REST_URL;

	$url = $REST_URL.$resource;
	
	$ch = curl_init();
	
	$data = ($method == "GET") ? arrayToUriEncoded($data) : json_encode($data);
	
	switch($method){
		case "GET":
			$url .= $data;
		break;
		case "POST":
			curl_setopt($ch, CURLOPT_POSTFIELDS, $data);  
			curl_setopt($ch, CURLOPT_POST, 1); 
		break;
		case "PUT":
			$datalen = strlen($data);  
			
			curl_setopt($ch, CURLOPT_POSTFIELDS, $data);  
			curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');

		break;
		case "DELETE":
			$datalen = strlen($data);  
			
			curl_setopt($ch, CURLOPT_POSTFIELDS, $data);  
			curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'DELETE');
			
		break;	
	}
		
	curl_setopt($ch, CURLOPT_URL, $url); 
	curl_setopt($ch, CURLOPT_TIMEOUT, 20);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	 
	$response = curl_exec($ch);
	
	curl_close($ch);
	
	return json_decode($response, true);
}

function arrayToUriEncoded($arr){
	$parts = array();
	foreach ($arr as $key => $value){
		
		
		if (is_array($value)){
			array_push($parts, $key.'='.json_encode($value));
		}else{
			array_push($parts, $key.'='.$value);
		}
	}
	
	return "?".join("&", $parts);
}

?>