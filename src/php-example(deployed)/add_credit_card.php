<?php
include('database_connection.php');
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

if ($_GET['btn'] == 'ok') {
	$sql="UPDATE account_customer
	SET cc_number='$_GET[card_number]', cc_expires='$_GET[expired_date]'
	WHERE username='$_GET[username]'";

	if (!mysql_query($sql, $link)){
		die('Error: ' . mysqli_error($link));
		echo 0;
	}
	else {
		echo 1;
	}
}
mysqli_close($link);	
?>
