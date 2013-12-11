<script src='/ruserba/scripts/registerkartu.js'></script>
<div class='formcontainer'>
	<h2>Pendaftaran Kartu Kredit</h2>
	<div id='skipregisterkartu'><a href='/ruserba'>Lewati tahap ini</a></div>
	<br />
	<br />
	<form id='formregisterkartu' method='post'>
		<span class='formlabel'>Nomor kartu</span><input type='text' name='nokartu' maxlength='16'><br />
		<br />
		
		<span class='formlabel'>Nama pada kartu</span><input type='text' name='namakartu' maxlength='256'><br />
		<br />
		
		<span class='formlabel'>Tanggal kadaluarasa</span><input type='date' name='expiry'><br />
		<br />
		
		<input type='submit' name='submit' value='Daftarkan'>
	</form>
</div>