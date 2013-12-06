<?php

/*** Barang ***/

// model: id, nama, harga, stok, kategori, deskripsi, jumlah_beli
// db: id_barang, nama_barang, harga, stok, kategori, deskripsi, jumlah_beli


require_once "../config.php";

function model_barang($data){
	$barang["id"] = intval($data["id_barang"]);
	$barang["nama"] = $data["nama_barang"];
	$barang["harga"] = intval($data["harga"]);
	$barang["stok"] = intval($data["stok"]);
	$barang["kategori"] = $data["kategori"];
	$barang["deskripsi"] = $data["deskripsi"];
	$barang["jumlah_beli"] = intval($data["jumlah_beli"]);
	
	return $barang;
}

// SOAP-based

function add_barang($token, $nama_barang, $harga, $stok, $kategori, $deskripsi){
	$desc = "bukan admin";
	
	$db = db_connect();
	$query = "SELECT role FROM token NATURAL JOIN user WHERE token_id = '$token'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
		
		if ($result->fetch_assoc()["role"] != "admin"){
			$db->close();
			return $desc;
		}
	
		$query = "INSERT INTO barang (nama_barang, harga, stok, kategori, deskripsi) VALUES ('$nama_barang', $harga, $stok, '$kategori', '$deskripsi')";
		
		if($db->query($query)) $desc = "";
		else $desc = "barang tidak dapat ditambahkan";
	}
	
	$db->close();
	
	return $desc;
}

// REST-based

function get_barang($id){
	$response["status"] = "error";
	$response["desc"] = "barang tidak ditemukan";
	
	if ($id == "") return response;

	$db = db_connect();
	$query = "SELECT * FROM barang WHERE id_barang = ".$id;
	
	if ($result = $db->query($query)){
		while($row = $result->fetch_assoc()){
			$response["status"] = "ok";
			$response["barang"] = model_barang($row);
			
			unset($response["desc"]);
		}
	}
	
	$db->close();
	
	return $response;
}

function get_kategori($cat, $page, $sort, $order){
	$response["status"] = "error";
	$response["desc"] = "barang tidak ditemukan";
	
	if ($cat == "") return response;

	$db = db_connect();
	$query = "SELECT * FROM barang WHERE kategori = '$cat' ORDER BY $sort $order LIMIT $page, 10";
	
	if ($result = $db->query($query)){
		$response["hasil"] = array();
		$response["status"] = "ok";
		unset($response["desc"]);
		while($row = $result->fetch_assoc()){			
			array_push($response["hasil"], model_barang($row));
		}
	}
	
	$db->close();
	
	return $response;
}

function search_barang($q, $page, $sort, $order){
	$response["status"] = "error";
	$response["desc"] = "barang tidak ditemukan";
	
	if ($q == "") return response;

	$db = db_connect();
	
	$search = "kategori LIKE '%$q%' or nama_barang LIKE '%$q%'";
	
	if (is_numeric($q))
		$search = "harga = $q";
	
	
	$query = "SELECT * FROM barang WHERE $search ORDER BY $sort $order LIMIT $page, 10";
	
	if ($result = $db->query($query)){
		$response["hasil"] = array();
		$response["status"] = "ok";
		unset($response["desc"]);
		while($row = $result->fetch_assoc()){			
			array_push($response["hasil"], model_barang($row));
		}
	}
	
	$db->close();
	
	return $response;
}

function get_populer(){
	$response["status"] = "error";
	$response["desc"] = "barang tidak ditemukan";
	
	$db = db_connect();
	$query = "SELECT * FROM barang ORDER BY jumlah_beli DESC LIMIT 0, 10";
	
	if ($result = $db->query($query)){
		$response["hasil"] = array();
		$response["status"] = "ok";
		unset($response["desc"]);
		while($row = $result->fetch_assoc()){			
			array_push($response["hasil"], model_barang($row));
		}
	}
	
	$db->close();
	
	return $response;
}

function edit_barang($id, $token, $barang){
	$response["status"] = "error";
	$response["desc"] = "bukan administrator";
	
	$db = db_connect();
	$query = "SELECT role FROM token NATURAL JOIN user WHERE token_id = '$token'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
	
		if ($result->fetch_assoc()["role"] != "admin"){
			$db->close();
			return $response;
		}
	
		$nama_barang = $barang['nama']; $harga = $barang['harga'];
		$stok = $barang['stok']; $kategori = $barang['kategori'];
		$deskripsi = $barang['deskripsi']; $jumlah_beli = $barang['jumlah_beli'];
		
		$query = "UPDATE barang SET nama_barang='$nama_barang', harga=$harga, stok=$stok, kategori='$kategori', deskripsi='$deskripsi', jumlah_beli=$jumlah_beli WHERE id_barang=$id";

		if ($db->query($query)){
			$response["status"] = "ok";
			unset($response["desc"]);
		}else{
			$response["desc"] = "update gagal";
		}
	}
	
	$db->close();
	
	return $response;
}

function del_barang($ids, $token){
	$response["status"] = "error";
	$response["desc"] = "bukan administrator";
	
	$db = db_connect();
	$query = "SELECT role FROM token NATURAL JOIN user WHERE token_id = '$token'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
	
		if ($result->fetch_assoc()["role"] != "admin") return $response;
		
		$response["status"] = "ok";
		unset($response["desc"]);
		
		foreach($ids as $id){
			$query = "DELETE FROM barang WHERE id_barang=$id";
			$db->query($query);
		}
	}
	
	$db->close();
	
	return $response;
}

function add_cart($id, $jumlah, $token){
	$response["status"] = "error";
	$response["desc"] = "belum login";
	
	$db = db_connect();
	$query = "SELECT * FROM token WHERE token_id = '$token'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
		
		$query = "SELECT stok FROM barang WHERE id_barang=$id";
		$result = $db->query($query);
		$stok = intval($result->fetch_assoc()["stok"]);
		
		if ($stok >= $jumlah){		
			$response["status"] = "ok";
			unset($response["desc"]);
		}else{
			$response["desc"] = "barang tidak mencukupi, hanya tersisa $stok";
		}
		
	}
	
	$db->close();
	
	return $response;
}

function buy($cart, $token){
	$response["status"] = "error";
	$response["desc"] = "belum login";
	
	$db = db_connect();
	$query = "SELECT * FROM token WHERE token_id = '$token'";
	
	if (($result = $db->query($query)) && ($result->num_rows > 0)){
		$username = $result->fetch_assoc()["username"];
		
		$db->autocommit(false);
	
		$success = true;
		
		foreach($cart as $id => $jumlah){
			$query = "UPDATE barang SET stok = stok - $jumlah, jumlah_beli = jumlah_beli + $jumlah WHERE id_barang = $id AND stok >= $jumlah";
			
			$db->query($query);
			
			if ($db->affected_rows != 1){
				$success = false; break;
			}
		}
		
		if ($success){
			$response["status"] = "ok";
			unset($response["desc"]);
			
			$db->query("UPDATE user SET jumlah_transaksi = jumlah_transaksi + 1 WHERE username = '$username'");
			
			$db->commit();
		}else{
			$db->rollback();
			$response["desc"] = "jumlah barang tidak mencukupi";
		}
	}
	
	$db->close();
	
	return $response;
}

?>