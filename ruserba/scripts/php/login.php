<?php
	$result = simplexml_load_file($rest."/user?username=%22".$_POST['username']."%22&password=%22".$_POST['username']."%22.xml");
	$jumlah = $result->children();
	if (count($jumlah) > 0) {
		echo json_encode(array('status'=>'success'));
		$result = simplexml_load_file($rest."/user_profile/".$result->row[0].".xml");
		session_start();
		$_SESSION['username'] = $_POST['username'];
		$_SESSION['nama'] = (string)$result->id;
		$_SESSION['email'] = (string)$result->fullname;
		$_SESSION['alamat'] = (string)$xml->birthdate;
		$_SESSION['kota'] = (string)$xml->email;
		$_SESSION['provinsi'] = (string)$xml->avatar;
		$_SESSION['kodepos'] = (string)$xml->gender;
		$_SESSION['nomor_ponsel'] = (string)$xml->about;
	}
	else {
		echo json_encode(array('status'=>'failed'));
	}
?>