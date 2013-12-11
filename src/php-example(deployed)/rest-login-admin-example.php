<?php
	include "database_connection.php";
	// username and password sent from form
	$myusername=$_GET['username'];
	$mypassword=$_GET['password'];

	// To protect MySQL injection (more detail about MySQL injection)
	$myusername = stripslashes($myusername);
	$mypassword = stripslashes($mypassword);
	$myusername = mysql_real_escape_string($myusername);
	$mypassword = mysql_real_escape_string($mypassword);
	$users = array();
	$sql="SELECT * FROM admin WHERE login='$myusername' and pass='$mypassword'";
	$result=mysql_query($sql, $link) or die(mysql_error()); 
	while($info = mysql_fetch_array( $result )){
		array_push($users, $info["login"]);
	}
	echo sizeof($users);
	//$count = sizeof($users);
?>