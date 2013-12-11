<?php
require_once('header.php'); ?>
<html>
	<head>
		<script src="AJAXaddtocart.js"></script>
		<script>
			if (localStorage.user=="admin") {
				window.location = "indexadmin.php"
			}
		</script>
		<script>
			if (localStorage.user==null) {
				window.location = "register.php";
			}
			function renderCart() {
				var element=document.getElementById("cart");
				var totalbelanja=0;
				for (var i = 0; i < sessionStorage.length; i++) {
					var harga=getHarga(sessionStorage.key(i));
					totalbelanja+=harga*sessionStorage.getItem(sessionStorage.key(i));
					element.innerHTML+="<form name='"+sessionStorage.key(i)+"'>";
					element.innerHTML+="Nama barang: "+sessionStorage.key(i)+"<br>";
					element.innerHTML+="Jumlah: <input type='number' name='jumlah' id='"+sessionStorage.key(i)+"' value='"+sessionStorage.getItem(sessionStorage.key(i))+"'><br>"
					element.innerHTML+="Harga satuan: "+harga+"<br>"
					element.innerHTML+="Harga total: "+(harga*sessionStorage.getItem(sessionStorage.key(i)))+"<br>"
					element.innerHTML+="<button id='edit' type='button' onclick='editProduct(\""+sessionStorage.key(i)+"\")'>Save</button>";
					element.innerHTML+="<button id='delete' type='button' onclick='deleteProduct(\""+sessionStorage.key(i)+"\")'>Delete</button><br><br>";
				}
				element.innerHTML+="</form>Total Belanja : "+totalbelanja+"<br>";
				element.innerHTML+="<button id='buy' type='button' onclick='AJAXbuy()'>Buy</button>";
			}
			function editProduct(productname) {
				sessionStorage.removeItem(productname);
				AJAXaddtocart(productname);
			}
			function deleteProduct(productname) {
				sessionStorage.removeItem(productname);
				location.reload();
			}
			function getHarga(productname) {
				var xmlhttp;
				if (window.XMLHttpRequest)
					{// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp=new XMLHttpRequest();
				}
				else
					{// code for IE6, IE5
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.open("GET","AJAXgetharga.php?productname="+productname,false);
				xmlhttp.send();
				return (xmlhttp.responseText.trim());
			}
			function AJAXbuy() {
				var xmlhttp;
				if (window.XMLHttpRequest)
					{// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp=new XMLHttpRequest();
				}
				else
					{// code for IE6, IE5
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				//Cek kartu
				xmlhttp.open("GET","AJAXcekkartu.php?username="+localStorage.user,false);
				xmlhttp.send();
				if (xmlhttp.responseText.trim()=="false") {
					alert("Silahkan isi data kartu kredit anda terlebih dahulu.");
					window.location = "card.php";
					return;
				}
				//Buy
				nProduk=sessionStorage.length;
				while (sessionStorage.length>0) {
					xmlhttp.open("GET","AJAXbuy.php?productname="+sessionStorage.key(0)+"&qty="+sessionStorage.getItem(sessionStorage.key(0)),false);
					xmlhttp.send();
					sessionStorage.removeItem(sessionStorage.key(0));
				}
				//Update transaksi user
				xmlhttp.open("GET","AJAXupdatetrans.php?username="+localStorage.user,false);
				xmlhttp.send();
				alert("Transaksi berhasil!");
				window.location = "index.php";
			}
		</script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<body>
	<?php
	require_once('middle.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Cart</h2>
		<div id="cart">
			<script>
				renderCart();
			</script>
		</div>
		</div>
		</div>
	</body>
</html>