<?php

require SITEPATH . '/framework/' . 'base_controller.class.php';
require SITEPATH . '/framework/' . 'registry.class.php';
require SITEPATH . '/framework/' . 'router.class.php';
require SITEPATH . '/framework/' . 'template.class.php';
require SITEPATH . '/framework/' . 'database.class.php';

//autoload class model
function __autoload($class_name) {
    $filename = strtolower($class_name) . '.class.php';
    $file = SITEPATH . '/app/models/' . $filename;
 	require ($file);
}

//create new registry
$registry = new Registry;
//passing config
$registry->config = $CONFIG;
//create database registry
$registry->database = Database::getInstance($registry);
