<?php
	include("config.php");
	
	function addToUser($data){
		// mengecek apakah masih bisa meng-add barang dengan id tertentu sejumlah tertentu
		// return -1 jika sukses, dan sisa barang jika gagal
		
		global $WSDL_URL, $SOAP_URL;
		
		ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
		$client = new SoapClient($WSDL_URL, array("location" => $SOAP_URL));
		$return = $client->createUser($data["username"], $data["password"], $data["email"], $data["name"], $data["address"], $data["provinsi"], $data["city"], $data["zipcode"], $data["contact"]);
		$array = simplexml_load_string($return);
		return $array;
	}
	
	function handleRegistrationAjax(){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		$response = addToUser($request);
		/*if ($sisa >= 0){
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
		}*/
			
		return json_encode($response);
	}
	
	if (isset($_POST["ajax"])){
		echo handleRegistrationAjax();
	}
?>
