<?php
	if (isset($_POST['cartcontent'])) {
		session_start();
		$_SESSION['cart'] = json_decode($_POST['cartcontent'], true);
		foreach ($_SESSION['cart'] as $key => $value) {
			if ($value == 0) {
				unset($_SESSION['cart'][$key]);
			}
		}
		echo json_encode(array('status'=>'success'));
	}
?>