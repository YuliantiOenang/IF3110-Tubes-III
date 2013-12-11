<!DOCTYPE HTML>
<html>
	<head>
		<TITLE>RUSERBA</TITLE>
		<link href="style.css" rel="stylesheet" type="text/css">
		<script src="ModalPopupWindow.js" type="text/javascript"></script>
		</head>
	<body>
		<div id="container">
			<div id="header">
				<a href="index-admin.php"><img src="logo_.png" alt="Tulisan Apa Gitu"></a>
				<div class="Horizlinks">
					<ul>
						<?php
							$state = 0;
//							include "json-decode.php";
//							$i = 0;
							
							//	echo '<li><a href=kategori.php?id=',$site,'>',$decoded[$i],'</a></li>';
							//	$i = $i + 1;
							/*include('database_connection.php'); // Connects to your Database 
							$data = mysql_query("SELECT DISTINCT category FROM catalog_product", $link) or die(mysql_error()); 
							while($info = mysql_fetch_array( $data )){
								if ($info['category']=="Alat Tulis") {
									$site="alattulis.php";
								}
								else if ($info['category']=="Daging") {
									$site="daging.php";
								}
								else if ($info['category']=="Buah") {
									$site="buah.php";
								}
								else if ($info['category']=="Sayur") {
									$site="sayur.php";
								}
								else if ($info['category']=="Pakaian") {
									$site="pakaian.php";
								}
								echo '<li><a href=',$site,'>',$info['category'],'</a></li>';
							}*/
	 					?> 
						<li id="li1"> </li>
						<li id="li2"> </li>
					</ul>
				</div>
			</div>
		</div>
	<script type="text/javascript">
			modalWin = new CreateModalPopUpObject();
			var a = "<form method=\"post\" action=\"login-admin.php\"> login: <input type=\"text\" id=\"username\" name=\"username7\"><br>pass: <input type=\"password\" id=\"password\" name=\"password\"><br><input name=\"login\" type=\"submit\" value=\"login\" id=\"login\"/></form>";
			function dipanggil(){
				modalWin.ShowMessage(a,200,300,'Login');
			}
				if (localStorage.login) {
					var login=localStorage.getItem('login');
					document.getElementById("li1").innerHTML="<a href=\"add-barang.php\"> Add </a>";
					document.getElementById("li2").innerHTML="<a href=\"logout_admin.php\"> Logout </a>";
				} else {
					document.getElementById("li1").innerHTML="<a href=\"javascript:dipanggil();\"> Login </a>";
					document.getElementById("li2").innerHTML="";
				}
		</script>