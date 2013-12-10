<?php
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	if (isset($_POST['username']) && isset($_POST['nama']) && isset($_POST['password']) && isset($_POST['alamat']) && isset($_POST['kota']) && isset($_POST['kodepos']) && isset($_POST['provinsi']) && isset($_POST['nohp'])) {
		$ch = curl_init($rest."/user/".$_POST['username']);
		$data = array("password" => $_POST['password']);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
		// $ch = curl_init($rest."/user_profile/".$_POST['username']);
		// $data = array("nama" => $_POST['nama'],"alamat" => $_POST['alamat'],"kota" => $_POST['kota'],"kode_pos" => $_POST['kodepos'],"provinsi" => $_POST['provinsi'],"nomor_ponsel" => $_POST['nohp']);
		// curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		// curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		// curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
		$_SESSION['password'] = $_POST['password'];
		$_SESSION['nama'] = (string)$result->nama;
		$_SESSION['alamat'] = (string)$result->alamat;
		$_SESSION['kota'] = (string)$result->kota;
		$_SESSION['provinsi'] = (string)$result->provinsi;
		$_SESSION['kodepos'] = (string)$result->kode_pos;
		$_SESSION['nomor_ponsel'] = (string)$result->nomor_ponsel;
		echo json_encode(array('status'=>'success'));
	}
?>