<?php 
	if(!isset($_SESSION)){
		session_start();
	}
	if(isset($_SESSION['login_user'])) {
		$user_check = $_SESSION['login_user'];
	} else {
		$user_check = "";
	}
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Detail Barang</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="detailbarang.js"></script>
	</head>
	<body>
		
			<!--Header-->
			<div id="header">
				<?php
					include("header.php");
					$namabarang=$_GET["namabarang"];
					require('database/getbarang.php');
				?>
			</div>
			<div><hr id="border"></div>
			<!--Body-->
			<div id="detail-body">
				<div id="detail-pic">
					<img alt="" id="photo" src="../image/goods/<?php echo $namabarang.".jpg"; ?>" width="120" height="150"/>
   					
					<br />
					<b><?php echo $namabarang?></b></a>
				</div>
				<div id="main-detail">
					<div id="detail-information">
						<b>Keterangan</b><br />
						<?php echo $good_detail; ?><br/><br/>
						<b>Harga</b><br />
						<?php echo "RP ".$good_price.",00"; ?><br/><br/>
						<b>Stok</b><br />
						<?php echo $good_available." buah"; ?><br/><br/>
						<b>Pembelian</b><br>
							<form method="post" action="database/beli.php?namabarang=<?php echo $_GET["namabarang"]; ?>">
							Notes :<input type="text" id="notes" name="textnotes" /><br>
							jumlah:<input type="text" id="jumlah" name="textjumlah" /><br>
							<input type="submit" value="Beli">
							<div id="warning-message"><?php echo $_GET["hasil"]; ?></div>
						</form>
					</div>
				</div>
			</div>
		
	</body>
</html>
