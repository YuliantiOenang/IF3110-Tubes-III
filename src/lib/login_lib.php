<?php
	include(dirname(__FILE__)."/db.php");
	
	function checkPassword($user, $password){
	
	    /*$services_json = json_decode(getenv("VCAP_SERVICES"),true);
		$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
		$username = $mysql_config["username"];
		$password = $mysql_config["password"];
		$hostname = $mysql_config["hostname"];
		$port = $mysql_config["port"];
		$db = $mysql_config["name"];
		$link = mysql_connect("$hostname:$port", $username, $password);
		$db_selected = mysql_select_db($db, $link);*/

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
	
	function getRole($user, $password){
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		$statement = $conn->prepare("SELECT role FROM member WHERE username = ? AND password = ?");
		
		$statement->bind_param("ss", $user, $password);
		$statement->execute();
		
		$statement->bind_result($result);
		
		$fetch = $statement->fetch();
		
		$statement->close();
		$conn->close();
		
		return $fetch ? $result : 'undefined';		
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
					$response["role"] = getRole($request["user"], $request["pass"]);
				}
			
			break;
			default:
				exit();
			break;
		}
		
		exit(json_encode($response));
	}
	
?>