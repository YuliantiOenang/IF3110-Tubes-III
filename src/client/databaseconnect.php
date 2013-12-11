<?php  
$db_hostname="localhost";  
$db_username="root";    // username 
$db_password="";        // password  
$db_name="datauser";     // nama database
function connect_db() {  
    global $db_hostname, $db_username, $db_password, $db_name;  
    $conn = mysql_connect($db_hostname, $db_username, $db_password) or die ("Sorry cannot connect to the database because: " . mysql_error());;  
    mysql_select_db($db_name);  
}  
?> 