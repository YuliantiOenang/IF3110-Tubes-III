<?php
	include("lib/search_lib.php");

	if(isset($_POST["ajax"])){
		$res = handleSearchAjax();
		
		if($res!=null){
			exit($res);
		}
		
		exit();
	}else if(!isset($_GET['q'])){
		header("Location: index.php");
	}
	
	$entry = $_GET['q'];
	$search = searchAll($entry, 0);	
	$success = count($search) > 0;
?>

<html>
<head>
<title>Search: <?php echo $entry?></title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/category.css" />

<script>
	<?php
		echo "var entry = '".$entry."'; ";
		echo "var loadable = ".($success ? "true" : "false").";\n";
		echo "var IMGURL = '$IMAGE_BASE_URL';\n";
	?>
	var loading = false;
	var page = 0;
</script>

<script src="js/ajax.js"></script>
<script src="js/login.js"></script>
<script src="js/transaction.js"></script>
<script src="js/adminsearch.js"></script>

</head>
<body>
<div class="outer">
	<?php include("header.php"); ?>
	<div class='content'>
		<h3><?php echo 'Search: "'.$entry.'"'; ?></h3>
		<div id="cattable">
			<?php
				foreach($search as $barang){
				echo '<div class="row rowbarang">';
				echo '<div class="cell33 imgcell" ><img class="imgbarang" src="'.$IMAGE_BASE_URL.$barang["id"].'.jpg" /></div>';
				echo '<div class="cell66"><div class="table">';
				echo '<div class="row title"><a href="admin_detail_barang.php?id='.$barang["id"].'">'.$barang["nama"].'</a></div>';
				echo '<div class="row">Kategori: <a href="admin_barang.php?cat='.$barang["kategori"].'">'.$barang["kategori"].'</a></div>';
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
		<?php
			if ($success){
				echo "<div id='infobottom'></div>";
			}else{
				echo "<div id='infobottom' class='backgrey'>no more match</div>";
			}
		?>
		
	</div>
</div>

</body>
</html>