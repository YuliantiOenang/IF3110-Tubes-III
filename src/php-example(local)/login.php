<!-- <!DOCTYPE html>
<html>
	<head> -->
		<link href="style.css" rel="stylesheet" type="text/css">
		<script src="ModalPopupWindow.js" type="text/javascript"></script>
		<script type="text/javascript">
			modalWin = new CreateModalPopUpObject();
			var a = "<form method=\"post\" action=\"checklogin.php\"> username: <input type=\"text\" id=\"username\" name=\"username\"><br>password: <input type=\"text\" id=\"password\" name=\"password\"><br><input name=\"login\" type=\"submit\" value=\"login\" id=\"login\"/></form>";
			function dipanggil(){
				modalWin.ShowMessage(a,200,300,'Login');
			}
			function load(){
				var username=localStorage.getItem('username');
				if (username=='undefined') {
					document.getElementById("status1").innerHTML="<a href=\"javascript:dipanggil();\"> Login </a>";
					document.getElementById("status2").innerHTML="<a href=\"registrasi_identitas.php\"> Register </a>";
				} else {
					document.getElementById("status1").innerHTML="<a href=\"javascript:dipanggil();\"> Logout </a>";
					document.getElementById("status2").innerHTML="<a href=\"registrasi_identitas.php\"> Hello </a>";
				}
			}
		</script>
	<!-- </head> -->
	<!-- <body onLoad="load();"> -->
		<!-- <li><a href="javascript:dipanggil();"> Login </a><li><a href="registrasi_identitas.php"> Register </a><li> -->
	<div onLoad="load()"></div>
	<li id="status1"> </li>
	<li id="status2"> </li>
	<!-- </body>
</html> -->