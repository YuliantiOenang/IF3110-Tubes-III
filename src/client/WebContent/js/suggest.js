if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttp2=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttp2.onreadystatechange=function()
{
	if (xmlhttp2.readyState==4 && xmlhttp2.status==200)
	{
		var parsedData = JSON.parse(xmlhttp2.responseText);		
		if (parsedData['content']=="") parsedData['content']="No Suggestion";
		document.getElementById('suggestions').innerHTML=parsedData['content'];
	}
};


function searchSuggestions(name)
{
	xmlhttp2.open("GET","/ruserba/barang/suggestions?name="+(name.value),true);
	xmlhttp2.send();
	document.getElementById('suggestions').classList.remove('hidden');
}

function suggestions(elmt)
{
	var elem = document.getElementById("suggestName");
	elem.value = elmt.text;
	document.getElementById("suggestions").innerHTML = "";
}