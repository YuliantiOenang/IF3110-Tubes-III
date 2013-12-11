<?php  

session_start();  

    $username =$_POST["username"];  
    $password =$_POST["password"];  
  
    //coba login
	$postdata = http_build_query(
    array(
        'username' => $username,
		'password' => $password
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/login', false, $context);
  $Expire = time() +60*60*24*30;
	if($result!=="false") 
    { 
		$result = json_decode($result,true);
		$_SESSION['username']=$username;
		$_SESSION['password']=$password;
    
		if ($result["nocredit"]===NULL){
			
		}else{
			$_SESSION['cardnumber']=$result["nocredit"];
			setcookie('cardnumber', $result["nocredit"], $Expire);
		}

		
        setcookie('username', $username, $Expire);
		setcookie('password', $password, $Expire);
		
		
		echo $username;
		
    }  
    else  
    {  
        print_r(" 100");  
	
    }
	
 
?> 