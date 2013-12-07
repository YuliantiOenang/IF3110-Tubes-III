<!--
field card number,
name on card
expired date
submit
submit, maka akan dilakukan ajax untuk mengecek card numer dan name on card tersebut valid
jika sukses akan ada notifikasi pembelian sukses
jika gagal memberikan notifikasi gagal dan kembali ke halaman registrasi kartu kredit -->
<!DOCTYPE html>
<html>
<head>
<title>Registrasi Kartu Kredit</title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/kredit.css" />

<script src="js/ajax.js"></script>
<script src="js/login.js"></script>
<script src="js/cart.js"></script>
<script>
var buying = <?php echo isset($_GET["buy"]) ? "true" : "false"; ?>;
</script>
<script src="js/kredit.js"></script>

</head>
<body onload="return !redirect_login();">

<div class="outer">
	<?php
		include("header.php");
	?>
	<div class='content'>
<h3> REGISTRASI KARTU KREDIT </h3>


	<div class="table">
		<div class="row">Registrasi kartu kredit dilakukan melalui form yang ada dibawah ini</div>
		<form method="post" action="submit.php">
		<div class="row">
			<div class="cell50">Card Number</div>
			<div class="cell50">: <input type="text" id="cardnumber" name="cardnumber" /></div>
		</div>
		<div class="row">
			<div class="cell50">Name on card</div>
			<div class="cell50">: <input type="text" id="namecard" name="namecard" /></div>
		</div>
		<div class="row">
			<div class="cell50">Expired Date (Format MM/YY)</div>
			<div class="cell50">: <input type="text" id="expireddate" name="expireddate" /></div>
		</div>
		<div class="row align-right">
			<input type="button" class="main-button" value = "Submit" onclick="validation(this.form)" /> <input class="grey-button" type="button" value = "Skip" onclick="skip()" />
		</div>
		</form>
	</div>

	
	
</div></div>
</body>
</html>