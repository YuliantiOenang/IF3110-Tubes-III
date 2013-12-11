<?php
	if (isset($_POST['username']) && isset($_POST['password'])) {
		$query = 'select token, last_login from user where username=? and password=?';
		$params = array($_POST['username'], $_POST['password']);
		include 'query.php';
		if (count($result) > 0) {
			include 'token_generator.php';
			$query = 'update user set token=?, last_login=? where username=?';
			$params = array($token, date('Y-m-d'), $_POST['username']);
			include 'query.php';
			echo json_encode(array('status'=>'success', 'token'=>$token));
		}
		else {
			echo json_encode(array('status'=>'failed'));
		}
	}
	else if (isset($_POST['token'])) {
		$query = 'select token, last_login from user where token=?';	
		$params = array($_POST['token']);
		include 'query.php';
		if (count($result) > 0) {
			$dt1 = new DateTime(date('Y-m-d'));
			$dt2 = new DateTime($result[0]['last_login']);
			$diff = date_diff($dt1, $dt2);
			if ($diff->format('%m') > 0 || $diff->format('%d') > 30) {
				$query = 'update user set token=?, last_login=? where token=?';
				$params = array(null, null, $_POST['token']);
				include 'query.php';
				echo json_encode(array('status'=>'failed'));
			}
			else {
				$query = 'update user set last_login=? where token=?';
				$params = array(date('Y-m-d'), $_POST['token']);
				include 'query.php';
				echo json_encode(array('status'=>'success'));
			}
		}
		else {
			echo json_encode(array('status'=>'failed'));
		}
	}
?>