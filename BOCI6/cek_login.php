<?php  

session_start();  

require_once("databaseconnect.php");   //memanggil file databaseconnect.php  

connect_db();       // memanggil fungsi connect_db yang ada di file databaseconnect.php  

    $username =$_POST["username"];  
    $password =$_POST["password"];  
  
    $query="SELECT * FROM user where username='$username' and password='$password'";   
    $result=mysql_query($query);  
  
    if(mysql_num_rows($result)>0) 
    {   $_SESSION['username']=$username;
		$_SESSION['password']=$password;
        $raw_results=mysql_fetch_array($result);
		if ($raw_results[9]===NULL){
			
		}else{
			$_SESSION['cardnumber']=$raw_results[9];
		}

		$Expire = time() +60*60*24*30;
        setcookie('username', $username, $Expire);
		setcookie('password', $password, $Expire);
		setcookie('cardnumber', $raw_results[9], $Expire);
		
		echo $username;
		
    }  
    else  
    {  
        echo '100';  
	
    }    
	
 
?> 