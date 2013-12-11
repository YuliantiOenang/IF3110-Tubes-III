<?php
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	session_start();
	$result = simplexml_load_file($rest."/kartu_kredit/".$_SESSION['username'].".xml");
	$jumlah = $result->children();
	if (count($jumlah) > 0) {
		if (time() > strtotime($result->kadaluarsa)) {
			echo json_encode(array('status'=>'expired'));
		}
		else {
			$success = true;
			foreach ($_SESSION['cart'] as $id => $amount) {
				$barang = simplexml_load_file($rest."/barang/".$id.".xml");
				if ($barang->tersedia >= $amount) {
					$tersedia = $barang->tersedia-$amount;
					$dibeli = $barang->dibeli+$amount;
					$ch = curl_init($rest."/barang/".$id);
					curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
					curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
					curl_setopt($ch, CURLOPT_POSTFIELDS, 'tersedia='.$tersedia);
					curl_exec($ch);
					$ch = curl_init($rest."/barang/".$id);
					curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
					curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
					curl_setopt($ch, CURLOPT_POSTFIELDS, 'dibeli='.$dibeli);
					curl_exec($ch);
					$ch = curl_init($rest."/barang/".$id);
					curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
					curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
					curl_setopt($ch, CURLOPT_POSTFIELDS, 'dibeli='.$dibeli);
					curl_exec($ch);
					unset($_SESSION['cart'][$id]);
				}
				else {
					$success = false;
				}
			}
			$result = simplexml_load_file($rest."/user_profile/".$_SESSION['username'].".xml");
			$jumlah_transaksi = $result->jumlah_transaksi + 1;
			$ch = curl_init($rest."/user_profile/".$_SESSION['username']);
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
			curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
			curl_setopt($ch, CURLOPT_POSTFIELDS, 'jumlah_transaksi='.$jumlah_transaksi);
			curl_exec($ch);
			curl_close($ch);
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
?>