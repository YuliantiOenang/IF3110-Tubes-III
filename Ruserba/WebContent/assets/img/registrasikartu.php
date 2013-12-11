<?php include 'header.php';?>
	
<div id="page" class="container">
	

	<div id="warning">
	</div>
	<!-- <form action="actions/registrasi-submit.php" method="POST"> -->
	<form action='http://localhost/waserda/index.php?registrasikartu&action="daftar"' method="POST">
	  nomor kartu : <br> <input type="text" name="no_kartu" onchange="validator();"><br>
	  nama pemegang kartu : <br> <input type="text" name="nama_pemegang_kartu" onchange="validator();"><br>
	  expired date (MM / YY) : <br> <input type="text" name="expired_date_month" onchange="validator();"> /
	  <input type="text" name="expired_date_year" onchange="validator();"> <br>
	  <!-- Nama Lengkap : <br> <input type="text" name="nama_lengkap"><br>
	  Nomor Handphone :<br> <input type="text" name="no_handphone"><br>
	  Alamat :<br> <input type="text" name="alamat"><br>
	  Provinsi: <input type="text" name="provinsi"><br>
	  Last name: <input type="text" name="kabupaten_kota"><br> -->
	  <input id="submit_button" type="submit" value="Submit">
	</form> 
</div>

<script src="assets/js/registrasi.js"></script>

<?php include 'footer.php'; ?>