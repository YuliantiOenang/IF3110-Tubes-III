<?php
	include("lib/db.php");
	function addToUser($data){
		// mengecek apakah masih bisa meng-add barang dengan id tertentu sejumlah tertentu
		// return -1 jika sukses, dan sisa barang jika gagal
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		
		$statement = $conn->prepare("SELECT * FROM member WHERE Email = ?");
		
		$statement->bind_param("s", $data["email"]);
		$statement->execute();
		
		/*$statement->bind_result($email1);*/
		
		if (!$statement->fetch()){
			$statement1 = $conn->prepare("SELECT * FROM member WHERE Username = ?");
		
			$statement1->bind_param("s", $data["username"]);
			$statement1->execute();
		
			/*$statement1->bind_result($username1);*/
			if (!$statement1->fetch()){
				$name=$data["name"];
				$address=$data["address"];
				$contact=$data["contact"];
				$email=$data["email"]; 
				$username=$data["username"];
				$password=$data["password"];
				$statement2 = $conn->prepare("INSERT INTO member(name,address,contact,email,username,password,jumlah_transaksi)VALUES('$name', '$address', '$contact', '$email', '$username', '$password', 0)");
				$statement2->execute();
				$statement2->close();
				
				$statement2 = $conn->prepare("SELECT mem_id FROM member WHERE Username = ?");
				$statement2->bind_param("s", $data["username"]);
				$statement2->execute();
				
				$statement2->bind_result($id);
				$statement2->fetch();
				
				
				return $id;
			}
			else{
				return -1;
			}
			$statement1->close();
		}
		else{
			return -2;
		}
		$statement->close();
		$conn->close();		
		
		
	}
		
	
	function handleRegistrationAjax(){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		$sisa = addToUser($request);
		if ($sisa >= 0){
			$response["status"] = "ok";
			$response["id"] = $sisa;
		}else{
			$response["status"] = "error";
			if ($sisa == -1){
				$response["message"] = "Username sudah terdaftar sebelumnya";
			}
			else{
				$response["message"] = "Email sudah terdaftar sebelumnya";
			}
		}
			
		return json_encode($response);
	}
	
	if (isset($_POST["ajax"])){
		echo handleRegistrationAjax();
	}
?>
