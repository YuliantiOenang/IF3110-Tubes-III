<?php

function writeShoppingCart() {
	$cart = $_SESSION['cart'];
	if (!$cart) {
		return '<p>Anda belum pesan apapun</p>';
	} else {
		// Parse the cart session variable
		$items = explode(',', $cart);
		$s = (count($items) > 1) ? 's' : '';
		return '<p>Ada ' . count($items) . ' barang' . $s . ' di keranjang belanja</p>';
	}
}

function getQty() {
	$cart = $_SESSION['cart'];
	if (!$cart) {
		return 0;
	} else {
		// Parse the cart session variable
		$items = explode(',', $cart);
		$s = (count($items) > 1) ? 's' : '';
		return count($items);
	}
}

function getDiskon($qty) {
	if ($qty >= 10)
		return 0.1;
	else
		return 0;
}

function showCart() {
	global $db;
	$total=0;
	$cart = $_SESSION['cart'];
	if ($cart) {
		$items = explode(',', $cart);
		$contents = array();
		foreach ($items as $item) {
			$contents[$item] = (isset($contents[$item])) ? $contents[$item] + 1 : 1;
		}
		$output[] = '<form action="index.php?page=cart&action=update" method="post" nama="cart">';
		$output[] = '<table border=0 align="center">';
		foreach ($contents as $nama => $qty) {
			$sql = "SELECT * from barang WHERE nama_barang = '$nama'";
			$result = pg_query($sql);
			$row = pg_fetch_array($result);
			extract($row);
			$output[] = '<tr>';

			$output[] = '<td>' . $nama_barang . '</td>';
			$output[] = '<td>Rp.' . $harga_barang . '</td>';
			$output[] = '<td><input type="text" name="qty' . $nama . '" value="' . $qty . '" size="3" maxlength="3" /></td>';

			$output[] = '<td>Rp.' . ($harga_barang * $qty) . '</td>';
			$total += $harga_barang * $qty;

			$output[] = '<td><a href="index.php?page=cart&action=delete&nama=' . $nama . '" class="r">Hapus</a></td>';
			$output[] = '</tr>';
		}
		$output[] = '</table>';
		$qty = getQty();
		
	
		$output[] = '<p>total		: <strong> Rp.' . $total . '</strong></p>';
	


		//session_register('totalbayar');
		$_SESSION['totalbayar'] = $total;
		$output[] = '<div><button type="submit">Update cart</button></div>';
		$output[] = '</form>';
	} else {
		$output[] = '<p>Keranjang belanja masih kosong.</p>';
	}
	return join('', $output);
}


?>