var xmlhttp;

if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttp=new XMLHttpRequest();
} else {// code for IE6, IE5
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}


function cekQuantity(id_brg) {
	var quantity;
	id_brg = typeof id_brg !== 'undefined' ? id_brg : 0;
	if (id_brg == 0) {
		id_barang = document.getElementById('id_barang').value;
		quantity = document.getElementById('quantity').value;
	} else {
		id_barang = document.getElementById('id_barang_'+id_brg).value;
		quantity = document.getElementById('quantity_'+id_brg).value;
	}
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			var data = JSON.parse(xmlhttp.responseText);
			if (data.status) {
				if (id_brg == 0) {
					document.getElementById('form-shop').submit();
				} else {
					document.getElementById('form-shop-'+id_brg).submit();
				}
			} else {
				alert("Stok untuk barang tersebut tidak cukup, stok barang bersisa "+data.stok);
			}
		}
	}
	if (quantity <= 0) {
		console.log("input not valid");
	} else {
		xmlhttp.open("GET",server+"/api/stokCukup?id_barang="+id_barang+"&quantity="+quantity,true);
		xmlhttp.send();
	}
}


function cekCart(nama_brg, defaultValue) {
	var quantity;
	nama_barang = document.getElementById('id_barang_'+nama_brg).value;
	quantity = document.getElementById('quantity_'+nama_brg).value;
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			var data = JSON.parse(xmlhttp.responseText);
			if (data.status) {
				alert("Jumlah barang "+nama_brg+" sudah diupdate menjadi "+quantity+" buah");
				window.location.reload();
			} else {
				document.getElementById('quantity_'+nama_brg).value = defaultValue;
				alert("Stok untuk barang tersebut tidak cukup, stok barang bersisa "+data.stok);
			}
		}
	}
	if (quantity <= 0) {
		document.getElementById('quantity_'+nama_brg).value = defaultValue;
		alert("Input tidak valid");
		console.log("input not valid");
	} else {
		xmlhttp.open("GET",server+"/api/changeQuantity?nama_barang="+nama_brg+"&quantity="+quantity,true);
		xmlhttp.send();
	}
}