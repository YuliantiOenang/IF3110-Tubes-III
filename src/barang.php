<?php

include("lib/transaksi_lib.php");
include("lib/search_lib.php");

if(isset($_POST["ajax"])){
	$response = handleTransactionAjax();
	if ($response != null){
		exit($response);
	}
	
	exit();	
}else if(!isset($_GET["id"])){
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
		echo '<form name="barang">';
		echo '<input type="hidden" name="id" value="'.$barang->id.'"/>';
		echo '<div id="nama" class="row title">'.$barang->nama.'</div>';
		echo '<div class="row"><img class="imgbarang" src="image/'.$barang->id.'.jpg" /></div>';
		echo '<div id="gambar_row" class="row harga"><div class="cell33">Gambar</div><div class="cell66">: </div><div id="gambar" class="cell66">'.$barang->id.'</div></div>';
		echo '<div class="row harga"><div class="cell33">Harga</div><div class="cell66">: Rp. </div><div id="harga" class="cell66">'.formatCurrency($barang->harga).'</div></div>';
		echo '<div class="row kategori"><div class="cell33">Kategori</div><div class="cell66">: ';
		echo '<a href="category.php?cat='.$barang->kategori.'">'.$barang->kategori.'</a></div></div>';
		echo '<div class="row"><div class="cell33">Deskripsi</div><div class="cell66">:</div></div>';
		echo '<div class="row deskripsi">'.$barang->deskripsi.'</div>';
		echo '</form>';
		echo '</div>';
		
		echo '<input class="main-button" type="button" value="Tambahkan ke Keranjang" onclick="addCart('.$barang->id.')"/>';
		echo '<div id="admin" class="row"></div>';
		?>
		<script>
			if (loginfo.role == 'admin') {
				admin.innerHTML = "<input type='button' value='Update' class='main-button-small' onclick='updateBarang()' /><input type='button' value='Hapus' class='main-button-small' />";
				nama.innerHTML = "<input type='text' name='nama' value='" + nama.innerHTML + "'/>";
				gambar.innerHTML = "<input type='text' name='gambar' value='" + gambar.innerHTML + "'/>";
				harga.innerHTML = "<input type='text' name='harga' value='" + harga.innerHTML + "'/>";
			} else {
				gambar_row.innerHTML = "<input type='hidden' name='gambar' value='" + gambar.innerHTML + "'/>";
			}
		</script>
		<?
	?>
	</div>
</div>
</body>
</html>