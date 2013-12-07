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
	jumlah = getCookie(id_barang);
	keterangan = "";
}

function pertanyaan(id_b,stok)
{
	jumlah = document.getElementById("quantity_"+id_b).value;
	keterangan = document.getElementById("keterangan_"+id_b).value;

	if ((jumlah == null) || (jumlah == ""))
		alert("jumlah barang harus diisi");
	else if (jumlah > stok) alert("Pemesanan barang melebihi stok, hanya tersisa "+stok+" barang");
	else
	{	
		setCookie(id_b,stok,30);
		//beliBarang();
		alert("cookie ok");
	}
	
}

function setCookie(c_name,value,exdays)
{
var exdate=new Date();
exdate.setDate(exdate.getDate() + exdays);
var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
document.cookie=c_name + "=" + c_value;
}

function getCookie(c_name)
{
var c_value = document.cookie;
var c_start = c_value.indexOf(" " + c_name + "=");
if (c_start == -1)
  {
  c_start = c_value.indexOf(c_name + "=");
  }
if (c_start == -1)
  {
  c_value = null;
  }
else
  {
  c_start = c_value.indexOf("=", c_start) + 1;
  var c_end = c_value.indexOf(";", c_start);
  if (c_end == -1)
  {
c_end = c_value.length;
}
c_value = unescape(c_value.substring(c_start,c_end));
}
return c_value;
}