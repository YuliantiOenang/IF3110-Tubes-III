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
		
		<!-- Navbar Section -->
		<p id="src-title">Search Result(s) for <span class="src-param">${QuerySearch}</span></p>
		<!-- End of Navbar -->
		
		<div id="dagangan">
			<!-- Dagangan Baris 1 -->
			<div class="frame">
			<c:set var="IdxHarga" value="0"/>
			<c:forEach var="item" items="${TabelSearchNamaBarang}" >
				<div class="kolom-6 product">					
					<div class="frame">
						<div class="kolom-6">
							<img class="gambar" src="res/img/product/<c:out value="${item}"/>.jpg" alt=""/>
						</div>
						<div class="kolom-6">
							<p class="nama-produk-b"><a href="DetailBarang?Nama=<c:out value="${item}"/>">${item}</a></p>
							<p class="harga">Harga : <c:out value="${TabelSearchHargaBarang[IdxHarga]}"/></p>
							<div class="frame buy-bar">
								<input class="kolom-9 buy-box" type="text" id='<c:out value="${item}"/>' name="buy" value="Banyaknya barang.." onfocus="checkclear(this)" onblur="checkempty(this, 'Banyaknya barang..')"> 
								<input type="button" class="kolom-1 buy-button" onClick=AddToCart("<c:out value="${item}"/>",<c:out value="${TabelHargaBarang[IdxHarga]}"/>,<c:out value="${item}"/>)></input>
							</div>
						</div>
					</div>
				</div>
				<c:set var="IdxHarga" value="${IdxHarga + 1}"/>
			 </c:forEach>
			</div>
		</div>
		
		<div id="pagination">
			<ul>
				<li><a href="Search?Page=0&Query=<c:out value="${QuerySearch}"/>">&laquo;First</a></li>
				<c:forEach  var="Page" begin="0" end="${PageSize}">
				<li><a href="Search?Page=<c:out value="${Page}"/>&Query=<c:out value="${QuerySearch}"/>">${Page+1}</a></li>
				</c:forEach>
				<li><a href="#">Last&raquo;</a></li>
			</ul>
		</div>
		
	</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 
	
</body>
</html>