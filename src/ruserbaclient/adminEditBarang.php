<?php
	require_once('header.php');
	if (isset($_COOKIE['isLogin']))
	{
		if ($_COOKIE['role']==2)
		{
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				<script type="text/javascript" src="js/cekUnik.js"></script>

<hr>


<form enctype="multipart/form-data" method="POST" action="admin/editbarang?id=17">
	
	<div class="register_div">
		<h1 class="header">Edit Barang</h1>

		<div class="per_form">
			<label>Nama</label>
			<input type="text" autocomplete="off" value="Valentia Black Heels2" name="nama_barang" onkeyup="cekUnik(this.value)" id="nama_barang"><span id="message"></span>
		</div>
		<div class="per_form">
			<label>Harga</label>
			<input type="text" value="470000" name="harga_barang">
		</div>
		<div class="per_form">
			<img width="100" height="100" src="images/barang/17.jpg"><br>
			<label>Gambar</label>
			<input type="file" value="17.jpg" name="file">
		</div>
		<button class="btn small full" name="submit" id="submitEditBarang" type="submit">Edit</button>
		<a class="btn small full" href="admin">Kembali</a>
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
