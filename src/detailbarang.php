<!DOCTYPE HTML>
<html>
<head><title>Detail Barang</title></head>

<?php include "header.php"; ?>
<?php include "sidebar.php"; ?>
<script src="javascript/transaksi.js"></script>
<script>
if(localStorage.wbduser){
	var currentpage=1;
	var shopping_bag = [];
	var sum_item = parseInt(<?php 
		$hasil3 = mysql_query("select count(*) from barang",$koneksi);
		$num =  mysql_fetch_array($hasil3);
		echo $num["count(*)"]-1; ?>);
	var maxpage= (sum_item/10+1);
	var isi,buyitem;
	initialize_bag();
}
</script>
<article id="featured" class="body">
	<?php
	if(isset($_GET['id'])){ $id=$_GET['id']; }
	$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restdetailbarang.php?id='.$id;
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
</article>

<?php include "footer.php"; ?>

</div>
</body>
</html>