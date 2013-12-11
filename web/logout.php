<?php
session_start();
session_destroy();
include "config/connect.php";

$mysql5=mysql_query("DELETE FROM `keranjang` WHERE id_customer='".$_COOKIE['IdCustomer']."'");
								setcookie("user1", $idmember, time()-3600*24*30);
								setcookie("IdCustomer", $getID, time()-3600*24*30);
								setcookie("kobupaten", $kota, time()-3600*24*30);
								setcookie("kodepos", $kodepos, time()-3600*24*30);
								setcookie("email", $email, time()-3600*24*30);
								setcookie("handphone", $hp, time()-3600*24*30);
								setcookie("username", $username, time()-3600*24*30);
								setcookie("provinsi", $provinsi, time()-3600*24*30);
								setcookie("alamat", $alamat, time()-3600*24*30);

header("location: index.php");

?>