<!DOCTYPE HTML>
<?php session_start(); 
$rest = "http://ditra77.ap01.aws.af.cm";
ini_set('max_execution_time', 300);
if(!isset($_SESSION['username']) || $_SESSION['username'] != 'admin') {
	header("Location: /ruserba");
}
?>

<html>
<head>
	<?php 
		$barang = simplexml_load_file($rest."/barang/".$_GET['id'].".xml");
	?>
	<title>Edit Barang <?php echo $barang->nama_barang; ?> </title>
	<link rel='icon' type='image/png' href='/ruseba/assets/favicon.png' />
	<link rel='stylesheet' media='only screen and (min-width:1224px)' href='/ruserba/stylesheets/desktop.css' />
	<script src='../scripts/admin.js'></script>
</head>
<body>
	<div id='wrapper'>
		<div id='header'><?php include 'headeradmin.php'; ?></div>
		<div class='divider'></div>
		<div id='content'>
			<h3 class="judul_halaman">
                Edit Barang <?php echo $barang->nama_barang; ?>
            </h3>
			<br/>
			<br/>
			<form id='barangform' method='post' onsubmit='return tambahBarang()' action='../scripts/php/simpanbarang.php'>
				<div class="list">
					<span class='formlabel'>Nama Barang</span>
				</div>
				<div>
					<?php
					echo "<input type='text' id='idnama' name='nama' value='".$barang->nama_barang."' >";
					?>
				</div>
				<div class="list">
					<span class='formlabel'>Harga Barang</span>
				</div>
				<div>
					<?php
					echo "<input type='text' id='idharga' name='harga' value=".$barang->harga_barang." >";
					?>
				</div>
				<div class="list">
					<span class='formlabel'>Tersedia</span>
				</div>
				<div>
					<?php
					echo "<input type='text' id='idtersedia' name='tersedia' value=".$barang->tersedia." >";
					?>
				</div>
				<div class="list">
					<span class='formlabel'>Gambar</span>
				</div>
				<div>
					<?php echo '<img src="../assets/barang/'.$barang->gambar .'" height="100%"/>'; ?>
					<input name="gambar" id="idgambar" type="file" size="30" accept="jpg">
				</div>
				<?php
				echo "<input name='id_barang' type='hidden' value=".$barang->id_barang.">";
				echo "<input name='kategori' type='hidden' value=".$barang->id_kategori.">";
				?>
				<input type='submit' name='submit' value='Perbarui'>
			</form>
        </div>
		<div class='divider'></div>
		<div id='footer'><?php include 'footer.php'; ?></div>
		<br /><br /><br /><br /><br /><br />
	</div>
</body>
</html>