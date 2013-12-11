<?php
	$token;
	$exist = true;
	while ($exist) {
		$characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		$token = '';
		for ($i = 0; $i < 20; $i++) {
			$token .= $characters[rand(0, strlen($characters) - 1)];
		}
		$query = "select token from user where token=?";
		$params = array($token);
		include 'query.php';
		$exist = count($result) > 0;
	}
?>