
<?php
			$url= "http://limitless-earth-2748.herokuapp.com/REST/getJumlahBarang/".urlencode($_GET['id']);
			$response=json_decode(file_get_contents($url),true);
	
			$arr=$response;

			if($arr['jumlah']<$_GET['jumlah'])
			{
				echo $arr['jumlah'];
			}
			else
			{
				$url= "http://limitless-earth-2748.herokuapp.com/REST/updateKeranjang/".$_GET['jumlah']."/".$_COOKIE['IdCustomer'];
				$response=json_decode(file_get_contents($url));
	
				$mysql=$response;
				if($mysql)
				{
				
				
				}
				
				
				
			}
			
     
?>

