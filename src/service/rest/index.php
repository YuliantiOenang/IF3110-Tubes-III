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
				// post cart/<id_barang>
			break;
			case 'buy':
				// post buy
			break;
			case 'login':
				// post login
			break;
			case 'logout':
				// post login
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_put($urlpart, $data){
		$response["status"] = "error";
		$response["desc"] = "unknown resource ".@$urlpart[0];
		
		switch(@$urlpart[0]){
			case 'barang':
				$response = edit_barang(intval(@$urlpart[1]), @$data['token'], @$data['barang']);
			break;
			case 'user':
				if (@$urlpart[2] == "card"){
					// put user/<username>/card
				}else{
					// put user/<username>
				}
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_get($urlpart, $data){
		$response["status"] = "error";
		$response["desc"] = "unknown resource ".@$urlpart[0];
		
		switch(@$urlpart[0]){
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
					// get user/<username>/card
				}else{
					// get user/<username>
				}
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_delete($urlpart, $data){
		$response["status"] = "error";
		$response["desc"] = "unknown resource ".@$urlpart[0];
		
		switch(@$urlpart[0]){
			case 'barang':
				// delete barang/<id>
			break;
		}
		
		echo json_encode($response);
	}
	
	function handle_default($urlpart, $data){echo '{"status": "error", "desc": "action not supported"}';}
}

$handler = new ShopRestHandler();
$handler->handle();

?>