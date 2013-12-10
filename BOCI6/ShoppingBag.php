<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
<?php	
	include 'header.php';
	include 'LibUser.php';
	session_start();
	if (isset($_SESSION['username'])){
		echo "<html>";
		echo "<head>";
		echo "<link rel=\"stylesheet\" type=\"text/css\" href=\"TabelCSS.css\">";
		echo "</head>";
		echo "<body>";
			
		echo "<div class=\"ShoppingBag\">";
		$Total=0;
		if (isset($_SESSION['cart'])){
			foreach ($_SESSION['cart'] as $Barang){
				echo "<div class=\"ShoppingBagRow\">";
				$Nama=$Barang[0]->GetNamaBarang();
				$Jumlah=$Barang[1];
				$Harga=$Barang[0]->GetHarga();
				$Total+=$Harga*$Jumlah;
				echo "<div class=\"ShoppingBagCellNama\">";echo "$Nama </div>";
				echo "<div class=\"ShoppingBagCellJumlah\">";echo "$Jumlah</div></div>";
				
			}
			echo "<div class=\"ShoppingBagCellNama\">";echo "TOTAL </div>";
			echo "<div class=\"ShoppingBagCellJumlah\">";echo "$Total</div>";
			echo "<button type=\"button\" onClick=\"location.href='Transaction.php?TransAct=1'\" class=\"btn\">Checkout Cart</button></div>";
		}
		else{
			echo "Cart Kosong";}
		echo "<br>";
		echo "<a href=\"index.php\">BACK</a><br>";
		echo "</body>";
		echo "</html>";
	}
	else{
		header('location: registrasi.php');  }
?>
</div>