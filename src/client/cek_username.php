<?php  

session_start();  


    $username =$_POST["username"];
	
   
   
	$postdata = http_build_query(
    array(
        'username' => $username
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

	$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/validasiusername', false, $context);

  
    if($result=="false")  
    {  
		echo false;
    }  
    else  
    {  
        echo true;  
    }    
	
 
?> 