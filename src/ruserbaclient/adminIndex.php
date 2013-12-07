<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				
<script type="text/javascript" src="js/deleteBarang.js"></script>
<h1 class="header">Administrator</h1><br>

<?php
		$var=$_GET['kategori'];
		$nama_barang=$_GET['nama_barang'];
		$kategori = $_GET['kategori'];
		$harga = $_GET['harga'];
		$OP = $_GET['operator'];
	?>

<a class="btn" href="adminAddBarang.php">+ Tambah Barang</a> 
Kategori : 

	<a class="btn small" href="#" onclick="init('<?=AdminBarangService;?>','harga','ASC','<?=$nama_barang;?>','Ladies Dress','<?=$harga;?>','<?=$OP;?>')"> Ladies Dress</a>

	<a class="btn small" href="#" onclick="init('<?=AdminBarangService;?>','harga','ASC','<?=$nama_barang;?>','Ladies Shoes','<?=$harga;?>','<?=$OP;?>')"> Ladies Shoes</a>

	<a class="btn small" href="#" onclick="init('<?=AdminBarangService;?>','harga','ASC','<?=$nama_barang;?>','Men Shirt','<?=$harga;?>','<?=$OP;?>')"> Men Shirt</a>

	<a class="btn small" href="#" onclick="init('<?=AdminBarangService;?>','harga','ASC','<?=$nama_barang;?>','Men Shirt','<?=$harga;?>','<?=$OP;?>')"> Men Shoes</a>

	<a class="btn small" href="#" onclick="init('<?=AdminBarangService;?>','harga','ASC','<?=$nama_barang;?>','Men Hat','<?=$harga;?>','<?=$OP;?>')"> Men Hat</a>
<br>
Sort by : 
		Nama 
		<a class="btn small" onclick="init('<?=AdminBarangService;?>','nama','ASC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">ASC</a> 
		<a class="btn small" onclick="init('<?=AdminBarangService;?>','nama','DESC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">DESC</a> 
		Harga 
		<a class="btn small" onclick="init('<?=AdminBarangService;?>','harga','ASC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">ASC</a> 
		<a class="btn small" onclick="init('<?=AdminBarangService;?>','harga','DESC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">DESC</a>


<br><br>		

<div id="konten">
</div>

<div id="loader" class="hidden"><img src="images/loader.gif" alt="" onload="init('<?=AdminBarangService;?>','harga','ASC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')"></div>

<?php
require_once('footer.php');
?>
