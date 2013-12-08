<script src="js/cartPayment.js"></script>
<script src="js/cookie.js"></script>
<?php
require_once('config.php');
if (isset($_COOKIE['isCreditCard']))
{
	$TopCart = $_COOKIE['topCart'];
	$total = 0;					
	for ($i=1;$i<=$TopCart;$i++)
	{
		$cook = $_COOKIE[$i];
		$pieces = explode("-", $cook);
		$id = $pieces[0];
		$jml = $pieces[1];
		$harga = $pieces[2];
		$nama = $pieces[3];
		$stok = $pieces[4];
		$total = $total + ($jml*$harga);
?>
		<img src="img/titik.png" onload="payment('<?=URLService;?>','<?=$id;?>','<?=$jml;?>',false)">
<?php
	}
	setcookie("topCart",0,0);
?>
	<img src="img/titik.png" onload="payment('<?=URLService;?>','','',true)">
<?php
	header("Location: barang.php");
}
else
{
	header("Location: registrasiKartu.php");
}
?>
