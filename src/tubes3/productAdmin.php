<?php
require_once('header.php'); ?>
<html>
	<head>
		<script src="AJAXaddtocart.js"></script>
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.php"
			}
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middleadmin.php'); ?>
		<div id="product">
		<div id="container">
		<?php
		echo '<h2>',strtoupper(substr($_GET["kategori"],0,1)),substr($_GET["kategori"],1),'</h2>'; ?>
		<form id="sort" action="productadmin.php" method="get">
			Sort : <select name="sort">
				<option value="namaasc" selected>Nama (a-z)</option>
				<option value="namadsc">Nama (z-a)</option>
				<option value="hargaasc">Harga (a-z)</option>
				<option value="hargadsc">Harga (z-a)</option>
			</select>
			<input type="hidden" name="kategori" value="<?php echo $_GET["kategori"] ?>">
			<input type="submit" value="Sort"><br><br>
		</form>
		
		<?php 
			$kategori=$_GET["kategori"];
			$sort=$_GET["sort"];
			/*$con=mysqli_connect("localhost","root","","ruserba");
			// Check connection
			if (mysqli_connect_errno()) {
				echo "Failed to connect to MySQL: " . mysqli_connect_error();
			}*/
			$url = "http://boiling-meadow-3341.herokuapp.com/rest/query/";
			if ($sort=="namaasc") {
				$sql = "SELECT * FROM data_barang WHERE kategori='".$kategori."' ORDER BY nama";
			}
			else if ($sort=="namadsc") {
				$sql = "SELECT * FROM data_barang WHERE kategori='".$kategori."' ORDER BY nama DESC";
			}
			else if ($sort=="hargaasc") {
				$sql = "SELECT * FROM data_barang WHERE kategori='".$kategori."' ORDER BY harga";
			}
			else if ($sort=="hargadsc") {
				$sql = "SELECT * FROM data_barang WHERE kategori='".$kategori."' ORDER BY harga DESC";
			}
			$url.= rawurlencode($sql);
			$result=json_decode(file_get_contents($url),true);
			//Kode paginasi
			//$result=mysqli_query($con,$sql);
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
			// Range query ke database
			//$max = ' LIMIT ' .($pagenum - 1) * $page_rows .',' .$page_rows;
			// Lakukan query sesuai range
			//$sql = $sql.$max;
			//$result=mysqli_query($con,$sql);
			$temp = $page_rows * $pagenum;
			// Display result
			for ($j=($temp-$page_rows);$j<$temp;$j++) {
				
				if ($j<$rows)
				{
					$row = $result[$j];
					$nama=trim($row['nama']);
					$harga=trim($row['harga']);
					echo '
						<img src="images/',$nama,'.jpg" alt="gambar" width=400 height=300><br>
						Nama: <a href="detiladmin.php?nama=',$nama,'&harga=',$harga,'" > ',$nama,'</a><br>
						Harga: ',$harga,'<br>
						-------------------------------------------------------------------<br><br>
					';
				}
			}
			echo ' --page',$pagenum,' of ',$last,'-- <p>';
			if ($pagenum==1) {
			} else {
				echo '<a href="productadmin.php?pagenum=1&kategori=',$kategori,'&sort=',$sort,'"> <<-First</a> &nbsp;  ';
				$previous = $pagenum-1;
				echo '<a href="productadmin.php?pagenum=',$previous,'&kategori=',$kategori,'&sort=',$sort,'"> <-Previous</a>   &nbsp; ---';
			}		
			if ($pagenum==$last) {
			} else {
				$next = $pagenum+1;
				echo '<a href="productadmin.php?pagenum=',$next,'&kategori=',$kategori,'&sort=',$sort,'"> Next -></a>   &nbsp; ---';
				echo '<a href="productadmin.php?pagenum=',$last,'&kategori=',$kategori,'&sort=',$sort,'"> Last ->></a>   &nbsp;';
			}
			//mysqli_close($con);
		?>
		</div>
	</div>
	</body>
</html>