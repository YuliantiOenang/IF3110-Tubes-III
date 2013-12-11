<?php
	include('database_connection.php');
	function register($username, $password, $nama_lengkap, $email, $phone, $alamat, $provinsi, $postcode, $city) {
	  	include('database_connection.php'); // Connects to your Database 
		// Check connection
		if (mysqli_connect_errno()){
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		$sql="INSERT INTO account_customer (username, password, nama_lengkap, email, phone, alamat, provinsi, postcode, city)
		VALUES
		('$username','$password','$nama_lengkap','$email','$phone','$alamat','$provinsi','$postcode','$city')";
		if (!mysql_query($sql, $link)){
			die('Error: ' . mysqli_error($link));
		}
		mysqli_close($link);
	}
	function nyetokBarang($namaBarang, $kategori, $harga, $stock, $deskripsi, $path) {
	  	include('database_connection.php'); // Connects to your Database 
		// Check connection
		if (mysqli_connect_errno()){
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		$sql="INSERT INTO catalog_product (name, category, price, quantity, description, path)
		VALUES
		('$namaBarang','$kategori','$harga','$stock','$deskripsi','$path')";
		if (!mysql_query($sql, $link)){
			die('Error: ' . mysqli_error($link));
		}
		mysqli_close($link);
	}
	ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
	$server = new SoapServer("soap-service.wsdl");
	$server->addFunction("register");
	$server->addFunction("nyetokBarang");
	$server->handle();
?>