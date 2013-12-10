<?php
	include("config.php");
	
	function addBarang($data){
		// menambah barang ke service
		
		global $WSDL_URL, $SOAP_URL;
		
		$barang = $data["barang"];
		ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
		$client = new SoapClient($WSDL_URL, array("location" => $SOAP_URL));
		$return = $client->createBarang($data["token"], $barang["nama"], $barang["harga"], $barang["stok"], $barang["kategori"], $barang["deskripsi"], $data["imgdata"]);
		$array = simplexml_load_string($return);
		
		return $array;
	}
	
	function handleAddBarangAjax(){
		// handle ajax untuk add barang
		
		$raw = substr(file_get_contents("php://input"), strlen("ajax="));
		
		$request = json_decode($raw, true);
		$response = array("status" => "error");
		
		$response = addBarang($request);
			
		return json_encode($response);
	}
	
	if (isset($_POST["ajax"])){
		echo handleAddBarangAjax();
	}
?>
