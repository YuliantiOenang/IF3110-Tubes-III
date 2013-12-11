<jsp:include page="contentBegin.jsp"></jsp:include>

<form method="post" action="${pageContext.request.contextPath}/SubmitRegister">
	<div class='register_div'>
		<h1 class='header'>Register</h1>
		<div class='per_form'>
			<label>Nama Lengkap</label><input type="text" name="Register[nama]" id="nama" value="" onkeyup="Register.cekNama()" required> <!-- <?php echo $model->nama ?> -->
			<span class='error' id="error-nama"></span>
		</div>
		
		<div class='per_form'>
			<label>Email</label><input type="text" name="Register[email]" id="email" value="" onkeyup="Register.cekEmail()" required> <!-- <?php echo $model->email ?> -->
			<span class='error' id="error-email"></span>
		</div>
		
		<div class='per_form'>
			<label>Username</label><input type="text" name="Register[username]" id="username" value="" onkeyup="Register.cekUsername()"required> <!-- <?php echo $model->username ?> -->
			<span class='error' id="error-username"></span>
		</div>
		
		<div class='per_form'>
			<label>Password</label><input type="password" name="Register[password]" id="password" placeholderPassword : ="" value="" onkeyup="Register.cekPassword()" required> <!-- <?php echo $model->password ?> -->
			<span class='error' id="error-password"></span>
		</div>
		
		<div class='per_form'>
			<label>Confirm Pass.</label><input type="password" name="Register[confirm]" id="confirm" value="" onkeyup="Register.cekConfirm()" required> <!-- <?php echo $model->confirm ?> -->
			<span class='error' id="error-confirm"></span>
		</div>
	</div>
	<div class='register_div'>
		<div class='per_form small'>
			<label class='uncheck'>Alamat</label><input type="text" name="Register[alamat]" id="alamat" value="" required> <!-- <?php echo $model->alamat ?> -->
			<span id="error-alamat"></span>
		</div>
		
		<div class='per_form small'>
			<label>Provinsi</label>
			<select value="" name="Register[provinsi]" id="provinsi" required> <!-- <?php echo $model->provinsi ?> -->
				<option value="">Pilih Provinsi</option>
				<%
  				String[] provinsi = {"Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Jambi", "Sumatera Selatan", "Lampung", "Bengkulu", "Bangka Belitung", "Kepulauan Riau", "Jakarta", "Jawa Barat", "Jawa Tengah", "Yogyakarta", "Jawa Timur", "Banten", "Bali", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Timur", "Kalimantan Tengah", "Kalimantan Selatan", "Sulawesi Utara", "Sulawesi Tengah", "Sulawesi Selatan", "Sulawesi Tenggara", "Gorontalo", "Sulawesi Barat", "Maluku", "Maluku Utara", "Papua", "Papua Barat"};		
  				for (String str : provinsi){
				%>
					<option value="<% out.print(str); %>"><% out.print(str); %></option>
  				<%
				}  
				%>
			</select>
			<span id="error-provinsi"></span>
		</div>
		
		<div class='per_form small'>
			<label class='uncheck'>Kota/Kabupaten</label><input type="text" name="Register[kota]" id="kota" value=""  required> <!-- <?php echo $model->kota ?> -->
			<span id="error-kota"></span>
		</div>
		
		<div class='per_form small'>
			<label class='uncheck'>Kodepos</label><input type="text" name="Register[kodepos]" id="kodepos" value="" onkeyup="Register.cekKodepos()" required> <!-- <?php echo $model->kodepos ?> -->
			<span id="error-kodepos"></span>
		</div>
		
		<div class='per_form small'>
			<label class='uncheck'>Telepon</label><input type="text" name="Register[telepon]" id="telepon" value="" onkeyup="Register.cekTelepon()" required> <!-- <?php echo $model->telepon ?> -->
			<span id="error-telepon"></span>
		</div>	
		<p class='keterangan'>aLorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet</p>
		<button type="submit" id="btn" disabled="disabled" class="btn">Daftar</button>
	</div><br/>
</form> <!-- <?php echo $this->getBaseUrl() ?> -->
<% out.print("<script>var server = '" + request.getContextPath() + "';</script>"); %>
<script src="${pageContext.request.contextPath}/js/register.js"></script>
<!-- <?php echo Template::getBaseUrl() ?> -->
<jsp:include page="contentEnd.jsp"></jsp:include>