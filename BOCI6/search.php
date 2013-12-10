<?php
	include 'Database.php';
	$SearchQuery=$_GET['src'];
	GetDBSearch($SearchQuery);
?>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
		<?php include 'header.php'; ?>
		
		<!-- Navbar Section -->
		<p id="src-title">Search Result(s) for <span class="src-param"><?php echo $SearchQuery?></span></p>
		<!-- End of Navbar -->
		
		<div id="dagangan">
			
			<!-- Dagangan Baris 1 -->
			<div class="frame">
			<?php 
				if (isset($_SESSION['Search'])){
					foreach($_SESSION['Search'] as $Barang) { ?>
				<div class="kolom-6 product">					
					<div class="frame">
						<div class="kolom-6">
							<img class="gambar" src="res/img/product/<?php echo $Barang->GetNamaBarang()?>.jpg" alt=""/>
						</div>
						<div class="kolom-6">
							<p class="nama-produk-b"><a href="detail-barang.php?id=<?php echo $Barang->GetIdBarang()?>&Kategori=<?php echo $Barang->GetKategori()?>"><?php echo $Barang->GetNamaBarang()?></a></p>
							<p class="harga">Harga: <?php echo $Barang->GetHarga()?> /kg</p>
						</div>
					</div>
				</div>
			<?php }} ?> 	
			</div>
			<!--End of Dagangan-->				
		</div>
		
		<div id="pagination">
			<ul>
				<li><a href="#">&laquo;First</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">Last&raquo;</a></li>
			</ul>
		</div>
		
	</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	
</body>
</html>