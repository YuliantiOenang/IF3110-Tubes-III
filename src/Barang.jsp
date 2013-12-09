<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
	<script language="javascript" type="text/javascript">
	function AddToCart(IdBarang,Harga,Jumlah){
		alert("AddToCart?Nama="+IdBarang+"&Jumlah="+Jumlah.value+"&Harga="+Harga);
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
		alert("AddToCart?Nama="+IdBarang+"&Jumlah="+Jumlah.value+"&Harga="+Harga+"&detail=kosong");
		xmlhttp.open("GET","AddToCart?Nama="+IdBarang+"&Jumlah="+Jumlah.value+"&Harga="+Harga+"&detail=kosong",true);
		xmlhttp.send();
	}
	</script>
</head>
<body>
	
	<div id="container">
	<%@ include file="header.jsp" %>
		
		<!-- Sort Combo Box -->
		<div id="sort-bar" class="frame">
			<div class="kolom-4">&nbsp;</div>
			Sort By :
			<button type="button" onClick="location.href='Barang?Kategori=<c:out value="${KategoriBarang}"/>&SortBy=NamaBarang'">Nama</button>
			<button type="button" onClick="location.href='Barang?Kategori=<c:out value="${KategoriBarang}"/>&SortBy=Harga'">Harga</button>
		</div>
		<div id="dagangan">
			<!-- Dagangan Baris 1 -->
			<div class="frame">
			<form action="deletebarang" method="POST">
			<c:set var="IdxHarga" value="0"/>
			<c:forEach var="item" items="${TabelNamaBarang}" >
				<div class="kolom-6 product">					
					<div class="frame">
						<div class="kolom-6">
							<img class="gambar" src="res/img/product/<c:out value="${item}"/>.jpg" alt=""/>
						</div>
						<div class="kolom-6">
							<p class="nama-produk-b"><a href="DetailBarang?Nama=<c:out value="${item}"/>">${item}</a></p>
							<p class="harga">Harga : <c:out value="${TabelHargaBarang[IdxHarga]}"/></p>
							<div class="frame buy-bar">
								<c:if test="${cookie.username.value != 'admin'}">
								<input class="kolom-9 buy-box" type="text" id='<c:out value="${item}"/>' name="buy" value="Banyaknya barang.." onfocus="checkclear(this)" onblur="checkempty(this, 'Banyaknya barang..')"> 
								<input type="button" class="kolom-1 buy-button" onClick=AddToCart("<c:out value="${item}"/>",<c:out value="${TabelHargaBarang[IdxHarga]}"/>,<c:out value="${item}"/>)></input>
								</c:if>
								<c:if test="${cookie.username.value == 'admin'}">
								Delete barang -- <input type="checkbox" name='<c:out value="${item}"/>'> </input>
								<br>
								<button type="button" onClick="location.href='editbarang.jsp?id=<c:out value="${item}" />'" >Edit Barang</button>
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<c:set var="IdxHarga" value="${IdxHarga + 1}"/>
			 </c:forEach>
			 
			<c:if test="${username == 'admin'}">
			<input type="submit" value="Delete Selected" onclick="return confirm('Are you sure you want to delete?')"/>
			</c:if>
			</form>
			</div>
		</div>
	</div>
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 
	
</body>
</html>