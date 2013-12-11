<?php
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	for($i=0;$i<count($_POST['id']);$i++){
		$del_id=$_POST['id'][$i];
		$ch = curl_init($rest."/kategori/".$del_id);
		curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
		curl_setopt($ch, CURLOPT_HEADER, 0);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
		curl_exec($ch);
		curl_close($ch);
	}
	header("location:../../pages/listkategori.php");
?>