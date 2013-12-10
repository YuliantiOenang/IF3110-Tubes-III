<?php

include("lib/transaksi_lib.php");
include("lib/search_lib.php");

if(isset($_POST["ajax"])){
	$response = handleTransactionAjax();
	if ($response != null){
		exit($response);
	}
	
	exit();	
} else if(!isset($_GET["id"])){
	header("Location: index.php");
}



$barang = searchId($_GET["id"]);
if ($barang == null) header("Location: index.php");

?>
<!DOCTYPE html />
<html>
<head>
<title>Barang</title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/barang.css" />

<script src="js/ajax.js"></script>
<script src="js/login.js"></script>
<script src="js/transaction.js"></script>
<script src="js/admin.js"></script>
</head>
<body>
<div class="outer">
	<?php
		include("header.php");
	?>
	<div class='content'>
	<?php
		echo '<div class="barang table">';
		echo '<div class="row title">'.$barang["nama"].'</div>';
		echo '<div class="row"><img class="imgbarang" src="'.$IMAGE_BASE_URL.$barang["id"].'.jpg" /></div>';
		echo '<div class="row harga"><div class="cell33">Harga</div><div class="cell66">: Rp. '.formatCurrency($barang["harga"]).'</div></div>';
		echo '<div class="row"><div class="cell33">Dibeli</div><div class="cell66">: '.$barang["jumlah_beli"].' kali</div>';
		echo '<div class="row kategori"><div class="cell33">Kategori</div><div class="cell66">: ';
		echo '<a href="admin_barang.php?cat='.$barang["kategori"].'">';
		echo $barang["kategori"].'</a></div></div>';
		echo '<div class="row jumlah"><div class="cell33">Stok</div><div class="cell66">: '.$barang["stok"].'</div></div>'; 
		echo '<div class="row"><div class="cell33">Deskripsi</div><div class="cell66">:</div></div>';
		echo '<div class="row deskripsi">'.$barang["deskripsi"].'</div>';
		echo '<div class="rowtools">';
		echo '<a href="edit_barang.php?id='.$barang["id"].'"><img src=image/Edit.jpg id="edit"></a>';
		echo '<input type="image" src=image/Delete.png id="delete" onclick="deleteBarangDetail(\''.$barang["kategori"].'\','.$barang["id"].')">';
		echo '</div></div>';

	?>
	</div>
</div>
</body>
</html>