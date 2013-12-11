<?php
	include 'header.php';
	include 'connect.php';

	//Retrieve from database
	$idbarang = $_GET['id'];
	$barang_query = 'SELECT * FROM `progin_13511059`.barang WHERE id_barang = '.$idbarang;
	$barang_hasil = mysql_query($barang_query,$con);
	$barang_row = mysql_fetch_array($barang_hasil);

	echo '<h1>'.$barang_row['nama_barang'].'</h1><br>';
	echo '<img src='.$barang_row['gambar_barang'].' width="300px" height="300px"/><br>';
	
	echo '<br><h2>Deskripsi : </h2><p>'.$barang_row['keterangan'].'</p><br>';
	echo'
	Request tambahan 	: <br>

	<form action="addcart.php" method="post" id="usrform">
		<textarea rows="4" cols="50"  name="request_tambahan" form="usrform"></textarea><br>
		<input type="hidden" 		  name="id_barang" value="'.$idbarang.'">
		Quantity : <input type="text" name="qt" style="width: 20px; text-align: right" /><br>
	<input type="submit" value="Add to cart">
	</form>
	<br>';

	include'footer.php';
?>