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
	$nama = $_GET['Username'];
	$pass = $_GET['Password'];
	$raw_results_category=mysql_query("SELECT * FROM user WHERE Username='$nama' AND password='$pass';") or die(mysql_error());
	$result_size=0;
	while($results_category = mysql_fetch_array($raw_results_category)){
		$result_size++;
		echo $results_category[0];
		echo ";";
		echo $results_category[1];
		echo ";";
		echo $results_category[2];
		echo ";"; 
		echo $results_category[3];
		echo ";";
		echo $results_category[4];
		echo ";";
		echo $results_category[5];
		echo ";"; 
		echo $results_category[6];
		echo ";";
		echo $results_category[7];
		echo ";";
		echo $results_category[8];
		echo ";"; 
		if ($results_category[9]!=null){
			echo $results_category[9];
			echo ";";} 
	}
	if ($result_size==0){
		echo "GAGAL";}
?>