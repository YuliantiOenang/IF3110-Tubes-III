<?php
	
	include 'connection.php';
		
	function GetBarang($link,$id) {
		$query = "SELECT * FROM barang WHERE id_barang=".$id;
		$result = mysql_query($query,$link);
		if(mysql_num_rows($result) > 0) {
			$row = mysql_fetch_array($result);
			return json_encode($row);
		} else {
			return json_encode(array('status'=>'empty'));
		}
	}
	
	function GetBarangByKategori($link,$id_kategori,$limit,$start_idx
		,$sortby,$sorttype) {
		$query = "SELECT * FROM barang WHERE id_kategori=".$id_kategori;
		
		if(isset($sortby)) {
			$query .= " ORDER BY ".$sortby." ".$sorttype;
		}		
		
		if(isset($start_idx) && isset($limit)) {
			$query .= " LIMIT " .$start_idx.",".$limit;
		} else if(isset($limit)) {
			$query .= " LIMIT 0,".$limit;
		}
		
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
	
	function GetAllBarang($link) {
		$query = "SELECT * FROM barang";
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
	
	if(isset($_GET['id_barang'])) {
		echo GetBarang($link,$_GET['id_barang']);
	} else if(isset($_GET['kategori'])) {
			echo GetBarangByKategori($link,$_GET['kategori'],$_GET['limit'],$_GET['idx'],$_GET['sortby'],$_GET['sorttype']);
	} else {
		echo GetAllBarang($link);
	}
?>