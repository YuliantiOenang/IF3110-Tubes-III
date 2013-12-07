if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttpDetail=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttpDetail=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttpDetail.onreadystatechange=function()
{
	if (xmlhttpDetail.readyState==4 && xmlhttpDetail.status==200)
	{
		var parsedData = JSON.parse(xmlhttpDetail.responseText);		
		var status = parsedData.status;
		var content = parsedData.content;
		if (status){document.getElementById("kontenDetailBarang").innerHTML = content;}
		else
			alert("Tidak berhasil");
	}
};

function detailBarang(URL,id)
{
	xmlhttpDetail.open("GET",URL+"/barang/detail?id="+id,true);
	xmlhttpDetail.send();
}
