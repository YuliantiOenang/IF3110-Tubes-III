<?php
include('database_connection.php');
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

?>
<?php
		for ($i=0; $i<mb_strlen($_GET['nama_lengkap']); $i++){
			if ($_GET['nama_lengkap']{$i}=='+'){
				$_GET['nama_lengkap']{$i} = ' ';
			}
		}
		for ($i=0; $i<mb_strlen($_GET['password']); $i++){
			if ($_GET['password']{$i}=='+'){
				$_GET['password']{$i} = ' ';
			}
		}
		for ($i=0; $i<mb_strlen($_GET['alamat']); $i++){
			if ($_GET['alamat']{$i}=='+'){
				$_GET['alamat']{$i} = ' ';
			}
		}
		for ($i=0; $i<mb_strlen($_GET['kota']); $i++){
			if ($_GET['kota']{$i}=='+'){
				$_GET['kota']{$i} = ' ';
			}
		}
		for ($i=0; $i<mb_strlen($_GET['provinsi']); $i++){
			if ($_GET['provinsi']{$i}=='+'){
				$_GET['provinsi']{$i} = ' ';
			}
		}
$sql="UPDATE account_customer SET password='$_GET[password]', nama_lengkap='$_GET[nama_lengkap]', phone='$_GET[handphone]', alamat='$_GET[alamat]', provinsi='$_GET[provinsi]', postcode='$_GET[kodepos]', city='$_GET[kota]'
WHERE username='$_GET[username]'";
if (!mysql_query($sql,$link))
  {
  die('Error: ' . mysql_error($link));
  echo '0';
  }
  else {
  	echo '1';
  }
mysql_close($link);
?>
