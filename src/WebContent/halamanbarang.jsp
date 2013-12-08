<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head><title>Halaman Barang</title>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
</head>
<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
<%@ include file="header.jsp" %>
<article id="featured" class="body">
	<%
	String kategori;
	String sort;
	if(request.getParameter("sort")!=null){
		sort = request.getParameter("sort");
	}else{
		sort = "nama";
	}
	if(request.getParameter("kategori")!=null){
		kategori = request.getParameter("kategori");
		out.println("<h3>Barang-barang "+kategori+" yang kami jual</h3><hr>");
		out.println("<div style='text-align:right'>Sort by <a href='halamanbarang.jsp?kategori="+kategori+"&sort=nama'>Name</a> | <a href='halamanbarang.jsp?kategori="+kategori+"&sort=harga'>Harga</a></div>");
	}else{
		kategori = null;
		out.println("<h3>Barang-barang yang kami jual</h3><hr>");
		out.println("<div style='text-align:right'>Sort by <a href='halamanbarang.jsp?sort=nama'>Name</a> | <a href='halamanbarang.jsp?sort=harga'>Harga</a></div>");
	}
	%>
	<center id="indikator"></center>
</article>
<%@ include file="footer.jsp" %>
<!-- Paginasi halaman dengan auto-generated content -->
<script>	
	var currentpage = 0;
	function getcontent(pages){
		currentpage = pages;
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				document.getElementById("featured").innerHTML+=xmlhttp.responseText;
				document.getElementById("featured").removeChild(document.getElementById("indikator"));
				var loader = document.createElement("center");
				loader.setAttribute("id", "indikator");
				document.getElementById("featured").appendChild(loader);
			}else{
				var loader ="<img src='images/loader.gif'><p>Memuat barang-barang yang lain...</p>";
				document.getElementById("indikator").innerHTML = loader;
			}
		}
		<% 
		if(request.getParameter("kategori")!=null){
			out.println("xmlhttp.open('GET','webservice?url=http://dichbar.ap01.aws.af.cm/ajaxbarang?page='+pages+'*kategori="+kategori+"*sort="+sort+"',true);");
		}else{
			out.println("xmlhttp.open('GET','webservice?url=http://dichbar.ap01.aws.af.cm/ajaxbarang?page='+pages+'*sort="+sort+"',true);");
		}
		%>
		xmlhttp.send();
	}
	window.onscroll = function() {
		if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
			currentpage++;
			getcontent(currentpage);
		}
	};
	getcontent(1);
</script>
</div>
</body>
</html>