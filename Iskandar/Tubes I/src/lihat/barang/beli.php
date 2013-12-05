<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
	<title> Beli Barang </title>
    <link href="<?=SITE_ROOT.NAME_ROOT;?>/css/table.css" rel="stylesheet"/>
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
	<div class="basiccontent" id="giantcontent">
<h2>Pembelian Barang</h2>

		<div id="table">
		<div class="header">
			<span class="kolom satu" id="narrowcolumn">No</span>
			<span class="kolom dua">Nama Barang</span>
			<span class="kolom tiga">Quantity</span>
            <span class="kolom empat">Harga Total</span>
			<span class="kolom lima">Deskripsi Tambahan</span>
			<span class="kolom enam">Status</span>

		</div>
		<?php
		$i=0; $total_harga=0;
		while ($row = mysql_fetch_object($data['listBarang']))
		{
			$i++;
            if ($row->status == 0) 
            {
              $total_harga = $total_harga + $row->jumlah_barang * $row->harga_barang;
		?>
		<div class="baris">
			<span class="kolom satu" id="narrowcolumn"><?=$i;?></span>
			<span class="kolom dua"><?=$row->nama_barang;?></span>
			<span class="kolom tiga"><?=$row->jumlah_barang;?></span>
            <span class="kolom empat"><?=$row->jumlah_barang * $row->harga_barang;?></span>
			<span class="kolom lima"><?=$row->deskripsi_tambahan;?></span>
			
			<?php
			if ($row->status == 0)
			{
			?>
				<span class="kolom enam"><font color="red">Barang belum dibayar / dibeli</font></span>
			<?php
			}
			else
			{
			?>
				<span class="kolom enam"><font color="green">Barang sudah dibayar / dibeli</font></span>
			<?php
			}
			?>
			</span>
		</div>
		<?php
            }
		}
		?>
		</div><br>
        
    Total Harga (Yang belum dibeli) : <?=$total_harga;?><br><br>

<form action="" method="POST">
Kartu Kredit :
<select name="kartu">
<?php
while ($row = mysql_fetch_object($data['listCC']))
{
?>
	<option value="<?=$row->id;?>"><?=$row->card_number;?></option>
<?php
}
?>
</select><br>
<input type="submit" value="submit" name="submit" <?php if ($total_harga == 0) echo "disabled"; ?>>
<input type="button" value="back" onClick="history.go(-1);return reset();">
</form>
</div>

<div id="login_popup">
    <div id="popup">
    <?=$data['loginView'];?>
</div>
</body>
</html>
