
<?php
	session_start();
	$email = $_GET["user"];
	$password = $_GET["pass"];
	
	$url= "http://limitless-earth-2748.herokuapp.com/REST/getPassPelanggan/".$email;
	$response=json_decode(file_get_contents($url));
	$bool=$response;
	
	if($bool)
	{
			$url= "http://limitless-earth-2748.herokuapp.com/REST/cekPassword/".urlencode("SELECT password FROM customer WHERE username = '$email' and password= '$password'");
			$response=json_decode(file_get_contents($url));
			$jumlah=$response;
			if($jumlah!=0)
			{
				$url= "http://limitless-earth-2748.herokuapp.com/REST/getAllCustomer/".$email;
				$response=json_decode(file_get_contents($url),true);
				
				$retVal=$response;
				$idmember=$retVal['idmember'];
				$getID=$retVal['getID'];
				$kota=$retVal['kota'];
				$kodepos=$retVal['kodepos'];
				$email=$retVal['email'];
				$hp=$retVal['hp'];
				$username=$retVal['username'];
				$provinsi=$retVal['provinsi'];
				$alamat=$retVal['alamat'];
				
				
				

								setcookie("user1", $idmember, time()+3600*24*30);
								setcookie("IdCustomer", $getID, time()+3600*24*30);
								setcookie("kobupaten", $kota, time()+3600*24*30);
								setcookie("kodepos", $kodepos, time()+3600*24*30);
								setcookie("email", $email, time()+3600*24*30);
								setcookie("handphone", $hp, time()+3600*24*30);
								setcookie("username", $username, time()+3600*24*30);
								setcookie("provinsi", $provinsi, time()+3600*24*30);
								setcookie("alamat", $alamat, time()+3600*24*30);
								
								$return = array();
								$return['nama'] = $idmember;
								$return['id'] = $getID;

								echo json_encode($return);
	
		}
		else
		{		
				echo "Login Gagal, Password salah";
		}
		
	}
	else
		{
				echo "Login Gagal, Email tidak valid";

		}
?>
