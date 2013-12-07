<?php

require_once "../config.php";

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

/*
function invalidate_user($username, $password, $email, $nama_lengkap, $alamat, $provinsi, $kota, $kodepos, $telepon){
	if (count($username) < 5) return "username minimal 5 karakter";
	if (!preg_match("/.+@.+\..{2,}/", $email)) return "format email salah";
	if ((count($password) < 8) || ($password == $username) || ($password = $email)) return "password minimal 8 karakter dan berbeda dengan username dan email";
	if (!preg_match("/.+ .+/", $nama_lengkap)) return "nama lengkap minimal 2 kata";
	return "";
}*/

// SOAP-based

function add_user($username, $password, $email, $nama_lengkap, $alamat, $provinsi, $kota, $kodepos, $telepon){
	$response["status"] = "error";
	
	
	$db = db_connect();
	
	$query  = "INSERT INTO user (username, password, email, nama_lengkap, alamat, provinsi, kota, kodepos, telepon) VALUES
				('$username', '$password', '$email', '$nama_lengkap', '$alamat', '$provinsi', '$kota', '$kodepos', '$telepon')";
				
	if ($db->query($query)){
		
		$token = base64_encode(uniqid($username, true));
		
		$query = "INSERT INTO token (token_id, username) VALUES ('$token', '$username')";
		$db->query($query);
	
		$response["status"] = "ok";
		$response["token"] = $token;
	}else{
		$response["desc"] = "username sudah ada";
	}
	
	
	$db->close();
	return $response;
}

// REST-based

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

function edit_card($username, $card, $token){
	$response["status"] = "error";
	$response["desc"] = "belum login";
	
	$db = db_connect();
	$query = "SELECT * FROM token WHERE token_id='$token' AND username='$username'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
	
		$card_name = @$card["card_name"]; $card_number = @$card["card_number"]; $card_date = @$card["card_date"];
		
		$query = "UPDATE user SET card_name='$card_name', card_number='$card_number', card_date='$card_date' WHERE username='$username'";
		
		$db->query($query);
		
		$response["status"] = "ok";	
		unset($response["desc"]);
	}
	
	$db->close();
	
	return $response;
}

function edit_user($username, $user, $token){
	$response["status"] = "error";
	$response["desc"] = "belum login";
	
	$db = db_connect();
	$query = "SELECT * FROM token WHERE token_id='$token' AND username='$username'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
	
		$sets = array();
		$attrs = array("password", "email", "nama_lengkap", "alamat", "provinsi", "kota", "kodepos", "telepon");
		
		foreach($attrs as $attr){
			$value = @$user[$attr];
			
			if ($value != ""){
				array_push($sets, "$attr = '$value'");
			}
		}
		
		if (count($sets) > 0){
			$setstr = join(", ", $sets);
			$query = "UPDATE user SET $setstr WHERE username='$username'";
			$db->query($query);
			$response["status"] = "ok";	
			
			unset($response["desc"]);
		}else{
			$response["desc"] = "update gagal";
		}
	}
	
	$db->close();
	
	return $response;
}

?>