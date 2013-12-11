 <?php
$con=mysqli_connect("localhost","root","","ruserba");
// Check connection
if (mysqli_connect_errno()) {
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

// Query from database
$sql = "UPDATE into barang SET nama '=".$_POST['nama']."', gambar'=".$_POST['img']."', 
	harga'=".$_POST['harga']."', kategori'=".$_POST['kategori']."', jumlah'=".$_POST['jumlah']."', 
	keterangan'=".$_POST['deskripsi']."', terjual'=".$_POST['terjual']."'");
$result=mysqli_query($con,$sql);
mysqli_query($result);
mysqli_close($con);
<html><body> Selamat, Item "+$_GET['nama']+" telah berhasil diedit"
            		+ "<br><br><a href='adminbarang.php'>Kembali ke halaman admin</a></body></html>
?>