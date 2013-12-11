<?php
	$con 	= getConnection();
	$sql	= "SELECT * FROM goods WHERE goods_name='$namabarang'";
	
	$result = mysql_query($sql);
	
	$row	= mysql_fetch_array($result);
	
	$godd_ID			= $row["goods_ID"];
	$good_name			= $row["goods_name"];
	$good_price			= $row["goods_price"];
	$good_detail		= $row["goods_detail"];
	$good_available		= $row["goods_available"];
	
/*	echo $profil_ID; echo "<br>";
	echo $profil_name; echo "<br>";
	echo $profil_password; echo "<br>";
	echo $profil_email; echo "<br>";
	echo $profil_address; echo "<br>";
	echo $profil_province; echo "<br>";
	echo $profil_district; echo "<br>";
	echo $profil_zipcode; echo "<br>";
	echo $profil_mobile; echo "<br>"; // */
	
	mysql_close($con);
?>