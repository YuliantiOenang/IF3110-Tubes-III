<?php 
	$services_json = json_decode(getenv("VCAP_SERVICES"),true);
	$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
	$username = $mysql_config["username"];
	$password = $mysql_config["password"];
	$hostname = $mysql_config["hostname"];
	$port = $mysql_config["port"];
	$db = $mysql_config["name"];

	$test = mysql_connect($hostname,$username,$password);
	if(!$test) {
		die('Could not connect: ' . mysql_error());
	}
	//echo 'Connected successfully';
	mysql_select_db("dd5292397ca984e1ca70022c3dfb26136") or die(mysql_error());
	$username1=$_GET['username'];
	$password1=$_GET['password'];
	$email=$_GET['email'];
	$namalengkap=$_GET['namalengkap'];
	$nohp=$_GET['nohp'];
	$provinsi=$_GET['provinsi'];
	$kota=$_GET['kota'];
	$alamat=$_GET['alamat'];
	$kodepos=$_GET['kodepos'];
	mysql_query("UPDATE user SET username='$username1' , password = '$password1' , email = '$email' , namalengkap  =  '$namalengkap' , nohp  =  '$nohp' , provinsi = '$provinsi' , kotakabupaten = '$kota' , alamat = '$alamat' , kodepos = '$kodepos' WHERE username='$username1' ;") or die(mysql_error());
	echo "BERHASIL";
?>