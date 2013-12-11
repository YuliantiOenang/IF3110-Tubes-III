<?php
	$dbhost  = 'localhost';
	$dbname  = 'tubes2';
	$dbuser  = 'root';
	$dbpass  = ''; 

	$con = mysql_connect($dbhost, $dbuser, $dbpass);
	
	// Check connection
	if($con == FALSE)
	{
		echo 'Cannot connect to database' . mysql_error();
	}
	else
	{
		echo 'Connected to database';
	}

	mysql_select_db($dbname, $con);
    
	$sql="DELETE FROM `peralatan` WHERE `no_alat`= 66 ";
	
	if (!mysql_query($sql,$con))
	{
		die('Error: ' . mysql_error($con));
	}
	echo "\n1 record deleted";
		
	$message = "Barang Berhasil didelete !";
	echo "<script type='text/javascript'>alert('$message');</script>";

	echo "<center> <a href=\"edit.php\">Klik disini</a> untuk kembali ke halaman sebelumnya </center>";	
	
	mysql_close($con);
?>