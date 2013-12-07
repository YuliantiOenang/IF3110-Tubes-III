<?php
	if (isset($_COOKIE['isLogin']))
	{
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
		<form method="post">
	<div class="register_div">
		<h1 class="header">Edit Profile</h1>
		<div class="per_form">
			<label>Nama Lengkap</label><input type="text" onkeyup="Register.cekNama()" required="" id="nama" name="prof_nama" value="habibie faried">
			<span id="error-nama" class="error"></span>
		</div>
		<div class="per_form">
			<label>Username</label><input type="text" disabled="disabled" id="username" value="habibie">
		</div>
		<div class="per_form">
			<label>Email</label><input type="text" disabled="disabled" id="email" value="sdasdas@as.com">
		</div>
		<div class="per_form">
			<label>Password Baru</label><input type="password" onkeyup="Register.cekPassword()" id="password" name="prof_password" value="">
			<span id="error-password" class="error"></span>
		</div>
		<div class="per_form">
			<label>Confirm Pass.</label><input type="password" onkeyup="Register.cekConfirm()" id="confirm" name="prof_confirm" value="">
			<span id="error-confirm" class="error"></span>
		</div>
	</div>
	<div class="register_div">
		<div class="per_form">
			<label>Alamat</label><input type="text" required="" id="alamat" name="prof_alamat" value="Jl. pelesiran 6">
			<span id="error-alamat"></span>
		</div>
		<div class="per_form">
			<label>Provinsi</label>
			<select required="" id="provinsi" name="prof_provinsi">
				<option value="">Pilih Provinsi :</option>
				
				
					<option selected="selected">Aceh</option>
				
					<option>Bali</option>
				
					<option>Bangka Belitung</option>
				
					<option>Banten</option>
				
					<option>Bengkulu</option>
				
					<option>Gorontalo</option>
				
					<option>Jakarta</option>
				
					<option>Jambi</option>
				
					<option>Jawa Barat</option>
				
					<option>Jawa Tengah</option>
				
					<option>Jawa Timur</option>
				
					<option>Kalimantan Barat</option>
				
					<option>Kalimantan Selatan</option>
				
					<option>Kalimantan Tengah</option>
				
					<option>Kalimantan Timur</option>
				
					<option>Kepulauan Riau</option>
				
					<option>Lampung</option>
				
					<option>Maluku</option>
				
					<option>Maluku Utara</option>
				
					<option>Nusa Tenggara Barat</option>
				
					<option>Nusa Tenggara Timur</option>
				
					<option>Papua</option>
				
					<option>Papua Barat</option>
				
					<option>Riau</option>
				
					<option>Sulawesi Barat</option>
				
					<option>Sulawesi Selatan</option>
				
					<option>Sulawesi Tengah</option>
				
					<option>Sulawesi Tenggara</option>
				
					<option>Sulawesi Utara</option>
				
					<option>Sumatera Barat</option>
				
					<option>Sumatera Selatan</option>
				
					<option>Sumatera Utara</option>
				
					<option>Yogyakarta</option>
				
			</select>
			<span id="error-provinsi"></span>
		</div>
		<div class="per_form">
			<label>Kota</label><input type="text" required="" id="kota" name="prof_kota" value="kenangan">
			<span id="error-kota"></span>
		</div>
		<div class="per_form">
			<label>Kode Pos</label><input type="text" required="" id="kodepos" name="prof_kodepos" value="11111">
			<span id="error-kodepos"></span>
		</div>
		<div class="per_form">
			<label>Telepon</label><input type="text" required="" id="telepon" name="prof_telepon" value="08213121">
			<span id="error-telepon"></span>
		</div>
		<button class="btn" onclick="return Register.compareDefault()" id="btn" type="submit">Simpan</button>
	</div>
</form>


<script src="js/register.js"></script>
<script>
	var server = "";
	var defaultForm = {};
	for (var key in Register.validForm) {
		if (Register.validForm.hasOwnProperty(key)) {
			defaultForm[key] = document.getElementById(key).value;
		}
	}
</script>
			</div>
		</div>
		<?php
require_once('footer.php');
}else
{
	header("Location: register.php");
}
?>
