
<?php
	
	for($i=0;$i<$_GET['jumlahBarang'];$i++)
	{
		if(isset($_GET['checkBox'.$i]))
		{
				$url= "http://limitless-earth-2748.herokuapp.com/REST/deleteKeranjang2/".$_GET['idBarang_'.$i];
				$response=json_decode(file_get_contents($url));
				if($response)
				{
					
				}
		}
	}

	header("location: shoppingbag.php");
?>