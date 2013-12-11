<?php

session_start(); 


$username=$_SESSION["username"];
$cardnumber=$_POST['cardnumber'];

$postdata = http_build_query(
    array(
        'username' => $username,
		'nocredit' => $cardnumber
		
	)
	);

$opts = array('http' =>
    array(
        'method'  => '.PUT',
        'header'  => "Content-type: application/x-www-form-urlencoded",
        'content' => json_encode($postdata)
    )
);

$context  = stream_context_create($opts);

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/insertcard', false, $context);
$result=json_decode($result,true);

 $_SESSION['cardnumber']=$cardnumber; 
 setcookie('cardnumber', $cardnumber, $Expire);
 header('location: index.php');  
exit;  

?>