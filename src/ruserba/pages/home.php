<h3 class='judul_halaman'>Barang terpopuler</h3>

<?php
	$result = simplexml_load_file($rest."/kategori.xml");
	foreach($result->children() as $child){ 
		$kategori = simplexml_load_file($rest."/kategori/".$child.".xml");
		echo '<div class="category_container">';
		echo '<span class="category">';
		echo '<img src="assets/icon_recommend.png" height="16"/>';
		echo ' ';
		echo '<a href="/ruserba/kategori/'.$kategori->id_kategori.'">';
		echo $kategori->nama_kategori;
		echo '</a>';
		echo '</span>';
		echo '<br>';
		echo '<br>';
		$barangs = simplexml_load_file($rest."/barang?id_kategori=".$kategori->id_kategori."%20order%20by%20dibeli%20desc%20limit%200,%203.xml");
		echo '<div class="barang_container">';
		foreach ($barangs->children() as $child2){
			$barang = simplexml_load_file($rest."/barang/".$child2."xml");
			echo '<div class="barang">';
			echo '<a href="/ruserba/barang/'.$barang->id_barang .'">';
			echo '<img src="assets/barang/'.$barang->gambar .'" height="100%"/>';
			echo '</a>';
			echo '<br>';
			echo '<span class="barang_nama">';
			echo '<a href="/ruserba/barang/'.$barang->id_barang .'">';
			echo $barang->nama_barang;
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
				echo 'Barang tersedia ('.$barang->tersedia .' unit)';
				echo '</span>';
				echo '<br>';
			}
			echo '<span class="barang_harga">';
			echo 'Rp '.$barang->harga_barang .',00';
			echo '</span>';
			echo '<br>';
			echo '</div>';
		}
		echo '<br>';
		echo '<br>';
		echo '</div>';
		echo '</div>';
		echo '<hr/>';
	}
	echo '<div id="mekanisme">';
	echo '<h3 class="judul_halaman">Mekanisme Transaksi</h3>';
	echo '<br>';
	echo '<br>';
    echo '<img src="assets/mekanisme.jpg" height=100%/>';
	echo '</div>';
?>