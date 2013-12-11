<?php
	session_start();
	$_SESSION['shopping_cart'][$_POST['id_barang']] = $_POST['qt'];
	$_SESSION['shopping_request'][$_POST['id_barang']] = $_POST['request_tambahan'];
	header('location:index.php');
?>