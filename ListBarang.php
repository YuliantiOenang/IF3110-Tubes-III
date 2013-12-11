<?php
	include 'connect.php';
		$hot_pangan = 'SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 1 ORDER BY n_beli DESC LIMIT 0,3';
		$hot_pakaian = 'SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 2 ORDER BY n_beli DESC LIMIT 0,3';
		$hot_elektronik = 'SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 3 ORDER BY n_beli DESC LIMIT 0,3';
		$hot_rumahtangga = 'SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 4 ORDER BY n_beli DESC LIMIT 0,3';
		$hot_olahraga = 'SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 5 ORDER BY n_beli DESC LIMIT 0,3';
		
		$pangan_hasil = mysql_query($hot_pangan,$con);
		$pakaian_hasil = mysql_query($hot_pakaian,$con);
		$elektronik_hasil = mysql_query($hot_elektronik,$con);
		$rumahtangga_hasil = mysql_query($hot_rumahtangga,$con);
		$olahraga_hasil = mysql_query($hot_olahraga,$con);

		if (!$pangan_hasil || !$pakaian_hasil || !$elektronik_hasil || !$rumahtangga_hasil || !$olahraga_hasil){
			echo "tidak dapat meload database";
		} else {
			$x = 0;
			while($pangan_row = mysql_fetch_array($pangan_hasil)) {
				$id_pangan[$x] = $pangan_row['id_barang'];
				$nama_pangan[$x] = $pangan_row['nama_barang'];
				$gambar_pangan[$x] = $pangan_row['gambar_barang'];
				$harga_pangan[$x] = $pangan_row['harga_barang'];
				$stok_pangan[$x] = $pangan_row['stok'];
				$x=$x+1;
			}
			$x = 0;
			while($pakaian_row = mysql_fetch_array($pakaian_hasil)) {
				$id_pakaian[$x] = $pakaian_row['id_barang'];
				$nama_pakaian[$x] = $pakaian_row['nama_barang'];
				$gambar_pakaian[$x] = $pakaian_row['gambar_barang'];
				$harga_pakaian[$x] = $pakaian_row['harga_barang'];
				$stok_pakaian[$x] = $pakaian_row['stok'];
				$x=$x+1;
			}
			$x = 0;
			while($elektronik_row = mysql_fetch_array($elektronik_hasil)) {
				$id_elektronik[$x] = $elektronik_row['id_barang'];
				$nama_elektronik[$x] = $elektronik_row['nama_barang'];
				$gambar_elektronik[$x] = $elektronik_row['gambar_barang'];
				$harga_elektronik[$x] = $elektronik_row['harga_barang'];
				$stok_elektronik[$x] = $elektronik_row['stok'];
				$x=$x+1;
			}
			$x = 0;
			while($rumahtangga_row = mysql_fetch_array($rumahtangga_hasil)) {
				$id_rumahtangga[$x] = $rumahtangga_row['id_barang'];
				$nama_rumahtangga[$x] = $rumahtangga_row['nama_barang'];
				$gambar_rumahtangga[$x] = $rumahtangga_row['gambar_barang'];
				$harga_rumahtangga[$x] = $rumahtangga_row['harga_barang'];
				$stok_rumahtangga[$x] = $rumahtangga_row['stok'];
				$x=$x+1;
			}
			$x = 0;
			while($olahraga_row = mysql_fetch_array($olahraga_hasil)) {
				$id_olahraga[$x] = $olahraga_row['id_barang'];
				$nama_olahraga[$x] = $olahraga_row['nama_barang'];
				$gambar_olahraga[$x] = $olahraga_row['gambar_barang'];
				$harga_olahraga[$x] = $olahraga_row['harga_barang'];
				$stok_olahraga[$x] = $olahraga_row['stok'];
				$x=$x+1;
			}	
		}
	echo '
        <div id="content" class="float_l">
        	<h1>Top Pangan</h1>';
        	for($x=0;$x<3;$x++) {
        		echo'
        		<div class="product_box">
	                <h3>'.$nama_pangan[$x].'</h3>
	                <a href="detail.php?id='.$id_pangan[$x].'"><img src="'.$gambar_pangan[$x].'"/></a>
	                <p class="product_price">Harga : Rp '.$harga_pangan[$x].',-<br>
	                Stok : '.$stok_pangan[$x].'<br>
	                <form name="beli" action="addcart.php" method="post">
			        	<input type="hidden" name="id_barang" value="'.$id_pangan[$x].'">
			        	<input type="hidden" name="request_tambahan" value="-">
				        Quantity <input type="text" name="qt" style="width: 20px; text-align: right" />
						<input type="submit" value="Add to cart">
	       			</form>
					</p>
            	</div>';
        	}
        	echo '
            <h1>Top Pakaian</h1>';
            for($x=0;$x<3;$x++) {
        		echo'
        		<div class="product_box">
	                <h3>'.$nama_pakaian[$x].'</h3>
	                <a href="detail.php?id='.$id_pakaian[$x].'"><img src="'.$gambar_pakaian[$x].'"/></a>
	                <p class="product_price">Harga : Rp '.$harga_pakaian[$x].',-<br>
	                Stok : '.$stok_pakaian[$x].'<br>
	                <form name="beli" action="addcart.php" method="post">
			        	<input type="hidden" name="id_barang" value="'.$id_pakaian[$x].'">
			        	<input type="hidden" name="request_tambahan" value="-">
				        Quantity <input type="text" name="qt" style="width: 20px; text-align: right" />
						<input type="submit" value="Add to cart">
	       			</form>
					</p>
            	</div>';
        	}
        	echo '
            <h1>Top Elektronik</h1>';
           	for($x=0;$x<3;$x++) {
        		echo'
        		<div class="product_box">
	                <h3>'.$nama_elektronik[$x].'</h3>
	                <a href="detail.php?id='.$id_elektronik[$x].'"><img src="'.$gambar_elektronik[$x].'"/></a>
	                <p class="product_price">Harga : Rp '.$harga_elektronik[$x].',-<br>
	                Stok : '.$stok_elektronik[$x].'<br>
	                <form name="beli" action="addcart.php" method="post">
			        	<input type="hidden" name="id_barang" value="'.$id_elektronik[$x].'">
			        	<input type="hidden" name="request_tambahan" value="-">
				        Quantity <input type="text" name="qt" style="width: 20px; text-align: right" />
						<input type="submit" value="Add to cart">
	       			</form>
					</p>
            	</div>';
        	}
        	echo '
            <h1>Top Rumah Tangga</h1>';
            for($x=0;$x<3;$x++) {
        		echo'
        		<div class="product_box">
	                <h3>'.$nama_rumahtangga[$x].'</h3>
	                <a href="detail.php?id='.$id_rumahtangga[$x].'"><img src="'.$gambar_rumahtangga[$x].'"/></a>
	                <p class="product_price">Harga : Rp '.$harga_rumahtangga[$x].',-<br>
	                Stok : '.$stok_rumahtangga[$x].'<br>
	                <form name="beli" action="addcart.php" method="post">
			        	<input type="hidden" name="id_barang" value="'.$id_rumahtangga[$x].'">
			        	<input type="hidden" name="request_tambahan" value="-">
				        Quantity <input type="text" name="qt" style="width: 20px; text-align: right" />
						<input type="submit" value="Add to cart">
	       			</form>
					</p>
            	</div>';
        	}
        	echo '
            <h1>Top Olah Raga</h1>';
            for($x=0;$x<3;$x++) {
        		echo'
        		<div class="product_box">
	                <h3>'.$nama_olahraga[$x].'</h3>
	                <a href="detail.php?id='.$id_olahraga[$x].'"><img src="'.$gambar_olahraga[$x].'"/></a>
	                <p class="product_price">Harga : Rp '.$harga_olahraga[$x].',-<br>
	                Stok : '.$stok_olahraga[$x].'<br>
	               <form name="beli" action="addcart.php" method="post">
			        	<input type="hidden" name="id_barang" value="'.$id_olahraga[$x].'">
			        	<input type="hidden" name="request_tambahan" value="-">
				        Quantity <input type="text" name="qt" style="width: 20px; text-align: right" />
						<input type="submit" value="Add to cart">
	       			</form>
					</p>
            	</div>';
        	}
        	echo '  	
        </div>';
?>