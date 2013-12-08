var signal=false;
var xmlhttpCartPayment;
var lock = false;

if (!signal)
{
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttpCartPayment=new XMLHttpRequest();
		signal = true;
	}
	else
	{// code for IE6, IE5
		xmlhttpCartPayment=new ActiveXObject("Microsoft.XMLHTTP");
	}
}

xmlhttpCartPayment.onreadystatechange=function()
{
	if (xmlhttpCartPayment.readyState==4 && xmlhttpCartPayment.status==200)
	{
		var parsedData = JSON.parse(xmlhttpCartPayment.responseText);		
		if (parsedData['content']=="OK")
		{
			alert("OKE");
		}
		lock=false;
	}
};

function payment(URL,id_b,stok_b,status)
{
	while (lock){}
	lock = true;

	if (status)
	{
		xmlhttpCartPayment.open("GET",URL+"/api/transaction?signal=selesai&IDUser="+getCookie('usernameID'),true);
		xmlhttpCartPayment.send();
	}
	else
	{
		xmlhttpCartPayment.open("GET",URL+"/api/transaction?signal=false&IDBarang="+id_b+"&stok="+stok_b,true);
		xmlhttpCartPayment.send();
	}
	//delete stok barang
	//update jml transaksi
}
