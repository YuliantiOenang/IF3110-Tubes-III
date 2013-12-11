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
	include "koneksi.inc.php";
	$query2 = "select * from barang where id='$id'";
	$hasil2 = mysql_query($query2,$koneksi);
	while($row = mysql_fetch_array($hasil2)){
		echo '<img src="'.$row["gambar"].'" width="318" height="238"/>';
		echo '<h2>'.$row["nama"].'</h2>';
		echo '<p>Keterangan : '.$row["keterangan"].'</p>';
		echo '<form>';
		echo '<pre>Masukkan jumlah barang yang akan dibeli		<input type="number" name="quantity" min="1" id="qty"></pre>';
		echo '<pre style="vertical-align:top">Masukkan tambahan permintaan 			<textarea name="tambahan" rows="4"></textarea></pre>';
		echo '<input type="button" value="Beli!" onclick="tempBuy('.$row["id"].',qty.value)"></form>';
	}
	?>
</article>

<?php include "footer.php"; ?>

</div>
</body>
</html>