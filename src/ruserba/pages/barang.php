<?php 
	if(!isset($_SESSION['username'])) {
		header("Location: /ruserba");
	} else if ($_SESSION['username'] == 'admin') {
		header("Location: /ruserba/pages/listkategori.php");
	}
?>
<script>var cartcontent = JSON.parse('<?php echo isset($_SESSION["cart"]) ? json_encode($_SESSION["cart"]) : "{}"; ?>');</script>
<script src='/ruserba/scripts/addamounttocart.js'></script>
<?php
	$barang = simplexml_load_file($rest."/barang/".$_GET['id'].".xml");
	echo '<h3 class="judul_halaman">';
	echo $barang->nama_barang;
	echo '</h3>';
	echo '<br/>';
	echo '<br/>';
	echo '<br/>';
	echo '<div class="barang_container">';
	echo '<div class="barang_gambar_detail">';
	echo '<img src="/ruserba/assets/barang/'.$barang->gambar.'" width=100%/>';
	echo '</div>';
	echo '<div class="barang_detail">';
	$kategori = simplexml_load_file($rest."/kategori/".$barang->id_kategori.".xml");
	echo 'Kategori: ';
	echo '<span class="barang_nama">';
	echo '<a href="/ruserba/kategori/'.$barang->id_kategori.'">';
	echo $kategori->nama_kategori;
	echo '</a>';
	echo '</span>';
	echo '<br>';
	if($barang->tersedia==0){
		echo '<span class="barang_tersedia">';
		echo 'Barang tidak tersedia';
		echo '</span>';
		echo '<br>';
	}
	else{
		echo '<span class="barang_tersedia">';
		echo 'Barang tersedia ('.$barang->tersedia.' 	unit)';
		echo '</span>';
		echo '<br>';
	}
	echo '<span class="barang_harga">';
	echo 'Rp '.$barang->harga_barang.',00';
	echo '</span>';
	echo '<br>';
	echo '<br>';
	echo '<br>';
	if ($barang->tersedia > 0) {
		echo 'Jumlah ';
		echo '<input type="number" class="inputjumlah" name="jumlah" value="1" min="1" max="'.(isset($_SESSION['cart'][(int)$barang->id_barang]) ? ($barang->tersedia - $_SESSION['cart'][(int)$barang->id_barang]) : $barang->tersedia).'"/>';
		echo '<br>';
		echo '<a class="button beli" name="'.$barang->id_barang.'" href="javascript:void(0)"><div>Pesan Barang</div></a>';
	}
	echo '</div>';
	echo '</div>';
?>