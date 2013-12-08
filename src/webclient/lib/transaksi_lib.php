<?php
	//require_once dirname(__FILE__)."/rest_request.php";

	//fungsi-fungsi transaksi barang
	
	function addToCart($id_barang, $jumlah, $token){
		// mengecek apakah masih bisa meng-add barang dengan id tertentu sejumlah tertentu
		
		$data["jumlah"]=$jumlah;
		$data["token"]=$token;
		
		$response = sendRestRequest("POST", "cart/$id_barang", $data);
		
		return $response;
	}
	
	function checkCreditCart($id, $user){
		$data["token"] = $id;
		
		$response = sendRestRequest("GET", "user/$user/card", $data);
		
		return @$response["has_card"];
	}
	
	function updateTransactionUser($id){
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		
		$statement = $conn->prepare("UPDATE member SET jumlah_transaksi = jumlah_transaksi + 1 WHERE mem_id = ?");
		
		$statement->bind_param("i", $id);
		$statement->execute();
			
		$statement->close();
		$conn->close();
	}
	
	function buy($list, $id, $user){
		/* list adalah array barang yang akan dibeli. tiap elemennya adalah:
		 * 		{"id" => id barang tsb, "jumlah" => jumlah barang yg dibeli}
		 * 
		 * buy() mengembalikan true jika pembelian berhasil, false jika gagal (ada barang yg tidak mencukupi).
		 * jika ada satu jenis barang yg tidak mencukupi, maka seluruh transaksi digagalkan
		 */
		 
		
		if(!checkCreditCart($id, $user)){
			$response["status"] = "error";
			$response["code"] = -1;
			return $response;
		}		 
		
		$data["cart"] = $list; $data["token"] = $id;
		
		$response = sendRestRequest("POST", "buy", $data);
		
		//print_r($response);
		
		if ($response["status"] != "ok"){
			$response["r"] = print_r($response);
			$response["code"] = 0;
		}
		
		return $response;
	}
	
	function handleTransactionAjax(){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		switch($request["action"]){
			case "add":
				$response = addToCart($request["id_barang"], $request["jumlah"], $request["token"]);
			break;
			case "buy":
				$response = buy($request["list"], $request["id"],  $request["user"]);
				/*if($result == 1){
					$response["status"] = "ok";
				}else{
					$response["code"] = $result;
				}*/
			break;
			default:
				return null;
			break;
		}
		
		return json_encode($response);
	}
	
?>
