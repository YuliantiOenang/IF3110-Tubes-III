<?php
  function tambahBarang($nama, $kategori, $harga, $jumlah, $deskripsi, $gambar) {
  	include "koneksi.inc.php";
  	ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
  	$sql = "INSERT INTO barang (nama,gambar,kategori,harga,jumlah,keterangan)
				VALUES
					('$nama' , 
					 '$gambar' , 
					 '$kategori' , 
					 '$harga' ,
					 '$jumlah' , 
					 '$deskripsi')
			";
	$result = mysql_query($sql);
	if (!$result) {
		die("Error : " . mysql_error());
		return 0;
	} else {
  		return 1;	
	}
}
$server = new SoapServer("tambahbarang.wsdl");
$server->addFunction("tambahBarang");
$server->handle();
?>