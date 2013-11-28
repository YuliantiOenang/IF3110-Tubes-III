<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
	<title> Ini laman registrasi </title>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/loginPopup.css" rel="stylesheet"/>
	<link href="<?=SITE_ROOT.NAME_ROOT;?>/css/profile.css" rel="stylesheet"/>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/mainstyle.css" rel="stylesheet"/>
    <script src="<?=SITE_ROOT.NAME_ROOT;?>/js/ajaxValidation.js" type="text/javascript"></script>
    <script src="<?=SITE_ROOT.NAME_ROOT;?>/js/ajaxLogin.js" type="text/javascript"></script>
</head>
<body>
	<div id="header">
		<div id="toplogo">
			<a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/home"><img id="logo" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/logoruserba.jpg" alt="home"></a>
		</div>
		<div id="logintop">
			<?php
				if ($_SESSION['username'] == null)
				{
			?>
			<a href="#login_popup"><strong>Login</strong></a>
			<br><br>
			<a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/register"><strong>Register</strong></a>
			<?php
				} else {
			?>
			<a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/logout"><strong>Logout</strong></a>
			<br><br>
			<a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user"><strong>Profile</strong></a>
            <br><br>
			<p id="welcometext">Welcome, <?php echo $_SESSION['username'] ?></p>
            <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/cart"><img id="tasbelanja" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/tasbelanja.jpg" alt="Tas Belanja"></a>        

			<?php
				}
			?>
                        <form action="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/cari" method="GET">
                        <p id ="search"><b>Cari Barang:</b>
                        Nama : <input type="text" name="search">
                        Kategori : 
                        <select name="kategori">
                        <option value="">--Pilih--</option>
                        <?php
                        while ($row = mysql_fetch_object($data['listCateg']))
                        {
                        ?>
                        <option value="<?=$row->name;?>"><?=$row->name;?></option>
                        <?php
                        }
                        ?>
                        </select>
                        Harga : <input type="text" name="harga">
                        <input type="submit"><br>
                        <span id="radiobutt">
                        <input type="radio" name="operator" value="L" checked>Less than
                        <input type="radio" name="operator" value="E">Equal to
                        <input type="radio" name="operator" value="G">Greater than
                        </span>
                        </p>
                        </form>
        </div>
                <div id="kategori">
                         <p>
								<span><a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/cari?search=&kategori=Sembako"><strong>Sembako</strong></a></span>
                                <span><a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/cari?search=&kategori=Handphone"><strong>Handphone</strong></a></span>
                                <span><a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/cari?search=&kategori=Peralatan+Listrik"><strong>PeralatanElektronik</strong></a></span>
                                <span><a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/cari?search=&kategori=Aksesoris+Komputer"><strong>AksesorisKomputer</strong></a></span>
                                <span><a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/cari?search=&kategori=Perabotan+Rumah"><strong>PerabotanRumah</strong></a></span>
                                <span><a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/cari?search=&kategori=Alat+Tulis"><strong>AlatTulis</strong></a></span>
                         </p>
                </div>
    </div>
<!--	<div id="registercontent">
		<h3 id="formtitle">FORM REGISTRASI</h3>
		<br><br>
		<form id="registerForm" action="#" autocomplete="off" method="POST" onsubmit="onRegister('../user/register', 'registerForm'); return false;">
			<p>Username:</p>
			<input type="text" name="username" id="username" onkeyup="ajaxValidation('checkUsername', this.value, this.id);">
			<p>Password:</p>
			<input type="password" name="password" id="password" onkeyup="ajaxValidation('checkPassword', this.value, this.id);">
			<p>Confirm Password:</p>
			<input type="password" name="confirm" id="confirm" onkeyup="ajaxValidation('checkConfirm', this.value, this.id);">
			<p>Nama Lengkap:</p>
			<input type="text" name="nama_lengkap" id="nama_lengkap" onkeyup="ajaxValidation('checkNamaLengkap', this.value, this.id);">
			<p>Nomor Handphone:</p>
			<input type="text" name="HP" id="HP">
			<p>Alamat:</p>
			<textarea name="alamat" id="alamat"></textarea>
			<p>Provinsi:</p>
			<input type="text" name="provinsi" id="provinsi">
			<p>Kota/Kabupaten:</p>
			<input type="text" name="kota" id="kota">
			<p>Kode Pos:</p>
			<input type="text" name="kodepos" id="kodepos">
			<p>Email:</p>
			<input type="text" name="email" id="email" onkeyup="ajaxValidation('checkEmail', this.value, this.id);">
			<br><br>
			<input type="submit" value="Submit">
			<p>* = wajib diisi</p>
		</form>

	</div> -->
	<div class="basiccontent">
<form id="registerForm" action="#" autocomplete="off" method="POST" onsubmit="onRegister('../user/register'); return false;">
    Email* : <input type="text" name="email" id="email" onkeyup="ajaxValidation('checkEmail', this.value, this.id);"><br>
    <div id="email_response" class="error_message"> </div>
    Username* : <input type="text" name="username" id="username" onkeyup="ajaxValidation('checkUsername', this.value, this.id);"><br>
    <div id="username_response" class="error_message"> </div>
    Password* : <input type="password" name="password" id="password" onkeyup="ajaxValidation('checkPassword', this.value, this.id);"><br>
    <div id="password_response" class="error_message"> </div>
    Confirm Password* : <input type="password" name="confirm" id="confirm" onkeyup="ajaxValidation('checkConfirm', this.value, this.id);"><br>
    <div id="confirm_response" class="error_message"> </div>
    Nama Lengkap* : <input type="text" name="nama_lengkap" id="nama_lengkap" onkeyup="ajaxValidation('checkNamaLengkap', this.value, this.id);"><br>
    <div id="nama_lengkap_response" class="error_message"> </div>    
    HP : <input type="text" name="HP" id="HP"><br>
    Alamat : <textarea name="alamat" id="alamat"></textarea><br>
    Provinsi : <input type="text" name="provinsi" id="provinsi"><br>
    Kota / Kabupaten : <input type="text" name="kota" id="kota"><br>
    KodePos : <input type="text" name="kodepos" id="kodepos"><br>
    <input type="submit" value="submit" name="submit" id="submit" disabled="true"><br>
    * = Wajib diisi
	</div>
</form>
<div id="login_popup">
    <div id="popup">
    <?=$data['loginView'];?>
</div>
</body>
</html>
