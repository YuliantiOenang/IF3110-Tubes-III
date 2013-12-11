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
	$NamaBarang=$_GET['NamaBarang'];
	$Jumlah=$_GET['Jumlah'];
	$IdBarang;
	$Harga;
	$Kategori;
	$JumlahTotal;
	$raw_results_category=mysql_query("SELECT * FROM barang WHERE NamaBarang='$NamaBarang';") or die(mysql_error());
	while($results_category = mysql_fetch_array($raw_results_category)){
		$IdBarang=$results_category[0];
		$Harga=$results_category[2];
		$Kategori=$results_category[3];
		$JumlahTotal=$results_category[4];
	}
	mysql_query("INSERT INTO transactionlog VALUES('$IdBarang','$NamaBarang','$Harga','$Jumlah','$username1','$Kategori');") or die (mysql_error());
	$NewJumlah=$JumlahTotal-$Jumlah;
	mysql_query("UPDATE barang SET Jumlah='$NewJumlah' WHERE NamaBarang='$NamaBarang';") or die (mysql_error());
	echo "BERHASIL";
?>