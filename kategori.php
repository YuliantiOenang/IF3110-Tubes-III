<?php
	include 'connect.php';
	include 'header.php';

	function getCateName($idkat){
		if($idkat==1){
			$nama = "Pangan";
		}
		else if($idkat==3){
			$nama = "Elektronik";
		}
		else if($idkat==2){
			$nama = "Pakaian";
		}
		else if($idkat==4){
			$nama = "Rumah Tangga";
		}
		else if($idkat==5){
			$nama = "Olah Raga";
		}
		else {
			$nama = "tidak terdaftar";
		}
	}

	//inisialisasi order_by
	if(!isset($_GET['order'])) {
		$order = 'nama_barang';
	} else {
		$order = $_GET['order'];
	}

	//inisialisasi page
	$page = $_GET['page'];
	$i = ($page-1)*10;

	//get banyaknya item
	$n_item = 30;


	
	//Retrieve from database
	$id = $_GET['id'];
	$kategori_query = 'SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = '.$id.' ORDER BY '.$order.' ASC LIMIT '.$i.', 10';
	$kategori_hasil = mysql_query($kategori_query,$con);
	
	//Write
	echo '
    <div id="content" class="float_l">';
		getCateName($id);
		while($kategori_row = mysql_fetch_array($kategori_hasil)) {
			$id_barang = $kategori_row['id_barang'];
			$nama = $kategori_row['nama_barang'];
			$gambar = $kategori_row['gambar_barang'];
			$harga = $kategori_row['harga_barang'];
			$stok = $kategori_row['stok'];
			echo'
			<div class="product_box">
				<h3>'.$nama.'</h3>
				<a href="detail.php?id='.$id_barang.'"><img src="'.$gambar.'"/></a>
				<p class="product_price">Harga : Rp '.$harga.',-<br>
				Stok : '.$stok.'<br>
				<form name="beli" action="addcart.php" method="post">
					<input type="hidden" name="id_barang" value="'.$id_barang.'">
					<input type="hidden" name="request_tambahan" value="-">
					Quantity <input type="text" name="qt" style="width: 20px; text-align: right" />
					<input type="submit" value="Add to cart">
				</form>
				</p>
			</div>';
		}

	//navigasi paginasi
	if ($page == 1) {
		echo '<li> <a href="kategori.php?id=', $id ,'&page=', $page+1 ,'">Berikutnya>>></a></li><br>';
		for ($x=1;$x<=$n_item/10;$x++) {
			echo '<li> <a href="kategori.php?id=', $id ,'&page=', $x ,'">',$x,'</a></li><br>';
		}
	}
	else if ($page >= $n_item/10) {
		echo '<li> <a href="kategori.php?id=', $id ,'&page=', $page-1 ,'"><<<Sebelumnya</a></li><br>';
		for ($x=1;$x<=$n_item/10;$x++) {
			echo '<li> <a href="kategori.php?id=', $id ,'&page=', $x ,'">',$x,'</a></li><br>';
		}
	} else {
		echo '<li> <a href="kategori.php?id=', $id ,'&page=', $page+1 ,'">Berikutnya>>></a></li><br>';
		for ($x=1;$x<=$n_item/10;$x++) {
			echo '<li> <a href="kategori.php?id=', $id ,'&page=', $x ,'">',$x,'</a></li><br>';
		}
		echo '<li> <a href="kategori.php?id=', $id ,'&page=', $page-1 ,'"><<<Sebelumnya</a></li><br>';
	}

	//fitur sorting
	echo '
	<p> Sort By : </p>
	<li> <a href="kategori.php?id=', $id ,'&page=1&order=nama_barang">Nama Barang</a></li><br>
	<li> <a href="kategori.php?id=', $id ,'&page=1&order=harga_barang">Harga Barang</a></li><br>';	
	echo '</div>';

    include 'footer.php';

?>
	