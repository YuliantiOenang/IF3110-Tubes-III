<?php
	if (isset($_POST['nama_barang'])) {
		$rest = "http://ditra77.ap01.aws.af.cm";
		ini_set('max_execution_time', 300);
		$result = simplexml_load_file($rest."/barang?nama_barang='".$_POST['nama_barang']."'.xml");
		$jumlah = $result->children();
		if (count($jumlah) > 0) {
			echo json_encode(array('status'=>'exists'));
		}
		else {
			echo json_encode(array('status'=>'not exists'));
		}
	}
?>