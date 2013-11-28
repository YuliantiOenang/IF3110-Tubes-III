<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
	<title> Ini laman Login </title>
	<link href="<?=SITE_ROOT.NAME_ROOT;?>/css/profile.css" rel="stylesheet"/>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/mainstyle.css" rel="stylesheet"/>
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
	<div class="basiccontent" id="profilecontent">
<!--Selamat Datang <?=$_SESSION['username'];?>, anda berada pada laman user<br>
Untuk menuju laman utama, klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/home"> disini </a><br>
Untuk lihat-lihat barang, klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang"> ini </a><br>
Untuk Logout, klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/logout"> ini </a><br>
Untuk mengedit data personal, silahkan klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/change"> ini</a><br>
Untuk mengecek pembelian, silahkan klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/cart"> ini</a><br> -->

<h2>Personal Information </h2>
<hr>
Username : <?=$_SESSION['username'];?><br>
Password : *****<br>
Nama Lengkap : <?=$_SESSION['nama_lengkap'];?><br>
Nomor HP : <?=$_SESSION['HP'];?><br>
Alamat : <?=$_SESSION['alamat'];?> <br>
Kota / Kabupaten : <?=$_SESSION['kota'];?><br>
Provinsi : <?=$_SESSION['provinsi'];?><br>
Kodepos : <?=$_SESSION['kodepos'];?><br>
Email : <?=$_SESSION['email'];?><br>
<?php
if ($_SESSION['isCreditCard'] == 0)
{
?>
<font color="red"> Anda belum mengisi kartu kredit </font>. 
<a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/addCreditCard"> Tambah Kartu Kredit</a><br>
<?php
}
else
{
?>
<font color="green"> Anda sudah memiliki kartu kredit </font>.
<a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/lihatCreditCard"> Lihat</a><br>
Anda juga boleh menambah kartu kredit lainnya, silahkan klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/addCreditCard"> ini</a><br>
<?php
}
?>
<br><hr>
Untuk mengedit data personal, silahkan klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/change"> ini</a>
</div>

</body>
</html>
