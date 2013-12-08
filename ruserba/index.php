<!DOCTYPE HTML>
<?php session_start(); 
$rest = "http://ditra77.ap01.aws.af.cm";
ini_set('max_execution_time', 300);
?>

<html>
<head>
	<?php include 'scripts/php/page.php'; ?>
	<title><?php echo getPageTitle(); ?></title>
	<link rel='icon' type='image/png' href='/ruseba/assets/favicon.png' />
	<link rel='stylesheet' media='only screen and (min-width:1224px)' href='/ruserba/stylesheets/desktop.css' />
</head>
<body>
	<div id='wrapper'>
		<div id='header'><?php include 'pages/header.php'; ?></div>
		<div class='divider'></div>
		<div id='content'>
			<?php include getPageContent(); ?>
		</div>
		<div class='divider'></div>
		<div id='footer'><?php include 'pages/footer.php'; ?></div>
		<br /><br /><br /><br /><br /><br />
	</div>
</body>
</html>