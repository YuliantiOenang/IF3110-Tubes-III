<?php
//meminta data user dengan REST
if(isset($_POST['username'])){
	$username = $_POST['username']; 
	$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restprofile.php?username='.$username;
	$curl = curl_init($service_url);
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
	$curl_response = curl_exec($curl);
	if ($curl_response === false) {
		$info = curl_getinfo($curl);
		curl_close($curl);
		die('error occured during curl exec. Additioanl info: ' . var_export($info));
	}
	curl_close($curl);
	$row = json_decode($curl_response);
	echo $row[0]."||";
	echo $row[1]."||";
	echo $row[2]."||";
	echo $row[3]."||";
	echo $row[4]."||";
	echo $row[5]."||";
	echo $row[6]."||";	
	echo $row[7]."||";
	echo $row[8]."||";
	echo $row[9]."||";
	echo $row[10];
}else{
	echo "Gagal mengambil data user!";
}
?>