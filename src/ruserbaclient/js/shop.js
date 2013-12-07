var xmlhttpShop;
var jumlah; 
var keterangan;
var id_barang;
var topCart = 0;

function pertanyaan(id_b,stok,harga)
{
	id_barang = id_b;
	jumlah = document.getElementById("quantity_"+id_b).value;
	keterangan = document.getElementById("keterangan_"+id_b).value;

	if ((jumlah == null) || (jumlah == ""))
		alert("jumlah barang harus diisi");
	else if (jumlah > stok) alert("Pemesanan barang melebihi stok, hanya tersisa "+stok+" barang");
	else
	{
		if (((getCookie('isLogin')) != null) && (getCookie('isLogin') != ""))	
		{
			var top = getCookie('topCart');
			if (top == null)
				top = 0;
			top = parseInt(top);
			top++;
			topCart=top;
			setCookie(topCart,id_b+"-"+jumlah+"-"+harga,30);
			alert(topCart);
			alert(getCookie(topCart));
			setCookie('topCart',topCart);		
			alert("Berhasil");
		}
		else
		{	
			alert("Silahkan daftar dan login untuk membeli");
			window.url="register.php";
		}
	}
}
