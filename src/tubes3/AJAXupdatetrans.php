<?php 
	
	$username=$_GET["username"];
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	
	$sqlquery2 = "SELECT * FROM data_user WHERE username='$username'";
	$url.= rawurlencode($sqlquery2);
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);
	
	if ($sqlresult2==false) {
		
	} else {
		for ($i=0;$i<$count;$i++) {
			$count2 = $sqlresult2[$i];
			$transaksi= (int) $count2['transaksi'] +1;
			$url2 = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
			$sqlquery3 = "UPDATE data_user SET transaksi='$transaksi' WHERE username='$username'";
			$url2.= rawurlencode($sqlquery3);
			$sqlresult2=json_decode(file_get_contents($url2),true);

		}
	}

?>
