<?
if(!isset($_SESSION['username']) || $_SESSION['username'] != 'admin') {
	header("Location: /ruserba");
}
?>
<div id="header_nonkategori">
<div id='logo'>
        <a href='listkategori.php'><img src='../assets/logo.png' /></a>
</div>
<div id='loggedin'>
    Administrator
    <a id='logoutbutton' class='button' href='/ruserba/scripts/php/logout.php'><div>Keluar</div></a>
</div>
</div>
<div id="header_kumpulankategori">
	<?php 
	$rest = "http://ditra77.ap01.aws.af.cm";
	ini_set('max_execution_time', 300);
	$result = simplexml_load_file($rest."/kategori.xml");
	foreach($result->children() as $child){ 
		$kat = simplexml_load_file($rest."/kategori/".$child.".xml");
		echo "<div class='header_kategori'>";
        echo '<a href="listbarang.php?kategori='.$kat->id_kategori.'">'.$kat->nama_kategori.'</a>';
        echo "</div>";
	}
	?>
</div>
