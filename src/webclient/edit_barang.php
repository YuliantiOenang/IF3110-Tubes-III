<?php

require_once "lib/search_lib.php";

if(!isset($_GET["id"])){
	header("Location: index.php");
}

$barang = searchId($_GET["id"]);
if ($barang == null) header("Location: index.php");

?>

<html>
<head>

<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/barang.css" />

<script src="js/ajax.js"></script>
<script src="js/login.js"></script>
<script>
	var changed = false;

	function edit(id_barang){
		nama = document.getElementById("namabarang").value;
		harga = document.getElementById("hargabarang").value;
		stok = document.getElementById("stokbarang").value;
		cat = document.getElementById("kategoribarang").value;
		desc = document.getElementById("descbarang").value;
		img = changed ? document.getElementById("display").src : "";
		
		log = getLoginInfo();
		
		data = {"token" : log.id, "imgdata" : img, "barang" : { "id": id_barang, "nama" : nama, "harga" : harga, "stok" : stok, "kategori" : cat, "deskripsi" : desc}};
			
		callback = function(response){
			
			if(response.status == "ok"){
				alert("berhasil");
			}else{
				alert(response.desc);
			}
			
		};
		
		sendRestAjax("PUT", "barang/"+id_barang, data, callback);
		
	}
	
	function onfilechange(){
		callback = function(result){
			document.getElementById("display").src = result;
			changed = true;
		}
	
		loadBase64Image('imgfile', callback);
	}
</script>
</head>

<body onload="redirect_admin()">
<div class="outer">
	<?php
		include("header.php");
	?>
	<div class='content'>
	<?php
		echo '<div class="barang table">';
		echo '<div class="row"><img class="imgbarang" id="display" src="'.$IMAGE_BASE_URL.$barang["id"].'.jpg" /></div>';
		echo '<div class="row"><input type="file" id="imgfile" onchange="onfilechange()" /></div>';
		echo '<div class="row"><div class="cell33">Nama barang</div><div class="cell66">: <input id="namabarang" type="text" value="'.$barang["nama"].'"/></div></div>';
		echo '<div class="row harga"><div class="cell33">Harga</div><div class="cell66">: Rp. <input id="hargabarang" type="text" value="'.$barang["harga"].'" /></div></div>';
		echo '<div class="row"><div class="cell33">Stok</div><div class="cell66">: <input id="stokbarang" type="text" value="'.$barang["stok"].'" /></div></div>';
		echo '<div class="row kategori"><div class="cell33">Kategori</div><div class="cell66">: ';
		echo '<input id="kategoribarang"type="text" value="'.$barang["kategori"].'" /></div></div>';
		echo '<div class="row"><div class="cell33">Deskripsi</div><div class="cell66">:</div></div>';
		echo '<div class="row deskripsi"><textarea id="descbarang">'.$barang["deskripsi"].'</textarea></div>';
		echo '</div>';
		
		echo '<input class="main-button" type="button" value="edit" onclick="edit('.$barang["id"].')"/>';
	?>
	</div>
</div>

</body>
</html>
