<?php
$data = $_GET['q'];
$type = intval($_GET['num']);
if (isset($_GET['pass'])) $pass = $_GET['pass'];
include "koneksi.inc.php";
switch ($type) {
	case 1://Full name validator 
		$regex = '/^([A-Za-z]{1,10})+([ ][A-Za-z]{1,20})+$/';
		if(preg_match($regex,$data)){
			echo 0;
		}else{
			echo 1;
		}
	break;
	case 2://username validator
		$sql="SELECT * FROM anggota WHERE username = '".$data."'";
		$regex = '/^([A-Za-z0-9]{5,20})$/';
		$result = mysql_query($sql,$koneksi);
		$samewithpass = false;
		if($pass==$data){$samewithpass = true;}
		if(mysql_num_rows($result)!=1 && preg_match($regex, $data) && !$samewithpass)echo 0;
	  	else if(mysql_num_rows($result)==1) echo 1;
		else if($samewithpass)echo 2;
		else echo 3;
	break;
	case 3://password validator
		$samewithpass = false;
		if($pass==$data){$samewithpass = true;}
		if(strlen($data)>7  && !$samewithpass){echo 0;}
		else 
			{	
				if($samewithpass){echo 1;}
				else echo 2;
			}
	break;
	case 4://copassword validator
		if($pass==$data){echo 0;}
		else echo 1;
	break;
	case 5://email validator
		$regex = '/^[a-z0-9]+([\._-][a-z0-9]+)*@[a-z0-9]+([\.-][a-z0-9]+)*(\.[a-z]{2,3})$/'; 
		if (preg_match($regex, $data)) {
			//echo $data . " is a valid email. We can accept it.";
			echo 0;
		} else { 
			echo 1;
		 	//echo $data . " is an invalid email. Please try again.";
		}
	break;
}
?>