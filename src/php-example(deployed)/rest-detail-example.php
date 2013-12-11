<?php
	include('database_connection.php'); 
	$detail = array();
	$result = mysql_query("select * from catalog_product where id = '".$_GET['id']."'", $link);
	//$result1 = mysql_query("select path from catalog_product where id = '".$_GET['id']."'");
	while ($row = mysql_fetch_array($result)) {
	    array_push($detail, $row['id']);
	    array_push($detail, $row['name']);
	    array_push($detail, $row['price']);
	    array_push($detail, $row['description']);
	    array_push($detail, $row['path']);
	}

//	while ($row1 = mysql_fetch_array($result1)) {
//	    $new_array1[] = $row1;
//	}
	mysql_close($link);// close mysql then do other job with set_time_limit(59)
	echo json_encode($detail);
?>