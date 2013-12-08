<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/header.js"></script>
<script>
if (localStorage.getItem('activeUser') == "" || localStorage.getItem('activeUser') == null){
	window.location="index.jsp";
}
var listShoppedItem = new Array();
listShoppedItem = JSON.parse(localStorage['shopList']);


function getListBarang() {
}

function getDatabaseLocation(IDBarang){
	for (var i=0;i<database.length;i++){
		if (IDBarang==database[i].Id){
			return i;
		}
	}
	return 0;
}

function showShoppingBag(){
	document.getElementById('contentArea').innerHTML="";
	document.getElementById('contentArea').innerHTML+="<h1>Tas Belanja</h1>";
	if (listShoppedItem.length>0){
		var totalHarga=0;
		document.getElementById('contentArea').innerHTML+="<div id='titleLine'>";
		document.getElementById('titleLine').innerHTML+="<div class=\"shoppedItemName\">Nama Barang</div>";
		document.getElementById('titleLine').innerHTML+="<div class=\"shoppedItemPrice\">Harga Satuan</div>";
		document.getElementById('titleLine').innerHTML+="<div class=\"shoppedItemNumber\">Jumlah</div>";
		document.getElementById('titleLine').innerHTML+="<div class=\"shoppedItemPrice\">Total </div>";
		document.getElementById('titleLine').innerHTML+="</div>";
		document.getElementById('contentArea').innerHTML+="<div class=\"eraseItem\"></div>";
		for (var i=0;i<listShoppedItem.length;i++){
			//var tempLocation =getDatabaseLocation(listShoppedItem[i].IdBeli);
			var tempId = "ShoppedItemNo"+i;
			totalHarga+=listShoppedItem[i].Harga*listShoppedItem[i].Jumlah;
			document.getElementById('contentArea').innerHTML+="<div class=\"shoppedItem\" id="+tempId+">";
			document.getElementById(tempId).innerHTML+="<div class=\"shoppedItemName\">"+listShoppedItem[i].Nama+"</div>";
			document.getElementById(tempId).innerHTML+="<div class=\"shoppedItemPrice\">Rp "+listShoppedItem[i].Harga+"</div>";
			document.getElementById(tempId).innerHTML+="<div class=\"shoppedItemNumber\">x "+listShoppedItem[i].Jumlah+" =</div>";
			document.getElementById(tempId).innerHTML+="<div class=\"shoppedItemPrice\">Rp "+listShoppedItem[i].Harga*listShoppedItem[i].Jumlah+"</div>";
			document.getElementById(tempId).innerHTML+="</div>";
			document.getElementById('contentArea').innerHTML+="<div class=\"eraseItem\" onclick=\"deleteItemFromBag('"+i+"')\">hapus</div>";
		}
		document.getElementById('contentArea').innerHTML+="<div id='bottomLine'>";
		document.getElementById('bottomLine').innerHTML+="<div class=\"shoppedItemName\">Total</div>";
		document.getElementById('bottomLine').innerHTML+="<div class=\"shoppedItemPrice\">-</div>";
		document.getElementById('bottomLine').innerHTML+="<div class=\"shoppedItemNumber\">-</div>";
		document.getElementById('bottomLine').innerHTML+="<div class=\"shoppedItemPrice\">Rp "+totalHarga+"</div>";
		document.getElementById('bottomLine').innerHTML+="</div>";
		document.getElementById('contentArea').innerHTML+="<button class=\"button\" id='payButton' onclick=\"payItemBag()\">Bayar!</button>";
	} else {
		document.getElementById('contentArea').innerHTML+="<div id='titleLine'> Anda belum membeli barang </div>";
	}
}
</script>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/shoppingbag.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/header.js"></script>
<title>Shopping Bag</title>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<div id='contentArea'>
	<script>showShoppingBag();</script>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>