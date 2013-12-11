<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/latihan.css"> <!--pemanggilan file css-->
<script src="js/AjaxCreateObject.js" language="javascript"></script>
<script src="js/function.js" language="javascript"></script>
</head>


<body>
<?php include "headeradmin.php"; ?>
    
<div class = "bodymain">
    <?php include "sidebar.php"; ?>
	<div class = "boddy">
		<div class = "topfivetitle">
		<p class = "title"> CATEGORY</p></br></br>
		<form method="get" action="kategori.php">
		<input type="key" name="key" hidden value="<?php echo $_GET['key'] ?>"/>
		<select name="sort">
			<option selected="<?php if (isset($_GET['sort']) and $_GET['sort']=='nama') echo "true"; else if(!isset($_GET['sort'])) echo 'false' ?>" value="nama"> Nama Barang </option>
			<option selected="<?php if (isset($_GET['sort']) and $_GET['sort']=='harga') echo "true"; else echo 'false' ?>" value="harga">Harga Barang</option>
		</select>
		<input type="submit" value="Sort">
		</form>
		</div>
		
		<?php
		
		$counter=0;
		
		if(isset($_GET['key']))
		{
			if(isset($_GET['sort']))
			{	
				session_unset();
		
				$url= "http://if3110tubes3.herokuapp.com/REST/getBarangSort/".$_GET['key']."/".$_GET['sort'];
				$response=json_decode(file_get_contents($url),true);
				$arr=$response;
				echo $arr["nama1"];
				$counter=0;
				while(isset($arr['nama'.$counter]))
				{
						$_SESSION['nama'.$counter]=$arr['nama'.$counter];
						$_SESSION['harga'.$counter]=$arr['harga'.$counter];
						$_SESSION['foto'.$counter]=$arr['foto'.$counter];
						$_SESSION['id'.$counter]=$arr['id'.$counter];
						$counter++;
						
				}
				echo $counter;
				$_SESSION['jumlah']=$counter;
			}
			else
			{
				session_unset();
		
				
				$url= "http://if3110tubes3.herokuapp.com/REST/getBarang/".$_GET['key']."";
				$response=json_decode(file_get_contents($url),true);
				$arr=$response;
				echo $arr["nama1"];
				$counter=0;
				while(isset($arr['nama'.$counter]))
				{
						$_SESSION['nama'.$counter]=$arr['nama'.$counter];
						$_SESSION['harga'.$counter]=$arr['harga'.$counter];
						$_SESSION['foto'.$counter]=$arr['foto'.$counter];
						$_SESSION['id'.$counter]=$arr['id'.$counter];
						$counter++;
						
				}
				echo $counter;
				$_SESSION['jumlah']=$counter;
			}
			//$_SESSION['hasil']=$hasil;
		}
		
		else
		{
		$hasil=$_SESSION['hasil'];
		//session_unset();
		$_SESSION['hasil']=$hasil;
		}
		if(!isset($_GET['page']))
		{
			$i=0;
			while($i<$counter && $i<10 && isset($_SESSION['nama'.$i]))
			{
			
			echo '<div class = "searchres">
					<div class = "previmage">
						<img src= "'.$_SESSION["foto".$i].'" class="resizeimage"><img>
					</div>
					<a href="detailbarang.php?id='.$_SESSION['id'.$i].'"><p class = "copyrightext"> '.$_SESSION["nama".$i].'</a> </br>
						  Rp'.$_SESSION["harga".$i].' </label> </br> </p>
					<laabel>jumlah :</label><input type="text" size=4  id="jumlahBarang'.$i.'"/>
					<input type="text" id="idBarang'.$i.'" value="'.$_SESSION['id'.$i].'" hidden/>';
					if(isset($_COOKIE['user1']))
					{
					?>
					<input type="button" onclick="cekJumlah(<?php echo $i;?>)" value="Beli"></input>
					<?php
					}
					else
					{
					?>
					<input type="button" onclick="alert('anda harus login terlebih dahulu'); window.location='index.php'" value="Beli"></input>
					<?php
					}
					echo '</div>';
			$i++;
			}
		}
		else
		{
			$counter=0;
			$batas=($_GET['page']*10)+10;
			$counter=$_GET['page']*10;
			while($counter<$batas && isset($_SESSION['nama'.$counter]))
			{
			echo '<div class = "searchres">
					<div class = "previmage">
						<img src= "'.$_SESSION["foto".$counter].'" class="resizeimage"><img>
					</div>
					<a href="detailbarang.php?id='.$_SESSION['id'.$counter].'"><p class = "copyrightext"> '.$_SESSION["nama".$counter].'</a> </br>
						  Rp'.$_SESSION["harga".$counter].' </label> </br> </p>
					<laabel>jumlah :</label><input type="text" size=4  id="jumlahBarang'.$counter.'"/>
					<input type="text" id="idBarang'.$counter.'" value="'.$_SESSION['id'.$counter].'" hidden/>';
					if(isset($_COOKIE['user1']))
					{
					?>
					<input type="button" onclick="cekJumlah(<?php echo $counter;?>)" value="Beli"></input>
					<?php
					}
					else
					{
					?>
					<input type="button" onclick="alert('anda harus login terlebih dahulu'); window.location='index.php'" value="Beli"></input>
					<?php
					}
					echo '</div>';
			$counter++;
			}
		}
		?>
			 <div class = "searchnext">
			 <?php

			 $num_rows = $_SESSION['jumlah'];
			 
			 if($num_rows%10!=0 && $num_rows>10)
			 {
				$tambah=1;
			 }
			 else
			 {
				$tambah=0;
			 }
			 $jumlahPage=$num_rows/10 + $tambah;
			 if(isset($_GET['sort']))
			 {
				$sort=$_GET['sort'];
			 }
			 else
			 {
				$sort="nama";
			 }
			 $i=0;
			 echo "Page : ";
		 for($i=0;$i<$jumlahPage-1;$i++)
			{
			echo '<a href="kategori.php?page='.$i.'&sort='.$sort.'&key='.$_GET['key'].'">'.($i+1).'  </a>';
			}
			?>
			</div>
			  
	</div>
	</div>
</body>
</html>