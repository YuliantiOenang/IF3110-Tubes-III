<?php
	if (isset($_POST['username']) && isset($_POST['nama']) && isset($_POST['password']) && isset($_POST['alamat']) && isset($_POST['kota']) && isset($_POST['kodepos']) && isset($_POST['provinsi']) && isset($_POST['nohp'])) {
		$query = 'update user set password=? where username=?';
		$params = array($_POST['password'], $_POST['username']);
		include 'query.php';
		$query = 'update user_profile set nama=?, alamat=?, kota=?, kode_pos=?, provinsi=?, nomor_ponsel=? where username=?';
		$params = array($_POST['nama'], $_POST['alamat'], $_POST['kota'], $_POST['kodepos'], $_POST['provinsi'], $_POST['nohp'], $_POST['username']);
		include 'query.php';
		echo json_encode(array('status'=>'success'));
	}
?>