<?php
if(isset($_POST['username'])){$username=$_POST['username'];}
if(isset($_POST['password'])){$password=$_POST['password'];}
if(isset($_POST['nama'])){$nama=$_POST['nama'];}
if(isset($_POST['nohp'])){$nohp=$_POST['nohp'];}
if(isset($_POST['alamat'])){$alamat=$_POST['alamat'];}
if(isset($_POST['provinsi'])){$provinsi=$_POST['provinsi'];}
if(isset($_POST['kota'])){$kota=$_POST['kota'];}
if(isset($_POST['kodepos'])){$kodepos=$_POST['kodepos'];}
if(isset($_POST['email'])){$email=$_POST['email'];}

ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
	
$client = new SoapClient("http://wbd3pusheen.ap01.aws.af.cm/registers.wsdl");
try {
	$status = $client->register($username,$password,$nama,$nohp,$alamat,$provinsi,$kota,$kodepos,$email);
	if($status=="ok"){
	?>
	<html>
		<head><script>
			if(typeof(Storage)!=="undefined"){
				localStorage.wbduser="<?php echo $username; ?>";
				localStorage.wbdlogintime=new Date().getTime();
				window.location="registercardform.php";
			}else{
				document.write("Maaf, browser kamu tidak support localStorage sehingga informasi username tidak dapat disimpan...");
				document.write("<a href='index.php'>Kembali ke halaman utama</a>");
			}
		</script>
		</head><body></body></html>
	<?php
	}else{
		echo "<html><body>Pendaftaran gagal.<br><a href='registerform.php'>Daftar ulang</a> atau <a href='index.php'>Kembali ke halaman utama</a></body></html>";
	}
} catch (SoapFault $exception) {
	echo $exception;      
}
?>