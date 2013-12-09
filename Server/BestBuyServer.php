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
	$raw_results_category = mysql_query("SELECT NamaBarang,Kategori,sum(Jumlah) FROM transactionlog WHERE Kategori='Beras' GROUP BY IdBarang ORDER BY sum(Jumlah) DESC;") or die(mysql_error());
	$i=0;
	while($results_category = mysql_fetch_array($raw_results_category) AND $i<3){
		echo $results_category[0];
		echo "<br/>";
		echo $results_product[1];
		//echo "<br/>";
		$i++;
	}
	$raw_results_category = mysql_query("SELECT NamaBarang,Kategori,sum(Jumlah) FROM transactionlog WHERE Kategori='Daging' GROUP BY IdBarang ORDER BY sum(Jumlah) DESC;") or die(mysql_error());
	$i=0;
	while($results_category = mysql_fetch_array($raw_results_category) AND $i<3){
		echo $results_category[0];
		echo "<br/>";
		echo $results_product[1];
		//echo "<br/>";
		$i++;
	}
	$raw_results_category = mysql_query("SELECT NamaBarang,Kategori,sum(Jumlah) FROM transactionlog WHERE Kategori='Sayuran' GROUP BY IdBarang ORDER BY sum(Jumlah) DESC;") or die(mysql_error());
	$i=0;
	while($results_category = mysql_fetch_array($raw_results_category) AND $i<3){
		echo $results_category[0];
		echo "<br/>";
		echo $results_product[1];
		//echo "<br/>";
		$i++;
	}
?>