<?php
	
	$nama_lengkap = $_GET['nama_lengkap'];
	$IdCustomer = $_COOKIE["IdCustomer"];
	$password = $_GET["password"];
	$alamat = $_GET["alamat"];
	$provinsi = $_GET["provinsi"];
	$kobupaten = $_GET["kobupaten"];
	$kodepos = $_GET["kodepos"];
	$handphone = $_GET["handphone"];
	$query="UPDATE customer SET nama='$nama_lengkap', password ='$password', alamat='$alamat',provinsi = '$provinsi',kota = '$kobupaten', kodepos ='$kodepos', hp = $handphone WHERE no_customer = $IdCustomer";
	$url= "http://if3110tubes3.herokuapp.com/REST/update/".urlencode($query);
	$response=json_decode(file_get_contents($url));
	$result=$response;
	
	if($result){
	?>
		<script>
		alert("berhasil update");
		window.location="edit_profile.php";
		</script>
		
	<?php	
		setcookie("user1",$nama_lengkap,time()+3600*24*30);
		setcookie("password",$password,time()+3600*24*30);
		setcookie("alamat",$alamat,time()+3600*24*30);
		setcookie("provinsi",$provinsi,time()+3600*24*30);
		setcookie("kobupaten",$kobupaten,time()+3600*24*30);
		setcookie("kodepos",$kodepos,time()+3600*24*30);
		setcookie("handphone",$handphone,time()+3600*24*30);
		
	}else{
	echo mysql_error();
	?>
		<script>
		alert("tidak berhasil udpate");
		window.location="edit_profile.php";
		</script>
	<?php
	}
?>