<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
	<title> Ruserba - Home</title>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/loginPopup.css" rel="stylesheet"/>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/mainstyle.css" rel="stylesheet"/>
    <script src="<?=SITE_ROOT.NAME_ROOT;?>/js/ajaxLogin.js" type="text/javascript"></script>
</head>
<body>

<!--
Untuk member silahkan <a href="#login_popup"> Masuk </a><br>
Untuk Admin silahkan <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/admin/login"> Admin Login </a><br>
Bagi yang ingin join silahkan <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user/register"> Daftar </a><br>
Untuk lihat-lihat barang, silahkan klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/home/gallery"> ini </a><br>
Untuk masuk laman akun anda, silahkan klik <a href="<?=SITE_ROOT.NAME_ROOT;?>/index.php/user">ini </a><br>
-->
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

	<div id="homecontent">
			<center><h2>Best Of Sembako</h2></center>
                <div class="scrollable">
                    <div class="items">
								<?php
								while ($row = mysql_fetch_object($data['Sembako']))
								{
								?>
                        	<img class="picsize" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/<?=$row->gambar;?>" alt="<?=$row->nama_barang;?>">
								<?php
								}
								?>
                    </div>
                </div>
			<!--</div>-->
	</div>

	<div id="homecontent">
			<center><h2>Best Of Handphone</h2></center>
                <div class="scrollable">
                    <div class="items">
								<?php
								while ($row = mysql_fetch_object($data['HP']))
								{
								?>
                        <img class="picsize" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/<?=$row->gambar;?>" alt="<?=$row->nama_barang;?>">
								<?php
								}
								?> 
                   </div>
                </div>
			<!--</div>-->
	</div>

	<div id="homecontent">
			<center><h2>Best Of Peralatan Listrik</h2></center>
                <div class="scrollable">
                    <div class="items">
								<?php
								while ($row = mysql_fetch_object($data['Listrik']))
								{
								?>
                        <img class="picsize" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/<?=$row->gambar;?>" alt="<?=$row->nama_barang;?>">
								<?php
								}
								?> 
                   </div>
                </div>
			<!--</div>-->
	</div>

	<div id="homecontent">
			<center><h2>Best Of Aksesoris Komputer</h2></center>
                <div class="scrollable">
                    <div class="items">
								<?php
								while ($row = mysql_fetch_object($data['Komputer']))
								{
								?>
                        <img class="picsize" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/<?=$row->gambar;?>" alt="<?=$row->nama_barang;?>">
								<?php
								}
								?> 
                   </div>
                </div>
			<!--</div>-->
	</div>

	<div id="homecontent">
			<center><h2>Best Of Perabotan Rumah</h2></center>
                <div class="scrollable">
                    <div class="items">
								<?php
								while ($row = mysql_fetch_object($data['Rumah']))
								{
								?>
                        <img class="picsize" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/<?=$row->gambar;?>" alt="<?=$row->nama_barang;?>">
								<?php
								}
								?> 
                   </div>
                </div>
			<!--</div>-->
	</div>

	<div id="homecontent">
			<center><h2>Best Of Perabotan Rumah</h2></center>
                <div class="scrollable">
                    <div class="items">
								<?php
								while ($row = mysql_fetch_object($data['Tulis']))
								{
								?>
                        <img class="picsize" src="<?=SITE_ROOT.NAME_ROOT;?>/gambar_barang/<?=$row->gambar;?>" alt="<?=$row->nama_barang;?>">
								<?php
								}
								?> 
                   </div>
                </div>
			<!--</div>-->
	</div>

<div id="login_popup">
    <div id="popup">
    <?=$data['loginView'];?>
</div>

</body>
</html>
