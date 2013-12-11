<?php
	require_once "nusoap.php";
	$client = new nusoap_client("http://wbd032.ap01.aws.af.cm/RegistrasiServer.php");
	echo $_GET['username'];
	echo $_GET['password'];
	$result = $client->call("Registrasi", array('username1' => $_GET['username'] ,'password1' => $_GET['password'] ,"email" => $_GET['email'],"namalengkap" => $_GET['namalengkap'],"nohp" => $_GET['nohp'],"provinsi" => $_GET['provinsi'],"kota" => $_GET['kota'],"alamat" => $_GET['alamat'],"kodepos" => $_GET['kodepos']));
	if ($client->fault) {
		echo "<h2>Fault</h2><pre>";
		print_r($result);
		echo "</pre>";
	}
	else {
		$error = $client->getError();
		if ($error) {
			echo "<h2>Error</h2><pre>" . $error . "</pre>";
		}
		else {
			//echo "<h2>HELLO</h2><pre>";
			echo $result;
			//echo "</pre>";
		}
	}
	/*echo '<h2>Request</h2>';
	echo '<pre>' . htmlspecialchars($client->request, ENT_QUOTES) . '</pre>';
	echo '<h2>Response</h2>';
	echo '<pre>' . htmlspecialchars($client->response, ENT_QUOTES) . '</pre>';*/
?>