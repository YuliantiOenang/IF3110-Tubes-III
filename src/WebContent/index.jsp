<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>RuSerBa</title>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />
</head>

<script>

var slideid;

function getbarang()
{
	var xmlhttp;
	
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
	    	document.getElementById("myslide").innerHTML = xmlhttp.responseText;	
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/indexservlet&type=html",true);
	xmlhttp.send();
}

function getslideid()
{
var xmlhttp;
	
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
	    	slideid = xmlhttp.responseText;	
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/indexslideservlet",true);
	xmlhttp.send();
}

getbarang();
getslideid();

</script>

<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
	<%@ include file="header.jsp" %>
	<article id="featured" class="body">
		<h2>Most Wanted Products</h2>
		<div id="slideshow">
				<label class="arrows" id="arrow-1" onclick="autoPlaySlide.slidetoleft();">prev</label>
				<label class="arrows" id="arrow-2" onclick="autoPlaySlide.slidetoright();">next</label>
				<div id="slideshow-inner">
					<ul id="myslide">
		</ul></div></div>
		<p>Cara belanja di RuSerBa Imba :<br>
- Pilih barang yang ingin anda beli (dapat memilih menu kategori maupun menggunakan search bar pada header untuk melakukan pencarian nama, kategori, maupun harga dari barang yang ingin anda beli)<br>
- Masukkan jumlah barang yang ingin anda beli untuk memasukkannya ke dalam Shopping Bag<br>
- Tekan tombol transaksi pada menu shopping bag untuk melakukan pembelian barang.<br></p>
	</article><!-- /#featured -->
	<%@ include file="footer.jsp" %>
	</div>
	<script>
	autoPlaySlide = {
		delay:3000,
		geser:0,
		counter:0,
		i:1,
		init: function(){
			document.getElementById("myslide").style.width= slideid+"00%";
		},
		play: function(){
			document.getElementById("myslide").style.left=autoPlaySlide.geser+"%";
			if(autoPlaySlide.counter==0){
				if(autoPlaySlide.i== slideid){ 
					autoPlaySlide.counter=1; 
					autoPlaySlide.geser+=100; 
				}else{ autoPlaySlide.geser-=100; }
			}else{
				if(autoPlaySlide.i==1){ 
					autoPlaySlide.counter=0; 
					autoPlaySlide.geser-=100; 
				}else{ autoPlaySlide.geser+=100; }
			}
			if(autoPlaySlide.counter==0){ autoPlaySlide.i++; }else{ autoPlaySlide.i--; }
			setTimeout("autoPlaySlide.play()",autoPlaySlide.delay);
		},
		slidetoleft: function(){
			autoPlaySlide.geser+=100;
			autoPlaySlide.i--;
			document.getElementById("myslide").style.left=autoPlaySlide.geser+"%";	
		},
		slidetoright: function(){
			autoPlaySlide.geser-=100;
			autoPlaySlide.i++;
			document.getElementById("myslide").style.left=autoPlaySlide.geser+"%";	
		}
	}
	autoPlaySlide.init();
	autoPlaySlide.play();
	</script>
</body>
</html>