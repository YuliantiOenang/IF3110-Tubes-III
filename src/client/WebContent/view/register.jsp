<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Arrays" %>
<form method="post">
	<div class='register_div'>
		<h1 class='header'>Register</h1>
		<div class='per_form'>
			<label>Nama Lengkap</label><input type="text" name="reg_nama" id="nama" value="" onkeyup="Register.cekNama()" required>
			<span class='error' id="error-nama"></span>
		</div>
		
		<div class='per_form'>
			<label>Email</label><input type="text" name="reg_email" id="email" value="" onkeyup="Register.cekEmail()" required>
			<span class='error' id="error-email"></span>
		</div>
		
		<div class='per_form'>
			<label>Username</label><input type="text" name="reg_username" id="username" value="" onkeyup="Register.cekUsername()"required>
			<span class='error' id="error-username"></span>
		</div>
		
		<div class='per_form'>
			<label>Password</label><input type="password" name="reg_password" id="password" placeholderPassword : ="" value="" onkeyup="Register.cekPassword()" required>
			<span class='error' id="error-password"></span>
		</div>
		
		<div class='per_form'>
			<label>Confirm Pass.</label><input type="password" name="reg_confirm" id="confirm" value="" onkeyup="Register.cekConfirm()" required>
			<span class='error' id="error-confirm"></span>
		</div>
	</div>
	<div class='register_div'>
		<div class='per_form small'>
			<label class='uncheck'>Alamat</label><input type="text" name="reg_alamat" id="alamat" value="" required>
			<span id="error-alamat"></span>
		</div>
		
		<div class='per_form small'>
			<label>Provinsi</label>
			<select value="" name="reg_provinsi" id="provinsi" required="">
				<option value="">Pilih Provinsi :</option>
				<% ArrayList<String> provinsi = new ArrayList<String>(Arrays.asList("Aceh","Bali","Bangka Belitung","Banten","Bengkulu","Gorontalo","Jakarta","Jambi","Jawa Barat","Jawa Tengah","Jawa Timur","Kalimantan Barat","Kalimantan Selatan","Kalimantan Tengah","Kalimantan Timur","Kepulauan Riau","Lampung","Maluku","Maluku Utara","Nusa Tenggara Barat","Nusa Tenggara Timur","Papua","Papua Barat","Riau","Sulawesi Barat","Sulawesi Selatan","Sulawesi Tengah","Sulawesi Tenggara","Sulawesi Utara","Sumatera Barat","Sumatera Selatan","Sumatera Utara","Yogyakarta")); %>
				<% for (String prof : provinsi) { %>
					<option><%= prof %></option>
				<% } %>
			</select>
			<span id="error-provinsi"></span>
		</div>
		
		<div class='per_form small'>
			<label class='uncheck'>Kota/Kabupaten</label><input type="text" name="reg_kota" id="kota" value=""  required>
			<span id="error-kota"></span>
		</div>
		
		<div class='per_form small'>
			<label class='uncheck'>Kodepos</label><input type="text" name="reg_kodepos" id="kodepos" value="" onkeyup="Register.cekKodepos()" required>
			<span id="error-kodepos"></span>
		</div>
		
		<div class='per_form small'>
			<label class='uncheck'>Telepon</label><input type="text" name="reg_telepon" id="telepon" value="" onkeyup="Register.cekTelepon()" required>
			<span id="error-telepon"></span>
		</div>	
		<p class='keterangan'>Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet</p>
		<button type="submit" id="btn" disabled="disabled" class="btn">Daftar</button>
	</div><br/>
</form>
<script src="js/register.js"></script>
<script>
	var server = "";
</script>