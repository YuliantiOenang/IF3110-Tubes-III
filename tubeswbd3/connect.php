<?php
//Syarat connect ke mysql
$host = "localhost";
$user = "root";
$password = "";
$db_name = "progin_13511059";
$con = mysql_connect($host,$user,$password,$db_name);
if(mysql_errno($con)){
	echo "Failed to Connect to Database";
}
?>