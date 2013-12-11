<?php
	include "database_connection.php";
	$tbl_name="account_customer";
	// username and password sent from form
	$myusername=$_GET['username'];
	$mypassword=$_GET['password'];

	// To protect MySQL injection (more detail about MySQL injection)
	$myusername = stripslashes($myusername);
	$mypassword = stripslashes($mypassword);
	$myusername = mysql_real_escape_string($myusername);
	$mypassword = mysql_real_escape_string($mypassword);
	$users = array();
	$sql="SELECT * FROM account_customer WHERE username='$myusername' and password='$mypassword'";
	$result=mysql_query($sql, $link) or die(mysql_error()); 
	while($info = mysql_fetch_array( $result )){
		array_push($users, $info["username"]);
	}
	echo sizeof($users);
	//$count = sizeof($users);
?>