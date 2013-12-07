if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttpCart=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttpCart=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttpCart.onreadystatechange=function()
{
	if (xmlhttpCart.readyState==4 && xmlhttpCart.status==200)
	{
		var parsedData = JSON.parse(xmlhttpCart.responseText);		
		if (parsedData.status)
		{
			alert("berhasil diganti");
			window.location = "";
		}
		else
		{
			alert("gagal diganti, stok tinggal "+parsedData.stok);
			window.location = "";
		}
	}
};

function updateCart(id)
{
	var valueBarang = document.getElementById("quantity_"+id).value;
	xmlhttpCart.open("GET","/ruserba/cart/update?id="+id+"&value="+valueBarang,true);
	xmlhttpCart.send();
}
