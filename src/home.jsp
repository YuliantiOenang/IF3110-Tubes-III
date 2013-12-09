<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
		<%@ include file="header.jsp" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		
		<a id="best-buy-btn" href="#best-buy" class="btn">See Best Buy!!</a>
		
		<!-- Slideshow Section -->
		<div id="slideshow" class="frame">
			<div class="item">
				<img class="img-konten" src="res/img/slideshow/gulali_world.png" alt=""/>
				<div class="caption">
					<p class="text">
						Check out our snack section! We have a lot of snack 
						from Gulali World!!
					</p>
				</div>
			</div>
			<a href="#" class="btn-left">&lsaquo;</a>
			<a href="#" class="btn-right">&rsaquo;</a>
		</div>
		<img src="res/img/baloon.png" alt=""/>
		<!-- End of Section -->
		<c:choose>
		<c:when test="${empty BestBuyProduct}">
		<%
			// New location to be redirected
			String site = new String("BestBuy");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		%>
		</c:when>
		<c:when test="${not empty BestBuyProduct}">
		<div id="best-buy" class="frame">
			<div id="bbuy-text" class="kolom-4">
				<p id="bbuy-a">Best Buy</p>
				<p id="bbuy-b">Products</p>
			</div>
			<div class="kolom-8">
				<div class="frame">
				<c:forEach var="item" items="${BestBeras}" >
					<div class="kolom-4 product">
						<a href="DetailBarang?Nama=<c:out value="${item}"/>">
							<img class="gambar" src="res/img/product/<c:out value="${item}"/>.jpg" alt=""/>
							<p class="nama-produk"><c:out value="${item}"/></p>
							<p class="asal-produk">Beras</p>
						</a>
					</div>
				</c:forEach>
				</div>	
				<div class="frame">
				<c:forEach var="item" items="${BestDaging}" >
					<div class="kolom-4 product">
						<a href="DetailBarang?Nama=<c:out value="${item}"/>">
							<img class="gambar" src="res/img/product/<c:out value="${item}"/>.jpg" alt=""/>
							<p class="nama-produk"><c:out value="${item}"/></p>
							<p class="asal-produk">Daging</p>
						</a>
					</div>
				</c:forEach>
				</div>
				<div class="frame">
				<c:forEach var="item" items="${BestSayuran}" >
					<div class="kolom-4 product">
						<a href="DetailBarang?Nama=<c:out value="${item}"/>">
							<img class="gambar" src="res/img/product/<c:out value="${item}"/>.jpg" alt=""/>
							<p class="nama-produk"><c:out value="${item}"/></p>
							<p class="asal-produk">Sayuran</p>
						</a>
					</div>
				</c:forEach>
				</div>
				<div class="frame">
				<c:forEach var="item" items="${BestFrozenFood}" >
					<div class="kolom-4 product">
						<a href="DetailBarang?Nama=<c:out value="${item}"/>">
							<img class="gambar" src="res/img/product/<c:out value="${item}"/>.jpg" alt=""/>
							<p class="nama-produk"><c:out value="${item}"/></p>
							<p class="asal-produk">Frozen Food</p>
						</a>
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
		</c:when>
		</c:choose>
	</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 
	
</body>
</html>