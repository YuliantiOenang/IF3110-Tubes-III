<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<?php echo SITEURL . '/include/css/style.css' ?>">
	<link rel="stylesheet" type="text/css" href="<?php echo SITEURL . '/include/css/login.css' ?>">
	<link rel="stylesheet" type="text/css" href="<?php echo SITEURL . '/include/css/register.css' ?>">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Nunito">

	<?php
		//default title
		if (!isset($title)) {
			$title = 'Toko Online Komplit';
		}
	?>
	<title><?php echo $title?></title>
</head>