<?php
    if(isset($_POST['nama'])){
        $nama = $_POST['nama'];
        $harga = $_POST['harga'];
        $tersedia = $_POST['tersedia'];
        $gambar = $_POST['gambar'];
        $kategori = $_POST['kategori'];
        $dibeli=0;
    }else{
        echo'<a href="listbarang.php?kategori='.$_POST['kategori'].'">';
     }
?>