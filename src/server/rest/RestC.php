<?php

class RestC{

	function handle(){
		$method = $_SERVER['REQUEST_METHOD'];	
		$data = json_decode(file_get_contents("php://input"), true);
		
		header("Content-Type: text/plain");
		  
		switch ($method) {
			case 'POST':
				$this->handle_post($data);
			break;
			case 'PUT':
				$this->handle_put($data);
			break;
			case 'GET':
				$this->handle_get($data);
			break;
			case 'DELETE':
				$this->handle_delete($data);
			break;
		}
	}
	
	function handle_post($urlpart, $data){}
	function handle_put($urlpart, $data){}
	function handle_get($urlpart, $data){}
	function handle_delete($urlpart, $data){}
}

?>