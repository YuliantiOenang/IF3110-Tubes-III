<?php
include('database_connection.php');
//Include The Database Connection File 

if(isset($_GET['username'], $_GET['buy'])) 
{
	$bag = json_decode($_GET['buy'],true);//Some clean up :)
	$myusername = $_GET['username'];
	$valid = 'true';
	foreach ($bag as $key=>$values) {
		$row = mysql_query("SELECT * FROM catalog_product WHERE id='$key'");
		$row2 = mysql_fetch_array($row);
		if ($row2['quantity'] < $values)
			$valid = 'false';
	}
	$row3 = mysql_query("SELECT * FROM account_customer WHERE Username='$myusername'") or die(mysql_error());
	$row4 = mysql_fetch_array($row3);
	if ($row4['cc_number'] == 0){
		echo "Belum registrasi credit card";
	} else
	if ($valid == 'false') {
		echo "Ada barang yang jumlahnya tidak mencukupi";
	} else {
		foreach ($bag as $key=>$values) {
			$row = mysql_query("UPDATE catalog_product SET quantity=quantity-'$values' WHERE id='$key'");
			$row5 = mysql_query("UPDATE catalog_product SET number_sold=number_sold+'$values' WHERE id='$key'");
		}
		$row2 = mysql_query("UPDATE account_customer SET n_transaction=n_transaction+1 WHERE username='$myusername'");
		echo "Pembelian sukses";
	}
} else if(isset($_GET['username']))//If a username has been submitted 
{
	$username = mysql_real_escape_string($_GET['username']);//Some clean up :)

	$check_for_username = mysql_query("SELECT * FROM account_customer WHERE username='$username'");
	//Query to check if username is available or not 

	if(mysql_num_rows($check_for_username))
	{
		echo '1';//If there is a  record match in the Database - Not Available
	}
	else
	{
		echo '0';//No Record Found - Username is available 
	}
}
else if(isset($_GET['nama']))//If a username has been submitted 
{
	$nama = mysql_real_escape_string($_GET['nama']);//Some clean up :)

	$check_for_username = mysql_query("SELECT * FROM catalog_product WHERE name='$nama'");
	//Query to check if username is available or not 

	if(mysql_num_rows($check_for_username))
	{
		echo '1';//If there is a  record match in the Database - Not Available
	}
	else
	{
		echo '0';//No Record Found - Username is available 
	}
} else if(isset($_GET['email']))//If a username has been submitted 
{
	$email = mysql_real_escape_string($_GET['email']);//Some clean up :)

	$check_for_email = mysql_query("SELECT * FROM account_customer WHERE email='$email'");
	//Query to check if email is available or not 

	if(mysql_num_rows($check_for_email))
	{
		echo '1';//If there is a  record match in the Database - Not Available
	}
	else
	{
		echo '0';//No Record Found - Username is available 
	}
} else if(isset($_GET['id']))//If a username has been submitted 
{
	$id = mysql_real_escape_string($_GET['id']);//Some clean up :)

	$row = mysql_query("SELECT * FROM catalog_product WHERE id='$id'");
	$row2 = mysql_fetch_array($row);
	//Query to check if username is available or not 
	echo $row2['quantity'];
} else if(isset($_GET['bag']))//If a username has been submitted 
{
	$bag = json_decode($_GET['bag'],true);//Some clean up :)
	$ret = "";
	$tot = 0;

	foreach ($bag as $key=>$values) {
		$row = mysql_query("SELECT * FROM catalog_product WHERE id='$key'");
		$row2 = mysql_fetch_array($row);
		$ret=$ret."
		<div class=\"cell tricol\">
			<br>
			<img src=.".$row2['path']." width=\"250\" height=\"250\">
			<div class=\"ex\">
				<center>
					<a href=\"Detail_Barang.php?id=".$row2['id']."\">".$row2['name']."</a>
				<center>
				".$row2['price']."
				<form action=\"proses_form.php\" method=\"POST\" >
					Jumlah Pembelian: <input type=\"text\" name=\"jumlah\" id=\"jumlah\" value=".$values.">
					<br>
					<span id=\"status\"></span>
				</form>
				<center><button type=\"button\" onclick=\"jumlah_check(".$row['id'].")\">Ganti jumlah</button><center>
			</div>
			<br>
			<br>
			<br>
		</div>";
		$tot=$tot+$values*$row2['price'];
	}
	$ret=$ret."
	<div class=\"cell tricol\">
		<br>
		<br>
		<div>
			".$tot."
		</div>
		<br>
		<br>
		<br>
	 	<form method=\"post\" action=\"checkbuy.php\">
			<div class=\"style_form\">
		    	<input name=\"submit\" type=\"submit\" value=\"Buy All\" id=\"reg_btn\"/>
		    </div>
	  	</form>
		<br>
		<br>
		<br>
	 	<form method=\"post\" action=\"clearshoppingbag.php\">
			<div class=\"style_form\">
		    	<input name=\"submit\" type=\"submit\" value=\"Clear All\" id=\"reg_btn\"/>
		    </div>
	  	</form>
	</div>";

	echo $ret;
}
?>