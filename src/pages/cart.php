<script>var cartcontent = JSON.parse('<?php echo isset($_SESSION["cart"]) ? json_encode($_SESSION["cart"]) : "{}"; ?>');</script>
<script src='/ruserba/scripts/cart.js'></script>
<script src='/ruserba/scripts/pay.js'></script>
<h3 class="judul_halaman">Keranjang Belanja</h3>
<br/>
<br/>
<br/>
<div id='detailkeranjang'>
	<?php
		$total = 0;
		if (!isset($_SESSION['cart']) || (isset($_SESSION['cart']) && count($_SESSION['cart']) == 0)) {
			echo 'Tidak ada barang dalam keranjang.';
		}
		else {
			foreach ($_SESSION['cart'] as $id => $amount) {
				$query = 'select * from barang left join kategori on barang.id_kategori=kategori.id_kategori where id_barang=?';
				$params = array($id);
				include 'scripts/php/query.php';
				$barang = $result[0];
				echo '<div class="halaman_category_container">';
				echo '<div class="barang_container">';
				echo '<div class="barang">';
				echo '<a href="/ruserba/barang/'.$barang['id_barang'].'">';
				echo '<img src="/ruserba/assets/barang/'.$barang['gambar'].'" height="100%"/>';
				echo '</a>';
				echo '</div>';
				echo '<div class="barang">';
				echo '<span class="barang_nama">';
				echo '<a href="/ruserba/barang/'.$barang['id_barang'].'">';
				echo $barang['nama_barang'];
				echo '</a>';
				echo '<br/>';
				echo 'Kategori: ';
				echo '<a href="/ruserba/kategori/'.$barang['id_kategori'].'">';
				echo $barang['nama_kategori'];
				echo '</a>';
				echo '</span>';
				echo '<br/>';
				if($barang['tersedia']==0){
					echo '<span class="barang_tersedia">';
					echo 'Tidak tersedia';
					echo '</span>';
					echo '<br>';
				}
				else{
					echo '<span class="barang_tersedia">';
					echo 'Tersedia '.$barang['tersedia'].' 	unit';
					echo '</span>';
					echo '<br>';
				}
				echo '<br/>';
				echo '<span class="barang_harga">';
				echo 'Rp <span id="harga_'.$barang['id_barang'].'">'.$barang['harga_barang'].'</span>,00';
				echo '</span>';
				echo '<br/>';
				echo '</div>';
				echo 'Jumlah ';
				echo '<input type="number" class="inputjumlah" name="'.$barang['id_barang'].'" value="'.$amount.'" min="0" max="'.$barang['tersedia'].'" />';
				echo '<br/>';
				$subtotal = $amount * $barang['harga_barang'];
				echo '<h5>Subtotal: Rp <span id="subtotal_'.$barang['id_barang'].'">'.$subtotal.'</span>,00</h5>';
				echo '</div>';
				echo '</div>';
				echo '<hr>';
				$total += $subtotal;
			}
		}
	?>
</div>
<div id='totalkeranjang'>
	<h3>Total:</h3>
	<h2>
		Rp <span id='angkatotal'><?php
			echo $total;
		?></span>,00
	</h2>
	<br />
	<?php
		if ($total > 0) {
	?>
	<a class='button' name='bayar' href='javascript:void(0)'><div>Bayar</div></a>
	<?php } ?>
</div>