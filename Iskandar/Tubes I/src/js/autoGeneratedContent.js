var bookmark = new Array();
var GScroll = new Array();

var GName;
var GJenis;
var GURL;

var CurPage;
var GJmlPage;

var str="";

if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttp.onreadystatechange=function()
{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		var parsedData = JSON.parse(xmlhttp.responseText);
		str = str+parsedData['content'];
		GPage = parsedData['pageOf'];
		GJmlPage = Math.floor(parsedData['jmlPage']);
		//berisi response str
		document.getElementById('ISI').innerHTML=str;
	}
}

function init(URL,name,jenis)
{
	GName = name;
	GJenis = jenis;
	GURL = URL;

	CurPage=0;
	str="";
	var i;
	for (i=0;i<=100;i++)
	{
		bookmark[i] = false;
		GScroll[i] = i * 1200;
	}
	xmlhttp.open("GET",URL+"?page="+CurPage+"&sort="+GName+"&jenisSort="+GJenis,true);
	CurPage++;
	xmlhttp.send();
}

onscroll = function() {
  var nVScroll = document.documentElement.scrollTop || document.body.scrollTop;
  
  if ((!bookmark[CurPage]) && (nVScroll > GScroll[CurPage]))
  {
	bookmark[CurPage] = true;
	setTimeout(function(){		
	 xmlhttp.open("GET",GURL+"?page="+CurPage+"&sort="+GName+"&jenisSort="+GJenis,true);
	 CurPage++;
	 xmlhttp.send();
	},1000);
  }
};
