var xmlhttpShop;
var jumlah; 
var keterangan;
var id_barang;

if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttpShop=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttpShop=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttpShop.onreadystatechange=function()
{
	if (xmlhttpShop.readyState==4 && xmlhttpShop.status==200)
	{
		var parsedData = JSON.parse(xmlhttpShop.responseText);		
		if (parsedData['content']=="OKE") alert("Berhasil");
		else if (parsedData['content'] == "LOGIN") alert("Anda belum login");
		else if (parsedData['content'] == "KREDIT") alert("Anda belum input kartu kredit");
		else alert("Transaksi Gagal");
	}
};

function beliBarang()
{
	xmlhttpShop.open("GET","/ruserba/barang/beli?id_barang="+id_barang+"&jumlah="+jumlah+"&keterangan="+keterangan,true);
	xmlhttpShop.send();
	jumlah = "";
	keterangan = "";
}

function pertanyaan(id_b,stok)
{
	id_barang = id_b;
	jumlah = document.getElementById("quantity_"+id_b).value;
	keterangan = document.getElementById("keterangan_"+id_b).value;

	if ((jumlah == null) || (jumlah == ""))
		alert("jumlah barang harus diisi");
	else if (jumlah > stok) alert("Pemesanan barang melebihi stok, hanya tersisa "+stok+" barang");
	else
	{
		beliBarang();
	}
	
}
