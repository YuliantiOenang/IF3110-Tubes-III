<?php
	include 'connect.php';
	session_start();
	$password = $_POST['password'];
	$fullname = $_POST['namalengkap'];
	$hpnum = $_POST['hpnum'];
	$address = $_POST['address'];
	$province = $_POST['province'];
	$kecamatan = $_POST['kecamatan'];
	$postalcode = $_POST['postcode'];
	$same_query = "SELECT * FROM `progin_13511059`.user WHERE
					password = '". $password."' AND nama_lengkap = '".
					$fullname."' AND handphone = '". $hpnum."' AND address= '".
					$address."' AND province = '".$province."' AND state = '".
					$kecamatan."' AND postcode='".$postalcode."'";
	$same_result = mysql_query($same_query,$con);
	if(mysql_num_rows($same_result)>0){
		echo 'The data is still Same';
	}
	else{
		$regist_query = "UPDATE `progin_13511059`.`user`
						SET
						nama_lengkap='".$fullname."', 
						password='".$password."',
						handphone=".$hpnum.",
						address='".$address."',
						province='". $province."',
						state='". $kecamatan."',
						postcode =". $postalcode."
						WHERE
						username= '".$_SESSION['username']."'";
		$regist_result = mysql_query($regist_query);
		if(!$regist_result){
			echo 'Unable to Edit Database';
		}
		else{
			header('location:index.php');
		}
	}	
?>