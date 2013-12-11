<?php
	include 'LibUser.php';
	session_start();
	if (isset($_GET['Kategori']) AND isset($_GET['id']) ){
		$Kategori=$_GET['Kategori'];
		if ($Kategori=="Beras"){
			$_SESSION['DetailBarang']=$_SESSION['Beras'][$_GET['id']];
		}
		else if ($Kategori=="Daging"){
			$_SESSION['DetailBarang']=$_SESSION['Daging'][$_GET['id']];
		}
		else if ($Kategori=="Sayuran"){
			$_SESSION['DetailBarang']=$_SESSION['Sayuran'][$_GET['id']];
		}
		else if ($Kategori=="Frozen Food"){
			$_SESSION['DetailBarang']=$_SESSION['FrozenFood'][$_GET['id']];
		}else if ($Kategori=="Snack"){
			$_SESSION['DetailBarang']=$_SESSION['Snack'][$_GET['id']];
		}
	}
?>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
	<script language="javascript" type="text/javascript">
	function AddToCart(IdBarang,Kategori){
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
					alert("Jumlah Barang : "+xmlhttp.responseText);}
			}
		}
		var JumlahStr=""+IdBarang;
		var Jumlah=document.getElementById(JumlahStr).value;
		alert("AddToCart.php?action=add&id="+IdBarang+"&Jumlah="+Jumlah+"&Kategori="+Kategori);
		xmlhttp.open("GET","AddToCart.php?action=add&id="+IdBarang+"&Jumlah="+Jumlah+"&Kategori="+Kategori,true);
		xmlhttp.send();
	}
	</script>
</head>
<body>
	
	<div id="container">
		
		<?php include 'header.php'; ?>
		
		<div id="dagangan">
			
			<!-- Dagangan Baris 1 -->
			<div class="frame">
				<div class="kolom-6 product">					
					<div class="frame">
						<div class="kolom-6">
							<img class="gambar" src="res/img/product/<?php echo $_SESSION['DetailBarang']->GetNamaBarang()?>.jpg" alt=""/>
						</div>
						<div class="kolom-6">
							<p class="nama-produk-b"><a href=""><?php echo $_SESSION['DetailBarang']->GetNamaBarang()?></a></p>
							<p class="harga">Harga: <?php echo $_SESSION['DetailBarang']->GetHarga()?> /kg</p>
							<div class="frame buy-bar">
								<textarea name="detail" class="kolom-10 buy-text" rows="4" onfocus="checkclear(this)" onblur="checkempty(this, 'Detail pesanan jika ada')">Detail pesanan jika ada</textarea>
								<input class="kolom-9 buy-box" type="text" id='<?php echo $_SESSION['DetailBarang']->GetIdBarang()?>' name="buy" value="Banyaknya barang.." onfocus="checkclear(this)" onblur="checkempty(this, 'Banyaknya barang..')"> 
								<button class="kolom-1 buy-button" type="button" onClick=AddToCart(<?php echo$_SESSION['DetailBarang']->GetIdBarang()?>,'<?php echo$_SESSION['DetailBarang']->GetKategori()?>')></button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--End of Dagangan-->	
		</div>
		
	</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	
</body>
</html>