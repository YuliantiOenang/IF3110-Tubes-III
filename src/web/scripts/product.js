function setProductOrder()	{
	var jumlah = document.getElementById("jumlahproduk");
	var keterangan = document.getElementById("keteranganproduk");
	var stok = document.getElementById("jumlahstok");
	var parts = window.location.search.substr(1).split("&");
	var $_GET = {};
	for (var i = 0; i < parts.length; i++) {
		var temp = parts[i].split("=");
		$_GET[decodeURIComponent(temp[0])] = decodeURIComponent(temp[1]);
	}
	
	if(parseInt(jumlah.value) <= parseInt(stok.innerHTML)){
		setProductQuantity($_GET['product_id'], jumlah.value);
		document.getElementById("errorjumlah").innerHTML = getOkSmall('Penambahan produk ke shopping bag berhasil');
	}else{
		document.getElementById("errorjumlah").innerHTML = getErrorSmall('Jumlah stok tidak mencukupi');
	}
	setProductNote($_GET['product_id'], keterangan.value);
}

window.addEventListener("load", function(){
	document.getElementById("buybutton").onclick = setProductOrder;
	var parts = window.location.search.substr(1).split("&");
	var $_GET = {};
	for (var i = 0; i < parts.length; i++) {
		var temp = parts[i].split("=");
		$_GET[decodeURIComponent(temp[0])] = decodeURIComponent(temp[1]);
	}
	var jumlahdibag = getProductQuantity($_GET['product_id']);
	var keterangandibag = getProductNote($_GET['product_id']);
	
	var jumlah = document.getElementById("jumlahproduk");
	var keterangan = document.getElementById("keteranganproduk");
	
	jumlah.value = jumlahdibag;
	keterangan.value = keterangandibag;
});