<?php 

	
	$username=$_GET["username"];
	$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
	$sqlquery2 = "SELECT * FROM data_user WHERE username='$username'";
	$url.= rawurlencode($sqlquery2);
	//$sqlresult2 = mysql_query($sqlquery2,$db2 ) or die ('Unable to run query:'.mysql_error());
	$sqlresult2=json_decode(file_get_contents($url),true);
	$count=count($sqlresult2);
	
	if ($sqlresult2==false) {
		echo "false";
	} else {
		for ($i=0;$i<$count;$i++) {
			$count2 = $sqlresult2[$i];
			$cardno = $count2['cardno'];
		}
		if ($cardno!=NULL) {
			echo $cardno;
		} else {
			echo "false";
		}
	}
	
?>
