<?php

class RestC{

	function handle(){
		$method = $_SERVER['REQUEST_METHOD'];	
		$lol = json_decode(file_get_contents("php://input"), true);
		$urlpart = explode("/", substr(@$_SERVER['PATH_INFO'], 1));
		header("Content-Type: text/plain");
		$lol.='&';
		$coba1 = "";
		$coba2= "";
		$bole = "false";
		for ($i = 0; $i<strlen($lol);$i++){
		
			if ($bole=="false"){
				if($lol[$i]!='=' && $lol[$i]!='&'){
					$coba1.=$lol[$i];
				}else{
					$bole="true";
					$i++;
				}
			}
			
			if ($bole=="true"){
				if ($lol[$i]!='&' && $lol[$i]!='='){
					$coba2.=$lol[$i];
				}else{
					$bole = "false";
					$data[$coba1]=$coba2;
					$coba1="";
					$coba2="";				
				}
			}
		}
		switch ($method) {
			case '.POST':
				$this->handle_post($urlpart, $data);
			break;
			case '.PUT':
				$this->handle_put($urlpart,$data);
			break;
			case '.GET':
				$this->handle_get($urlpart,$data);
			break;
			case '.DELETE':
				$this->handle_delete($urlpart,$data);
			break;
			default :
				$this->handle_default($urlpart,$data,$method);
			break;
		}
	}
	
	function handle_post($urlpart, $data){}
	function handle_put($urlpart,$data){}
	function handle_get($urlpart,$data){}
	function handle_delete($urlpart,$data){}
	function handle_default($urlpart,$data,$method){}
}

?>