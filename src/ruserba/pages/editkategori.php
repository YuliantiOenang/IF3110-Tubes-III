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
		$kategori = simplexml_load_file($rest."/kategori/".$_GET['id'].".xml");
	?>
	<title>Edit Kategori <?php echo $kategori->nama_kategori; ?> </title>
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
                Edit Kategori <?php echo $kategori->nama_kategori; ?>
            </h3>
			<br/>
			<br/>
			<form id='kategoriform' method='post' onsubmit='return tambahKategori()' action='../scripts/php/simpankategori.php'>
				<span class='formlabel'>Nama Kategori</span>
				<?php
				echo "<input type='hidden' id='idid' name='id' value=".$kategori->id_kategori.">";
				echo "<input type='text' id='idnama' name='nama' value='".$kategori->nama_kategori."'>";
				?>                       
				<br /><br />
				<input type='submit' name='submit' value='Perbarui'>
			</form>
        </div>
		<div class='divider'></div>
		<div id='footer'><?php include 'footer.php'; ?></div>
		<br /><br /><br /><br /><br /><br />
	</div>
</body>
</html>