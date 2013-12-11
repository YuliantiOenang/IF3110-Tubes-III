<?php
					$client = new SoapClient(null, array(
				'location' => "http://if3110tubes3.herokuapp.com/server.php",
				'uri'      => "urn://if3110tubes3.herokuapp.com"));

  if($_GET['jumlah'] == 0)
  {
  ?>
				<script type="text/javascript">
							window.alert("Tidak ada barang yang di beli");
							window.location="pembayaran.php";
				</script>
	<?php
  }
  $url= "http://if3110tubes3.herokuapp.com/REST/getCardNumber/".$_COOKIE['IdCustomer'];
$response=json_decode(file_get_contents($url));
	
$arr=$response;
	
	if($arr=='0')
	{
		?>
				<script type="text/javascript">
							window.alert("Maaf Anda belum mendaftarkan kartu kredit anda");
							window.location="registrasi_kartu.php?status=payment";
				</script>
		<?php
	}
	
  $url= "http://if3110tubes3.herokuapp.com/REST/prosesPayment1/".$_COOKIE['IdCustomer'];
$response=json_decode(file_get_contents($url));
	$count=0;
$arr=$response;
  $bool=$arr;
			
			$boolChek=true;
			if($bool)
			{
			  $url= "http://if3110tubes3.herokuapp.com/REST/prosesPayment2/".$_COOKIE['IdCustomer'];
				$response=json_decode(file_get_contents($url),true);
	
				$arr=$response;
				var_dump ($arr);
				
			while(isset($arr['idAlat'.$count]))
			{
				$url= "http://if3110tubes3.herokuapp.com/REST/prosesPayment3/".$arr['idAlat'.$count];
				$response=json_decode(file_get_contents($url),true);
				$arr2=$response;
				var_dump ($arr2);
				$counter=0;
				while(isset($arr2['jumlahProses'.$counter]))
				{	
					if($arr2['jumlahProses'.$counter]<$arr['jumlah'.$count])
					{
						$bool=false;
					}

   $return = $client->__soapCall("addTerbayar",array($arr['idAlat'.$count],$arr['jumlah'.$count],$_COOKIE['IdCustomer'],$arr['pesan'.$count]));
   $mysql2=json_decode($return,true);
   $mysql3=$mysql2['status'];
					$newCount=$arr2['jumlahProses'.$counter]-$arr['jumlah'.$count];
					
					$url= "http://if3110tubes3.herokuapp.com/REST/updatePeralatan/".$newCount."/".$arr['jumlah'.$count];
					$response=json_decode(file_get_contents($url));
					$mysql4=$response;
					
					$url= "http://if3110tubes3.herokuapp.com/REST/deleteKeranjang/".$_COOKIE['IdCustomer'];
					$response=json_decode(file_get_contents($url));
					$mysql5=$response;
					if(!$mysql3 || !$mysql4)
					{
						$boolChek=false;
					}
					$counter++;
				}
				$count++;
				echo $count;
			}
			if($boolChek)
			{
			?>
				<script type="text/javascript">
							window.alert("Berhasil Membeli");
							window.location="index.php";
				</script>
			<?php
			}
			else
			{
				?>
				<script type="text/javascript">
							window.alert("Gagal membeli, terdapat kesalahan dalam akses database");
							window.location="index.php";
				</script>
			<?php
			}
			}
			else
			{
				?>
				<script type="text/javascript">
							window.alert("Gagal Membeli, benda kurang");
							window.location="index.php";
				</script>
			<?php
			}
			
         
     
?>