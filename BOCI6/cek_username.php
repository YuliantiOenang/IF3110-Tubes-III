<?php  

session_start();  

require_once("databaseconnect.php");   //memanggil file databaseconnect.php  

connect_db();       // memanggil fungsi connect_db yang ada di file databaseconnect.php  

    $username =$_POST["username"];
	
    $query="SELECT * FROM user where username='$username'";   
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