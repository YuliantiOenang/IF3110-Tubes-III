<?php
//Document path
define('SERVER_ROOT' , getcwd()."/");
define('SITE_ROOT' , 'http://'.$_SERVER['SERVER_NAME'].'/'); 
define('NAME_ROOT' , 'wbdf'); //ganti ini apabila foldernya bukan 'wbdf'

//Konfigurasi database
define('HOST_SQL','localhost'); //MySQL server HOST
define('USER_SQL','root'); //user database
define('PASS_SQL',''); //password database
define('SQL_NAME','tubes1'); //nama database

//router, penghubung MVC
require_once(SERVER_ROOT.'/router.php');
