<?php	
		include("./lib/db.php");
		$card_number = "";
		$name_card = "";
		$expired_date = "";
		$error = ""; $userid = "";
		
		if (isset($_POST["ajax"])) {
			$request = json_decode($_POST["ajax"], true);			
			$card_number = $request["cardnumber"]; 
			$expired_date = $request["expireddate"]; 
			$name_card = $request["namecard"];
			$userid = $request["id"];
			validation();
		}
		
		

		function setCreditCard(){
			global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME, $userid, $card_number, $name_card, $expired_date;
			
			$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
			$statement = $conn->prepare("UPDATE member SET no_credit = ?, nama_credit = ?, expired_date = ? WHERE mem_id = ?");
			
			$statement->bind_param("sssi", $card_number, $name_card, $expired_date, $userid);
			$statement->execute();
			
			$statement->close();
			$conn->close();
		}
		
		function validation () {
		global $error;
			if (validateNumber() && validateDate() && validateNotEmpty( ) ) {
				$response["status"] = "ok";
				setCreditCard();
			} else {
				$response["status"] = "error";
				$response["deskripsi"] = $error;
			}
			echo (json_encode($response));
		}

		function validateNumber( ) {
		global $card_number, $error;
		
			if (strlen($card_number) != 16) {
				$error = "Nomor kartu tidak valid";
				return false;
			}
			return true;
		}

		function validateDate ( ) {
		global $expired_date, $error;
 			 $slash = strpos($expired_date, "/");
			 $bulan = intval(substr($expired_date, 0,$slash));
			 $tahun = intval(substr($expired_date, $slash+1,strlen($expired_date)-$slash+1));
			if ($tahun < 10) 
			if ($bulan < 0 || $bulan >12) {
				$error = "Bulan Salah";
				return false;
			}
			if ($tahun < 0 || $tahun >99) {
				$error = "alert (\"Tahun Salah\");\n";
				return false;
			}
			if (($tahun == 13) && ($bulan<11)) {
				$error = "Kartu Expired";
				return false;
			}
			if ($tahun < 13) {
				$error = "Kartu Expired";
				return false;
			}
 		return true;
		}
			
		function validateNotEmpty( ) {
		//melihat input kosong atau tidak
		global $card_number, $name_card, $expired_date, $error;
		if ($card_number && $name_card && $expired_date) {
			return true;
			}
			$error = "Please enter a value";
		return false;
		};	
	?>