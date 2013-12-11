<?php  

session_start();  

    $cardnumber =$_POST["cardnumber"];
	$expiredate =$_POST["expiredate"];
	
   $postdata = http_build_query(
    array(
        'creditnumber' => $cardnumber,
		'creditexpire' => $expiredate
	)
	);

	$opts = array('http' =>
    array(
        'method'  => '.GET',
        'header'  => "Content-type: application/x-www-form-urlencoded",
        'content' => json_encode($postdata)
    )
	);

	$context  = stream_context_create($opts);

	$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/validasicreditexpire', false, $context); 
  
    if($result=="true")  
    {  
		echo true;
    }  
    else  
    {  
        echo false;  
    }    
	
 
?> 