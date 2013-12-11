<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
	<script language="javascript" type="text/javascript">
	function AddToCart(IdBarang,Harga,Jumlah){
		var detail=document.getElementById("detail").value;
		alert("AddToCart?Nama="+IdBarang+"&Jumlah="+Jumlah.value+"&Harga="+Harga+"&detail="+detail);
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}
		else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				alert("Pesanan sedang diproses");
				if (xmlhttp.responseText.trim()=="Betul"){
					alert("Pesanan Diterima");}
				else{
					alert("Maaf pesanan ditolak, Jumlah Barang : "+xmlhttp.responseText);}
			}
		}
		xmlhttp.open("GET","AddToCart?Nama="+IdBarang+"&Jumlah="+Jumlah.value+"&Harga="+Harga+"&detail="+detail,true);
		xmlhttp.send();
	}
	</script>
</head>
<body>
	
	<div id="container">
		
		<%@ include file="header.jsp" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		
		
		<div id="dagangan">
			<!-- Dagangan Baris 1 -->
			<div class="frame">
				<div class="kolom-6 product">					
					<div class="frame">
						<div class="kolom-6">
							<img class="gambar" src="res/img/product/<c:out value="${DetailNamaBarang}"/>.jpg" alt=""/>
						</div>
						<div class="kolom-6">
							<p class="nama-produk-b"><a href="DetailBarang?Nama=<c:out value="${DetailNamaBarang}"/>">${DetailNamaBarang}</a></p>
							<p class="harga">Harga : <c:out value="${DetailHargaBarang}"/></p>
							<input type="text" id="detail" name="detail" class="kolom-10 buy-text" rows="4" onfocus="checkclear(this)" onblur="checkempty(this, 'Detail pesanan jika ada')"></input>
							<div class="frame buy-bar">
								<input class="kolom-9 buy-box" type="text" id='<c:out value="${DetailNamaBarang}"/>' name="buy" value="Banyaknya barang.." onfocus="checkclear(this)" onblur="checkempty(this, 'Banyaknya barang..')"> 
								<input type="button" class="kolom-1 buy-button" onClick=AddToCart("<c:out value="${DetailNamaBarang}"/>",<c:out value="${DetailHargaBarang}"/>,<c:out value="${DetailNamaBarang}"/>)></input>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 
</body>
</html>