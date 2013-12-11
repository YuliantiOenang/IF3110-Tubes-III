<h3 class='judul_halaman'>Barang terpopuler</h3>

<?php
	$query = "select * from kategori";	
	include 'scripts/php/query.php';
	foreach($result as $kategori){  
		echo '<div class="category_container">';
		echo '<span class="category">';
		echo '<img src="assets/icon_recommend.png" height="16"/>';
		echo ' ';
		echo '<a href="/ruserba/kategori/'.$kategori['id_kategori'].'">';
		echo $kategori['nama_kategori'];
		echo '</a>';
		echo '</span>';
		echo '<br>';
		echo '<br>';
		$query = "select * from barang where barang.id_kategori = ? order by dibeli desc limit 0, 3";  
		$params = array($kategori['id_kategori']);
		include 'scripts/php/query.php';
		echo '<div class="barang_container">';
		foreach ($result as $barang){  
			echo '<div class="barang">';
			echo '<a href="/ruserba/barang/'.$barang['id_barang'].'">';
			echo '<img src="assets/barang/'.$barang['gambar'].'" height="100%"/>';
			echo '</a>';
			echo '<br>';
			echo '<span class="barang_nama">';
			echo '<a href="/ruserba/barang/'.$barang['id_barang'].'">';
			echo $barang['nama_barang'];
			echo '</a>';
			echo '</span>';
			echo '<br>';
			if($barang['tersedia']==0){
				echo '<span class="barang_tersedia">';
				echo 'Barang tidak tersedia';
				echo '</span>';
				echo '<br>';
			}
			else{
				echo '<span class="barang_tersedia">';
				echo 'Barang tersedia ('.$barang['tersedia'].' unit)';
				echo '</span>';
				echo '<br>';
			}
			echo '<span class="barang_harga">';
			echo 'Rp '.$barang['harga_barang'].',00';
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
?>
