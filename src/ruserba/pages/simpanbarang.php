<?php
	if(isset($_POST['nama'])){
		$nama = $_POST['nama'];
        $id = $_POST['id_barang'];
        $tersedia = $_POST['tersedia'];
        $harga = $_POST['harga'];
        $gambar = $_POST['gambar'];
		
	}else{
		echo'<a href="listbarang.php?kategori='.$_POST['kategori'].'">';
	}
?>