<?php

$hint1=false;
$hint2=false;
$hint3=false;
$hint4=false;
$hint5=false;

function cekEmail($email,$password) {
	$hint1=false;

	if(preg_match('/^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*(\.[a-zA-Z]{2,3})$/',$email) && $password!=$email ){
		$hint1=true;
	}
	if ($hint1 == false) {
		$response="email tidak valid dan tidak boleh sama password";
	} else $response=null;
	//output the response
	echo $response;
}

function cekUser($username,$pass) {
	$hint2=false;

	if(preg_match('/^([_a-zA-Z0-9-]{5})+([_a-zA-Z0-9-])*$/',$username) && $pass!=$username){
		$hint2=true;
	}
	if ($hint2 == false) {
		$response="username minimal 5 karakter, tidak boleh sama dengan password";
	} else $response=null;
	//output the response
	echo $response;
}

function cekPassword($password,$username) {
	$hint3=false;

	if(preg_match('/^([_a-zA-Z0-9-]{8})+([_a-zA-Z0-9-])*$/',$password) && $password!=$username){
		$hint3=true;
	}
	if ($hint3 == false) {
		$response="username minimal 8 karakter, tidak boleh sama username";
	} else $response=null;
	//output the response
	echo $response;
}

function cekConfirmPassword($cpassword,$password) {
	$hint4=false;

	if($password==$cpassword){
		$hint4=true;
	}
	if ($hint4 == false) {
		$response="harus sama dengan password";
	} else $response=null;
	//output the response
	echo $response;
}

function cekNama($nama) {
	$hint5=false;

	if(preg_match('/([_a-zA-Z-]* [_a-zA-Z-]*)/',$nama) ){
		$hint5=true;
	}
	if ($hint5 == false) {
		$response="minimal mengandung 1 spasi";
	} else $response=null;
	//output the response
	echo $response;
}

//get the q parameter from URL
$q=$_GET["q"];
$jenis=$_GET["jenis"];

if ($jenis=="email") {
	$pass=$_GET["pass"];
	cekEmail($q,$pass);
} else if ($jenis=="user") {
	$pass=$_GET["pass"];
	cekUser($q,$pass);
} else if ($jenis=="pass") {
	$user=$_GET["user"];
	cekPassword($q,$user);
} else if ($jenis=="cpass") {
	$password=$_GET["password"];
	cekConfirmPassword($q,$password);
} else if ($jenis=="nama") {
	cekNama($q);
}


/*
if ($hint1==true && $hint2==true && $hint3==true && $hint4==true && $hint5==true){ 
	$visible="";
} else {
	$visible="";
} */
	
?>