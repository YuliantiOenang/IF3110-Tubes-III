<?php
	include 'header.php';
	include 'connect.php';

	//inisialisasi order_by
	if(!isset($_GET['order'])) {
		$order = 'nama_barang';
	} else {
		$order = $_GET['order'];
	}

	//inisialisasi page
	$page = $_GET['page'];
	$i = ($page-1)*10;

	//Retrieve from database
	$name = $_GET['searched'];
	$harga = $_GET['s_harga'];
	$kategori = $_GET['s_kategori'];

if (!empty($name)) {
	if(!empty($harga)){ //ada harga
		if(!empty($kategori)){
			$n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%' AND harga_barang BETWEEN 0 AND ".$harga."
						AND kategori_barang = ".$kategori;
			$search_query = "SELECT * FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%' AND harga_barang BETWEEN 0 AND ".$harga."
						AND kategori_barang = ".$kategori." ORDER BY ".$order." ASC LIMIT ".$i.", 10";
		}else { //kategori kosong
			$n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%' AND harga_barang BETWEEN 0 AND ".$harga;
			$search_query = "SELECT * FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%' AND harga_barang BETWEEN 0 AND ".$harga." ORDER BY ".$order." ASC LIMIT ".$i.", 10";
		}
	}else{ //harga kosong
		if(!empty($kategori)) {
			$n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%' AND kategori_barang = ".$kategori;
			$search_query = "SELECT * FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%' AND kategori_barang = ".$kategori." ORDER BY ".$order." ASC LIMIT ".$i.", 10";
		} else {
			$n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%'";
			$search_query = "SELECT * FROM `progin_13511059`.barang 
						WHERE nama_barang like '%".$name."%' ORDER BY ".$order." ASC LIMIT ".$i.", 10";
		}
		
	}
}else{// nama kosong
	if(!empty($harga)){ //ada harga
		if(!empty($kategori)){ //ada kategori
			$n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang 
						WHERE harga_barang BETWEEN 0 AND ".$harga."
						AND kategori_barang = ".$kategori;
			$search_query = "SELECT * FROM `progin_13511059`.barang 
						WHERE harga_barang BETWEEN 0 AND ".$harga."
						AND kategori_barang = ".$kategori." ORDER BY ".$order." ASC LIMIT ".$i.", 10";
		}else { //kategori kosong
			$n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang 
						WHERE harga_barang BETWEEN 0 AND ".$harga;
			$search_query = "SELECT * FROM `progin_13511059`.barang 
						WHERE harga_barang BETWEEN 0 AND ".$harga." ORDER BY ".$order." ASC LIMIT ".$i.", 10";
		}
	} else { //gak ada harga
		if(!empty($kategori)) {
			$n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang 
						WHERE kategori_barang=".$kategori;
			$search_query = "SELECT * FROM `progin_13511059`.barang 
						WHERE kategori_barang=".$kategori." ORDER BY ".$order." ASC LIMIT ".$i.", 10";
		}
	}
}
	$n_item_hasil = mysql_query($n_item_query,$con);
	$search_hasil = mysql_query($search_query,$con);

	$n_item_row = mysql_fetch_array($n_item_hasil);
	$n_item = $n_item_row['n_item'];
	//Write
	echo '
	<div id="content" class="float_l">';
		if ($n_item == 0) {
			echo '<h3>Gak Ketemu Bro</h3>';
		} else {
			while($search_row = mysql_fetch_array($search_hasil)) {
			$id_barang = $search_row['id_barang'];
			$nama_barang = $search_row['nama_barang'];
			$gambar_barang = $search_row['gambar_barang'];
			$harga_barang = $search_row['harga_barang'];
			$stok_barang = $search_row['stok'];
			echo'
			<div class="product_box">
				<h3>'.$nama_barang.'</h3>
				<a href="detail.php?id='.$id_barang.'"><img src="'.$gambar_barang.'"/></a>
				<p class="product_price">Harga : Rp '.$harga_barang.',-<br>
				Stok : '.$stok_barang.'<br>
				<form name="beli" action="addcart.php" method="post">
					<input type="hidden" name="id_barang" value="'.$id_barang.'">
					<input type="hidden" name="request_tambahan" value="-">
					Quantity <input type="text" name="qt" style="width: 20px; text-align: right" />
					<input type="submit" value="Add to cart">
				</form>
			</div>';
			}
		}

	//navigasi paginasi
	if ($n_item > 10) {
		if ($page == 1) {
			echo '<li> <a href="search.php?page=', $page+1 ,'&searched=',$name,'&s_harga=',$harga,'&s_kategori=',$kategori,'">Berikutnya>>></a></li><br>';
			for ($x=0;$x<$n_item/10;$x++) {
				echo '<li> <a href="search.php?page=', $x+1 ,'&searched=',$name,'&s_harga=',$harga,'&s_kategori=',$kategori,'">',$x+1,'</a></li><br>';
			}
		}
		else if ($page >= $n_item/10) {
			echo '<li> <a href="search.php?page=', $page-1 ,'&searched=',$name,'&s_harga=',$harga,'&s_kategori=',$kategori,'"><<<Sebelumnya</a></li><br>';
			for ($x=0;$x<$n_item/10;$x++) {
				echo '<li> <a href="search.php?page=', $x+1 ,'&searched=',$name,'&s_harga=',$harga,'&s_kategori=',$kategori,'">',$x+1,'</a></li><br>';
			}
		} else {
			echo '<li> <a href="search.php?page=', $page+1 ,'&searched=',$name,'&s_harga=',$harga,'&s_kategori=',$kategori,'">Berikutnya>>></a></li><br>';
			for ($x=0;$x<$n_item/10;$x++) {
				echo '<li> <a href="search.php?page=', $x+1 ,'&searched=',$name,'&s_harga=',$harga,'&s_kategori=',$kategori,'">',$x+1,'</a></li><br>';
			}
			echo '<li> <a href="search.php?page=', $page-1 ,'&searched=',$name,'&s_harga=',$harga,'&s_kategori=',$kategori,'"><<<Sebelumnya</a></li><br>';
		}
		//fitur sorting
		echo '
		<p> Sort By : </p>
		<li> <a href="search.php?page=1&searched=',$name,'&order=nama_barang">Nama Barang</a></li><br>
		<li> <a href="search.php?page=1&searched=',$name,'&order=harga_barang">Harga Barang</a></li><br>';
	}

	echo '</div>';
    include 'footer.php';
?>