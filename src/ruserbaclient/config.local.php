<?php
define('URLService','http://localhost:8080/thelastruserba/');
define('SOAPService','http://localhost/soap/');
define('BarangService',URLService.'/barang');
define('AdminBarangService',URLService.'/admin/index');
define('LoginService',URLService.'/login');
ini_set('display_errors','Off');
ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache

