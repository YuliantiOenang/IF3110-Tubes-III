<?php

class RestHandler{

	function handle(){
		$method = $_SERVER['REQUEST_METHOD'];
		
		$urlpart = explode("/", substr(@$_SERVER['PATH_INFO'], 1));
		
		$data = json_decode(file_get_contents("php://input"), true);
		
		header("Content-Type: text/plain");
		header('Access-Control-Allow-Origin: *');
		header('Access-Control-Allow-Methods: POST, GET, PUT, DELETE, HEAD');

		switch ($method) {
			case 'POST':
				$this->handle_post($urlpart, $data);
			break;
			case 'PUT':
				$this->handle_put($urlpart, $data);
			break;
			case 'GET':
				$this->handle_get($urlpart, $_GET);
			break;
			case 'DELETE':
				$this->handle_delete($urlpart, $data);
			break;
			default:
				$this->handle_default($urlpart, $data);
			break;
		}
	}
	
	function handle_post($urlpart, $data){}
	function handle_put($urlpart, $data){}
	function handle_get($urlpart, $data){}
	function handle_delete($urlpart, $data){}
	function handle_default($urlpart, $data){}	
}

?>