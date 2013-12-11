<?php
	include "database_connection.php";
	$sql = "DELETE FROM catalog_product WHERE id = '$_GET[id]'"; 
	if (!mysql_query($sql,$link))
  {
  die('Error: ' . mysql_error($link));
  echo '0';
  }
  else {
  	echo '1';
  }
mysql_close($link);
?>