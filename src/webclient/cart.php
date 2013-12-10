<?php
	include("lib/transaksi_lib.php");
	include("lib/search_lib.php");
	
	if(isset($_POST["ajax"])){
		$res = handleSearchAjax();
		
		if($res!=null){
			exit($res);
		}else{
			exit(handleTransactionAjax());
		}
		
		exit();
	}
?>

<!DOCTYPE html />
<html>
<head>
<title>Keranjang Belanja</title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/cart.css" />

<script src="js/ajax.js"></script>
<script src="js/login.js"></script>
<script src="js/transaction.js"></script>
<script src="js/cart.js"></script>

</head>
<body onload="loadCartPage()">
<div class="outer">
	<?php include("header.php"); ?>
	<div class="content">
		<h3>Keranjang Belanja</h3>
		<div id="cart" class="table"></div>
	</div>
</div>
</body>
</html>