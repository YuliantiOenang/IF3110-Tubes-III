<%
	if (session.getAttribute("BestBuy1")==null){
		response.sendRedirect("getbestbuy");
	}else{

	}
	
%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
		<jsp:include page="header.jsp"/>	
		
	
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
		<div id="divpetunjuk">
	<div id="formpetunjuk">
	<br>Aturan Belanja: <br> 
	<br>1. Pengguna yang ingin berbelanja harus memiliki akun terlebih dahulu, jika sudah, pilih login dan jika belum pilih registrasi
	<br><br>2. Pengguna yang ingin berbelanja harus memasukkan informasi kartu kredit, jika tidak, transaksi tidak akan direalisasikan
	<br>HAPPY SHOPPING!
	</div>
	</div>
		
		<div id="best-buy" class="frame">
			<div id="bbuy-text" class="kolom-4">
				<p id="bbuy-a">Best Buy</p>
				<p id="bbuy-b">products</p>
			</div>
			<div class="kolom-8">
			
			
				<div class="frame">
					<div class="judulbest">
					BERAS
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy1"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy1"));%></p>
						</a>
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy2"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy2"));%></p>
						</a>						
					</div>
					<div class="kolom-4 product">
						<a href="#">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy3"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy3"));%></p>
						</a>							
					</div>
					</div>
					<div class="frame">
					<div class="judulbest">
					DAGING
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy4"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy4"));%></p>
						</a>						
					</div>		
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy5"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy5"));%></p>	
						</a>						
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy6"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy6"));%></p>	
						</a>						
					</div>
					</div>
					<div class="frame">
					<div class="judulbest">
					SAYURAN
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy7"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy7"));%></p>	
						</a>						
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy8"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy8"));%></p>		
						</a>						
					</div>
					
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy9"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy9"));%></p>	
						</a>						
					</div>
					</div>
					<div class="frame">
					<div class="judulbest">
					FROZEN FOOD
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy10"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy10"));%></p>
						</a>						
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy11"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy11"));%></p>
						</a>						
					</div>
					
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy12"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy12"));%></p>
						</a>						
					</div>
					</div>
					<div class="frame">
					<div class="judulbest">
					SNACK
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy13"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy13"));%></p>	
						</a>						
					</div>
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy14"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy14"));%></p>
						</a>						
					</div>
					
					<div class="kolom-4 product">
						<a href="">
							<img class="gambarhome" src="res/img/product/<%out.print((String)session.getAttribute("BestBuy15"));%>.jpg" alt=""/>
							<p class="nama-produk"><%out.print((String)session.getAttribute("BestBuy15"));%></p>
						</a>						
					</div>
					</div>
				</div>
			</div>
		</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	
	
</body>
</html>