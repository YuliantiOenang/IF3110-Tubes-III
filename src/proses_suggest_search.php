<?php
	$q=$_GET["q"];
	$count=0;
	$cek=array();
	$url="http://if3110tubes3.herokuapp.com/REST/getAllSuggest";
	$response=json_decode(file_get_contents($url),true);

	if($response['status']){
		$hint="";
		for($i=0; $i<$response['jumlah']; $i++){
			if (strtolower($q)==strtolower(substr($response['nama'.$i],0,strlen($q)))){
				$hint=$response['nama'.$i];
				break;
			}
		}
		echo $hint;
	}else{
		echo "Database ampas";
	}
?>