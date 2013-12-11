<?php
if(isset($_GET['cardnumber'])){ $cardnumber=$_GET['cardnumber']; }
if(isset($_GET['name'])){ $name=rawurlencode($_GET['name']); }
if(!empty($cardnumber) && !empty($name)){
	$service_url = "http://wbd3pusheen.ap01.aws.af.cm/restcard.php?cardnumber=".$cardnumber."&name=".$name;
	$curl = curl_init($service_url);
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
	$curl_response = curl_exec($curl);
	if ($curl_response === false) {
		$info = curl_getinfo($curl);
		curl_close($curl);
		die('error occured during curl exec. Additioanl info: ' . var_export($info));
	}
	echo $curl_response;
	curl_close($curl);
}else{
	if(isset($_POST['username'])){$username=$_POST['username'];}
	if(isset($_POST['cardnumber'])){$cardnumber=$_POST['cardnumber'];}
	if(isset($_POST['nama'])){$nama=$_POST['nama'];}
	if(isset($_POST['expired'])){$expired=$_POST['expired'];}
	
	ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
	$client = new SoapClient("http://wbd3pusheen.ap01.aws.af.cm/registers.wsdl");
	try {
		$status = $client->registercard($username,$cardnumber,$nama,$expired);
		if($status=="ok"){
		?>
		<html>
			<head><script>
				alert("Pendaftaran kartu kredit berhasil!");
				window.location.href="../tubeswbd3/index.php";
			</script>
		</head><body></body></html>
		<?php
		}else{
			echo "<html><body>Pendaftaran kartu kredit gagal.<br><a href='registercardform.php?username=".$username."'>Kembali</a> atau <a href='index.php'>Kembali ke halaman utama</a></body></html>";
		}
	} catch (SoapFault $exception) {
		echo $exception;  		
	}
}
?>