<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
<form method="post">
	<div class="register_div">
		<h1 class="header">Register</h1>
		<div class="per_form">
			<label>Nama Lengkap</label><input type="text" required="" onkeyup="Register.cekNama()" value="" id="nama" name="reg_nama">
			<span id="error-nama" class="error"></span>
		</div>
		
		<div class="per_form">
			<label>Email</label><input type="text" required="" onkeyup="Register.cekEmail('<?=URLService;?>')" value="" id="email" name="reg_email">
			<span id="error-email" class="error"></span>
		</div>
		
		<div class="per_form">
			<label>Username</label><input type="text" required="" onkeyup="Register.cekUsername('<?=URLService;?>')" value="" id="username" name="reg_username">
			<span id="error-username" class="error"></span>
		</div>
		
		<div class="per_form">
			<label>Password</label><input type="password" required="" onkeyup="Register.cekPassword()" value="" :="" placeholderpassword="" id="password" name="reg_password">
			<span id="error-password" class="error"></span>
		</div>
		
		<div class="per_form">
			<label>Confirm Pass.</label><input type="password" required="" onkeyup="Register.cekConfirm()" value="" id="confirm" name="reg_confirm">
			<span id="error-confirm" class="error"></span>
		</div>
	</div>
	<div class="register_div">
		<div class="per_form small">
			<label class="uncheck">Alamat</label><input type="text" required="" value="" id="alamat" name="reg_alamat">
			<span id="error-alamat"></span>
		</div>
		
		<div class="per_form small">
			<label>Provinsi</label>
			<select required="" id="provinsi" name="reg_provinsi" value="">
				<option value="">Pilih Provinsi :</option>
				
				
					<option>Aceh</option>
				
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
		
		<div class="per_form small">
			<label class="uncheck">Kota/Kabupaten</label><input type="text" required="" value="" id="kota" name="reg_kota">
			<span id="error-kota"></span>
		</div>
		
		<div class="per_form small">
			<label class="uncheck">Kodepos</label><input type="text" required="" onkeyup="Register.cekKodepos()" value="" id="kodepos" name="reg_kodepos">
			<span id="error-kodepos"></span>
		</div>
		
		<div class="per_form small">
			<label class="uncheck">Telepon</label><input type="text" required="" onkeyup="Register.cekTelepon()" value="" id="telepon" name="reg_telepon">
			<span id="error-telepon"></span>
		</div>	
		<p class="keterangan">Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet</p>
		<button class="btn" disabled="disabled" id="btn" type="submit">Daftar</button>
	</div><br>
</form>
<script src="js/register.js"></script>
<script>
	var server = "";
</script>
			</div>
		</div>
<?php
require_once('footer.php');
?>
