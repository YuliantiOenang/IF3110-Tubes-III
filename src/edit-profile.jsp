<%

	String username = "";
    String password= "";
	String email= "";
	String namalengkap= "";
	String nohp= "";
	String provinsi= "";
	String kotakabupaten= "";
	String alamat= "";
	String kodepos= "";
	String nocredit= "";
	String jumlahtransaksi="";
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
	
	if(valuelagi==null){ 
		response.sendRedirect("registrasi.jsp");
	}else{
		if ( (String)session.getAttribute("email")==null){
			response.sendRedirect("getdatamember");
		}else{ 
			username = (String)session.getAttribute("username");
			password = (String)session.getAttribute("password");
			email= (String)session.getAttribute("email");
			namalengkap = (String)session.getAttribute("namalengkap");
			nohp= (String)session.getAttribute("nohp");
			provinsi= (String)session.getAttribute("provinsi");
			kotakabupaten= (String)session.getAttribute("kotakabupaten");
			alamat=(String)session.getAttribute("alamat");
			kodepos=(String)session.getAttribute("kodepos");
			jumlahtransaksi=(String)session.getAttribute("jumlahtransaksi");			
		}
		
	}
%> 


<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Profile</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
	<jsp:include page="header.jsp"/>
		

		<input type='hidden' name='iusername' id='iusername' value="<% out.print(username);%>" />
		<input type='hidden' name='ipassword' id='ipassword' value="<% out.print(password);%>" />
		<input type='hidden' name='iemail' id='iemail' value="<% out.print(email);%>" />
		<input type='hidden' name='inamalengkap' id='inamalengkap' value="<% out.print(namalengkap);%>" />
		<input type='hidden' name='inohp' id='inohp' value="<% out.print(nohp);%>" />
		<input type='hidden' name='iprovinsi' id='iprovinsi' value="<% out.print(provinsi);%>" />
		<input type='hidden' name='ikotakabupaten' id='ikotakabupaten' value="<% out.print(kotakabupaten);%>" />
		<input type='hidden' name='ialamat' id='ialamat' value="<% out.print(alamat);%>" />
		<input type='hidden' name='ikodepos' id='ikodepos' value="<% out.print(kodepos);%>" />

	

		<div id="form-registrasi" class="frame">
			<p id="registration-title">Your Profile</p>
			
			<div id="data-diri" class="frame">
				<img class="kolom-3 gambar" src="res/img/userpict_b.png" alt=""/>
				<div class="kolom-9 teks">
					
					
					<form id='profile' action='UpdateServlet' method='post' accept-charset='UTF-8' onsubmit = "return cekChangeData()">
						<div class="form-field">
							<p class="label">Username:</p>
							<p>
							<input name="eusername" title="minimal 5 karakter" id="eusername" required="required" onkeyup="cekvalidAll()" readonly value="<% out.print(username);%>" class="field-box kolom-12">
							</p>
						</div>
						
						<div class="form-field">
							<p class="label">Change Password :</p>
							<p>
								<input type='text' name='validasipassword' id='validasipassword' maxlength="10" value ="valid" readonly/>
								<input type = "password" name="epassword" title="minimal 8 karakter" id="epassword" oninput="!!(cekPassword() & cekCPassword())" required="required" onkeyup="cekvalidAll()" value="<% out.print(password);%>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Confirm Password :</p>
							<p>
								<input type='text' name='validasiCpassword' id='validasiCpassword' maxlength="10" value ="valid" readonly/>
								<input type = "password" name="cpassword" title="minimal 8 karakter" id="cpassword" oninput="cekCPassword()" required="required" onkeyup="cekvalidAll()" value="<% out.print(password);%>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Nama Lengkap :</p>
							<p>
								<input type='text' name='validasinamalengkap' id='validasinamalengkap' maxlength="10" value ="valid" readonly/>
								<input type='text' name='namalengkap' title ="lalala yeyeye" id='namalengkap' maxlength="50" required="required" onkeyup="!!(cekNamaDuaKata() & cekvalidAll())" value="<% out.print(namalengkap);%>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Email :</p>
							<p>
								<input type='text' name='email'  id='email' title = "cuman@contoh.com" maxlength="50" required="required" onkeyup="cekvalidAll()" value="<%out.print(email);%>" readonly class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">No HP :</p>
							<p>
								<input type='text' name='validasinohp' id='validasinohp' maxlength="10" value ="valid" readonly/>
								<input type='text' name='nohp' id='nohp' title="harus angka" maxlength="50" required="required" onkeyup="!!(ceknohp() & cekvalidAll())" value="<% out.print(nohp);%>" class="field-box kolom-12"/>
							</p>
						</div>

						<div class="form-field">
							<p class="label">Provinsi:</p>
							<p>
								<input type='text' name='provinsi' id='provinsi' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<% out.print(provinsi);%>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Kota/Kabupaten:</p>
							<p>
								<input type='text' name='kotakabupaten' id='kotakabupaten' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<% out.print(kotakabupaten);%>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Alamat:</p>
							<p>
								<input type='text' name='alamat' id='alamat' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<% out.print(alamat);%>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Kode Pos:</p>
							<p>
								<input type='text' name='kodepos' id='kodepos' pattern="[0-9]+[0-9]*" title="harus angka" maxlength="50" required="required" onkeyup="cekvalidAll()" value="<% out.print(kodepos);%>" class="field-box kolom-12"/>
							</p>
						</div>
						
						jumlah transaksi <%out.print(jumlahtransaksi);%><br/>
						<input type='submit' id="btn-profile" class="btn" name='edit' value='edit' />
						
					</form>

				</div>
				
			</div>
			
		</div>
		
	</div>
	

	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>	
	<script src="scriptmember.js"></script>

</body>
</html>