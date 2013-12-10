<?php
	include("lib/transaksi_lib.php");
	include("lib/search_lib.php");
	
	if(isset($_POST["ajax"])){
		$res = handleSearchAjax();
		
		if($res!=null){
			exit($res);
		}
		
		exit();
	}/*else if(!isset($_GET["cat"])){
		header("Location: index.php");
		exit();
	}*/
	
	$cat = $_GET["cat"];
	
	$sort = "nama_barang";
	
	$harga_selected = false;
	
	if (isset($_GET["sort"])){
		$sort = $_GET["sort"];
		if ($sort == "harga") $harga_selected = true;
	}
	
	$order = "asc";
	
	$desc_selected = false;
	
	if(isset($_GET["order"])){
		$order = $_GET["order"];
		if($order == "desc") $desc_selected = true;
	}
	
	
	
	$list = searchCategory($cat, 0, $sort, $order);
	/*if (count($list) == 0){
		header("Location: index.php");
		exit();
	}*/	
?>


<!DOCTYPE html />
<html>
<head>
<title>Kategori: <?php echo $cat?></title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/category.css" />

<script>

	var listcheck = [];
	
	function checkedToList(id){
		if (document.getElementById(id).checked==true) {
			listcheck.push(id);
		} else {
			var index = listcheck.indexOf(id);
			if (index > -1) {
				array.splice(index, 1);
			}
		}
	}
	
	function deleteBarang(id){
		if (!confirm("Anda yakin ingin melakukan penghapusan?"))
			return;
		data = { "ids" : [id], "token" : getLoginInfo().id};
		
		callback = function (response) {
			if (response.status=="ok"){
				alert ("Barang (barang-barang) berhasil dihapus)!");
				window.location.reload();
			} else {
				alert (response.desc);
			}
		}

		sendRestAjax("DELETE", "barang", data , callback);
		
	}
	
	function deleteBulkBarang(){
		if (!confirm("Anda yakin ingin melakukan penghapusan?"))
				return;
		data = { "ids" : listcheck, "token" : getLoginInfo().id};
		
		callback = function (response) {
			if (response.status=="ok"){
				alert ("Barang (barang-barang) berhasil dihapus)!");
				window.location.reload();
			} else {
				alert (response.desc);
			}
		}
		
		sendRestAjax("DELETE", "barang", data , callback);
		
	}
	
	


<?php
	echo "var category = '".$cat."';";
	echo "var sortby = '".$sort."';";
	echo "var order = '".$order."';";
?>
</script>


<script src="js/ajax.js"></script>
<script src="js/login.js"></script>
<script src="js/transaction.js"></script>
<script src="js/category.js"></script>

</head>
<body>
<div class="outer">
	<?php include("header.php"); ?>
	<div class='content'>
	<?php echo "<h3>Kategori: ".$cat."</h3>"; 
	echo '<a href="add_barang.php"><img src=image/Plus.png id="add"></a>';
	echo '<input type="image" src=image/Delete.png id="bulkdelete" onclick="deleteBulkBarang()">';
	echo '"<input type="hidden" name="admincode" id="adminidcode">"';?>
	Pengurutan:
	<select onchange="changeSortBy(this.value)">
		<option value="nama" <?php if(!$harga_selected) echo "selected"; ?> >Nama Barang</option>
		<option value="harga" <?php if($harga_selected) echo "selected"; ?> >Harga Barang</option>
	</select>
	
	<select onchange="changeOrder(this.value)">
		<option value="asc" <?php if(!$desc_selected) echo "selected"; ?> >Ascending</option>
		<option value="desc" <?php if($desc_selected) echo "selected"; ?> >Descending</option>
	</select>
	
	<div id='cattable' class='table'>
	<?php
		foreach($list as $barang){
			echo '<div class="row rowbarang">';
			echo '<div class="cell33 imgcell" ><img class="imgbarang" src="'.$IMAGE_BASE_URL.$barang["id"].'.jpg" /></div>';
			echo '<div class="cell66"><div class="table">';
			echo '<div class="row title"><a href="barang.php?id='.$barang["id"].'">'.$barang["nama"].'</a></div>';
			echo '<div class="row">Rp. '.formatCurrency($barang["harga"]).'</div>';
			echo '<div class="row">Dibeli '.$barang["jumlah_beli"].' kali</div>';
			echo '<div class="row">Stok  : '.$barang["stok"].'</div>'; 
			echo '<div class="row">'.$barang["deskripsi"].'</div>';
			echo '<div class="rowtools"><input type="checkbox" name="'.$barang["id"].'" id="'.$barang["id"].'" onclick=checkedToList('.$barang["id"].')>'; 
			echo '<a href="edit_barang.php?id='.$barang["id"].'"><img src=image/Edit.jpg id="edit"></a>';
			echo '<input type="image" src=image/Delete.png id="delete" onclick="deleteBarang('.$barang["id"].')">';
			echo '</div></div></div>';
			echo '</div>';
		}
	?>
	</div>
	<div id='infobottom'></div>
	
	</div>
</div>
</body>
</html>