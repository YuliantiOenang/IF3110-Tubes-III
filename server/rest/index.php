<?php

require_once "user.php";
require_once "RestC.php";

class Rest extends RestC{
	function handle_post($urlpart,$data){
		$response["status"] = "error";
		$response["desc"] = "URI is not available in method POST";
		
		echo json_encode($response);
	}
	
	function handle_put($urlpart,$data){
		$response["status"] = "error";
		$response["desc"] = "URI is not available in method PUT";
		if ($urlpart[0]=="editprofile"){
			$response = editprofile($data["username"],$data["password"],$data["namalengkap"],$data["nohp"],$data["provinsi"],$data["kotakabupaten"],$data["alamat"],$data["kodepos"]);
		}
		if ($urlpart[0]=="insertcard"){
			$response = insertcard($data["username"],$data["nocredit"]);
		}
		if ($urlpart[0]=="buy"){
			$response = buy($data["namabarang"],$data["jumlah"]);
		}
		
		echo json_encode($response);
	}
	
	function handle_get($urlpart,$data){
		$response["status"] = "error";
		$response["desc"] = "URI is not available in method GET";
		if ($urlpart[0]=="login"){
			$response = login($data["username"],$data["password"]);
		}
		
		if ($urlpart[0]=="getprofile"){
			$response = getprofile($data["username"]);
		}
		
		if ($urlpart[0]=="barangbykategori"){
			$response = barangbykategori($data["kategori"]);
		}
		
		if ($urlpart[0]=="detailbarang"){
			$response = getdetail($data["namabarang"]);
		}
		
		if ($urlpart[0]=="sortbyharga"){
			$response = sortbyharga($data["kategori"]);
		}
		
		if ($urlpart[0]=="sortbynama"){
			$response = sortbynama($data["kategori"]);
		}
		
		if ($urlpart[0]=="search"){
			$response = search($data["search"]);
		}
		if ($urlpart[0]=="validasiusername"){
			$response = validasiusername($data["username"]);
		}
		if ($urlpart[0]=="validasiemail"){
			$response = validasiemail($data["email"]);
		}
		if ($urlpart[0]=="validasicreditnumber"){
			$response = validasicreditnumber($data["creditnumber"]);
		}
		if ($urlpart[0]=="validasicreditname"){
			$response = validasicreditname($data["creditnumber"],$data["creditname"]);
		}
		if ($urlpart[0]=="validasicreditexpire"){
			$response = validasicreditexpire($data["creditnumber"],$data["creditexpire"]);
		}
		
		if($urlpart[0]=="getjumlah"){
			$response = getjumlah($data["namabarang"]);
		}
		
		echo json_encode($response);
	}
	
	function handle_delete($urlpart,$data){
		$response["status"] = "error";
		$response["desc"] = "URI is not available in method DELETE";
		if ($urlpart[0]=="deletebarang"){
			$response = deletebarang($data["namabarang"]);
		}
		
		echo json_encode($response);
	}
	function handle_default($urlpart,$data,$method){
		$response["status"] = "error";
		$response["desc"] = "METHOD '$method' is not available";
		echo json_encode($response);
	}
}

$handler = new Rest();
$handler->handle();

?>