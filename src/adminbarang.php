<?php include('headeradmin.php'); ?>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />
<html>
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
<body>
	<div class="index">
	<form name='check' action='admin' method='POST'>
	<input type="hidden" name="admincode" id="admincode">
	<article id="featured" class="body">
	
	<?php
		if(isset($_GET['sort'])){ $sort = $_GET['sort']; }else{	$sort = "nama"; }
		if(isset($_GET['kategori'])){ $kategori = $_GET['kategori']; }else{ $kategori = null; }
		if ($kategori != null){
			echo '<h3>Halaman Admin - "'.$kategori.'"</h3><hr>';
			echo'<div class="headertools">';
				echo'<a href="tambahbarang.php"><img src=images/Plus.png id="add"></a>';
				echo'<input type="image" src="images/Delete.png" id="delete" onclick="submitdelete(document.forms[\"check\"],0)>';
			echo '</div>';
			echo '<div id="sort"> Sort by <a href="adminbarang.php?kategori='.$kategori.'&sort="nama"> Name </a>|<a href="adminbarang.php?kategori='.$kategori.'&sort="harga"> Harga </a></div>';
		} else {
			echo '<h3>Halaman Admin</h3><hr>';
			echo '<div class="headertools">';
				echo '<a href="tambahbarang.php"><img src=images/Plus.png id="add"></a>';
				echo '<input type="image" src=images/Delete.png id="delete" onclick="submitdelete(document.forms[\"check\"],0)>';
			echo '</div>';
			echo '<div id="sort">Sort by <a href="adminbarang.php?sort="nama"> Name </a>|<a href="adminbarang.php?sort="harga">Harga</a></div>';
		}
	?>
	
	<center id="indikator"></center>
	</article>
	</form>

<!-- Paginasi halaman dengan auto-generated content -->
<script>	
	var currentpage = 1;
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
		if(isset($_GET['kategori'])){
			echo "xmlhttp.open('GET','AJAXadminbarang.php?page='+pages+'&kategori=".$_GET['kategori']."&sort=nama',true);";
		}else{
			echo "xmlhttp.open('GET','AJAXadminbarang.php?page='+pages+'&sort=nama',true);";
		}
		?>
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
	getcontent(1);
</script>

<?php include "footer.php";?>
</div>
<!-- Paginasi halaman dengan auto-generated content -->
<script>	
	function getcontent2(page){
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				document.getElementById("featured").innerHTML+=xmlhttp.responseText;
				document.getElementById("indikator").innerHTML="";
			}else{
				document.getElementById("indikator").innerHTML="<img src='images/loader.gif'><p>Memuat barang-barang yang lain...</p>";
			}
		}
		<?php if($kategori){ echo 'xmlhttp.open("GET","ajaxbarang.php?page="+page+"&kategori='.$kategori.'&sort='.$sort.'",true);'; }
		else{ echo 'xmlhttp.open("GET","ajaxbarang.php?page="+page+"&sort='.$sort.'",true);'; } ?>
		xmlhttp.send();
	}
</script>
</body>
</html>