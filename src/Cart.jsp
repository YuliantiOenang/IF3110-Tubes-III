<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
	<script language="javascript" type="text/javascript">
	</script>
</head>
<body>
	
	<div id="container">
		
		<%@ include file="header.jsp" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:choose>
		<c:when test="${empty cookie.username.value}">
		<%
			// New location to be redirected
			String site = new String("registrasi.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		%>
		</c:when>
		<c:when test="${not empty cookie.username.value}">
		<c:set var="IdxHarga" value="0"/>
		<c:set var="TotalHarga" value="0"/>
		<c:forEach var="item" items="${CartNama}" >
		<div class="kolom-6 Cart">					
			<div class="frame">
				<div class="kolom-6">
					<img class="gambar" src="res/img/product/<c:out value="${item}"/>.jpg" alt=""/>
				</div>
				<div class="kolom-6">
					<p class="nama-produk-b"><a href="DetailBarang?Nama=<c:out value="${item}"/>"><c:out value="${item}"/> </a></p>
					<p class="harga">Harga : <c:out value="${CartHarga[IdxHarga]}"/></p>
					<p class="harga">Jumlah : <c:out value="${CartJumlah[IdxHarga]}"/></p>
					<p class="harga">Detail : <c:out value="${CartDetail[IdxHarga]}"/></p>
				</div>
			</div>
		</div>
		<c:set var="TotalCurrent" value="${CartHarga[IdxHarga] * CartJumlah[IdxHarga]}"/>
		<c:set var="TotalHarga" value="${TotalHarga + TotalCurrent}"/>
		<c:set var="IdxHarga" value="${IdxHarga + 1}"/>
		</c:forEach>
	</div>
	<c:choose>
	<c:when test="${not empty cookie.creditcard.value}">
	<a href="Checkout" class="btn">Check Out</a>
	<p class="harga">Total Harga : <c:out value="${TotalHarga}"/></p>
	</c:when>
	<c:when test="${empty cookie.creditcard.value}">
	<a href="credit-card.jsp" class="btn">Check Out</a>
	<p class="harga">Total Harga : <c:out value="${TotalHarga}"/></p>
	</c:when>
	</c:choose>
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	</c:when>
	</c:choose>
</body>
</html>