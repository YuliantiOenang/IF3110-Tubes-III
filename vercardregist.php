<?php
	include 'connect.php';
	$username = 'codename'; //Ini nanti harusnya dari SESSION
	$cardnum = $_POST['cardnum'];
	$namecard = $_POST['namecard'];
	$expdate = new datetime($_POST['expdate']);
	$expdateresult = $expdate->format('Y-m-d H:i:s');
	$cardregist_query = "INSERT INTO `progin_13511059`.`creditcard` (`card_id`, `card_nameon`, `card_expdate`, `card_owner`) 
						VALUES ('$cardnum', '$namecard', '$expdateresult', '$username')";
	$cardregist_result = mysql_query($cardregist_query);
	header('location:index.php');
?>

