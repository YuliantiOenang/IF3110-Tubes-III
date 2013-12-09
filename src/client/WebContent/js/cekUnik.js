if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttpUnik=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttpUnik=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttpUnik.onreadystatechange=function()
{
	if (xmlhttpUnik.readyState==4 && xmlhttpUnik.status==200)
	{
		var parsedData = JSON.parse(xmlhttpUnik.responseText);		
		if (parsedData['content']=="UNIK")
		{
			document.getElementById("submitEditBarang").disabled=false;
			document.getElementById("message").innerHTML="<font-color='green'>Nama Unik</font>";
		}
		else
		{
			document.getElementById("submitEditBarang").disabled=true;
			document.getElementById("message").innerHTML="<font-color='red'>Nama barang tidak unik</font>";
		}
	}
};

function cekUnik(name)
{
	if (name=="")
	{
		document.getElementById("submitEditBarang").disabled=true;
		document.getElementById("message").innerHTML="<font-color='red'>Nama barang tidak boleh kosong</font>";
	}
	else
	{
		xmlhttpUnik.open("GET","/ruserba/admin/cekBarang?name="+name,true);
		xmlhttpUnik.send();
	}
}
