<?php
//meminta data user pada database dengan REST
$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restvalidasi.php?q='.rawurlencode($_GET['q']).'&num='.$_GET['num'].'&pass='.$_GET['pass'];
$curl = curl_init($service_url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
$curl_response = curl_exec($curl);
if($curl_response==0){
	echo 0;
}else if ($curl_response === false) {
	$info = curl_getinfo($curl);
	curl_close($curl);
	die('error occured during curl exec. Additioanl info: ' . var_export($info));
}else{
	echo $curl_response;
}
curl_close($curl);
?>