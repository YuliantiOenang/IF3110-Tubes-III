<?php
if (isset($_POST['data'])) $tabel = $_POST['data'];
if(isset($_POST['username'])) $username = $_POST['username'];
$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restbuy.php?data='.$tabel.'&username='.$_POST['username'];
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
?>