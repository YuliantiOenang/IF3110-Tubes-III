<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>RuSerBa</title>
	<link rel="stylesheet" href="css/header.css" type="text/css" />
	<link rel="stylesheet" href="css/main.css" type="text/css" /> 
</head>
<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
	<header id="banner" class="body">
	<span style="float:left"><a href="index.php"><img src="images/logo.png" alt="RuSerBa Logo" width="110" height="110"/></a></span>
	<h1><span><a href="index.php">RuSerBa<br><strong>Ruko Serba Ada</strong></a></span></h1>
 	<nav><ul id="menubar">
		<li><a href="index.php">Home</a></li>
		<li><a href="halamanbarang.php" onmouseover="slidedown(true)" onmouseup="slidedown(false)">Kategori Barang</a>
			<ul class="sub-menu">	
			<?php
			//meminta daftar kategori barang dengan REST
			$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restkategori.php';
			$curl = curl_init($service_url);
			curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
			$curl_response = curl_exec($curl);
			if ($curl_response === false) {
				$info = curl_getinfo($curl);
				curl_close($curl);
				die('error occured during curl exec. Additioanl info: ' . var_export($info));
			}
			curl_close($curl);
			$decoded = json_decode($curl_response);
			for($i=0;$i<sizeof($decoded);$i++){
				echo '<li><a href="halamanbarang.php?kategori='.$decoded[$i].'">'.$decoded[$i].'</a></li>';
			}
			?>
			</ul>
		</li>
		<div id="log"></div>
		<li><a href="shoppingbag.php">Shopping Bag</a></li>
		<div id="searchbar" style="float:right">
		<li><input type="text" name="search" id="cari" placeholder="Cari Barang" onkeyup="searchsuggest(cari.value)" onblur="resetsuggest()">
			<ul class="suggestion" id="cariyu">	
			</ul>
		</li>
		<li><button type="button" onclick="resetsearch();search(cari.value,1);">Search</button></li>
		</div>
	</ul></nav>
	</header><!-- /#banner -->
	<!-- buat animasi kotak login user -->
	<div id='mbox' style='display:none;'></div>
	<div id='back_mbox' style='display:none;'></div><div id='fade_mbox' style='display:none;'></div>
	<!-- kotak user login -->
	<div id="userlogin">
	<form method="post">
		<pre><span id="errorInfo"><span/></pre>
		<pre>Username		<input type="text" id="username" name="username"></pre>
		<pre>Password		<input type="password" id="password" name="password"></pre>
		<input type="button" value="Login" onclick="auth(username.value,password.value)"> <a href="registerform.php">Daftar baru!</a>
	</form>
	</div>
	<div id="patrick"><img src="images/patrick.gif" width="20%" height="20%"></div>
	<!-- import script dari file javascript -->
	<script src="javascript/header.js"></script>