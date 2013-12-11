<?php
	include('database_connection.php'); 
	$barangs = array();
	$barangs_per_kategori = array();
	$info_barangs = array();
	$result1 = mysql_query("select * from catalog_product where category = 'alat tulis' order by number_sold DESC", $link);
//	$result1a = mysql_query("select path from catalog_product where category = 'alat tulis' order by number_sold DESC", $link);
	$result2 = mysql_query("select * from catalog_product where category = 'daging' order by number_sold DESC", $link);
//	$result2a = mysql_query("select path from catalog_product where category = 'daging' order by number_sold DESC", $link);
	$result3 = mysql_query("select * from catalog_product where category = 'sayur' order by number_sold DESC", $link);
//	$result3a = mysql_query("select path from catalog_product where category = 'sayur' order by number_sold DESC", $link);
	$result4 = mysql_query("select * from catalog_product where category = 'buah' order by number_sold DESC", $link);
//	$result4a = mysql_query("select path from catalog_product where category = 'buah' order by number_sold DESC", $link);
	$result5 = mysql_query("select * from catalog_product where category = 'pakaian' order by number_sold DESC", $link);
//	$result5a = mysql_query("select path from catalog_product where category = 'pakaian' order by number_sold DESC", $link);
	while ($row = mysql_fetch_array($result1)) {
	    array_push($info_barangs, $row['id']);
	    array_push($info_barangs, $row['name']);
	    array_push($info_barangs, $row['price']);
	    array_push($info_barangs, $row['number_sold']);
	    array_push($info_barangs, $row['path']);
	    array_push($barangs_per_kategori, $info_barangs);
		$info_barangs = array();    
	}
	array_push($barangs, $barangs_per_kategori);
	$barangs_per_kategori = array();

	while ($row = mysql_fetch_array($result2)) {
	    array_push($info_barangs, $row['id']);
	    array_push($info_barangs, $row['name']);
	    array_push($info_barangs, $row['price']);
	    array_push($info_barangs, $row['number_sold']);
	    array_push($info_barangs, $row['path']);
	    array_push($barangs_per_kategori, $info_barangs);
	    $info_barangs = array();
	}
	array_push($barangs, $barangs_per_kategori);
	$barangs_per_kategori = array();

	while ($row = mysql_fetch_array($result3)) {
	    array_push($info_barangs, $row['id']);
	    array_push($info_barangs, $row['name']);
	    array_push($info_barangs, $row['price']);
	    array_push($info_barangs, $row['number_sold']);
	    array_push($info_barangs, $row['path']);
	    array_push($barangs_per_kategori, $info_barangs);
	    $info_barangs = array();
	}
	array_push($barangs, $barangs_per_kategori);
	$barangs_per_kategori = array();

	while ($row = mysql_fetch_array($result4)) {
	    array_push($info_barangs, $row['id']);
	    array_push($info_barangs, $row['name']);
	    array_push($info_barangs, $row['price']);
	    array_push($info_barangs, $row['number_sold']);
	    array_push($info_barangs, $row['path']);
	    array_push($barangs_per_kategori, $info_barangs);
	    $info_barangs = array();
	}
	array_push($barangs, $barangs_per_kategori);
	$barangs_per_kategori = array();

	while ($row = mysql_fetch_array($result5)) {
	    array_push($info_barangs, $row['id']);
	    array_push($info_barangs, $row['name']);
	    array_push($info_barangs, $row['price']);
	    array_push($info_barangs, $row['number_sold']);
	    array_push($info_barangs, $row['path']);
	    array_push($barangs_per_kategori, $info_barangs);
		$info_barangs = array();
	}
	array_push($barangs, $barangs_per_kategori);
	$barangs_per_kategori = array();

	mysql_close($link);// close mysql then do other job with set_time_limit(59)
	echo json_encode($barangs);
?>