<?php 
	
	$productname=$_GET["productname"];
	$beli=$_GET["qty"];

	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_barang WHERE nama='$productname'";
	$url.= rawurlencode($sqlquery2);
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);
	
	if ($sqlresult2==false) {
		echo "false";
	} else {
		for ($i=0;$i<$count;$i++) {
			$count2 = $sqlresult2[$i];
			$stok=trim($count2['stok']);
		}
		if ($stok < $beli) {
			echo $stok;
		} else {
			echo "true";
		}
	}
?>


	