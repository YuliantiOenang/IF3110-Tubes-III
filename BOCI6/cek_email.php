<?php  

session_start();  

require_once("databaseconnect.php");   //memanggil file databaseconnect.php  

connect_db();       // memanggil fungsi connect_db yang ada di file databaseconnect.php  

    $email =$_POST["email"];
	
    $query="SELECT * FROM user where email='$email'"; 
    $result=mysql_query($query);  
  
    if(mysql_num_rows($result)>0)  
    {  
        
        
		echo false;
		
    }  
    else  
    {  
        echo true;  
	
    }    
	
 
?> 