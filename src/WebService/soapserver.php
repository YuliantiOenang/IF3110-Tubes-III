<?php
  ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache

  include "koneksi.inc.php"; //untuk koneksi ke database
  function register($username,$password,$nama,$nohp,$alamat,$provinsi,$kota,$kodepos,$email){
	global $koneksi;
	$perintah="INSERT INTO anggota(username,password,nama,nomorhp,alamat,provinsi,kota,kodepos,email,foto) 
	values ('$username','$password','$nama','$nohp','$alamat','$provinsi','$kota','$kodepos','$email','user.png')";
	if(!empty($username) and !empty($password)){
		$hasil=mysql_query($perintah,$koneksi);
		if($hasil){
			$status = "ok";
			return $status;
		}else{
			throw new SoapFault("Server","Error : Query SQL tidak bisa dieksekusi.");
		}
	}
  }
  function registercard($username,$cardnumber,$nama,$expired){
	global $koneksi;
	$perintah="INSERT INTO kartu_kredit(owner,card_number,nama,expired) 
		values ('$username','$cardnumber','$nama','$expired')";
	$hasil=mysql_query($perintah,$koneksi);
	if($hasil){ 
		$status = "ok";
		return $status;
	}else{
		throw new SoapFault("Server","Error : Query SQL tidak bisa dieksekusi.");
	}
  }
  function tambahBarang($nama, $kategori, $harga, $jumlah, $deskripsi, $gambar) {
  	global $koneksi;
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
		throw new SoapFault("Server","Error : Query SQL tidak bisa dieksekusi.");
	} else {
  		return 1;	
	}
  }
$server = new SoapServer("registers.wsdl");
$server->addFunction("register");
$server->addFunction("registercard");
$server->addFunction("tambahBarang");
$server->handle();
?>