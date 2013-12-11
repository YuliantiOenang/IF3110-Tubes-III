<?php
include "koneksi.inc.php";
if(isset($_GET['cardnumber'])){ $cardnumber=$_GET['cardnumber']; }
if(isset($_GET['name'])){ $name=($_GET['name']1); }
$ret = "notvalid";
//cardnumber and name validator
$regex = '/^([A-Za-z]{1,10})+([ ][A-Za-z]{1,20})+$/';
if(preg_match($regex, $name) && strlen($cardnumber)==16){
	ret = "valid";
}
echo $ret;
sleep(3);
?>