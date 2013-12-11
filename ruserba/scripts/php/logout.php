<?php
	session_start();
	if (isset($_POST['token'])) {
		$query = 'select username from user where token=?';
		$params = array($_POST['token']);
		include 'query.php';
		if (count($result) > 0) {
			$query = 'update user set token=null, last_login=null where username=?';
			$params = array($result[0]['username']);
			include 'query.php';
		}
		session_destroy();
		echo json_encode(array('status'=>'success'));
	}
?>