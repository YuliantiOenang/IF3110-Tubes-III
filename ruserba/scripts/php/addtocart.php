<?php
	if (isset($_POST['id'])) {
		$query = 'select * from barang where id_barang=?';
		$params = array($_POST['id']);
		include 'query.php';
		if (count($result)>0){
			$amount = 1;
			if (isset($_POST['amount'])) {
				$amount = $_POST['amount'];
			}
			if($result[0]['tersedia']>=$amount){
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