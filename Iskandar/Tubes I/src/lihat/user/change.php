<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
	<title> Ini laman ganti indentitas </title>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/profile.css" rel="stylesheet"/>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/mainstyle.css" rel="stylesheet"/>
    <script src="<?=SITE_ROOT.NAME_ROOT;?>/js/ajaxValidation.js" type="text/javascript"></script>
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
	<div class="basiccontent">
		<form id="changeForm" action="#" method="POST" onsubmit="onChange('../user/change'); return false;">
			<input type="hidden" name="email" id="email" value="<?=$_SESSION['email'];?>">
			<input type="hidden" name="username" id="username" value="<?=$_SESSION['username'];?>">
			Nama Lengkap* : <input type="text" name="nama_lengkap" id="nama_lengkap" value="<?=$_SESSION['nama_lengkap'];?>" onkeyup="ajaxValidation('checkNamaLengkap', this.value, this.id);"><br>
			<div id="nama_lengkap_response" class="error_message"> </div> 
			New Password* : <input type="password" name="password" id="password" value="<?=$_SESSION['password'];?>" onkeyup="ajaxValidation('checkPassword', this.value, this.id);"><br>
			<div id="password_response" class="error_message"> </div>
			Confirm Password* : <input type="password" name="confirm" value="" id="confirm" onkeyup="ajaxValidation('checkConfirm', this.value, this.id);"><br>
			<div id="confirm_response" class="error_message"> </div>
			HP : <input type="text" name="HP" id="HP" value="<?=$_SESSION['HP'];?>"><br>
			Alamat : <textarea name="alamat" id="alamat"><?=$_SESSION['alamat'];?></textarea><br>
			Provinsi : <input type="text" name="provinsi" id="provinsi" value="<?=$_SESSION['provinsi'];?>"><br>
			Kota / Kabupaten : <input type="text" name="kota" id="kota" value="<?=$_SESSION['kota'];?>"><br>
			KodePos : <input type="text" name="kodepos" id="kodepos" value="<?=$_SESSION['kodepos'];?>"><br>
			<input type="submit" value="submit" name="submit">
			<input type="button" value="back" onClick="history.go(-1);return reset();"><br>
			* = Wajib diisi
		</form>
	</div>
</body>
</html>
