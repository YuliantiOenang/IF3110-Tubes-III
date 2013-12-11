<?php  

session_start();  


	$cardnumber=$_POST["cardnumber"];
    $namecard =$_POST["namecard"];
	$postdata = http_build_query(
    array(
        'creditnumber' => $cardnumber,
		'creditname' => $namecard
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

	$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/validasicreditname', false, $context); 
  
    if($result=="true")  
    {  
		echo true;
    }  
    else  
    {  
        echo false;  
    }    
	
 
?> 