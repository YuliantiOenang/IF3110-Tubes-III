<?php
require_once('config.php');
$client = new SoapClient(SOAPService."service.wsdl",array('location' => SOAPService));
$return = $client->createBarang($_POST['nama_barang'],$_POST['harga_barang'],$_POST['stok'],$_POST['kategori'],$_POST['keterangan']);	
header("Location: adminIndex.php");
?>
