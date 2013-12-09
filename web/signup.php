<?php

      $client = new SoapClient(null, array(
      'location' => "http://limitless-earth-2748.herokuapp.com/server.php",
      'uri'      => "urn://limitless-earth-2748.herokuapp.com"));

   $return = $client->__soapCall("addCustomer",array($_POST['nama_lengkap'],$_POST['kobupaten'],$_POST['kodepos'],$_POST['email'],$_POST['handphone'],$_POST['password'],$_POST['username'],$_POST['provinsi'],$_POST['alamat']));
   $mysql2=json_decode($return,true);
   $mysql=$mysql2['status'];
		if($mysql)
		{

			$url= "http://limitless-earth-2748.herokuapp.com/REST/getNoPelanggan/".$_POST['email']."/".$_POST['password'];
			$response=json_decode(file_get_contents($url));
			$Id=$response;

			setcookie("user1", $_POST['nama_lengkap'], time()+3600);
			setcookie("kobupaten", $_POST['kobupaten'], time()+3600);
			setcookie("IdCustomer", $Id, time()+3600*24*30);
			setcookie("kodepos",  $_POST['kodepos'], time()+3600*24*30);
			setcookie("email",  $_POST['email'], time()+3600*24*30);
			setcookie("handphone",  $_POST['handphone'], time()+3600*24*30);
			setcookie("username",  $_POST['username'], time()+3600*24*30);
			setcookie("provinsi",  $_POST['provinsi'], time()+3600*24*30);
			setcookie("alamat",  $_POST['alamat'], time()+3600*24*30);
		?>
			<script type="text/javascript">
						window.alert("Berhasil Register, Silahkan daftarkan kartu kredit anda");
						window.location="registrasi_kartu.php";
						</script>
		<?php
		}
		else
		{
		?>
			<script type="text/javascript">
						window.alert("Gagal Register");
						window.location="index.php";
			</script>
		<?php
		
		}
		
         
     
?>

