<?php
	
//include konfigurasi, jamin ada
require 'app/config.php';

//mengeset error sesuai environment variable
switch (ENVIRONMENT) {
	case 'production':
		error_reporting(0);
		ini_set('error_reporting', 0);
		break;
	case 'testing':
	case 'development':
	default:
		error_reporting(E_ALL);
		ini_set('error_reporting', E_ALL);
		break;
}

//SITEPATH
$site_path = realpath(dirname(__FILE__));
define ('SITEPATH', $site_path);

//include initialization, jamin ada
require 'framework/init.php';

//load router
$registry->router = new Router($registry);
//load path ke controller
$registry->router->setPath (SITEPATH . '/app/controllers');
//load template
$registry->template = new Template($registry);
//load controller
$registry->router->loader();