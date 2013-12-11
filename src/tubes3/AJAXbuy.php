<?php 
	
	$productname=$_GET["productname"];
	$qty=(int) $_GET['qty'];
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_barang WHERE nama='$productname'";
	$url.= rawurlencode($sqlquery2);
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);
	
	if ($sqlresult2==false) {
	
	} else {
		for($i=0;$i<$count;$i++) {
			$count2 = $sqlresult2[$i];
			$stokbaru = (int)trim($count2['stok'])-$qty;
			$terjual = (int)trim($count2['terjual'])+$qty;
		}
		$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
		$sqlquery3 = "UPDATE data_barang SET stok='$stokbaru', terjual='$terjual' WHERE nama='$productname'";
		$url.= rawurlencode($sqlquery3);
		$sqlresult3=json_decode(file_get_contents($url),true);
	}
?>
