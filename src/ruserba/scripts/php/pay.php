<?php
	if (isset($_POST['username'])) {
		$query = 'select * from kartu_kredit where username=?';
		$params = array($_POST['username']);
		include 'query.php';
		if (count($result) > 0) {
			if (time() > strtotime($result[0]['kadaluarsa'])) {
				echo json_encode(array('status'=>'expired'));
			}
			else {
				session_start();
				$success = true;
				foreach ($_SESSION['cart'] as $id => $amount) {
					$query = 'select tersedia from barang where id_barang=?';
					$params = array($id);
					include 'query.php';
					if ($result[0]['tersedia'] >= $amount) {
						$query = 'update barang set tersedia=tersedia-?, dibeli=dibeli+? where id_barang=?';
						$params = array($amount, $amount, $id);
						include 'query.php';
						unset($_SESSION['cart'][$id]);
					}
					else {
						$success = false;
					}
				}
				if ($success) {
					echo json_encode(array('status'=>'success'));
				}
				else {
					echo json_encode(array('status'=>'partial'));
				}
			}
		}
		else {
			echo json_encode(array('status'=>'failed'));
		}
	}
?>