<?php
	if (isset($_POST['username']) && isset($_POST['nokartu']) && isset($_POST['nama']) && isset($_POST['kadaluarsa'])) {
		$query = 'select username from kartu_kredit where username=?';
		$params = array($_POST['username']);
		include 'query.php';
		if (count($result) > 0) {
			$query = 'update kartu_kredit set no_kartu=?, nama=?, kadaluarsa=? where username=?';
			$params = array($_POST['nokartu'], $_POST['nama'], $_POST['kadaluarsa'], $_POST['username']);
		}
		else {
			$query = 'insert into kartu_kredit values (?,?,?,?)';
			$params = array($_POST['username'], $_POST['nokartu'], $_POST['nama'], $_POST['kadaluarsa']);
		}
		include 'query.php';
		echo json_encode(array('status'=>'success'));
	}
?>
