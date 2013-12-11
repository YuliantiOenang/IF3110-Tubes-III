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
	$cardnumber = $_GET['cardnumber'];
	$username1 = $_GET['username'];
	//echo $cardnumber;
	//echo $username1;
	mysql_query("UPDATE user SET nocredit='$cardnumber' WHERE username='$username1';") or die(mysql_error());
	echo "BERHASIL";
?>