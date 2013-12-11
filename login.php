<?php
	$host = "localhost";
	$user = "root";
	$password = "";
	$db_name = "progin_13511059";
	$con = mysql_connect($host,$user,$password,$db_name);
	if(mysql_errno($con)){
		echo "Failed to Connect to Database";
	}
	$username = $_GET['username'];
	$password = $_GET['password'];
	//Prevent SQL Injection
	$username = stripslashes($username);
	$password = stripslashes($password);
	$username = mysql_real_escape_string($username);
	$password = mysql_real_escape_string($password);
	//Membaca data dari database
	$verifikasi_query ="SELECT * FROM `progin_13511059`.user WHERE username ='$username' and password ='$password'";
	$verifikasi_hasil =mysql_query($verifikasi_query,$con);

	$count = mysql_num_rows($verifikasi_hasil);

	if($count ==0){
		echo 'User not found or Password is Wrong';
	}
	else if($count>1){
		echo 'There is something wrong with database';
	}
	else{
		session_start();
		$_SESSION['username']=$username;
		header('Location: index.php');
	}	
?>