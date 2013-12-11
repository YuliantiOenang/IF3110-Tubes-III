<?
// Include functions
require_once ('functions.inc.php');
// Start the session

// Process actions
$cart = $_SESSION['cart'];
$action = $_GET['action'];
switch ($action) {
	case 'add' :
		if ($cart) {
			$cart .= ',' . $_GET['nama'];
		} else {
			$cart = $_GET['nama'];
		}
		break;
		
	case 'delete' :
		if ($cart) {
			$items = explode(',', $cart);
			$newcart = '';
			foreach ($items as $item) {
				if ($_GET['nama'] != $item) {
					if ($newcart != '') {
						$newcart .= ',' . $item;
					} else {
						$newcart = $item;
					}
				}
			}
			$cart = $newcart;
		}
		break;
	case 'update' :
		if ($cart) {
			$newcart = '';
			foreach ($_POST as $key => $value) {
				if (stristr($key, 'qty')) {
					$nama = str_replace('qty', '', $key);
					$items = ($newcart != '') ? explode(',', $newcart) : explode(',', $cart);
					$newcart = '';
					foreach ($items as $item) {
						if ($nama != $item) {
							if ($newcart != '') {
								$newcart .= ',' . $item;
							} else {
								$newcart = $item;
							}
						}
					}
					for ($i = 1; $i <= $value; $i++) {
						if ($newcart != '') {
							$newcart .= ',' . $nama;
						} else {
							$newcart = $nama;
						}
					}
				}
			}
		}

		$cart = $newcart;
		break;
	case '': break;
}
$_SESSION['cart'] = $cart;
?>

<div id="shoppingcart">
	<h3>Keranjang belanja anda</h3>
	<?php
	echo writeShoppingCart();
	?>
</div>
<div id="contents">
	<h3>Cek keranjang belanja</h3>
	<?php
	echo showCart();
	?>

	<input type="button" value="Beli" onClick="parent.location='index.php?page=daftarkartukredit'">
</div>
