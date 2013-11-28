<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
	<title> Lihat Kartu Kredit </title>
	<link href="<?=SITE_ROOT.NAME_ROOT;?>/css/profile.css" rel="stylesheet"/>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/mainstyle.css" rel="stylesheet"/>
	<link href="<?=SITE_ROOT.NAME_ROOT;?>/css/table.css" rel="stylesheet"/>
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
	<div class="basiccontent" id="largecontent">
		Credit card anda<br>
		<div id="table">
		<div class="header">
			<span class="kolom satu" id="narrowcolumn">No</span>
			<span class="kolom dua" id="widecolumn">Number</span>
			<span class="kolom tiga">Nama</span>
			<span class="kolom empat">Expired Date</span>
		</div>
		<?php
		$i=0;
		while ($row = mysql_fetch_object($data['listCC']))
		{
			$i++;
		?>
		<div class="baris">
			<span class="kolom satu" id="narrowcolumn"><?=$i;?></span>
			<span class="kolom dua" id="widecolumn"><?=$row->card_number;?></span>
			<span class="kolom tiga"><?=$row->name;?></span>
			<span class="kolom empat"><?=$row->expired_date;?></span>
		</div>
		<?php
		}
		?>
		</div>
	</div>
</body>
</html>
