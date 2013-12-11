<!DOCTYPE HTML>
<html>
<head><title>Halaman Barang</title></head>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<?php include "header.php";?>
<?php include "sidebar.php";?>
<article id="featured" class="body">
	<?php
	if(isset($_GET['sort'])){ $sort=$_GET['sort']; }else{ $sort="nama"; }
	if(isset($_GET['page'])){ $page=($_GET['page']-1)*10; }else{ $page=0; }
	if(isset($_GET['kategori'])){ 
		$kategori=$_GET['kategori']; 
	}else{
		$kategori=null;
	}
	echo "<h3>Barang-barang $kategori yang kami jual</h3><hr>";
	if(isset($_GET['kategori'])){ 
		echo "<div style='text-align:right'>Sort by <a href='halamanbarang.php?kategori=$kategori&sort=nama'>Name</a> | <a href='halamanbarang.php?kategori=$kategori&sort=harga'>Harga</a></div>";
	}else{
		echo "<div style='text-align:right'>Sort by <a href='halamanbarang.php?sort=nama'>Name</a> | <a href='halamanbarang.php?sort=harga'>Harga</a></div>";
	}?>
	<center id="indikator"></center>
</article>
<?php include "footer.php";?>
<!-- Paginasi halaman dengan auto-generated content -->
<script>	
	var currentpage=1;
	var maxpage=5;
	function getcontent(page){
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
				var loader ="<img src='images/ajax-loader.gif'><p> Memuat barang-barang yang lain...</p>";
				document.getElementById("indikator").innerHTML = loader;
			}
		}
		<?php if($kategori){ echo 'xmlhttp.open("GET","ajaxbarang.php?page="+page+"&kategori='.$kategori.'&sort='.$sort.'",true);'; }
		else{ echo 'xmlhttp.open("GET","ajaxbarang.php?page="+page+"&sort='.$sort.'",true);'; } ?>
		xmlhttp.send();
	}
	window.onscroll = function() {
		if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
			if(currentpage<maxpage){
				currentpage++;
				getcontent(currentpage);
			}
		}
	};
	window.onload = getcontent(1);
</script>
</div>
</body>
</html>