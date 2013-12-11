<?php
	include "koneksi.inc.php";
	$barang = array();
	$info_barang = array();
		$query3 = "select * from barang group by kategori";
		$hasil3 = mysql_query($query3,$koneksi);
		$slideid = 0;
		while($row3 = mysql_fetch_array($hasil3)){
			$rank=1;
			$query4 = "select * from barang where kategori='".$row3["kategori"]."' order by terjual desc limit 0,3";
			$hasil4 = mysql_query($query4,$koneksi);
			while($row4 = mysql_fetch_array($hasil4)){
				$slideid++;
				array_push($info_barang, $row4['gambar']);
				array_push($info_barang, $row4['kategori']);
				array_push($info_barang, $row4['id']);
				array_push($info_barang, $row4['nama']);
				array_push($info_barang, $row4['keterangan']);
				array_push($barang, $info_barang);
				$info_barang = array();
			$rank++;
			}
		}
		echo json_encode($barang);
	?>