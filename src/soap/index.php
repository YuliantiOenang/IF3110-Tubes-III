<?php 
// shop functions
ini_set("display_errors", "On"); // disabling WSDL cache

function connectMySQL(){
	$json_string = getenv("VCAP_SERVICES");
	if ($json_string == "")
	{
		define(MySQLHost,"localhost");
		define(MySQLPass,"tkislam123");
		define(MySQLUser,"root");
		define(MySQLTable,"ruserba");
	}
	else
	{
		$data = json_decode($json_string, TRUE);
		define(MySQLHost,$data["mysql-5.1"][0]["credentials"]["hostname"]);
		define(MySQLPass,$data["mysql-5.1"][0]["credentials"]["password"]);
		define(MySQLUser,$data["mysql-5.1"][0]["credentials"]["username"]);
		define(MySQLTable,$data["mysql-5.1"][0]["credentials"]["name"]);
	}
}

function getXMLRetval($retval){
	$xml = "<retval>";
	foreach($retval as $key => $value){
		$xml .= "<$key>$value</$key>";
	}
	$xml .= "</retval>";
	
	return $xml;
}

function createUser($username, $password, $email, $nama_lengkap, $alamat, $provinsi, $kota, $kodepos, $telepon){
	connectMySQL();
	$response["status"] = MySQLHost.MySQLUser.MySQLPass.MySQLTable;
	$con = mysql_connect(MySQLHost,MySQLUser,MySQLPass);
	mysql_select_db(MySQLTable, $con);
	$ret = mysql_query("INSERT INTO account (username, password, email, nama, alamat, provinsi, kota, kodepos, telepon,role) VALUES ('".$username."','".$password."','".$email."','".$nama_lengkap."','".$alamat."','".$provinsi."','".$kota."','".$kodepos."','".$telepon."','1')");
	mysql_close();
	return getXMLRetval($response);
}

function createBarang($nama_barang, $harga, $stok, $kategori, $deskripsi){
	connectMySQL();
	$response["status"] = MySQLHost.MySQLUser.MySQLPass.MySQLTable;
	$con = mysql_connect(MySQLHost,MySQLUser,MySQLPass);
	mysql_select_db(MySQLTable, $con);
	$Query = "INSERT INTO barang (nama, harga, gambar, stok, keterangan,id_kategori) VALUES ('".$nama_barang."','".$harga."','1.jpg','".$stok."','".$deskripsi."','".$kategori."')";
	$ret = mysql_query($Query);
	$response["Query"] = $Query;
	mysql_close();
	return getXMLRetval($response);
}

function createKartu($id_account, $card_number, $name_of_card, $expired_date){
	connectMySQL();
	$response["status"] = MySQLHost.MySQLUser.MySQLPass.MySQLTable;
	$con = mysql_connect(MySQLHost,MySQLUser,MySQLPass);
	mysql_select_db(MySQLTable, $con);
	$Query = "INSERT INTO kredit (id_account, card_number, name_of_card, expired_date) VALUES ('".$id_account."','".$card_number."','".$name_of_card."','".$expired_date."')";
	$ret = mysql_query($Query);
	$response["Query"] = $Query;
	mysql_close();
	return getXMLRetval($response);
}

ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
$server = new SoapServer("service.wsdl");
$server->addFunction("createUser");
$server->addFunction("createBarang");
$server->addFunction("createKartu");
$server->handle();
?>
