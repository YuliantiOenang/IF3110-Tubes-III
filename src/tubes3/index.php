<?php
require_once('header.php'); ?>
<html>
	<head>
		<script src="AJAXaddtocart.js"></script>
		<script>
			if (localStorage.user=="admin") {
				window.location = "indexadmin.php"
			}
		</script>
		<link rel="stylesheet" href="header.css">
	</head>
	<?php
	require_once('middle.php'); ?>
		<div id="product">
		<div id="container">
		<h2>Home</h2>
		<?php 
			$kategori=array("beras","daging","ikan","sayur","buah");
			for($i=0;$i<count($kategori);$i++) {
				echo "<h3>",ucfirst($kategori[$i]),"</h3>";
				
				/* $con=mysqli_connect("localhost","root","","ruserba");
				// Check connection
				if (mysqli_connect_errno()) {
					echo "Failed to connect to MySQL: " . mysqli_connect_error();
				} */

				// Query from database
				$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
				$sql = "SELECT * FROM data_barang WHERE kategori='".$kategori[$i]."' ORDER BY terjual DESC";
				$url.= rawurlencode($sql);
				$result=json_decode(file_get_contents($url),true);
				// Display result
				for ($j=0;$j<3;$j++) {
					$row = $result[$j];
					$nama=trim($row['nama']);
					$harga=trim($row['harga']);
					echo'
					<div id="containertop3">
					<img src="images/',$nama,'.jpg" alt=gambar width=200 height=150> <br>
					Nama: <a href="detil.php?nama=',$nama,'&harga=',$harga,'" > ',$nama,'</a><br>
					Harga: ',$harga,'<br>
					Banyak: <input type="texttop3" name="qty" id="',$nama,'">
					<button type="button" onclick="AJAXaddtocart(\'',$nama,'\')">Add to cart</button>
					</div>
					';
				}
				echo '<br><br><br><br><br><br><br><br><br><br><br><br>';
			}
			
			//mysql_close($db);
		?>
		
		</div>
		</div>
	</body>
</html>