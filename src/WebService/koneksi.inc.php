<?php
$services_json = json_decode(getenv("VCAP_SERVICES"),true);
$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
$username = $mysql_config["username"];
$password = $mysql_config["password"];
$hostname = $mysql_config["hostname"];
$port = $mysql_config["port"];
$db = $mysql_config["name"];
$koneksi = mysql_connect("$hostname:$port", $username, $password);
//$db_selected = mysql_select_db($db, $link);
mysql_select_db($db, $koneksi) or die ("Database tidak ditemukan!".mysql_error());
?>