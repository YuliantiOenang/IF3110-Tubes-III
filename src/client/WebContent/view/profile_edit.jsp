<%@ page import="javaModel.Profile" %>
<%@ page import="javaModel.Helper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<% Profile P = (Profile) request.getAttribute("profile"); %>

<form method="post">
	<div class='register_div'>
		<h1 class='header'>Edit Profile</h1>
		<div class="per_form">
			<label>Nama Lengkap</label><input type="text" value="<%= P.nama.get(0) %>" name="prof_nama" id="nama" required onkeyup="Register.cekNama()">
			<span class="error" id="error-nama"></span>
		</div>
		<div class="per_form">
			<label>Username</label><input type="text" value="<%= P.username.get(0) %>" id="username" disabled="disabled">
		</div>
		<div class="per_form">
			<label>Email</label><input type="text" value="<%= P.email.get(0) %>" id="email" disabled="disabled">
		</div>
		<div class="per_form">
			<label>Password Baru</label><input type="password" value="" name="prof_password" id="password" onkeyup="Register.cekPassword()">
			<span class="error" id="error-password"></span>
		</div>
		<div class="per_form">
			<label>Confirm Pass.</label><input type="password" value="" name="prof_confirm" id="confirm" onkeyup="Register.cekConfirm()">
			<span class="error" id="error-confirm"></span>
		</div>
	</div>
	<div class='register_div'>
		<div class="per_form">
			<label>Alamat</label><input type="text" value="<%= P.alamat.get(0) %>" name="prof_alamat" id="alamat" required>
			<span id="error-alamat"></span>
		</div>
		<div class="per_form">
			<label>Provinsi</label>
			<select name="prof_provinsi" id="provinsi" required>
				<option value="">Pilih Provinsi :</option>
				<% ArrayList<String> provinsi = new ArrayList<String>(Arrays.asList("Aceh","Bali","Bangka Belitung","Banten","Bengkulu","Gorontalo","Jakarta","Jambi","Jawa Barat","Jawa Tengah","Jawa Timur","Kalimantan Barat","Kalimantan Selatan","Kalimantan Tengah","Kalimantan Timur","Kepulauan Riau","Lampung","Maluku","Maluku Utara","Nusa Tenggara Barat","Nusa Tenggara Timur","Papua","Papua Barat","Riau","Sulawesi Barat","Sulawesi Selatan","Sulawesi Tengah","Sulawesi Tenggara","Sulawesi Utara","Sumatera Barat","Sumatera Selatan","Sumatera Utara","Yogyakarta")); %>
				<% for (String prof : provinsi) { %>
					<option <% if (prof.equals(P.provinsi.get(0))) { %>selected="selected"<% } %>><%= prof %></option>
				<% } %>
			</select>
			<span id="error-provinsi"></span>
		</div>
		<div class="per_form">
			<label>Kota</label><input type="text" value="<%= P.kota.get(0) %>" name="prof_kota" id="kota" required>
			<span id="error-kota"></span>
		</div>
		<div class="per_form">
			<label>Kode Pos</label><input type="text" value="<%= P.kodepos.get(0) %>" name="prof_kodepos" id="kodepos" required>
			<span id="error-kodepos"></span>
		</div>
		<div class="per_form">
			<label>Telepon</label><input type="text" value="<%= P.telepon.get(0) %>" name="prof_telepon" id="telepon" required>
			<span id="error-telepon"></span>
		</div>
		<button type="submit" id="btn" onclick="return Register.compareDefault()" class="btn">Simpan</button>
	</div>
</form>


<script src="/ruserba/js/register.js"></script>
<script>
	var server = "";
	var defaultForm = {};
	for (var key in Register.validForm) {
		if (Register.validForm.hasOwnProperty(key)) {
			defaultForm[key] = document.getElementById(key).value;
		}
	}
</script>