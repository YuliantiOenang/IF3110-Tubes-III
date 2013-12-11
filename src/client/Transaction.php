<?php 
	include 'LibUser.php';
	session_start();
	if (isset($_GET['TransAct']) AND isset($_SESSION['username']) AND isset($_SESSION['cardnumber']) AND isset($_SESSION['cart'])){
	
		/*mysql_connect("localhost", "root", "") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());*/
		function InsertToDB($IdBarang,$Jumlah,$Harga,$Username,$NamaBarang,$Kategori){
			ini_set("soap.wsdl_cache_enabled", "0"); // disabling WSDL cache
			$client = new SoapClient("http://gentle-ocean-7553.herokuapp.com/service.wsdl");
			$return = $client->createTransaction($NamaBarang,$Harga,$Jumlah,$Username,$Kategori,'-');
		
		
		}
		function UpdateDB($NamaBarang,$Jumlah){
			$postdata = http_build_query(
			array(
				'namabarang' => $NamaBarang
			)
			);

			$opts = array('http' =>
				array(
					'method'  => '.GET',
					'header'  => "Content-type: application/x-www-form-urlencoded",
					'content' => json_encode($postdata)
				)
			);

			$context  = stream_context_create($opts);

			$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/getjumlah', false, $context);
			$result=json_decode($result,true);			
			$OldJumlah=$result["jumlah"];		
			$NewJumlah=$OldJumlah-$Jumlah;
			$postdata = http_build_query(
			array(
				'namabarang' => $NamaBarang,
				'jumlah' => $NewJumlah
			)
			);

			$opts = array('http' =>
				array(
					'method'  => '.PUT',
					'header'  => "Content-type: application/x-www-form-urlencoded",
					'content' => json_encode($postdata)
				)
			);

			$context  = stream_context_create($opts);

			$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/buy', false, $context);
			$result=json_decode($result,true);					
			
		}	
		foreach ($_SESSION['cart'] as $Barang){
			$NamaBarang=$Barang[0]->GetNamaBarang();
			$Jumlah=$Barang[1];
			$Harga=$Barang[0]->GetHarga();
			$IdBarang=$Barang[0]->GetIdBarang();
			$Kategori=$Barang[0]->GetKategori();
			$Username=$_SESSION['username'];
			InsertToDB($IdBarang,$Jumlah,$Harga,$Username,$NamaBarang,$Kategori);
			UpdateDB($NamaBarang,$Jumlah);	
		}
		unset($_SESSION['cart']);
		header('location:ShoppingBag.php');}
	else if (isset($_SESSION['username']) AND !isset($_SESSION['cardnumber'])){
		header('location:credit-card.php');}
	else{
		header('location:index.php');}
?>
	 
