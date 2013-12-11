<?php
//meminta data user dengan REST
if(isset($_POST['username'])){
	$username = $_POST['username']; 
	$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restcekcard.php?username='.$username;
	$curl = curl_init($service_url);
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
	$curl_response = curl_exec($curl);
	if ($curl_response === false) {
		$info = curl_getinfo($curl);
		curl_close($curl);
		die('error occured during curl exec. Additioanl info: ' . var_export($info));
	}
	curl_close($curl);
	echo $curl_response;
}else{
	echo "Gagal mengambil data user!";
}
?>