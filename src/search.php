<?php
if(isset($_GET['cari'])){ $cari = $_GET['cari']; }
if(isset($_GET['suggest'])){ $suggest = $_GET['suggest']; }
if(isset($_GET['page'])){ $page=($_GET['page']-1)*10; }else{ $page=0; }
$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restsearch.php?cari='.$cari.'&suggest='.$suggest.'&page='.$page;
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