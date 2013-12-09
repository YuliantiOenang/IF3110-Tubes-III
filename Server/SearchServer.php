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
	$Query = $_GET['Query'];
	$PageNum = (int)$_GET['PageNum'];
	if ($PageNum==-1){
		$i=0;
		$raw_results_category = mysql_query("SELECT NamaBarang,Harga FROM barang WHERE NamaBarang LIKE '%".$Query."%';") or die(mysql_error());
		while($results_category = mysql_fetch_array($raw_results_category)){
			$i++;
		}
		echo $i;}
	else{
		$raw_results_category = mysql_query("SELECT NamaBarang,Harga FROM barang WHERE NamaBarang LIKE '%".$Query."%' LIMIT $PageNum, 2;") or die(mysql_error());
		while($results_category = mysql_fetch_array($raw_results_category)){
			echo $results_category[0];
			echo ";";
			echo $results_category[1];
			echo ";";
			$i++;
		}
	}
?>