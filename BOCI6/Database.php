<?php 
	include 'LibUser.php';
	session_start();
	function GetDBBarang_BestBuy(){
		if (isset($_SESSION['BestBuy']) AND isset($_SESSION['BestBuyKategori'])){
			unset($_SESSION['BestBuy']);
			unset($_SESSION['BestBuyKategori']);}
		mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());
		$raw_results_category = mysql_query("SELECT Kategori FROM TransactionLog GROUP BY Kategori ORDER BY sum(Jumlah) DESC; ") or die(mysql_error());
		$i=0;
		while($results_category = mysql_fetch_array($raw_results_category) AND $i<5){
			$_SESSION['BestBuyKategori'][$i]=$results_category[0];
			//echo "$results_category[0] <br>";
			$raw_results_product = mysql_query("SELECT NamaBarang FROM TransactionLog WHERE Kategori='$results_category[0]' GROUP BY namabarang ORDER BY sum(Jumlah) DESC;") or die(mysql_error());
			$results_product= mysql_fetch_array($raw_results_product);
			//echo "$results_product[0] <br>";
			$_SESSION['BestBuy'][$i]=$results_product[0];
			$Tampil1=$_SESSION['BestBuy'][$i];
			$Tampil2=$_SESSION['BestBuyKategori'][$i];
			//echo "$Tampil1 dari $Tampil2";
			$i++;
		}
	}
	function remove_duplicates(array $array){
		$tmp_array = array();
		foreach($array as $key => $val){
			if (!in_array($val,$tmp_array)){
				$tmp_array[$key]=$val;}
		}
		return $tmp_array;}
	function GetDBBeras($SortBy="NULL"){
		if (isset($_SESSION['Beras'])){
			unset($_SESSION['Beras']);}
		mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());
		if ($SortBy=="NULL"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Beras';") or die (mysql_error());}
		else if ($SortBy=="Nama"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Beras' ORDER BY NamaBarang ASC;") or die (mysql_error());}
		else if ($SortBy=="Harga"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Beras' ORDER BY Harga ASC;") or die (mysql_error());}
		$Index=0;
		while($results=mysql_fetch_array($raw_results)){
			$Index=$results[0];
			
			
			$_SESSION['Beras'][$Index]=new Barang($results[0],$results[1],$results[2],$results[3],$results[4]);
		}
		//$_SESSION['Beras']=remove_duplicates($_SESSION['Beras']);
	}
	function GetDBDaging($SortBy="NULL"){
		if (isset($_SESSION['Daging'])){
			unset($_SESSION['Daging']);}
		mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());
		if ($SortBy=="NULL"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Daging';") or die (mysql_error());}
		else if ($SortBy=="Nama"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Daging' ORDER BY NamaBarang ;") or die (mysql_error());}
		else if ($SortBy=="Harga"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Daging' ORDER BY Harga ASC;") or die (mysql_error());}
		$Index=0;
		while($results=mysql_fetch_array($raw_results)){
			$Index=$results[0];
			$_SESSION['Daging'][$Index]=new Barang($results[0],$results[1],$results[2],$results[3],$results[4]);
		}
		$_SESSION['Daging']=remove_duplicates($_SESSION['Daging']);
	}
	function GetDBSayuran($SortBy="NULL"){
		if (isset($_SESSION['Sayuran'])){
			unset($_SESSION['Sayuran']);}
		mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());
		if ($SortBy=="NULL"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Sayuran';") or die (mysql_error());}
		else if ($SortBy=="Nama"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Sayuran' ORDER BY NamaBarang ASC;") or die (mysql_error());}
		else if ($SortBy=="Harga"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Sayuran' ORDER BY Harga ASC;") or die (mysql_error());}
		$Index=0;
		while($results=mysql_fetch_array($raw_results)){
			$Index=$results[0];
			$_SESSION['Sayuran'][$Index]=new Barang($results[0],$results[1],$results[2],$results[3],$results[4]);
		}
		$_SESSION['Sayuran']=remove_duplicates($_SESSION['Sayuran']);
	}
	function GetDBFrozenFood($SortBy="NULL"){
		if (isset($_SESSION['FrozenFood'])){
			unset($_SESSION['FrozenFood']);}
		mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());
		if ($SortBy=="NULL"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Frozen Food';") or die (mysql_error());}
		else if ($SortBy=="Nama"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Frozen Food' ORDER BY NamaBarang ASC;") or die (mysql_error());}
		else if ($SortBy=="Harga"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Frozen Food' ORDER BY Harga ASC;") or die (mysql_error());}
		$Index=0;
		while($results=mysql_fetch_array($raw_results)){
			$Index=$results[0];
			$_SESSION['FrozenFood'][$Index]=new Barang($results[0],$results[1],$results[2],$results[3],$results[4]);
		}
		$_SESSION['FrozenFood']=remove_duplicates($_SESSION['FrozenFood']);
	}
	function GetDBSnack($SortBy="NULL"){
		if (isset($_SESSION['Snack'])){
			unset($_SESSION['Snack']);}
		mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());
		if ($SortBy=="NULL"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Snack';") or die (mysql_error());}
		else if ($SortBy=="Nama"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Snack' ORDER BY NamaBarang ASC;") or die (mysql_error());}
		else if ($SortBy=="Harga"){
			$raw_results = mysql_query("SELECT * FROM Barang WHERE Kategori='Snack' ORDER BY Harga ASC;") or die (mysql_error());}
		$Index=0;
		while($results=mysql_fetch_array($raw_results)){
			$Index=$results[0];
			$_SESSION['Snack'][$Index]=new Barang($results[0],$results[1],$results[2],$results[3],$results[4]);
		}
		$_SESSION['Snack']=remove_duplicates($_SESSION['Snack']);
	}
	function GetDBSearch($SearchQuery){
		if (isset($_SESSION['Search'])){
			unset($_SESSION['Search']);}
		mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());
		$raw_results = mysql_query("SELECT * FROM Barang WHERE (NamaBarang LIKE '%".$SearchQuery."%')") or die (mysql_error());
		$i=0;
		while($results=mysql_fetch_array($raw_results)){
			$_SESSION['Search'][$i]=new Barang($results[0],$results[1],$results[2],$results[3],$results[4]);
			$i++;
		}
	}
?>