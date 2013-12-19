<?php
	include 'connection.php';
	
	function GetKategori($link,$id) {
		$query = "SELECT * FROM kategori WHERE id_kategori=".$id;
		$result = mysql_query($query,$link);
		if(mysql_num_rows($result) > 0) {
			$row = mysql_fetch_array($result);
			return json_encode($row);
		} else {
			return json_encode(array('status'=>'empty'));
		}
	}
	
	function GetAllKategori($link) {
		$query = "SELECT * FROM kategori";
		$result = mysql_query($query,$link);
		if(mysql_num_rows($result) > 0) {
			$response = array();
			$idx = 0;
			while($row = mysql_fetch_array($result)) {
				$response[$idx] = $row;
				$idx++;
			}
			$response['length'] = $idx;
			return json_encode($response);
		} else {
			return json_encode(array('status'=>'empty'));
		}
	}
	
	if(isset($_GET["id"])) {
		echo GetKategori($link,$_GET["id"]);
	} else {
		echo GetAllKategori($link);
	}
?>