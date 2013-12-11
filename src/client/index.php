<?php
	
	include 'Database.php';
	GetDBBarang_BestBuy();
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
		
	
		
		<br/>
		<a id="best-buy-btn" href="#best-buy" class="btn">Best Buy Products!!</a>
		
		<!-- Slideshow Section -->
		<div id="slideshow" class="frame">
			<div class="item">
				<img class="img-konten" src="res/img/slideshow/gulali_world.png" alt=""/>
				<div class="caption">
					<p class="text">
						Thank you for visiting our online shop !
					</p>
				</div>
			</div>
			<a href="#" class="btn-left">&lsaquo;</a>
			<a href="#" class="btn-right">&rsaquo;</a>
		</div>
		<br/><br/><br/><br/>
		<!-- End of Section -->
		<div id="divpetunjuk" style="float: left; width: 27%;">
	<form id="formpetunjuk">
	<br>Aturan Belanja: <br> 
	<br>1. Pengguna yang ingin berbelanja harus memiliki akun terlebih dahulu, jika sudah, pilih login dan jika belum pilih registrasi
	<br><br>2. Pengguna yang ingin berbelanja harus memasukkan informasi kartu kredit, jika tidak, transaksi tidak akan direalisasikan
	<br>HAPPY SHOPPING!
	</form>
	</div>
		
		<div id="best-buy" class="frame">
			<div id="bbuy-text" class="kolom-4">
				<p id="bbuy-a">Best Buy</p>
				<p id="bbuy-b">Products</p>
			</div>
			<div class="kolom-8">
				<div class="frame">
					<div class="kolom-4 product">
						<a href="">
							<img class="gambar" src="res/img/product/<?php echo $_SESSION['BestBuy'][0]?>.jpg" alt=""/>
							<p class="nama-produk"><?php echo $_SESSION['BestBuy'][0]?></p>
							<p class="asal-produk"><?php echo $_SESSION['BestBuyKategori'][0]?></p>
						</a>
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambar" src="res/img/product/<?php echo $_SESSION['BestBuy'][1]?>.jpg" alt=""/>
							<p class="nama-produk"><?php echo $_SESSION['BestBuy'][1]?></p>
							<p class="asal-produk"><?php echo $_SESSION['BestBuy'][1]?></p>	
						</a>						
					</div>
					<div class="kolom-4 product">
						<a href="#">
							<img class="gambar" src="res/img/product/<?php echo $_SESSION['BestBuy'][2]?>.jpg" alt=""/>
							<p class="nama-produk"><?php echo $_SESSION['BestBuy'][2]?></p>
							<p class="asal-produk"><?php echo $_SESSION['BestBuy'][2]?></p>
						</a>							
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambar" src="res/img/product/<?php echo $_SESSION['BestBuy'][3]?>.jpg" alt=""/>
							<p class="nama-produk"><?php echo $_SESSION['BestBuy'][3]?></p>
							<p class="asal-produk"><?php echo $_SESSION['BestBuy'][3]?></p>		
						</a>						
					</div>			
				</div>
			</div>
		</div>
	</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 
	<script>
	function forLogin(){
		var tes = AJAXPost();
		if (tes!=" 100 "){
			var username = AJAXPost();
			document.getElementById('sbmtlogin').value="Login\nLogin Sukses";
			var newhtml =		'<h3>Welcome, <span class="user-name"><a href="getdatamember.php" id="member">'+username+'</a></span>!</h3><p id="user-control"><span class="edit-logout">	<a href="logout.php" id="logout2">Logout</a></span></p>';
			document.getElementById("logreg").innerHTML=newhtml;
	
		}else{
			document.getElementById('sbmtlogin').value="Login\nusername/password salah";
		}
	}
	</script>	
	
</body>
</html>