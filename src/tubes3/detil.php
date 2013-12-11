<?php
require_once('header.php'); ?>
<html>
	<head>
		<script type="text/javascript" src="AJAXaddtocart.js"></script>
		<script>
			if (localStorage.user=="admin") {
				window.location = "indexadmin.php"
			}
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middle.php'); ?>
		<div id="container-left">
		<div id="container">
		<?php 
			$namabrg=$_GET["nama"];
			$harga=$_GET["harga"];
		?>
		<?php echo '<h3>',strtoupper(substr($namabrg,0,1)),substr($namabrg,1),'</h3>'; ?>
		<?php 
			echo '
				<img src="images/',$namabrg,'.jpg" alt="gambar" width=400 height=300><br>
				Nama: ',$namabrg,'<br>
			';
			$deskripsi = "c:\\xampp\\htdocs\\tubes3\\deskripsi\\";
			$deskripsi .= $namabrg;
			$deskripsi .= ".txt";
			
			$str= file_get_contents($deskripsi);
			$str = nl2br($str, true); 
			echo $str;
			echo '
			<br><br>Harga: ',$harga,'<br>
			Catatan: <input type="text"><br>
			Banyak: <input type="number" name="qty" id="',$namabrg,'"><br>
			<button type="button" onclick="AJAXaddtocart(\'',$namabrg,'\')">Add to cart</button><br><br>
			';
			
		?>
	
		
		</div>
		</div>
	</body>
</html>