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
		$kategori = simplexml_load_file($rest."/kategori/".$_GET['kategori'].".xml");
	?>
	<title>List Barang Kategori <?php echo $kategori->nama_kategori; ?></title>
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
                List Barang Kategori <?php echo $kategori->nama_kategori; ?>
			</h3>
			<br/>
			<br/>
			<?php 
			$result = simplexml_load_file($rest."/barang?id_kategori=".$kategori->id_kategori.".xml");
			?>
			<form action="../scripts/php/hapusbarang.php" method="post">
				<?php
				foreach($result->children() as $child){ 
				$barang = simplexml_load_file($rest."/barang/".$child.".xml");
				?>
				<div class="halaman_list_category_container">
					<div>
						<span class="barang_nama">
							<?php 
							echo "<input type='checkbox' name='id[]' value=".$barang->id_barang.">";
							echo "<input type='hidden' name='kategori' value=".$_GET['kategori'].">";
							echo "<a href='editbarang.php?id=".$barang->id_barang."'>";
							echo $barang->nama_barang;
							echo "</a>";
							?>
						</span>                    
					</div>
				</div>
				<hr>
				<?php 
				}
				?>
				<input type="submit" value="Hapus" onclick="return hapusBarang()" />
			</form>
			<br/>
			<br/>
			<h3 class="judul_halaman">
				Tambah Barang Kategori <?php $kategori->nama_kategori; ?>
			</h3>
			<div class="tambahbarang">
                <br />
                <form id='barangform' method='post' action='tambahbarang.jsp'>
                    <div class="list">
                        <span class='formlabel'>Nama Barang</span>
                    </div>
                    <div>
                        <input type='text' id="idnama" name='nama'>
                    </div>
                    <div class="list">
                        <span class='formlabel'>Harga Barang</span>
                    </div>
                    <div>
                        <input type='text' id="idharga" name='harga'>
                    </div>
                    <div class="list">
                        <span class='formlabel'>Tersedia</span>
                    </div>
                    <div>
                        <input type='text' id="idtersedia" name='tersedia'>
                    </div>
                    <div class="list">
                        <span class='formlabel'>Gambar</span>
                    </div>
                    <div>
                        <input name="gambar" id="idgambar" type="file" size="30" accept="jpg">
                    </div>
                    <?php 
                    echo "<input name='kategori' type='hidden' value=".$_GET['kategori'].">";
                    ?>
                    <input type='submit' name='submit' value='Tambahkan' onclick='return tambahBarang()'>
                </form>
            </div>
		</div>
		<div class='divider'></div>
		<div id='footer'><?php include 'footer.php'; ?></div>
		<br /><br /><br /><br /><br /><br />
	</div>
</body>
</html>