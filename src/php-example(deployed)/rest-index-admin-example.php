<?php
	include "database_connection.php";
	$barangs = array();
	$data = mysql_query("SELECT name FROM catalog_product", $link) or die(mysql_error()); 
	while($info = mysql_fetch_array( $data )){
		array_push($barangs, $info["name"]);
	}
	echo json_encode($barangs);
?>