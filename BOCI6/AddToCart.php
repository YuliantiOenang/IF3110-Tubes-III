<?php
	include 'LibUser.php';
	session_start();
	$IdxBarang = $_GET['id'];
	$Kategori = $_GET['Kategori'];
	$Jumlah=$_GET['Jumlah'];
	if ($Kategori=="Beras"){
		$Barang = $_SESSION['Beras'][$IdxBarang];
		$OldJumlah=$_SESSION['Beras'][$IdxBarang]->GetJumlah();
		if ($Jumlah > $OldJumlah){
			echo "$OldJumlah";}
		else{
			echo "Betul";
			$NewJumlah=$_SESSION['Beras'][$IdxBarang]->GetJumlah() - $Jumlah;
			$_SESSION['Beras'][$IdxBarang]->setJumlah($NewJumlah);
			$JumlahTerkini = $_SESSION['Beras'][$IdxBarang]->GetJumlah();}
	}
	else if ($Kategori=="Daging"){
		$Barang = $_SESSION['Daging'][$IdxBarang];
		$OldJumlah=$_SESSION['Daging'][$IdxBarang]->GetJumlah();
		if ($Jumlah > $OldJumlah){
			echo "$OldJumlah";}
		else{
			echo "Betul";
			$NewJumlah=$_SESSION['Daging'][$IdxBarang]->GetJumlah() - $Jumlah;
			$_SESSION['Daging'][$IdxBarang]->setJumlah($NewJumlah);
			$JumlahTerkini = $_SESSION['Daging'][$IdxBarang]->GetJumlah();}
	}
	else if ($Kategori=="Sayuran"){
		$Barang = $_SESSION['Sayuran'][$IdxBarang];
		$OldJumlah=$_SESSION['Sayuran'][$IdxBarang]->GetJumlah();
		if ($Jumlah > $OldJumlah){
			echo "$OldJumlah";}
		else{
			echo "Betul";
			$NewJumlah=$_SESSION['Sayuran'][$IdxBarang]->GetJumlah() - $Jumlah;
			$_SESSION['Sayuran'][$IdxBarang]->setJumlah($NewJumlah);
			$JumlahTerkini = $_SESSION['Sayuran'][$IdxBarang]->GetJumlah();}
	}
	else if ($Kategori=="FrozenFood"){
		$Barang = $_SESSION['FrozenFood'][$IdxBarang];
		$OldJumlah=$_SESSION['FrozenFood'][$IdxBarang]->GetJumlah();
		if ($Jumlah > $OldJumlah){
			echo "$OldJumlah";}
		else{
			echo "Betul";
			$NewJumlah=$_SESSION['FrozenFood'][$IdxBarang]->GetJumlah() - $Jumlah;
			$_SESSION['FrozenFood'][$IdxBarang]->setJumlah($NewJumlah);
			$JumlahTerkini = $_SESSION['FrozenFood'][$IdxBarang]->GetJumlah();}
	}
	else if ($Kategori=="Snack"){
		$Barang = $_SESSION['Snack'][$IdxBarang];
		$OldJumlah=$_SESSION['Snack'][$IdxBarang]->GetJumlah();
		if ($Jumlah > $OldJumlah){
			echo "$OldJumlah";}
		else{
			echo "Betul";
			$NewJumlah=$_SESSION['Snack'][$IdxBarang]->GetJumlah() - $Jumlah;
			$_SESSION['Snack'][$IdxBarang]->setJumlah($NewJumlah);
			$JumlahTerkini = $_SESSION['Snack'][$IdxBarang]->GetJumlah();}
	}
	$IdBarang = $Barang->GetIdBarang();
	//$Barang->DisplayBarang();
	/*mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
	mysql_select_db("datauser") or die(mysql_error());
	$raw_results = mysql_query("SELECT * FROM Barang WHERE IdBarang=$IdxBarang") or die (mysql_error());
	$results=mysql_fetch_array($raw_results);
	echo "$results[0],$results[1],$results[2],$results[3]";
	$Barang=new Barang($results[0],$results[1],$results[2],$results[3],$results[4]);*/
	//Fungsi mengecek Apakah barang sudah ada di cart
	function IsBarangExist($Barang){
		foreach ($_SESSION['cart'] as $BarangTemp){
			if ($BarangTemp[0]->GetIdBarang()==$Barang->GetIdBarang()){
				return true;}
		}
		return false;
	}
	if ($Jumlah < $OldJumlah){
	if (!isset($_SESSION['cart'])){
		$_SESSION['cart'][$IdBarang][0]=$Barang;
		$_SESSION['cart'][$IdBarang][1]=$Jumlah;
	}
	else{
		if (!IsBarangExist($Barang)){
			$_SESSION['cart'][$IdBarang][0]=$Barang;
			$_SESSION['cart'][$IdBarang][1]=$Jumlah;
		}
		else{
			$_SESSION['cart'][$IdBarang][1]+=$Jumlah;
		}
	}
	}
?>
	