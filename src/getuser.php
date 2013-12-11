<?php
$u = $_GET['q'];
$p = $_GET['r'];

include "koneksi.inc.php";
$sql="SELECT password FROM anggota WHERE username = '".$u."'";
$result = mysql_query($sql,$koneksi);
if(mysql_num_rows($result)==1){
  $row = mysql_fetch_array($result);
  if($p==$row['password']) echo "LOGIN";
}else echo "Incorrect username/password Combination
The username and password you entered don't match.";
?>