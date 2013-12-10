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
	
	function handleTransactionAjax(){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		switch($request["action"]){
			case "add":
				$response = addToCart($request["id_barang"], $request["jumlah"], $request["token"]);
			break;
			default:
				return null;
			break;
		}
		
		return json_encode($response);
	}
	
?>
