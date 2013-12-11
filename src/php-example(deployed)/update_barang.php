<?php
include('database_connection.php');
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

?>
<?php
		for ($i=0; $i<mb_strlen($_GET['nama']); $i++){
			if ($_GET['nama']{$i}=='+'){
				$_GET['nama']{$i} = ' ';
			}
		}
		for ($i=0; $i<mb_strlen($_GET['kategori']); $i++){
			if ($_GET['kategori']{$i}=='+'){
				$_GET['kategori']{$i} = ' ';
			}
		}
		for ($i=0; $i<mb_strlen($_GET['deskripsi']); $i++){
			if ($_GET['deskripsi']{$i}=='+'){
				$_GET['deskripsi']{$i} = ' ';
			}
		}
$sql="UPDATE catalog_product SET name='$_GET[nama]', category='$_GET[kategori]', price='$_GET[harga]', quantity='$_GET[stok]', description='$_GET[deskripsi]', path='$_GET[path]'
WHERE id='$_GET[id]'";
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
