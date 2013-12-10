<?php
	if (isset($_POST['username'])) {
		$query = 'select username from user where username=?';
		$params = array($_POST['username']);
		include 'query.php';
		if (count($result) > 0) {
			echo json_encode(array('status'=>'exists'));
		}
		else {
			echo json_encode(array('status'=>'not exists'));
		}
	}
	else if (isset($_POST['email'])) {
		$query = 'select email from user_profile where email=?';
		$params = array($_POST['email']);
		include 'query.php';
		if (count($result) > 0) {
			echo json_encode(array('status'=>'exists'));
		}
		else {
			echo json_encode(array('status'=>'not exists'));
		}
	}
?>