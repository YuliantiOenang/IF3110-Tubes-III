<?php

require_once "user.php";
require_once "RestC.php";

class Rest extends RestC{
	function handle_post($data){
		$response["tes1"] = "tes1";
		
		echo json_encode($response);
	}
	
	function handle_put($data){
		$response["tes1"] = "tes1";
		
		echo json_encode($response);
	}
	
	function handle_get($data){
		$response["tes1"] = "tes1";
		$response = get_user($data["username"]);
	
		echo json_encode($data);
	}
	
	function handle_delete($data){
		$response["tes1"] = "tes1";
		
		echo json_encode($response);
	}
}

$handler = new Rest();
$handler->handle();

?>