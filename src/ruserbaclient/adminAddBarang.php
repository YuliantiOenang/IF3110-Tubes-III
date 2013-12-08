<?php
	require_once('header.php');
	if (isset($_COOKIE['isLogin']))
	{
		if ($_COOKIE['role']==2)
		{
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				<script type="text/javascript" src="js/cekUnik.js"></script>

<form enctype="multipart/form-data" method="POST" action="adminAddBarangProcess.php">
<div class="register_div">
	<h1 class="header">Tambah Barang</h1>
	<div class="per_form">
		<label>Nama</label>
		<input type="text" autocomplete="off" name="nama_barang" onkeyup="cekUnik('<?=URLService;?>',this.value)" id="nama_barang"> <span id="message"></span>
	</div>
	<div class="per_form">
		<label>Kategori</label>
		 
		<select name="kategori">
			<option value="">--Pilih Kategori--</option>
			
				<option value="1"> Ladies Dress</option>
			
				<option value="2"> Ladies Shoes</option>
			
				<option value="3"> Men Shirt</option>
			
				<option value="4"> Men Shoes</option>
			
				<option value="5"> Men Hat</option>
			
			
		</select>
	</div>
	<div class="per_form">
		<label>Harga</label>
		<input type="text" name="harga_barang">
	</div>
	<div class="per_form">
		<label>Stok</label>
		<input type="text" name="stok">
	</div>
	<div class="per_form">
		<label>Keterangan</label>
		<input type="text" name="keterangan">
	</div>
	<div class="per_form">
		<label>Gambar</label>
		<input type="file" name="file">
	</div>
	<button class="btn small full" name="submit" id="submitEditBarang" type="submit">Tambah Barang</button>
</div>
</form>
			</div>
		</div>
<?php
		require_once('footer.php');
		}
		else header("Location:index.php");
	}
	else header("Location:index.php");
?>
