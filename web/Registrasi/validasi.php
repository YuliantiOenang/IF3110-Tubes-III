<?php

$email_a = $_GET["email"];
$email_b = explode('.',$email_a);
        
$username= $_GET["username"];



$pass= $_GET["password"];

$confPass= $_GET["confirm_password"];
$temp="       Andrian Octavianus                         ";
$LeftTrim= ltrim($temp);
$boolUsedUser=true;
$namaLengkap=rtrim(ltrim($_GET["nama_lengkap"]));

$url= "http://limitless-earth-2748.herokuapp.com/REST/getNamaCustomer/".$username."";
$response=json_decode(file_get_contents($url));
$boolUsedUser=$response;


$boolUsedEmail=true;

$url= "http://limitless-earth-2748.herokuapp.com/REST/getNama/".$email_a."";
$response=json_decode(file_get_contents($url));
$boolUsedEmail=$response;

$boolUser=false;
$boolPass=false;
$bool = true;
$boolNama=false;
$boolEmail = false;
$retval=array();

$namaLeng = explode(' ',$namaLengkap);
if(count($namaLeng)>1){
	if($namaLeng[1] != ''){
		$boolUser = true;
	}
}

if(strlen($username)>4 && $username!=$pass)
{
	$boolNama=true;
}

if($pass==$confPass&& $pass!= "" && $confPass!="" && strlen($pass)>=8)
{
	$boolPass=true;
}

if(count($email_b) > 2)
{
	$bool=false;
}
else
{
	if(count($email_b)>1)
	{
		if(strlen($email_b[1])<2)
		{
			
			$bool=false;
		}
	}

}

if (filter_var($email_a, FILTER_VALIDATE_EMAIL) && $bool) {
   $boolEmail = true;
}


$return = array();
$return["boolUser"] = $boolUser;
$return["boolPass"] = $boolPass;
$return["bool"] = $boolEmail;
$return["boolNama"] = $boolNama;
$return["boolUsedUser"] = $boolUsedUser;
$return["boolUsedEmail"] = $boolUsedEmail;
echo json_encode($return);

?>