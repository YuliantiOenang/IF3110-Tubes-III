<?php
	include('database_connection.php'); 
	$kategori = array();
	$info_kategori = array();
	if (isset($_GET['id'])){
		if ($_GET['id']==2){
			if(!isset($_GET["sort"])|| !isset($_GET["order"])){
				$result = mysql_query("select * from catalog_product where category = 'Sayur' order by name Asc", $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by name Asc");
			}else{
				$result = mysql_query("select * from catalog_product where category = 'sayur' order by ".$_GET["sort"]." ".$_GET["order"], $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by ".$_GET["sort"]." ".$_GET["order"]);
			}	
		}
		else if ($_GET['id']==3){
			if(!isset($_GET["sort"])|| !isset($_GET["order"])){
				$result = mysql_query("select * from catalog_product where category = 'pakaian' order by name Asc", $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by name Asc");
			}else{
				$result = mysql_query("select * from catalog_product where category = 'pakaian' order by ".$_GET["sort"]." ".$_GET["order"], $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by ".$_GET["sort"]." ".$_GET["order"]);
			}	
		}
		else if ($_GET['id']==4){
			if(!isset($_GET["sort"])|| !isset($_GET["order"])){
				$result = mysql_query("select * from catalog_product where category = 'daging' order by name Asc", $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by name Asc");
			}else{
				$result = mysql_query("select * from catalog_product where category = 'daging' order by ".$_GET["sort"]." ".$_GET["order"], $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by ".$_GET["sort"]." ".$_GET["order"]);
			}	
		}
		else if ($_GET['id']==5){
			if(!isset($_GET["sort"])|| !isset($_GET["order"])){
				$result = mysql_query("select * from catalog_product where category = 'buah' order by name Asc", $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by name Asc");
			}else{
				$result = mysql_query("select * from catalog_product where category = 'buah' order by ".$_GET["sort"]." ".$_GET["order"], $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by ".$_GET["sort"]." ".$_GET["order"]);
			}	
		}
		else if ($_GET['id']==6){
			if(!isset($_GET["sort"])|| !isset($_GET["order"])){
				$result = mysql_query("select * from catalog_product where category = 'alat tulis' order by name Asc", $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by name Asc");
			}else{
				$result = mysql_query("select * from catalog_product where category = 'alat tulis' order by ".$_GET["sort"]." ".$_GET["order"], $link);
		//		$result1 = mysql_query("select path from catalog_product where category = 'sayur' order by ".$_GET["sort"]." ".$_GET["order"]);
			}	
		}
	}
//	$a = mysql_num_rows($result);
//	array_push($kategori, $a);
	while ($row = mysql_fetch_array($result)) {
	    array_push($info_kategori, $row['id']);
	    array_push($info_kategori, $row['name']);
	    array_push($info_kategori, $row['price']);
	    array_push($info_kategori, $row['path']);
	    array_push($kategori, $info_kategori);
	    $info_kategori = array();
	}
	echo json_encode($kategori);
//	while ($row1 = mysql_fetch_array($result1)) {
//	    $new_array1[] = $row1;
//	}
	mysql_close($link);// close mysql then do other job with set_time_limit(59)
?>