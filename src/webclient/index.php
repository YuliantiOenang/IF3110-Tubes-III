<?php
	include("lib/transaksi_lib.php");
	include("lib/search_lib.php");
	
	$list = searchHome();
?>

<!DOCTYPE html />
<html>
<head>
<title>Ruko Serba Ada - Home</title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/category.css" />

<script src="js/ajax.js"></script>
<script src="js/login.js"></script>
<script src="js/transaction.js"></script>

</head>
<body>
<div class="outer">
	<?php include("header.php"); ?>
	<div class='content'>
	<h3>Selamat datang di Toko Online Ruko Serba Ada!</h3>
	Silahkan melihat barang-barang unggulan kami dan selamat berbelanja!<br/>

	<div id='cattable' class='table'>
	<?php
		foreach($list as $barang){
			echo '<div class="row rowbarang">';
	
			echo '<div class="cell33 imgcell" ><img class="imgbarang" src="'.$IMAGE_BASE_URL.$barang["id"].'.jpg" /></div>';
			echo '<div class="cell66"><div class="table">';
			echo '<div class="row title"><a href="barang.php?id='.$barang["id"].'" />'.$barang["nama"].'</a></div>';
			echo '<div class="row">Kategori: <a href="category.php?cat='.$barang["kategori"].'">'.$barang["kategori"].'</a></div>';
			echo '<div class="row">Dibeli '.formatCurrency($barang["jumlah_beli"]).' kali</div>';
			echo '<div class="row">Rp. '.formatCurrency($barang["harga"]).'</div>';
			echo '<div class="row">'.$barang["deskripsi"].'</div>';
			echo '<div class="row"><input type="button" value="Tambahkan ke Keranjang" class="main-button-small" onclick="addCart('.$barang["id"].')" /></div>';
			echo '</div></div>';
			
			echo '</div>';
		}
	?>
	</div>	
	</div>
</div>
</body>
</html>
