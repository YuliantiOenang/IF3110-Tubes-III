<script src='scripts/register.js'></script>
<div class='formcontainer'>
	<h2>Pendaftaran RuSerbA</h2>
	<br />
	<form id='registerform' method='post'>
		<span class='formlabel'>Username</span><input type='text' name='username'><br />
		<span id='erroruser5' class='formerrortext'>Username paling sedikit 5 karakter</span>
		<span id='erroruser' class='formerrortext'>Username sudah digunakan</span><br />
		
		<span class='formlabel'>Kata sandi</span><input type='password' name='password'><br />
		<span id='errorpass' class='formerrortext'>Kata sandi paling sedikit 8 karakter</span>
		<span id='errorpassuser' class='formerrortext'>Kata sandi tidak boleh sama dengan username</span>
		<span id='errorpassemail' class='formerrortext'>Kata sandi tidak boleh sama dengan alamat email</span><br />
		
		<span class='formlabel'>Konfirmasi kata sandi</span><input type='password' name='confirm'><br />
		<span id='errorcpass' class='formerrortext'>Kata sandi tidak cocok</span><br />
		
		<span class='formlabel'>Nama lengkap</span><input type='text' name='name'><br />
		<span id='errorname' class='formerrortext'>Nama lengkap harus terdiri dari paling sedikit 2 kata</span><br />
		
		<span class='formlabel' class='formlabel'>Alamat email</span><input type='text' name='email'><br />
		<span id='erroremailformat' class='formerrortext'>Format alamat email salah</span>
		<span id='erroremail' class='formerrortext'>Alamat email sudah digunakan</span><br />
		
		<br />
		<input type='submit' name='submit' value='Daftarkan'>
	</form>
</div>