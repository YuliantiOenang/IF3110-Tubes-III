<?php
  $client = new SoapClient("http://wbd3pusheen.ap01.aws.af.cm/registers.wsdl");
  $nama = $_POST['nama'];
  $kategori = $_POST['kategori'];
  $harga = $_POST['harga'];
  $jumlah = $_POST['jumlah'];
  $deskripsi = $_POST['deskripsi'];
  $gambar = $_POST['gambar'];
  print($client->tambahBarang($nama, $kategori, $harga, $jumlah, $deskripsi, $gambar));
?>
<script>
	alert("Berhasil menambah barang");
	window.location = "tambahbarang.php";
</script>