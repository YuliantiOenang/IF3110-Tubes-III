<?php  
session_start();  
UNSET($_SESSION['username']);  
UNSET($_SESSION['password']);  
session_destroy();  
setcookie("username","",time()-3600);
setcookie("password","",time()-3600);
setcookie("cardnumber","",time()-3600);
header('location: index.php');  
exit;  
?>