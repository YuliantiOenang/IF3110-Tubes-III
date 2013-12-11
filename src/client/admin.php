<?php


	include 'Database.php';
	
	if (isset($_SESSION["username"])==NULL){
		header('location: index.php'); 
	}
		 if (isset($_SESSION["username"]) && $_SESSION["username"]!="admin"){ 
		header('location: index.php');  
	}
	GetDBAdmin();
	
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
		
		
		
		<!-- Sort Combo Box -->

		
		<div id="dagangan">
			<!-- Dagangan Baris 1 -->
			<div class="frame">
			<?php $i=0;foreach($_SESSION['Admin'] as $Barang) { ?>
				<div class="kolom-6 product">					
					<div class="frame">
						<div class="kolom-6">
							<img class="gambar" src="res/img/product/<?php echo $Barang->GetNamaBarang()?>.jpg" alt=""/>
						</div>
						<div class="kolom-6">
							<p class="nama-produk-b"><a href="detail-barang.php?id=<?php echo $i?>&Kategori=<?php echo $Barang->GetKategori()?>"><?php echo $Barang->GetNamaBarang()?></a></p>
							<p class="harga">Harga: <?php echo $Barang->GetHarga()?> /kg</p>
							<div class="frame buy-bar">
							<button  type="button" onClick="" name="buttonedit">edit</button>
							
							<button  type="button" onClick="location.href = 'handledelete.php'" name="buttondelete">delete</button>
							</div>
						</div>
					</div>
				</div>
			<?php $i++;} ?> 	
			</div>
		</div>
	</div>
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
</body>
</html>