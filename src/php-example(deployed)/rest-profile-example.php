<?php
	include "database_connection.php";
	$kategori = array();
	$data = mysql_query("SELECT DISTINCT category FROM catalog_product", $link) or die(mysql_error()); 
	while($info = mysql_fetch_array( $data )){
		array_push($kategori, $info["category"]);
	}
	echo json_encode($kategori);
?>