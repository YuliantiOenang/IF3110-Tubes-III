<?php
	if(!isset($_SESSION)){
		session_start();
	}
	
	if(isset($_SESSION['login_user'])) {
		$user_check = $_SESSION['login_user'];
	} else {
		$user_check = "";
	}
	
	if (!function_exists('getConnection')) {
		function getConnection(){
			// Create connection
			$con = mysql_connect("localhost","root","","progin_13510023");
			// Check connection
			if (mysql_connect_errno($con))
			{
				echo "Failed to connect to MySQL: " . mysql_connect_error();
			}
			return $con;
		}
	}
	
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Keranjang Belanja</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body onload="select()">
		<!--Header-->
			<div id="header">
				<?php
					include("header.php");
					
						$con 	= getConnection();
	
						$sql	= "SELECT * FROM cart WHERE profil_ID='$user_check'";

						$result = mysql_query($sql);

						$count	= mysql_num_rows($result);
				?>
			</div>
			<!--Body-->
			<div id="profile-page-body">
				<div id="profil">
					<?php 
					echo "<h1>Daftar Keranjang Belanja</h1>";
					for ($x=0; $x<$count; $x++) {
						echo "Barang<br><br>";
						echo "Jumlah<br><br>";
						echo "Note<br><br>";
						echo "<br>";
					}
					?>
				</div>
				
				<div id="profil">
					<?php 
					echo "<h1><br></h1>";
					while($row = mysql_fetch_array($result)){
						echo "  : ".$row["cart_goods"]."<br><br>";
						echo "  : ".$row["cart_count"]."<br><br>";
						echo "  : ".$row["cart_note"]."<br><br>";
					}	
					?>
				</div>
				
				<div id="cartbutton">
					<form id="buttonbayar" method="post" action="edit-profile.php?username=a"><input type="submit" value="Bayar" ></form>
					
					<form id="buttoncancel" method="post" action="database\cancelcart.php"><input type="submit" value="Cancel" ></form>
				</div>
				

			</div>
	</body>
</html>