<?php
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	if (isset($_POST['username']) && isset($_POST['nama']) && isset($_POST['password']) && isset($_POST['alamat']) && isset($_POST['kota']) && isset($_POST['kodepos']) && isset($_POST['provinsi']) && isset($_POST['nohp'])) {
		$ch = curl_init($rest."/user/".$_POST['username']);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, 'password='.$_POST['password']);
		curl_exec($ch);
		$ch = curl_init($rest."/user_profile/".$_POST['username']);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, 'nama='.$_POST['nama']);
		curl_exec($ch);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, 'alamat='.$_POST['alamat']);
		curl_exec($ch);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, 'kota='.$_POST['kota']);
		curl_exec($ch);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, 'provinsi='.$_POST['provinsi']);
		curl_exec($ch);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, 'kode_pos='.$_POST['kodepos']);
		curl_exec($ch);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
		curl_setopt($ch, CURLOPT_POSTFIELDS, 'nomor_ponsel='.$_POST['nohp']);
		curl_exec($ch);
		curl_close($ch);
		echo json_encode(array('status'=>'success'));
	}
?>