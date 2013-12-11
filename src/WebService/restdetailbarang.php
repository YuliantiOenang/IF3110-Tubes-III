<?php 
include "koneksi.inc.php";
$query2 = "select * from barang where id='".$_GET['id']."'";
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