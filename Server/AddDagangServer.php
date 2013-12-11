<?php
	require_once "nusoap.php";
	function AddDagang($nama,$harga,$kategori,$jumlah) {
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
		mysql_query("INSERT INTO barang (NamaBarang, Harga, Kategori, Jumlah) VALUES('$nama','$harga','$kategori','$jumlah')") or die(mysql_error());
		return "BERHASIL";
	}
	$server = new soap_server();
	$server->register("AddDagang");
	$server->service($HTTP_RAW_POST_DATA);
?>