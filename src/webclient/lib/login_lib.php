<?php
	include(dirname(__FILE__)."/rest_request.php");
	
	function checkPassword($user, $password){
		
		$data["username"] = $user;
		$data["password"] = $password;
		
		$res = sendRestRequest("POST", "login", $data);
		
		$response = simplexml_load_string($res);
		
		if ($response["status"] == "ok"){
			return $response["token"];
		}else{
			return null;
		}
	}
	
	
	if(isset($_POST["ajax"])){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		switch($request["action"]){
			case "login":
				$tok = checkPassword($request["user"], $request["pass"]);
				if ( $tok!=null){
					$response["status"] = "ok";
					$response["id"] = $tok;
				}
			
			break;
			default:
				exit();
			break;
		}
		
		exit(json_encode($response));
	}
	
?>