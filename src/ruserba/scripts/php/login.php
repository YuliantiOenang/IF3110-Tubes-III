<?php
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	$result = simplexml_load_file($rest."/user?username='".$_POST['username']."'&password='".$_POST['password']."'.xml");
	$jumlah = $result->children();
	if (count($jumlah) > 0) {
		$result = simplexml_load_file($rest."/user_profile/".$result->row[0].".xml");
		session_start();
		$_SESSION['username'] = $_POST['username'];
		echo json_encode(array('status'=>'success'));
		
	}
	else {
		echo json_encode(array('status'=>'failed'));
	}
?>