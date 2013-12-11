<?php

	$card_number = $_GET["card_number"];
	$card_name = $_GET["card_name"];
	$card_expired = $_GET["card_expired"];
	$return1 = array();
	
	$url= "http://limitless-earth-2748.herokuapp.com/REST/cekKartu/".urlencode($card_name)."/".$card_number;
	$response=json_decode(file_get_contents($url));
	
	$arr=$response;
	
	if($arr >0){
		$url= "http://limitless-earth-2748.herokuapp.com/REST/updateKartu/".urlencode($card_number)."/".$_COOKIE['IdCustomer'];
		$response=json_decode(file_get_contents($url));
		$mysql=$response;
		if($mysql)
		{
		$return1["status"] = true;
		}
		else
		{
		$return1["status"] = false;
		}
		echo json_encode($return1);
	}else{
		$return1["status"] = false;
		$return1["cek"] = $card_number;
		
		echo json_encode($return1);
	}
?>