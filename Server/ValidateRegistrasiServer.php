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
	$DataType=$_GET['DataType'];
	$Data=$_GET['Data'];
	//echo $DataType;
	//echo $Data;
	if ($DataType=="username"){
		//echo $DataType;
		//echo $Data;
		$raw_results_category = mysql_query("SELECT * FROM user WHERE username='$Data';");
		$i=0;
		while($results_category = mysql_fetch_array($raw_results_category)){
			$i++;
		}
		if ($i>0){
			echo "GAGAL";}
		else{
			echo "BERHASIL";}
	}
	else if ($DataType=="email"){
		$raw_results_category = mysql_query("SELECT * FROM user WHERE email='$Data';");
		$i=0;
		while($results_category = mysql_fetch_array($raw_results_category)){
			$i++;
		}
		if ($i>0){
			echo "GAGAL";}
		else{
			echo "BERHASIL";}
	}
	else if ($DataType=="cardnumber"){
		$raw_results_category = mysql_query("SELECT * FROM creditcard WHERE number='$Data';");
		$i=0;
		while($results_category = mysql_fetch_array($raw_results_category)){
			$i++;
		}
		if ($i>0){
			echo "BERHASIL";}
		else{
			echo "GAGAL";}
	}
	else if ($DataType=="cardname"){
		$raw_results_category = mysql_query("SELECT * FROM creditcard WHERE name='$Data';");
		$i=0;
		while($results_category = mysql_fetch_array($raw_results_category)){
			$i++;
		}
		if ($i>0){
			echo "BERHASIL";}
		else{
			echo "GAGAL";}
	}
	else if ($DataType=="expiredate"){
		$raw_results_category = mysql_query("SELECT * FROM creditcard WHERE expiredate='$Data';");
		$i=0;
		while($results_category = mysql_fetch_array($raw_results_category)){
			$i++;
		}
		if ($i>0){
			echo "BERHASIL";}
		else{
			echo "GAGAL";}
	}
?>