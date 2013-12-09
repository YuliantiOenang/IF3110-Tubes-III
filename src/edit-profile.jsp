
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
	<%@ include file="header.jsp" %>
	<c:choose>
		<c:when test="${empty username}">
		<%
			// New location to be redirected
			String site = new String("registrasi.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		%>
		</c:when>
		
		<c:when test="${not empty username}">
		<input type='hidden' name='iusername' id='iusername' value="<c:out value="${cookie.username.value}"/>" />
		<input type='hidden' name='ipassword' id='ipassword' value="<c:out value="${cookie.password.value}"/>" />
		<input type='hidden' name='iemail' id='iemail' value="<c:out value="${cookie.email.value}"/>" />
		<input type='hidden' name='inamalengkap' id='inamalengkap' value="<c:out value="${cookie.NamaLengkap.value}"/>" />
		<input type='hidden' name='inohp' id='inohp' value="<c:out value="${cookie.NomerHp.value}"/>" />
		<input type='hidden' name='iprovinsi' id='iprovinsi' value="<c:out value="${cookie.Provinsi.value}"/>" />
		<input type='hidden' name='ikotakabupaten' id='ikotakabupaten' value="<c:out value="${cookie.Kota.value}"/>" />
		<input type='hidden' name='ialamat' id='ialamat' value="<c:out value="${cookie.Alamat.value}"/>" />
		<input type='hidden' name='ikodepos' id='ikodepos' value="<c:out value="${cookie.KodePos.value}"/>" />

	

		<div id="form-registrasi" class="frame">
			<p id="registration-title">Your Profile</p>
			
			<div id="data-diri" class="frame">
				<img class="kolom-3 gambar" src="res/img/userpict_b.png" alt=""/>
				<div class="kolom-9 teks">
					
					
					<form id='profile' action='UpdateProfile' method='post' accept-charset='UTF-8' onsubmit = "return cekChangeData()">
						<div class="form-field">
							<p class="label">Username:</p>
							<p>
							<input name="username" title="minimal 5 karakter" id="username" required="required" onkeyup="cekvalidAll()" readonly value="<c:out value="${cookie.username.value}"/>" class="field-box kolom-12">
							</p>
						</div>
						
						<div class="form-field">
							<p class="label">Change Password :</p>
							<p>
								<input type='text' name='validasipassword' id='validasipassword' maxlength="10" value ="valid" readonly/>
								<input type = "password" name="password" title="minimal 8 karakter" id="password" oninput="!!(cekPassword() & cekCPassword())" required="required" onkeyup="cekvalidAll()" value="<c:out value="${cookie.password.value}"/>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Confirm Password :</p>
							<p>
								<input type='text' name='validasiCpassword' id='validasiCpassword' maxlength="10" value ="valid" readonly/>
								<input type = "password" name="cpassword" title="minimal 8 karakter" id="cpassword" oninput="cekCPassword()" required="required" onkeyup="cekvalidAll()" value="<c:out value="${cookie.password.value}"/>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Nama Lengkap :</p>
							<p>
								<input type='text' name='validasinamalengkap' id='validasinamalengkap' maxlength="10" value ="valid" readonly/>
								<input type='text' name='namalengkap' title ="lalala yeyeye" id='namalengkap' maxlength="50" required="required" onkeyup="!!(cekNamaDuaKata() & cekvalidAll())" value="<c:out value="${cookie.NamaLengkap.value}"/>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Email :</p>
							<p>
								<input type='text' name='email'  id='email' title = "cuman@contoh.com" maxlength="50" required="required" onkeyup="cekvalidAll()" value="<c:out value="${cookie.email.value}"/>" readonly class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">No HP :</p>
							<p>
								<input type='text' name='validasinohp' id='validasinohp' maxlength="10" value ="valid" readonly/>
								<input type='text' name='nohp' id='nohp' title="harus angka" maxlength="50" required="required" onkeyup="!!(ceknohp() & cekvalidAll())" value="<c:out value="${cookie.NomerHp.value}"/>" class="field-box kolom-12"/>
							</p>
						</div>

						<div class="form-field">
							<p class="label">Provinsi:</p>
							<p>
								<input type='text' name='provinsi' id='provinsi' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<c:out value="${cookie.Provinsi.value}"/>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Kota/Kabupaten:</p>
							<p>
								<input type='text' name='kotakabupaten' id='kotakabupaten' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<c:out value="${cookie.Kota.value}"/>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Alamat:</p>
							<p>
								<input type='text-area' name='alamat' id='alamat' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<c:out value="${cookie.Alamat.value}"/>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Kode Pos:</p>
							<p>
								<input type='text' name='kodepos' id='kodepos' pattern="[0-9]+[0-9]*" title="harus angka" maxlength="50" required="required" onkeyup="cekvalidAll()" value="<c:out value="${cookie.KodePos.value}"/>" class="field-box kolom-12"/>
							</p>
						</div>
						<div class="form-field">
							<p class="label">Jumlah Transaksi:</p>
							<p>
								<input type='text' name='JumlahTrans' id='JumlahTrans' value="<c:out value="${cookie.JumlahTransaksi.value}"/>" class="field-box kolom-12" readonly/>
							</p>
						</div>
						<input type='submit' id="btn-profile" class="btn" name='edit' value='edit' />
					</form>

				</div>
				
			</div>
			
		</div>
		</c:when>
		</c:choose>
	</div>
	

	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>	
	<script src="scriptmember.js"></script>
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 
	

</body>
</html>