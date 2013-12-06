<?php

require_once "config.php";

// model: username, password, email, nama_lengkap, alamat, provinsi, kota, kodepos, telepon, jumlah_transaksi, has_card, role
// db : username, password, email, nama_lengkap, alamat, provinsi, kota, kodepos, telepon, jumlah_transaksi, role, card_name, card_number, card_date

function model_user($data){
	$user["username"] = @$data["username"]; $user["email"] = @$data["email"];
	$user["nama_lengkap"] = @$data["nama_lengkap"]; $user["alamat"] = @$data["alamat"];
	$user["provinsi"] = @$data["provinsi"]; $user["kota"] = @$data["kota"];
	$user["kodepos"] = @$data["kodepos"]; $user["telepon"] = @$data["telepon"];
	$user["jumlah_transaksi"] = @$data["jumlah_transaksi"]; $user["role"] = @$data["role"];
	$user["has_card"] = $data["card_name"] != null;
	
	return $user;
}

function get_user($username, $token){
	$response["status"] = "error";
	$response["desc"] = "belum login";
	
	$db = db_connect();
	$query = "SELECT * FROM token WHERE token_id='$token' AND username='$username'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
		
		$query = "SELECT * FROM user WHERE username='$username'";
		$result = $db->query($query);
		$row = $result->fetch_assoc();
		
		$response["status"] = "ok";
		$response["user"] = model_user($row);
			
		unset($response["desc"]);
	}
	
	$db->close();
	
	return $response;
}

function check_card($username, $token){
	$response = get_user($username, $token);
	
	if($response["status"] == "ok"){
		$response["has_card"] = $response["user"]["has_card"];
		unset($response["user"]);
	}
	
	return $response;
}

function login($username, $password){
	$response["status"] = "error";
	$response["desc"] = "username atau password salah";
	
	$db = db_connect();
	$query = "SELECT * FROM user WHERE password='$password' AND username='$username'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
		
		$token = base64_encode(uniqid($username, true));
		
		$query = "INSERT INTO token (token_id, username) VALUES ('$token', '$username')";
		$db->query($query);
		
		$response["status"] = "ok";
		$response["token"] = $token;
			
		unset($response["desc"]);
	}
	
	$db->close();
	
	return $response;
}

function logout($username, $token){
	$response["status"] = "error";
	$response["desc"] = "logout gagal";
	
	$db = db_connect();
	$query = "DELETE FROM token WHERE token_id='$token' AND username='$username'";
	
	if (($result = $db->query($query)) && ($db->affected_rows > 0)){		
		$response["status"] = "ok";			
		unset($response["desc"]);
	}
	
	$db->close();
	
	return $response;
}


?>