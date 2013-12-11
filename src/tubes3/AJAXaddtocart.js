function AJAXaddtocart(productname) {
	
	var xmlhttp;
	var qty=document.getElementById(productname).value;
	if (isNaN(Number(qty))) {
		alert("Masukan bukan angka");
		return;
	}
	else if(Number(qty)<1) {
		alert("Masukan harus lebih dari 0");
		return;
	}
	if (window.XMLHttpRequest)
		{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
		{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET","AJAXaddtocart.php?productname="+productname+"&qty="+qty,false);
	xmlhttp.send();
	if (xmlhttp.responseText.trim()!="true") {
		alert("Stok barang tidak cukup! Tersedia "+xmlhttp.responseText.trim()+" stok");
	}
	else {
		alert(productname+" "+qty+" pcs ditambahkan ke cart");
		for (var i=0;i<Number(qty);i++) {
			if (sessionStorage.getItem(productname)) {
				var newval = Number(sessionStorage.getItem(productname));
				newval++;
				sessionStorage.setItem(productname, newval);
			}
			else {
				sessionStorage.setItem(productname, "1");
			}
		}
		location.reload();
	}
}