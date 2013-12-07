var curURL;

if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttpDelete=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttpDelete=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttpDelete.onreadystatechange=function()
{
	if (xmlhttpDelete.readyState==4 && xmlhttpDelete.status==200)
	{
		var parsedData = JSON.parse(xmlhttpDelete.responseText);		
		if (parsedData['content']=="OK"){window.open(curURL,"_self");}
		else
		{
			alert("Tidak berhasil");
		}
	}
};

function deleteBarangConfirm(id)
{
	//di hardcode disini
	var r=confirm("Apakah anda ingin menghapus barang ini?");
	if (r==true)
	{
		curURL = document.URL;
		xmlhttpDelete.open("GET","http://localhost:8080/thelastruserba/admin/deletebarang?id="+id,true);
		xmlhttpDelete.send();
	} 
}
