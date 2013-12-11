<?php
	//fungsi-fungsi transaksi barang
	
	function addToCart($id_barang, $jumlah){
		// mengecek apakah masih bisa meng-add barang dengan id tertentu sejumlah tertentu
		// return -1 jika sukses, dan sisa barang jika gagal
		$services_json = json_decode(getenv("VCAP_SERVICES"),true);
		$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
		$username = $mysql_config["username"];
		$password = $mysql_config["password"];
		$hostname = $mysql_config["hostname"];
		$port = $mysql_config["port"];
		$db = $mysql_config["name"];
		/*$link = mysql_connect("$hostname:$port", $username, $password);
		$db_selected = mysql_select_db($db, $link);*/

		$conn = new mysqli($hostname, $username, $password, $db);
		
		$statement = $conn->prepare("SELECT stok FROM barang WHERE id_barang = ?");
		
		$statement->bind_param("i", $id_barang);
		$statement->execute();
		
		$statement->bind_result($sisa);
		$statement->fetch();
		$statement->close();
		
		$conn->close();
		
		return $sisa >= $jumlah ? -1 : $sisa;
	}
	
	function checkCreditCart($id){
		$services_json = json_decode(getenv("VCAP_SERVICES"),true);
		$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
		$username = $mysql_config["username"];
		$password = $mysql_config["password"];
		$hostname = $mysql_config["hostname"];
		$port = $mysql_config["port"];
		$db = $mysql_config["name"];
		/*$link = mysql_connect("$hostname:$port", $username, $password);
		$db_selected = mysql_select_db($db, $link);*/

		$conn = new mysqli($hostname, $username, $password, $db);
		$statement = $conn->prepare("SELECT no_credit FROM member WHERE mem_id = ?");
		
		$statement->bind_param("i", $id);
		$statement->execute();
		
		$statement->bind_result($result);
		$statement->fetch();
		
		$statement->close();
		$conn->close();
		
		return ($result != null);	
	}
	
	function updateTransactionUser($id){
		$services_json = json_decode(getenv("VCAP_SERVICES"),true);
		$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
		$username = $mysql_config["username"];
		$password = $mysql_config["password"];
		$hostname = $mysql_config["hostname"];
		$port = $mysql_config["port"];
		$db = $mysql_config["name"];
		/*$link = mysql_connect("$hostname:$port", $username, $password);
		$db_selected = mysql_select_db($db, $link);*/

		$conn = new mysqli($hostname, $username, $password, $db);
		
		$statement = $conn->prepare("UPDATE member SET jumlah_transaksi = jumlah_transaksi + 1 WHERE mem_id = ?");
		
		$statement->bind_param("i", $id);
		$statement->execute();
			
		$statement->close();
		$conn->close();
	}
	
	function buy($list, $id){
		/* list adalah array barang yang akan dibeli. tiap elemennya adalah:
		 * 		{"id" => id barang tsb, "jumlah" => jumlah barang yg dibeli}
		 * 
		 * buy() mengembalikan true jika pembelian berhasil, false jika gagal (ada barang yg tidak mencukupi).
		 * jika ada satu jenis barang yg tidak mencukupi, maka seluruh transaksi digagalkan
		 */
		
		if(!checkCreditCart($id)){
			return -1;
		}		 
		 
		$services_json = json_decode(getenv("VCAP_SERVICES"),true);
		$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
		$username = $mysql_config["username"];
		$password = $mysql_config["password"];
		$hostname = $mysql_config["hostname"];
		$port = $mysql_config["port"];
		$db = $mysql_config["name"];
		/*$link = mysql_connect("$hostname:$port", $username, $password);
		$db_selected = mysql_select_db($db, $link);*/

		$conn = new mysqli($hostname, $username, $password, $db);
		
		$conn->autocommit(false);
		
		$success = 1;	
		$sql = "UPDATE barang SET stok = stok - ?, jumlah_terbeli = jumlah_terbeli + ? WHERE id_barang = ? AND stok >= ?";
		
		foreach ($list as $item){
			$statement = $conn->prepare($sql);
			$statement->bind_param("iiii", $item["jumlah"], $item["jumlah"], $item["id"], $item["jumlah"]);
			$statement->execute();
			
			$success = ($statement->affected_rows == 1) ? 1 : 0; // sukses jika affected row tepat 1
			
			$statement->close();
			
			if (!$success){
				break;
			}
		}
		
		if ($success){ // jika semua sukses, commit
			$conn->commit();
			updateTransactionUser($id);
		}else{ // ada 1 aja yg gagal, rollback
			$conn->rollback();
		}	
		
		
		$conn->close();
		return $success;
	}
	
	function handleTransactionAjax(){
		// handle ajax untuk aksi2 transaksi
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		switch($request["action"]){
			case "add":
				$sisa = addToCart($request["id_barang"], $request["jumlah"]);
				if ($sisa == -1)
					$response["status"] = "ok";
				else
					$response["sisa"] = $sisa;
			break;
			case "buy":
				$result = buy($request["list"], $request["id"]);
				if($result == 1){
					$response["status"] = "ok";
				}else{
					$response["code"] = $result;
				}
			break;
			default:
				return null;
			break;
		}
		
		return json_encode($response);
	}
?>
