<?php  

session_start();  

require_once("databaseconnect.php");   //memanggil file databaseconnect.php  

connect_db();       // memanggil fungsi connect_db yang ada di file databaseconnect.php  

    $cardnumber =$_POST["cardnumber"];
	$expiredate =$_POST["expiredate"];
	
    $query="SELECT * FROM creditcard WHERE number='$cardnumber' AND expiredate='$expiredate'";   
    $result=mysql_query($query) or die("EITS");  
  
    if(mysql_num_rows($result)>0)  
    {  
		echo true;
    }  
    else  
    {  
        echo false;  
    }    
	
 
?> 