<?php
	if (isset($_POST['id'])) {
		$rest = "http://ditra77.ap01.aws.af.cm";
		ini_set('max_execution_time', 300);
		$barang = simplexml_load_file($rest."/barang/".$_POST['id'].".xml");
		if (count($barang->children())>0){
			$amount = 1;
			if (isset($_POST['amount'])) {
				$amount = $_POST['amount'];
			}
			if($barang->tersedia>=$amount){
				session_start();
				if (isset($_SESSION['cart'])){
					if (array_key_exists($_POST['id'], $_SESSION['cart'])) {
						$_SESSION['cart'][$_POST['id']] += $amount;
					}
					else {
						$_SESSION['cart'][$_POST['id']] = $amount;
					}
				}
				else {
					$_SESSION['cart'] = array($_POST['id'] => $amount);
				}
				echo json_encode(array('status'=>'success'));
			}
			else{
				echo json_encode(array('status'=>'failed'));
			}
		
		}
		else {
			echo json_encode(array('status'=>'failed'));
		}
	}
?>