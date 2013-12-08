<script src='/ruserba/scripts/profile.js'></script>
<div class='formcontainer'>
	<h2 id='formtitle'></h2>
	<br />
	<form id='formprofile' method='post'>
		<?php
			echo '<input type="hidden" name="username" value ="'.$_SESSION['username'].'">';
			echo '<input type="hidden" name="name_old" value ="'.$_SESSION['nama'].'">';
			echo '<input type="hidden" name="password_old" value ="'.$_SESSION['password'].'">';
			echo '<input type="hidden" name="email" value ="'.$_SESSION['email'].'">';
			echo '<input type="hidden" name="alamat_old" value ="'.$_SESSION['alamat'].'">';
			echo '<input type="hidden" name="provinsi_old" value ="'.$_SESSION['provinsi'].'">';
			echo '<input type="hidden" name="kotakabupaten_old" value ="'.$_SESSION['kota'].'">';
			echo '<input type="hidden" name="kodepos_old" value ="'.$_SESSION['kodepos'].'">';
			echo '<input type="hidden" name="nohp_old" value ="'.$_SESSION['nomor_ponsel'].'">';
		?>
		<span class='formlabel'>Nama lengkap</span><input type='text' name='name'value = ' '><br />
		<span id='errorname' class='formerrortext'>Nama lengkap harus terdiri dari paling sedikit 2 kata</span><br />
		
		<span class='formlabel'>Kata sandi</span><input type='password' name='password'><br />
		<span id='errorpass' class='formerrortext'>Kata sandi paling sedikit 8 karakter</span>
		<span id='errorpassuser' class='formerrortext'>Kata sandi tidak boleh sama dengan username</span>
		<span id='errorpassemail' class='formerrortext'>Kata sandi tidak boleh sama dengan alamat email</span><br />
		
		<span class='formlabel'>Konfirmasi kata sandi</span><input type='password' name='confirm'><br />
		<span id='errorcpass' class='formerrortext'>Kata sandi tidak cocok</span><br />
		
		<span class='formlabel'>Alamat</span><input type='text' name='alamat'><br />
		<br />

		<span class='formlabel'>Kota/kabupaten</span><input type='text' name='kotakabupaten'><br />
		<br />
		
		<span class='formlabel'>Kode pos</span><input type='text' name='kodepos'><br />
		<span id='errorposint' class='formerrortext'>Format kode pos salah</span>
		<br />

		<span class='formlabel'>Provinsi</span><input type='text' name='provinsi'><br />
		<br />
		
		<span class='formlabel'>Nomor ponsel</span><input type='text' name='nohp'><br />
		<span id='errorjumlah' class='formerrortext'>Nomor ponsel tidak boleh melebihi 15 angka</span>
		<span id='errornoint' class='formerrortext'>Format nomor ponsel salah</span>
		<br />
		
		<br />
		<input type='submit' name='esubmit' value='Simpan'>
	</form>
</div>