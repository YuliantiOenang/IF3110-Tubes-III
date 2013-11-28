<?php
ini_set('display_errors', 'Off');
ini_set('session.cookie_lifetime', 60 * 60 * 24 * 30); //30 hari
session_start(); //session start

function __autoload($className)
{
	//Kelas yang dipanggil oleh controller akan masuk kesini
	list($filename , $suffix) = split('_' , $className);

	if (strtolower($filename) == "view") //jika yang dipanggil kelas view, maka perlakuan khusus
		$file = SERVER_ROOT . '/view.php';
	else if (strtolower($filename) == "sql")
		$file = SERVER_ROOT . '/sql.php';
	else
		$file = SERVER_ROOT . '/model/' . strtolower($filename) . '.php';


	if (file_exists($file)) include_once($file); //include once
	else die("Kelas ".$filename." tidak ditemukan"); //jika file tidak ditemukan
}

$URI = $_SERVER['REQUEST_URI'];
$parsed = explode('/' , $URI);
$indexPage = $parsed[2];

if (($indexPage != "index.php") && ($indexPage != null)) die('<h2> Udah, jangan liat-liat kk. <br> Inget Dosa :v </h2>');

$page = $parsed[3];
$func = $parsed[4];

$parsingfunc = explode('?',$func);
$function = $parsingfunc[0];

if ($page == null)
{
	header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/home");
	die();
}

if ($function == null) $function="index";

/* Parsing Data + Debug */
$getVars = array();
foreach ($_REQUEST as $key => $value)
{
	$getVars[$key] = urldecode($value);
}
/* End of Parsing */

//target file, bisa diambil dari $page
$target = SERVER_ROOT . '/pengontrol/'.$page.'.php';
if (file_exists($target))
{
	include_once($target);
	$class = ucfirst($page);

	if (class_exists($class)) $controller = new $class; //instansiasi kelas
	else die('kelas '.$class.' tidak ada, coba lihat kembali nama kelas anda');
}
else die('file controller '.$page.'.php tidak ditemukan');
$bool = $controller->$function($getVars); //panggil fungsi main pada kelas target
