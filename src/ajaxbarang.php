<?php
//meminta daftar barang dengan REST
if(isset($_GET['sort'])){ $sort=$_GET['sort']; }else{ $sort="nama"; }
if(isset($_GET['page'])){ $page=$_GET['page']; }else{ $page=1; }
if(isset($_GET['kategori'])){ 
	$kategori=rawurlencode($_GET['kategori']); 
	$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restbarang.php?kategori='.$kategori.'&sort='.$sort.'&page='.$page;
}else{
	$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restbarang.php?sort='.$sort.'&page='.$page;
}
$curl = curl_init($service_url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
$curl_response = curl_exec($curl);
if ($curl_response === false) {
	$info = curl_getinfo($curl);
	curl_close($curl);
	die('error occured during curl exec. Additioanl info: ' . var_export($info));
}
curl_close($curl);
$decoded = json_decode($curl_response);
for($i=0;$i<sizeof($decoded);$i++){
	$row = $decoded[$i];
	echo '<div class="view">';
	echo '<img src="'.$row[0].'" width="318" height="238"/>';
	echo '<div class="mask">';
	echo '<h2><a href="detailbarang.php?id='.$row[1].'">'.$row[2].'</a></h2>';
	echo '<p>Harga: '.$row[3].'</p>';
	echo '<form action="shoppingbag.php" method="GET">Masukkan jumlah yang akan dibeli: ';
	echo '<input type="number" name="quantity" min="0" id="qty2"><input type="button" value="Beli!" id="buy" onclick="tempBuy('.$row[1].',qty2.value)"></form>';
	echo '</div></div>';
}
?>