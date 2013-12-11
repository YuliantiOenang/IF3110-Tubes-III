<?php
	if (isset($_POST['username'])) {
		$query = 'select * from user left join user_profile on user.username=user_profile.username where user.username=?';
		$params = array($_POST['username']);
		include 'query.php';
		if (count($result) == 0) {
			echo json_encode(array('status'=>'failed'));
		}
		else {
			echo json_encode(array('status'=>'success', 'record'=>$result[0]));
		}
	}
?>