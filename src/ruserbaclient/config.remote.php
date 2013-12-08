<?php
define('URLService','http://thelastruserba.ap01.aws.af.cm/');
define('SOAPService','http://thelastruserbasoap.ap01.aws.af.cm/');
define('BarangService',URLService.'/barang');
define('AdminBarangService',URLService.'/admin/index');
define('LoginService',URLService.'/login');
ini_set('display_errors','Off');
ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache

