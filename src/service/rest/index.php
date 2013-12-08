<?php

/*** REST Server ***/

require_once "../model/barang.php";
require_once "../model/user.php";

require_once "RestHandler.php";

class ShopRestHandler extends RestHandler{
	function handle_post($urlpart, $data){
		$response["status"] = "error";
		$response["desc"] = "unknown resource ".@$urlpart[0];
		
		switch(@$urlpart[0]){
			case 'cart':
				$response = add_cart(intval(@$urlpart[1]), @$data["jumlah"], @$data["token"]);
			break;
			case 'buy':
				$response = buy(@$data["cart"], @$data["token"]);
			break;
			case 'login':
				$response = login(@$data["username"], @$data["password"]);
			break;
			case 'logout':
				$response = logout(@$data["username"], @$data["token"]);
			break;
			case 'test':
				$response = array("status" => "ok", "method" => "POST", "url" => $urlpart, "data" => $data);
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_put($urlpart, $data){
		$response["status"] = "error";
		$response["desc"] = "unknown resource ".@$urlpart[0];
		
		switch(@$urlpart[0]){
			case 'barang':
				$response = edit_barang(intval(@$urlpart[1]), @$data['token'], @$data['barang'], @$data['imgdata']);
			break;
			case 'user':
				if (@$urlpart[2] == "card"){
					$response = edit_card(@$urlpart[1], @$data["card"], @$data["token"]);
				}else{
					$response = edit_user(@$urlpart[1], @$data["user"], @$data["token"]);
				}
			break;
			case 'test':
				$response = array("status" => "ok", "method" => "PUT", "url" => $urlpart, "data" => $data);
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_get($urlpart, $data){
		$response["status"] = "error";
		$response["desc"] = "unknown resource ".@$urlpart[0];
		
		switch(@$urlpart[0]){
			case 'cart':
				$response = get_cart(@$data["ids"]);
			break;
			case 'barang':
				$response = get_barang(@$urlpart[1]);
			break;
			case 'kategori':
				$page = is_numeric(@$data["page"]) ? $data["page"] : 0;
				$sort = (@$data["sort"]=="harga") ? "harga" : "nama_barang"; 
				$order = (@$data["order"]=="desc") ? "desc" : "asc";
				
				$response = get_kategori(@$urlpart[1], $page, $sort, $order);
			break;
			case 'search':
				$page = is_numeric(@$data["page"]) ? $data["page"] : 0;
				$sort = (@$data["sort"]=="harga") ? "harga" : "nama_barang"; 
				$order = (@$data["order"]=="desc") ? "desc" : "asc";
				
				$response = search_barang(@$urlpart[1], $page, $sort, $order);
			break;
			case 'populer':
				$response = get_populer();
			break;
			case 'user':
				if (@$urlpart[2] == "card"){
					$response = check_card(@$urlpart[1], $data["token"]);
				}else{
					$response = get_user(@$urlpart[1], $data["token"]);
				}
			break;
			case 'test':
				$response = array("status" => "ok", "method" => "GET", "url" => $urlpart, "data" => $data);
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_delete($urlpart, $data){
		$response["status"] = "error";
		$response["desc"] = "unknown resource ".@$urlpart[0];
		
		switch(@$urlpart[0]){
			case 'barang':
				$response = del_barang(@$data["ids"], @$data["token"]);
			break;
			case 'test':
				$response = array("status" => "ok", "method" => "DELETE", "url" => $urlpart, "data" => $data);
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_default($urlpart, $data){echo '{"status": "error", "desc": "action not supported"}';}
}

$handler = new ShopRestHandler();
$handler->handle();

?>