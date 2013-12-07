<?php
	include("lib/transaksi_lib.php");
	include("lib/search_lib.php");
	
	if(isset($_POST["ajax"])){
		$res = handleSearchAjax();
		
		if($res!=null){
			exit($res);
		}
		
		exit();
	}else if(!isset($_GET["cat"])){
		header("Location: index.php");
		exit();
	}
	
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
	if (count($list) == 0){
		header("Location: index.php");
		exit();
	}	
?>

<!DOCTYPE html />
<html>
<head>
<title>Kategori: <?php echo $cat?></title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/category.css" />

<script>
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
	<?php echo "<h3>Kategori: ".$cat."</h3>"; ?>
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
			
			echo '<div class="cell33 imgcell" ><img class="imgbarang" src="image/'.$barang->id.'.jpg" /></div>';
			echo '<div class="cell66"><div class="table">';
			echo '<div class="row title"><a href="barang.php?id='.$barang->id.'" />'.$barang->nama.'</a></div>';
			echo '<div class="row">Rp. '.formatCurrency($barang->harga).'</div>';
			echo '<div class="row">'.$barang->deskripsi.'</div>';
			echo '<div class="row"><input type="button" value="Tambahkan ke Keranjang" class="main-button-small" onclick="addCart('.$barang->id.')" /></div>';
			echo '</div></div>';
			
			echo '</div>';
		}
	?>
	</div>
	<div id='infobottom'></div>
	
	</div>
</div>
</body>
</html>