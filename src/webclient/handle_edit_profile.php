<?php
	include("config.php");
	include("lib/rest_request.php");
	
	function updateUser($data){
		// mengecek apakah masih bisa meng-add barang dengan id tertentu sejumlah tertentu
		// return -1 jika sukses, dan sisa barang jika gagal
		
		global $WSDL_URL, $SOAP_URL;
		
		$result=sendRestRequest("PUT","user/".$data["user"]["username"],$data);
		return $result;
	}
	
	function handleEditProfileAjax(){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		$response = updateUser($request);
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
		echo handleEditProfileAjax();
	}
?>
