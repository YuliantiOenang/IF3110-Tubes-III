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
	
	function DeleteBarang($link,$id) {
		$query = "DELETE FROM barang WHERE id_barang=".$id;
		$result = mysql_query($query,$link);
		if($result) {
			return json_encode(array('status'=>'success'));
		} else {
			return json_encode(array('status'=>'empty'));
		}
	}
	
	function EditBarang($link,$id,$nama_barang,$harga_barang,$gambar,$tersedia, $dibeli) {
		$query = "SELECT * FROM barang WHERE nama_barang='".$nama_barang."'";
		$result = mysql_query($query,$link);
		if(mysql_num_rows($result) > 0) {
			return json_encode(array('status'=>'name already exist'));
		}
		
		$query = "UPDATE barang SET ";
		if(isset($nama_barang)) {
			$query .= " nama_barang='".$nama_barang."'";
			$query .= ",";
		}
		
		if(isset($harga_barang)) {
			$query .= " harga_barang=".$harga_barang;
			$query .= ",";
		}
		
		if(isset($gambar)) {
			$query .= " gambar='".$gambar."'";
			$query .= ",";
		}
		
		if(isset($tersedia)) {
			$query .= " tersedia=".$tersedia;
			$query .= ",";
		}
		
		if(isset($dibeli)) {
			$query .= " dibeli=".$dibeli;
			$query .= ",";
		}
		
		$query = substr($query,0,strlen($query) - 1);
		$query .= " WHERE id_barang=".$id;
		
		echo $query;
		$result = mysql_query($query,$link);
		if($result) {
			return json_encode(array('status'=>'success'));
		} else {
			return json_encode(array('status'=>'failed'));
		}
		
	}
	
	if(isset($_GET['id_barang'])) {
		if(isset($_GET['nama']) || isset($_GET['harga']) || isset($_GET['gambar']) || isset($_GET['tersedia']) || isset($_GET['dibeli'])) {
			echo EditBarang($link,$_GET['id_barang'],$_GET['nama'],$_GET['harga'],$_GET['gambar'],$_GET['tersedia'],$_GET['dibeli']);
		} else {
			echo GetBarang($link,$_GET['id_barang']);
		}
	} else if(isset($_GET['kategori'])) {
			echo GetBarangByKategori($link,$_GET['kategori'],$_GET['limit'],$_GET['idx'],$_GET['sortby'],$_GET['sorttype']);
	} else if(isset($_GET['delete_id'])) {
		echo DeleteBarang($link,$_GET['delete_id']);
	} else {
		echo GetAllBarang($link);
	}
?>