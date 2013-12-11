 <?php
include "koneksi.inc.php";
$id = $_POST['id'];
$nama = $_POST['nama'];
$gambar = $_POST['gambar'];
$harga = $_POST['harga'];
$kategori = $_POST['kategori'];
$jumlah = $_POST['jumlah'];
$deskripsi = $_POST['deskripsi'];

$sql = "update barang set nama = '".$nama."', gambar = '".$gambar."', harga = '".$harga."', 
	kategori = '".$kategori."', jumlah = '".$jumlah."', 
	keterangan = '".$deskripsi."' where id = ".$id;
$result = mysql_query($sql,$koneksi);

if($result) {
	echo "Selamat, Item ".$_POST['nama']." telah berhasil di edit";	
} else {
	echo "Item ".$_POST['nama']." tidak berhasil diedit";
}
echo "<a href='adminbarang.php'> Kembali ke halaman admin </a>";
?>