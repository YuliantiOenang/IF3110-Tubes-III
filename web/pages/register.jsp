<%-- 
    Document   : register
    Created on : Nov 30, 2013, 10:32:24 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Resistrasi</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<script type="text/javascript" src="../scripts/register.js"></script>
	</head>
        
	<body>
		<!--Header-->
			<div id="header">
                            <jsp:include page="header.jsp" />
			</div>
			<!--Body-->
			<div id="task-page-body">
				<h1>REGISTRASI:</h1>
				<div id="register">
					Username:<br><br>
					Nama Lengkap:<br><br>
					No HP:<br><br>
					Alamat:<br><br>
					Provinsi:<br><br>
					Kabupaten:<br><br>
					Kode Pos:<br><br>
					Password:<br><br>
					Confirm Password:<br><br>
					Email:
				</div>
				<div id="register-form">
				<form  enctype="multipart/form-data" method="post" action="register">
					<!--UserName-->
					<div id="spacing-username">
					<input type="text" id="username" onKeyUp="checker()" name="textusername" value=""/><br /><br /><br />
					</div>
					<!--Name-->
					<div id="spacing-nama">
					<input type="text" id="namalengkap" onKeyUp="checker()" name="textnamalengkap" value=""/> <br /><br />
					</div>
					<!--HP-->
					<div id="spacing-hp">
					<input type="text" id="HP" onKeyUp="checker()" name="textHP" value=""/> <br /><br />
					</div>
					<!--Alamat-->
					<div id="spacing-alamat">
					<input type="text" id="alamat" onKeyUp="checker()" name="textalamat" value=""/> <br /><br />
					</div>
					<!--Provinsi-->
					<div id="spacing-provinsi">
					<input type="text" id="provinsi" onKeyUp="checker()" name="textprovinsi" value=""/> <br /><br />
					</div>
					<!--Kabupaten-->
					<div id="spacing-kabupaten">
					<input type="text" id="kabupaten" onKeyUp="checker()" name="textkabupaten" value=""/> <br /><br />
					</div>
					<!--Pos-->
					<div id="spacing-pos">
					<input type="text" id="pos" onKeyUp="checker()" name="textpos" value=""/> <br /><br />
					</div>
					<!--Password-->
					<div id="spacing-password">
					<input type="password" id="password" onKeyUp="checker()" name="textpassword" value=""/> <br /><br /><br />
					</div>
					<!--Confirm Password-->
					<div id="spacing-confirmpassword">
					<input type="password" id="confirmpassword" onKeyUp="checker()" name="textconfirmpassword" value=""/><br /><br />
					</div>
					<!--Email-->
					<div id="spacing-email">
					<input type="text" id="email" onKeyUp="checker()" name="textemail" value=""/><br />
					</div>
					<div id="warning-message"></div>
					<button id="create">REGISTER</button>
				</form>
				</div>
			</div>
	</body>
</html>
