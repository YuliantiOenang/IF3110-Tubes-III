<?php
	$url= "http://limitless-earth-2748.herokuapp.com/REST/deleteKeranjang2/".$_GET['idBarang'];
				$response=json_decode(file_get_contents($url));
				header("location: shoppingbag.php");
?>