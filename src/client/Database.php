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
		if ($SortBy=="NULL"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Beras'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/barangbykategori', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Nama"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Beras'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbynama', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Harga"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Beras'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbyharga', false, $context);
$result=json_decode($result,true);}
		$Index=0;
		while($Index<count($result)){
	
			//$Index=$results[0];
			$_SESSION['Beras'][$Index]=new Barang($result['index_'.$Index]['idbarang'],$result['index_'.$Index]['namabarang'],$result['index_'.$Index]['harga'],$result['index_'.$Index]['kategori'],$result['index_'.$Index]['jumlah']);
			$Index++;
		}
		$_SESSION['Beras']=remove_duplicates($_SESSION['Beras']);
	}
	function GetDBDaging($SortBy="NULL"){
		if (isset($_SESSION['Daging'])){
			unset($_SESSION['Daging']);}
	
		if ($SortBy=="NULL"){
	$postdata = http_build_query(
    array(
        'kategori' => 'Daging'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/barangbykategori', false, $context);
$result=json_decode($result,true);
}
		else if ($SortBy=="Nama"){
				$postdata = http_build_query(
    array(
        'kategori' => 'Daging'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbynama', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Harga"){
				$postdata = http_build_query(
    array(
        'kategori' => 'Daging'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbyharga', false, $context);
$result=json_decode($result,true);}
		$Index=0;
		while($Index<count($result)){
	
			//$Index=$results[0];
			$_SESSION['Daging'][$Index]=new Barang($result['index_'.$Index]['idbarang'],$result['index_'.$Index]['namabarang'],$result['index_'.$Index]['harga'],$result['index_'.$Index]['kategori'],$result['index_'.$Index]['jumlah']);
			$Index++;
		}
		$_SESSION['Daging']=remove_duplicates($_SESSION['Daging']);
	}
	function GetDBSayuran($SortBy="NULL"){
		if (isset($_SESSION['Sayuran'])){
			unset($_SESSION['Sayuran']);}

		if ($SortBy=="NULL"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Sayuran'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/barangbykategori', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Nama"){
				$postdata = http_build_query(
    array(
        'kategori' => 'Sayuran'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbynama', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Harga"){
				$postdata = http_build_query(
    array(
        'kategori' => 'Sayuran'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbyharga', false, $context);
$result=json_decode($result,true);}
		$Index=0;
		while($Index<count($result)){
	
			//$Index=$results[0];
			$_SESSION['Sayuran'][$Index]=new Barang($result['index_'.$Index]['idbarang'],$result['index_'.$Index]['namabarang'],$result['index_'.$Index]['harga'],$result['index_'.$Index]['kategori'],$result['index_'.$Index]['jumlah']);
			$Index++;
		}
		$_SESSION['Sayuran']=remove_duplicates($_SESSION['Sayuran']);
	}
	function GetDBFrozenFood($SortBy="NULL"){
		if (isset($_SESSION['FrozenFood'])){
			unset($_SESSION['FrozenFood']);}
		
		if ($SortBy=="NULL"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Frozen Food'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/barangbykategori', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Nama"){
				$postdata = http_build_query(
    array(
        'kategori' => 'Frozen Food'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbynama', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Harga"){
				$postdata = http_build_query(
    array(
        'kategori' => 'Frozen Food'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbyharga', false, $context);
$result=json_decode($result,true);}
		$Index=0;
	
		while($Index<count($result)){
	
			//$Index=$results[0];
			$_SESSION['FrozenFood'][$Index]=new Barang($result['index_'.$Index]['idbarang'],$result['index_'.$Index]['namabarang'],$result['index_'.$Index]['harga'],$result['index_'.$Index]['kategori'],$result['index_'.$Index]['jumlah']);
			$Index++;
		}
		$_SESSION['FrozenFood']=remove_duplicates($_SESSION['FrozenFood']);
	}
	function GetDBSnack($SortBy="NULL"){
		if (isset($_SESSION['Snack'])){
			unset($_SESSION['Snack']);}
		if ($SortBy=="NULL"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Snack'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/barangbykategori', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Nama"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Snack'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbynama', false, $context);
$result=json_decode($result,true);}
		else if ($SortBy=="Harga"){
			$postdata = http_build_query(
    array(
        'kategori' => 'Snack'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/sortbyharga', false, $context);
$result=json_decode($result,true);}
		$Index=0;
		while($Index<count($result)){
	
			//$Index=$results[0];
			$_SESSION['Snack'][$Index]=new Barang($result['index_'.$Index]['idbarang'],$result['index_'.$Index]['namabarang'],$result['index_'.$Index]['harga'],$result['index_'.$Index]['kategori'],$result['index_'.$Index]['jumlah']);
			$Index++;
		}
		$_SESSION['Snack']=remove_duplicates($_SESSION['Snack']);
	}
	function GetDBSearch($SearchQuery){
		if (isset($_SESSION['Search'])){
			unset($_SESSION['Search']);}
		
		$postdata = http_build_query(
    array(
        'search' => $SearchQuery
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/search', false, $context);
$result=json_decode($result,true);
$Index=0;
		while($Index<count($result)){
	
			//$Index=$results[0];
			$_SESSION['Search'][$Index]=new Barang($result['index_'.$Index]['idbarang'],$result['index_'.$Index]['namabarang'],$result['index_'.$Index]['harga'],$result['index_'.$Index]['kategori'],$result['index_'.$Index]['jumlah']);
			$Index++;
		}
	}
	
	function GetDBAdmin(){
		if (isset($_SESSION['Admin'])){
			unset($_SESSION['Admin']);}


			$postdata = http_build_query(
    array(
        'kategori' => 'tes'
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

$result = file_get_contents('http://gentle-ocean-7553.herokuapp.com/rest/index.php/admin', false, $context);
$result=json_decode($result,true);
$Index=0;
		while($Index<count($result)){
	
			//$Index=$results[0];
			$_SESSION['Admin'][$Index]=new Barang($result['index_'.$Index]['idbarang'],$result['index_'.$Index]['namabarang'],$result['index_'.$Index]['harga'],$result['index_'.$Index]['kategori'],$result['index_'.$Index]['jumlah']);
			$Index++;
		}

}


?>