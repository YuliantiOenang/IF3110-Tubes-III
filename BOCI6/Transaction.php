<?php 
	include 'LibUser.php';
	session_start();
	if (isset($_GET['TransAct']) AND isset($_SESSION['username']) AND isset($_SESSION['cardnumber']) AND isset($_SESSION['cart'])){
		/*mysql_connect("localhost", "root", "") or die("Error connecting to database: ".mysql_error());
		mysql_select_db("datauser") or die(mysql_error());*/
		function InsertToDB($IdBarang,$Jumlah,$Harga,$Username,$NamaBarang,$Kategori){
			$conn=mysql_connect("localhost", "root", "") or die("Error connecting to database: ".mysql_error());
			mysql_select_db("datauser") or die(mysql_error());
			$sql = "INSERT INTO TransactionLog VALUES('$IdBarang','$NamaBarang','$Harga','$Jumlah','$Username','$Kategori');";
			$retval=mysql_query($sql,$conn) or die(mysql_error());
			if(!$retval){
				die('Could not enter data: ' . mysql_error());
			}
			echo "Entered data successfully\n";
		}
		function UpdateDB($IdBarang,$Jumlah){
			mysql_connect("localhost","root","") or die("Error connecting to database: ".mysql_error());
			mysql_select_db("datauser") or die(mysql_error());
			$raw_results = mysql_query("SELECT Jumlah FROM Barang WHERE IdBarang='$IdBarang'") or die (mysql_error());
			$i=0;
			$results=mysql_fetch_array($raw_results);
			$OldJumlah=$results[0];
		
			$NewJumlah=$OldJumlah-$Jumlah;
			
			mysql_query("UPDATE Barang SET Jumlah='$NewJumlah' WHERE IdBarang='$IdBarang';") or die (mysql_error());
		}	
		foreach ($_SESSION['cart'] as $Barang){
			$NamaBarang=$Barang[0]->GetNamaBarang();
			$Jumlah=$Barang[1];
			$Harga=$Barang[0]->GetHarga();
			$IdBarang=$Barang[0]->GetIdBarang();
			$Kategori=$Barang[0]->GetKategori();
			$Username=$_SESSION['username'];
			InsertToDB($IdBarang,$Jumlah,$Harga,$Username,$NamaBarang,$Kategori);
			UpdateDB($IdBarang,$Jumlah);	
		}
		unset($_SESSION['cart']);
		echo "transaksi berhasil";
		echo "<a href=\"index.php\">BACK</a><br>";}
	else if (isset($_SESSION['username']) AND !isset($_SESSION['cardnumber'])){
		header('location:credit-card.php');}
	else{
		header('location:index.php');}
?>