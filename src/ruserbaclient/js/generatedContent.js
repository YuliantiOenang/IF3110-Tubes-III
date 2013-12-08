var bookmark = new Array();
var GScroll = new Array();

var GName;
var GJenis;
var GURL;
var GsearchName,GsearchKateg,GsearchHarga,GsearchOP;

var CurPage;
var GJmlPage;
var FirstTime=true;

var str="";

if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttpEA=new XMLHttpRequest();
}
else
{// code for IE6, IE5
	xmlhttpEA=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttpEA.onreadystatechange=function()
{
	if (xmlhttpEA.readyState==4 && xmlhttpEA.status==200)
	{
		var parsedData = JSON.parse(xmlhttpEA.responseText);		
		str = str+parsedData['content'];
		GPage = parsedData['pageOf'];
		GJmlPage = Math.floor(parsedData['jmlPage']);
		//berisi response str
		//document.getElementById('ISI').innerHTML=str;
		document.getElementById('konten').innerHTML = str;
		document.getElementById("loader").classList.add("hidden");
	}
};

function init(URL,name,jenis,searchName,searchKateg,searchHarga,searchOP)
{
	GName = name;
	GJenis = jenis;
	GURL = URL;
	GsearchName = searchName;
	GsearchKateg = searchKateg;
	GsearchHarga = searchHarga;
	GsearchOP = searchOP;
	
	CurPage=1;
	str="";
	var i;
	for (i=1;i<=100;i++)
	{
		bookmark[i] = false;
		GScroll[i] = (i-2) * 150;
	}
	xmlhttpEA.open("GET",GURL+"?page="+CurPage+"&sort="+GName+"&jenisSort="+GJenis+"&search="+GsearchName+"&kategori="+GsearchKateg+"&harga="+GsearchHarga+"&operator="+GsearchOP,true); //URL samain
	CurPage++;
	xmlhttpEA.send();
}

onscroll = function() {
  var nVScroll = document.documentElement.scrollTop || document.body.scrollTop;
 
  if ((!bookmark[CurPage]) && (nVScroll > GScroll[CurPage]))
  {
	//alert("NVScroll :"+nVScroll+" Scroll : "+GScroll[CurPage]);
	bookmark[CurPage] = true;
	document.getElementById("loader").classList.remove("hidden");
	setTimeout(function(){		
		xmlhttpEA.open("GET",GURL+"?page="+CurPage+"&sort="+GName+"&jenisSort="+GJenis+"&search="+GsearchName+"&kategori="+GsearchKateg+"&harga="+GsearchHarga+"&operator="+GsearchOP,true);
	 CurPage++;
	 xmlhttpEA.send();
	},2000);
  }
};