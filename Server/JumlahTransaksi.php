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
	$raw_results_category=mysql_query("SELECT count(*) FROM transactionlog WHERE username='$username1';") or die(mysql_error());
	$result_size=0;
	while($results_category = mysql_fetch_array($raw_results_category)){
		$result_size=$results_category[0];
	}
	echo $result_size;
?>