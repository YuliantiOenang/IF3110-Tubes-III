<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user=="admin") {
				window.location = "indexadmin.php"
			}
		</script>
		<script>
			if (localStorage.user==null) {
				window.location = "register.php";
			}
			function AJAXcard() {
				var username=localStorage.user;
				var cardno=document.forms["card"]["cardno"].value;
				var nameoncard=document.forms["card"]["nameoncard"].value;
				var expdate=document.forms["card"]["expdate"].value;
				var xmlhttp;
				if (window.XMLHttpRequest)
					{// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp=new XMLHttpRequest();
				}
				else
					{// code for IE6, IE5
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.open("GET","AJAXcard.php?username="+username+"&cardno="+cardno+"&nameoncard="+nameoncard+"&expdate="+expdate,false);
				xmlhttp.send();
				if (xmlhttp.responseText.trim()=="true") {
					alert("Registrasi kartu kredit berhasil");
					window.location="index.php";
				}
				else {
					alert("Card no / Name on card sudah pernah digunakan");
				}
			}
		</script>
		<script language="javaScript" type="text/javascript" src="calendar.js"></script>
		<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middle.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Registrasi Kartu Kredit</h2>
		<form name="card">
			Card no: <br><input type="text" name="cardno"><br>
			Name on card: <br><input type="text" name="nameoncard"><br>
			Expire date: <br><input type="date" name="expdate">
			<br>
			<button id="submit" type="button" onclick="AJAXcard()">OK</button>
			<a href="index.php"><button type="button">Skip</button></a>
		</form>
		
		
		
		</div>
		</div>
	</body>
</html>