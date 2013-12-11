<?php 
	
	$username=$_GET["username"];
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";

	$sqlquery2 = "SELECT * FROM data_user WHERE username='$username'";
	$url.= rawurlencode($sqlquery2);
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);
	
	if ($count>0) {
		for($i=0;$i<$count;$i++) {
		$count2=$sqlresult2[$i];
		$sql=trim($count2['username']);
		$sql .= "`";
		$sql .=trim($count2['nama']);
		$sql .= "`";
		$sql .=trim($count2['nohp']);
		$sql .= "`";
		$sql .=trim($count2['alamat']);
		$sql .= "`";
		$sql .=trim($count2['provinsi']);
		$sql .= "`";
		$sql .=trim($count2['kota']);
		$sql .= "`";
		$sql .=trim($count2['kodepos']);
		$sql .= "`";
		$sql .=trim($count2['email']);
		$sql .= "`";
		$sql .=trim($count2['password']);
		$sql .= "`";
		$sql .=trim($count2['transaksi']);
			echo $sql;
		}

	}
	
	//mysql_close($db2);
?>

