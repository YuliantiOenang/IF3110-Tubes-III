<?php
	include(dirname(__FILE__)."/db.php");
	
	function checkPassword($user, $password){
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		$statement = $conn->prepare("SELECT mem_id FROM member WHERE username = ? AND password = ?");
		
		$statement->bind_param("ss", $user, $password);
		$statement->execute();
		
		$statement->bind_result($result);
		
		$fetch = $statement->fetch();
		
		$statement->close();
		$conn->close();
		
		return $fetch ? $result : -1;		
	}
	
	
	if(isset($_POST["ajax"])){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		switch($request["action"]){
			case "login":
				$id = checkPassword($request["user"], $request["pass"]);
				if ( $id!=-1){
					$response["status"] = "ok";
					$response["id"] = $id;
				}
			
			break;
			default:
				exit();
			break;
		}
		
		exit(json_encode($response));
	}
	
?>