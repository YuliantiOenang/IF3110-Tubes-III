<?php
	include('database_connection.php');
	$result_info = array();
	$results = array(); 
	$result = mysql_query("select * from catalog_product where category like '%".$_GET['nama']."%' OR name like '%".$_GET['nama']."%' OR price like  '%".$_GET['nama']."%'", $link);
//	$result1 = mysql_query("select path from catalog_product where category like '%".$_GET['nama']."%' OR name like '%".$_GET['nama']."%' OR price like '%".$_GET['nama']."%'");
	while ($row = mysql_fetch_array($result)) {
	    array_push($result_info, $row['id']);
	    array_push($result_info, $row['name']);
	    array_push($result_info, $row['price']);
	    array_push($result_info, $row['path']);
	    array_push($results, $result_info);
	    $result_info = array();
	}
	mysql_close($link);// close mysql then do other job with set_time_limit(59)
	echo json_encode($results);
?>