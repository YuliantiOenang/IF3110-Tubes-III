<!DOCTYPE HTML>
<html>
<head><title>Edit Barang</title>
<link rel="stylesheet" href="css/adminbarang.css" type="text/css" />
<script>
	function submitdelete(form,val){
		document.getElementById("admincode").value=val;
		var r=confirm("Anda yakin ingin menghapus barang (barang-barang) ini?");
		if (r==true){
			form.submit();
		 }
	}
	function submitdelete2(form,val,id){
		document.getElementById("admincode").value=val;
		document.getElementById(id).checked=true;
		var r=confirm("Anda yakin ingin menghapus barang (barang-barang) ini?");
		if (r==true){
			form.submit();
		 }
	}
	
</script>
</head>
<div class="index">
<body>

<?php include 'header.php'?>

<form name='check' action='admin' method='POST'>
<input type="hidden" name="admincode" id="admincode">
<article id="featured" class="body">
	<?php 
		if($sort = $_GET['sort'] != null){
			$sort = $_GET['sort'];
		} else {
			$sort = "nama";
	
		if ($kategori = $_GET['kategori']; != null){
			$kategori = $_GET['kategori'];
			<h3>Halaman Admin - "+kategori+"</h3><hr>
			<div class='headertools'>
			<a href='tambahbarang.php'><img src=images/Plus.png id='add'></a>
			<input type='image' src=images/Delete.png id='delete'onclick='submitdelete(document.forms[\"check\"],0)'>
			</div>
			<div id='sort'>Sort by <a href='adminbarang.jsp?kategori="+kategori+"&sort=nama'>Name</a> | <a href='adminbarang.jsp?kategori="+kategori+"&sort=harga'>Harga</a></div>
		} else {
			$kategori = null;
		<h3>Halaman Admin</h3><hr>
		<div class='headertools'>
			<a href='tambahbarang.jsp'><img src=images/Plus.png id='add'></a>
			<input type='image' src=images/Delete.png id='delete' onclick='submitdelete(document.forms[\"check\"],0)'>
		</div>
		<div id='sort'>Sort by <a href='adminbarang.jsp?sort=nama'>Name</a> | <a href='adminbarang.jsp?sort=harga'>Harga</a></div>
		}
	?>
	
	<center id="indikator"></center>
</article></form>

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
		
		<?php
			if ($kategori = $_GET['kategori']){
				xmlhttp.open('GET','ajaxadminbarang?page='+pages+'&kategori="+kategori+"&sort="+sort+"',true);
			} else {
				xmlhttp.open('GET','ajaxadminbarang?page='+pages+'&sort="+sort+"',true);
			}
				
		?>
		xmlhttp.send();
	}
	window.onscroll = function() {
		if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
			//if(currentpage<maxpage){
				currentpage++;
				getcontent(currentpage);
			//}
		}
	};
	getcontent(1);
</script>
</div>
</body>
</html>