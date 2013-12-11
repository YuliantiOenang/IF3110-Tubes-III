<?php
  $client = new SoapClient("http://destra.ap01.aws.af.cm/soap-service.wsdl");
  if (isset($_POST['username'])){
  print($client->register($_POST['username'],$_POST['password'],$_POST['nama_lengkap'],$_POST['email'],$_POST['handphone'],$_POST['alamat'],$_POST['provinsi'],$_POST['kodepos'],$_POST['kota']));
  ?>
  <script type="text/javascript">
		localStorage.username='<?php echo $_POST['username'];?>';
		var d = new Date();
		d.setDate(d.getDate() + 30);
		var n = d.getTime();
		localStorage.expired_time=n; 
		window.location="registrasi_kartu_kredit.php";
	</script>
	<?php
	} else if (isset($_POST['nama'])){
		 print($client->nyetokBarang($_POST['nama'],$_POST['kategori'],$_POST['harga'],$_POST['stok'],$_POST['deskripsi'],$_POST['path']));
		 ?>
  		<script type="text/javascript">
			window.location="index-admin.php";
		</script>
	<?php
	}

?>