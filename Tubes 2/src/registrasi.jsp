<%
	String name="";
	String value="";
	String valuelagi=null;
	Cookie[] cookies = request.getCookies();
	if (cookies!=null){
	for (int i = 0; i < cookies.length; i++) {
		Cookie c = cookies[i];
		name = c.getName();
		value = c.getValue();
		
		if (name.equals("username")){
			valuelagi=value;
		}
		session.setAttribute(name, value); 
	}
	}
	
	if(valuelagi!=null){ 
		response.sendRedirect("index.jsp");
	}
		
%>
 
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Registrasi</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
		<jsp:include page="header.jsp"/>
		

		<div id="form-registrasi" class="frame">
			<p id="registration-title">Registration</p>
			

			<form id='register' action='insertdata' method='post' accept-charset='UTF-8' onsubmit = "">
			
				<div class="form-field">
					<p class="label">Username :</p>
					<p>
					<input type='text' name='validasiusername' id='validasiusername' maxlength="10" value ="tidak valid" readonly/>
					<input name="rusername" title="minimal 5 karakter" id="rusername" required="required" onkeyup="!!(cekusername() & cekvalidAll())" class="field-box kolom-12"/>
					</p>
				</div>
				
				<div class="form-field">
					<p class="label">Password :</p>
					<p>
					<input type='text' name='validasipassword' id='validasipassword' maxlength="10" value ="tidak valid" readonly/>
					<input type = "password" name="rpassword" title="minimal 8 karakter" id="rpassword" oninput="!!(cekPassword() & cekCPassword())" required="required" onkeyup="cekvalidAll()" class="field-box kolom-12"/>
					</p>
				</div>				

				<div class="form-field">
					<p class="label">Password(retype) :</p>
					<p>
					<input type='text' name='validasiCpassword' id='validasiCpassword' maxlength="10" value ="tidak valid" readonly/>
					<input type = "password" name="cpassword" title="minimal 8 karakter" id="cpassword" oninput="cekCPassword()" required="required" onkeyup="cekvalidAll()" class="field-box kolom-12"/>
					</p>
				</div>		
				
				<div class="form-field">
					<p class="label">Nama Lengkap :</p>
					<p><input type='text' name='validasinamalengkap' id='validasinamalengkap' maxlength="10" value ="tidak valid" readonly/>
					<input type='text' name='namalengkap' title ="lalala yeyeye" id='namalengkap' maxlength="50" required="required" onkeyup="!!(cekNamaDuaKata() & cekvalidAll())" class="field-box kolom-12"/>
					</p>
				</div>
				
				<div class="form-field">
					<p class="label">Email :</p>
					<p>
					<input type='text' name='validasiemail' id='validasiemail' maxlength="10" value ="tidak valid" readonly/>
					<input type='text' name='email'  id='email' title = "cuman@contoh.com" maxlength="50" required="required" onkeyup="!!(cekEmail() & cekvalidAll())" class="field-box kolom-12"/>
					</p>
				</div>
				
				<div class="form-field">
					<p class="label">Handphone :</p>
					<p>
					<input type='text' name='validasinohp' id='validasinohp' maxlength="10" value ="tidak valid" readonly/>
					<input type='text' name='nohp' id='nohp' title="harus angka" maxlength="50" required="required" onkeyup="!!(ceknohp() & cekvalidAll())" class="field-box kolom-12"/>
					</p>
				</div>
				
				<div class="form-field">
					<p class="label">Provinsi :</p>
					<p><input type='text' name='provinsi' id='provinsi' maxlength="50" required="required" onkeyup="cekvalidAll()" class="field-box kolom-12"/></p>
				</div>
				
				<div class="form-field">
					<p class="label">Kota/Kabupaten :</p>
					<p><input type='text' name='kotakabupaten' id='kotakabupaten' maxlength="50" required="required" onkeyup="cekvalidAll()" class="field-box kolom-12"/></p>
				</div>
				
				<div id="alamat" class="form-field">
					<p class="label">Alamat :</p>					
					<input type='text' name='alamat' id='alamat' maxlength="50" required="required" onkeyup="cekvalidAll()" class="field-box kolom-12 field-area"></textarea>
				</div>
				
				
				<div class="form-field">
					<p class="label">Kode Pos :</p>
					<p><input type='text' name='kodepos' id='kodepos' pattern="[0-9]+[0-9]*" title="harus angka" maxlength="50" required="required" onkeyup="cekvalidAll()" value="" class="field-box kolom-12"/></p>
				</div>
				



				<br/>
				<input type='submit' id="submitbutton"  class="btn" name='register' value='Register' disabled==false />
			</form>
		</div>
		
	</div>
	

	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>	
	<script src="scriptregister.js"></script>
	<script src="AjaxRegister.js"></script>
	

</body>
</html>