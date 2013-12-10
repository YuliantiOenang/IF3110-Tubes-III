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
	<title>List Kategori</title>
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
                List Kategori
            </h3>
			<br/>
			<br/>
			<?php 
			$result = simplexml_load_file($rest."/kategori.xml");
			?>
			<form action="ruserba/scripts/php/hapuskategori.php">
				<?php
				foreach($result->children() as $child){ 
				$kategori = simplexml_load_file($rest."/kategori/".$child.".xml");
				?>
				<div class="halaman_list_category_container">
					<div>
						<div class="list">
							<span class="barang_nama">
								<?php 
								echo "<input type='checkbox' name='id' value=".$kategori->id_kategori.">";
								echo "<a href='editkategori.php?id=".$kategori->id_kategori."'>";
								echo $kategori->nama_kategori;
								echo "</a>";
								?>
							</span>
						</div>
						<div>
							<span class="barang_nama">
								<?php 
								echo "<a href='listbarang.php?kategori=".$kategori->id_kategori."'>";
								echo "Lihat Barang";
								echo "</a>";
								?>
							</span>
						</div>                          
					</div>
				</div>
				<hr>
				<?php 
				}
				?>
				<input type="submit" value="Hapus" onclick="return hapusKategori()" />
			</form>
			<br/>
			<br/>
			<h3 class="judul_halaman">
				Tambah Kategori
			 </h3>
			<div class="tambahkategori">
				<br />
				<form id='kategoriform' method='post' action='tambahkategori.jsp'>
						<span class='formlabel'>Nama Kategori</span><input type='text' id="idnama" name='nama'><br />
						<br />
						<input type='submit' name='submit' value='Tambahkan' onclick='return tambahKategori()'>
				</form>
			</div>
        </div>
		<div class='divider'></div>
		<div id='footer'><?php include 'pages/footer.php'; ?></div>
		<br /><br /><br /><br /><br /><br />
	</div>
</body>
</html>