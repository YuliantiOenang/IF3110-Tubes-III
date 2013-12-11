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
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middle.php'); ?>
		<div id="product">
		<div id="container">
		<h2>Search Result</h2>
		
		<?php 
			$keyword=$_GET["keyword"];
			$kategori=$_GET["kategori"];
			$range=$_GET["range"];

			// Query from database
			$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
			$sql="";
			if ($range=="<10000") {
				$sql = "SELECT * FROM data_barang WHERE kategori LIKE '%$kategori%' AND UPPER(nama) LIKE UPPER('%$keyword%') AND harga < 10000";
			} else if ($range=="10000-50000") {
				$sql = "SELECT * FROM data_barang WHERE kategori LIKE '%$kategori%' AND UPPER(nama) LIKE UPPER('%$keyword%') AND (harga BETWEEN 10000 AND 50000)";
			} else if ($range==">50000") {
				$sql = "SELECT * FROM data_barang WHERE kategori LIKE '%$kategori%' AND UPPER(nama) LIKE UPPER('%$keyword%') AND harga > 50000";
			} else if ($range=="0"){
				$sql = "SELECT * FROM data_barang WHERE kategori LIKE '%$kategori%' AND UPPER(nama) LIKE UPPER('%$keyword%')";
			}
			$sql = preg_replace("([%])","persen",$sql);
			$url.= rawurlencode($sql);
			//$url = preg_replace("([%]+)","*",$url);
			$result=json_decode(file_get_contents($url),true);
			if ($result==false) {
				echo "Pencarian tidak ditemukan";
			}
			else {
				$rows=count($result);
				//Cek pagenum ada/tidak
				if (!(isset($_GET["pagenum"]))) { 
					$pagenum = 1;
				}
				else {
					$pagenum = $_GET["pagenum"];
				}
				// Tentukan halaman last
				$page_rows = 2;
				$last = ceil($rows/$page_rows);
				// Koreksi jika pagenum di luar range
				if ($pagenum < 1) {
					$pagenum = 1;
				}
				else if ($pagenum > $last) {
					$pagenum = $last; 
				}

				$temp = $page_rows * $pagenum;
				// Display result
				for ($j=($temp-$page_rows);$j<$temp;$j++) {
					if ($j < $rows) {
						$row = $result[$j];
						$nama=trim($row['nama']);
						$harga=trim($row['harga']);
						echo "<img src=\"/tubes3/images/",$nama,".jpg\" alt='gambar' width='400' height='300'><br>";
						echo "Nama: <a href='detil.php?nama=$nama&harga=$harga'>",$nama,"</a><br>";
						echo "Harga: ",$harga,"<br>";
						echo "Banyak: <input type='text' name='qty' id='",$nama,"'>";
						echo "<button type='button' onclick='AJAXaddtocart(\"",$nama,"\")'>Add to cart</button><br><br>";
					}
				}
				
				// Display Paginasi
				echo " --Page $pagenum of $last-- <p>";
				if ($pagenum == 1) {
				}
				else {
					echo " <a href='{$_SERVER['PHP_SELF']}?pagenum=1&keyword=$keyword&kategori=$kategori&range=$range'> <<-First</a> ";
					echo " ";
					$previous = $pagenum-1;
					echo " <a href='{$_SERVER['PHP_SELF']}?pagenum=$previous&keyword=$keyword&kategori=$kategori&range=$range'> <-Previous</a> ";
				} 
				echo " ---- ";
				if ($pagenum == $last) {
				}
				else {
					$next = $pagenum+1;
					echo " <a href='{$_SERVER['PHP_SELF']}?pagenum=$next&keyword=$keyword&kategori=$kategori&range=$range'>Next -></a> ";
					echo " ";
					echo " <a href='{$_SERVER['PHP_SELF']}?pagenum=$last&keyword=$keyword&kategori=$kategori&range=$range'>Last ->></a> ";
				} 
			}
			//mysqli_close($con);
		?>
		
		</div>
	</div>
	</body>
</html>