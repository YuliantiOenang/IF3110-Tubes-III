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
		<div id="pagination">
			<ul>
				<?php $n = $_GET["f"];
				  $m = $_GET["l"];
				 $o = $_GET["f"];
				 $p = $_GET["l"];
				  if ($_GET["f"]>10){
					  $o = $_GET["f"]-10;
					  $p = $_GET["l"]-10;
				   ?>
					   
				 <?php }
				 if ($_GET["l"]<count($_SESSION['Search'])){
					   $n = $_GET["f"]+10;
					   $m = $_GET["l"]+10;
				  ?>
				  	
				 <?php }?>
				 <li><a href="search.php?src=<?php echo $SearchQuery ?>&amp;f=<?php echo $o;?>&amp;l=<?php echo $p?>">&laquo;Previous</a></li>
				 <li><a href="search.php?src=<?php echo $SearchQuery ?>&amp;f=<?php echo $n;?>&amp;l=<?php echo $m?>">Next&raquo;</a></li>
				
				
			
			</ul>
		</div>
		<div id="dagangan">
			
			<!-- Dagangan Baris 1 -->
			<div class="frame">
			<?php $i = 0;
			if (isset($_SESSION['Search'])){
			$test = count($_SESSION["Search"]);
			if ($test>$_GET["l"]){
				$test = $_GET["l"];
			}
			for ($i =$_GET["f"];$i<=$test;$i++){
			
			
				 ?>
				<div class="kolom-6 product">					
					<div class="frame">
						<div class="kolom-6">
							<img class="gambar" src="res/img/product/<?php echo $_SESSION['Search'][$i]->GetNamaBarang()?>.jpg" alt=""/>
						</div>
						<div class="kolom-6">
							<p class="nama-produk-b"><a href="detail-barang.php?id=<?php echo $i?>&Kategori=<?php echo $_SESSION['Search'][$i]->GetKategori()?>"><?php echo $_SESSION['Search'][$i]->GetNamaBarang()?></a></p>
							<p class="harga">Harga: <?php echo $_SESSION['Search'][$i]->GetHarga()?> /kg</p>
						</div>
					</div>
				</div>
			<?php }} ?> 	
			</div>
			<!--End of Dagangan-->				
		</div>
		
	
		
	</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	
</body>
</html>