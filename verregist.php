<?php
	include 'connect.php';
	$username = $_POST['username'];
	$password = $_POST['password'];
	$fullname = $_POST['namalengkap'];
	$hpnum = $_POST['hpnum'];
	$address = $_POST['address'];
	$province = $_POST['province'];
	$kecamatan = $_POST['kecamatan'];
	$postalcode = $_POST['postcode'];
	$email = $_POST['email'];

	$username_query = "SELECT * FROM `progin_13511059`.user WHERE username='".$username."'";
	$username_result = mysql_query($username_query,$con);
	$email_query = "SELECT * FROM `progin_13511059`.user WHERE email ='".$email."'";
	$email_result = mysql_query($email_query,$con);
	
	if(mysql_num_rows($email_result)>0){
		echo 'Email already Exist';
	}
	else if(mysql_num_rows($username_result)>0){
		echo 'Username already Exist';
	}
	else{
		$regist_query = "INSERT INTO `progin_13511059`.`user` (`username`, `nama_lengkap`, `password`, `email`, `handphone`, `address`, `province`, `state`, `postcode`) 
					VALUES ('$username',
							'$fullname',
							'$password',
							'$email',
							'$hpnum',
							'$address',
							'$province',
							'$kecamatan',
							'$postalcode')";
		$regist_result = mysql_query($regist_query);
		if(!$regist_result){
			echo 'The Registration is failed';
		}
		else{
			header('location:index.php');
		}
	}
?>