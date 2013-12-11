<?php
	include 'connect.php';
	session_start();
	print_r($_SESSION['shopping_cart']);
	foreach($_SESSION['shopping_cart'] as $id => $amount){
		$_SESSION['shopping_cart'][$id] = $_POST[$id];
	}
	header('location:shoppingbag.php');
?>