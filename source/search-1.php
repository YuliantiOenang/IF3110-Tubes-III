<?php
include ("config-1.php"); 
$query = $_POST['query'];
$pencarian = $_POST['pencarian'];

if ($_POST['submit']) {
	$query=pg_query("select * from barang where $pencarian like '%$query%' ");
	$cek=pg_num_rows($query);
	echo "
	<table border='1'>
	<tr>
		<td>Nama Barang</td><td>Harga Barang</td>
		<td>Stok</td><td>Gambar</td><td>Kategori</td>
		
	</tr>";
	if($cek){
		while ($row = pg_fetch_array($query)) {  //fetch the result from query into an array
		echo "
		<tr>
		<td>".$row['nama_barang']."</td>
		<td>".$row['harga_barang']."</td>
		<td>".$row['stok_barang']."</td>
		<td>".$row['gambar_barang']."</td>
		<td>".$row['kategori']."</td>
		</tr>";}
	}
	else{
		echo "Tidak ada data";
	}
}
else{
	unset($_POST['submit']);
}
echo "</table>";
?>
