<?php
			$url= "http://if3110tubes3.herokuapp.com/REST/getJumlahBarang/".urlencode($_GET['id']);
	$response=json_decode(file_get_contents($url),true);
	
	$arr=$response;
	
			
			if($arr['jumlah']<$_GET['jumlah'])
			{
				echo $arr['jumlah'];
			}
			else
			{
				$client = new SoapClient(null, array(
				'location' => "http://if3110tubes3.herokuapp.com/server.php",
				'uri'      => "urn://if3110tubes3.herokuapp.com"));

   $return = $client->__soapCall("addCart",array($_COOKIE['IdCustomer'],$_GET['id'],$_GET['jumlah'],$_GET['permintaan']));
   $mysql2=json_decode($return,true);
   $mysql=$mysql2['status'];
	
				if($mysql)
				{
				}
				else
				{
				echo "gagal";
				}
				
				
				
			}
			
     
?>

