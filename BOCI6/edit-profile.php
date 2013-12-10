<?php  

session_start();
if(isset($_COOKIE['username'])){
	if (isset($_SESSION['email'])){
		$username = $_SESSION['username'];
		$password = $_SESSION['password'];
		$email=$_SESSION['email'];
		$namalengkap=$_SESSION['namalengkap'];
		$nohp=$_SESSION['nohp'];
		$provinsi=$_SESSION['provinsi'];
		$kotakabupaten=$_SESSION['kotakabupaten'];
		$alamat=$_SESSION['alamat'];
		$kodepos=$_SESSION['kodepos'];
		$data2=$_SESSION['jumlahtransaksi'];
	}else{
		header('location: getdatamember.php'); 
	}
}else{
	header('location: registrasi.php');  
}
 ?> 


<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
	<?php include 'header.php'; ?>
		

		<input type='hidden' name='iusername' id='iusername' value="<?php echo $username?>" />
		<input type='hidden' name='ipassword' id='ipassword' value="<?php echo $password?>" />
		<input type='hidden' name='iemail' id='iemail' value="<?php echo $email?>" />
		<input type='hidden' name='inamalengkap' id='inamalengkap' value="<?php echo $namalengkap?>" />
		<input type='hidden' name='inohp' id='inohp' value="<?php echo $nohp?>" />
		<input type='hidden' name='iprovinsi' id='iprovinsi' value="<?php echo $provinsi?>" />
		<input type='hidden' name='ikotakabupaten' id='ikotakabupaten' value="<?php echo $kotakabupaten?>" />
		<input type='hidden' name='ialamat' id='ialamat' value="<?php echo $alamat?>" />
		<input type='hidden' name='ikodepos' id='ikodepos' value="<?php echo $kodepos?>" />

	

		<div id="form-registrasi" class="frame">
			<p id="registration-title">Your Profile</p>
			
			<div id="data-diri" class="frame">
				<img class="kolom-3 gambar" src="res/img/userpict_b.png" alt=""/>
				<div class="kolom-9 teks">
					
					
					<form id='profile' action='update.php' method='post' accept-charset='UTF-8' onsubmit = "return cekChangeData()">
						<div class="form-field">
							<p class="label">Username:</p>
							<p>
							<input name="username" title="minimal 5 karakter" id="username" required="required" onkeyup="cekvalidAll()" readonly value="<?php echo $username?>" class="field-box kolom-12">
							</p>
						</div>
						
						<div class="form-field">
							<p class="label">Change Password :</p>
							<p>
								<input type='text' name='validasipassword' id='validasipassword' maxlength="10" value ="valid" readonly/>
								<input type = "password" name="password" title="minimal 8 karakter" id="password" oninput="!!(cekPassword() & cekCPassword())" required="required" onkeyup="cekvalidAll()" value="<?php echo $password ?>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Confirm Password :</p>
							<p>
								<input type='text' name='validasiCpassword' id='validasiCpassword' maxlength="10" value ="valid" readonly/>
								<input type = "password" name="cpassword" title="minimal 8 karakter" id="cpassword" oninput="cekCPassword()" required="required" onkeyup="cekvalidAll()" value="<?php echo $password ?>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Nama Lengkap :</p>
							<p>
								<input type='text' name='validasinamalengkap' id='validasinamalengkap' maxlength="10" value ="valid" readonly/>
								<input type='text' name='namalengkap' title ="lalala yeyeye" id='namalengkap' maxlength="50" required="required" onkeyup="!!(cekNamaDuaKata() & cekvalidAll())" value="<?php echo $namalengkap?>" class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">Email :</p>
							<p>
								<input type='text' name='email'  id='email' title = "cuman@contoh.com" maxlength="50" required="required" onkeyup="cekvalidAll()" value="<?php echo $email ?>" readonly class="field-box kolom-12">
							</p>
						</div>

						<div class="form-field">
							<p class="label">No HP :</p>
							<p>
								<input type='text' name='validasinohp' id='validasinohp' maxlength="10" value ="valid" readonly/>
								<input type='text' name='nohp' id='nohp' title="harus angka" maxlength="50" required="required" onkeyup="!!(ceknohp() & cekvalidAll())" value="<?php echo $nohp?>" class="field-box kolom-12"/>
							</p>
						</div>

						<div class="form-field">
							<p class="label">Provinsi:</p>
							<p>
								<input type='text' name='provinsi' id='provinsi' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<?php echo $provinsi?>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Kota/Kabupaten:</p>
							<p>
								<input type='text' name='kotakabupaten' id='kotakabupaten' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<?php echo $kotakabupaten?>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Alamat:</p>
							<p>
								<input type='text-area' name='alamat' id='alamat' maxlength="50" required="required" onkeyup="cekvalidAll()" value="<?php echo $alamat?>" class="field-box kolom-12"/>
							</p>
						</div>


						<div class="form-field">
							<p class="label">Kode Pos:</p>
							<p>
								<input type='text' name='kodepos' id='kodepos' pattern="[0-9]+[0-9]*" title="harus angka" maxlength="50" required="required" onkeyup="cekvalidAll()" value="<?php echo $kodepos?>" class="field-box kolom-12"/>
							</p>
						</div>
						
						jumlah transaksi <?php echo $data2 ?><br/>
						<input type='submit' id="btn-profile" class="btn" name='edit' value='edit' />
						
					</form>

				</div>
				
			</div>
			
		</div>
		
	</div>
	

	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>	
	<script src="scriptmember.js"></script>

</body>
</html>