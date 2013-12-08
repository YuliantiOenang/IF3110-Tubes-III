<?php
require_once('config.php');
$client = new SoapClient(SOAPService."service.wsdl",array('location' => SOAPService));
$return = $client->createKartu($_COOKIE['usernameID'],$_POST['card_number'],$_POST['name_of_card'],$_POST['expired_date']);	
print_r(simplexml_load_string($return));
$expire=time()+60*60*24*30;
setcookie("isCreditCard", "1", $expire);
header("Location: profil.php");
?>
