<?php
	include 'connect.php';
	session_start();
	$creditid = $_GET['creditid'];
	if($creditid==0){
		echo '<a href="shoppingbag.php">Pilih dulu </a> atau <a href="cardregist.php">registrasi kartu kredit </a>';
	}
	else{
		foreach ($_SESSION['shopping_cart'] as $id => $amount) {
		$checkamount_query = "SELECT * FROM `progin_13511059`.barang WHERE id_barang ='".$id."'";
		$checkamount_result = mysql_query($checkamount_query,$con);
		if(!$checkamount_result){
			echo 'Tidak berhasil melakukan pemeriksaan stok barang';
		}
		else{
			$checkamount_row = mysql_fetch_array($checkamount_result);
			if($checkamount_row['stok'] < $amount){
				echo 'Jumlah tidak valid, <a href="shoppingbag.php">kembali</a>';

			}
			else{
				$beli_query = "SELECT * FROM `progin_13511059`.barang WHERE id_barang ='".$id."'";
				$beli_result = mysql_query($beli_query,$con);
				if(!$beli_result){
					echo 'Tidak berhasil melakukan pembelian barang';
				}
				else{
					$beli_row = mysql_fetch_array($beli_result);
					$newPembelian = $beli_row['n_beli']	+ $amount;
					$newStok = $beli_row['stok'] - $amount;
					$updatedb_query = "UPDATE `progin_13511059`.`barang` SET `n_beli` = '".$newPembelian."', `stok` = '".$newStok."' WHERE `barang`.`id_barang` = '".$id."'";
					$updatedb_result = mysql_query($updatedb_query,$con);
					if(!$updatedb_result){
						echo 'Tidak berhasil mengupdate database';
					}
					else{
						unset($_SESSION['shopping_cart'][$id]);
						//var_dump($_SESSION['shopping_cart']);
						header('location:shoppingbag.php');
					}
				}
			}
		}	
	}	
	}
?>