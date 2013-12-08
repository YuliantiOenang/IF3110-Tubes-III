<?php
	if (isset($_POST['username']) && isset($_POST['password']) && isset($_POST['name']) && isset($_POST['email'])) {
		include 'token_generator.php';
		$query = 'insert into user values (?,?,?,?)';
		$params = array($_POST['username'], $_POST['password'], $token, date('Y-m-d'));
		include 'query.php';
		$query = 'insert into user_profile (username,nama,email) values (?,?,?)';
		$params = array($_POST['username'], $_POST['name'], $_POST['email']);
		include 'query.php';
		echo json_encode(array('status'=>'success', 'token'=>$token));
	}
?>