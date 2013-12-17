<?php
	$con=mysqli_connect("localhost","root", "", $CONFIG['mysql']['database'] );
	if(mysqli_connect_errno()){
			echo "Gagal Buka DB" . msqli_connect_error();
	}
?>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<?php echo SITEURL . '/include/css/style.css'?>">		
	</head>
		
	<body> 
		
		<?php require SITEPATH . '/app/views/header.php'?>			
		
		<!-- BAGIAN POP UP MESSAGE-->
		<a href="#x" class="overlay" id="login_form"></a>
		<div class="popup">
			<h2>Selamat Datang disitus kami</h2>
			<p>Silahkan masukan username dan password</p>
			
			<div>
				<input type="text" id="login" placeholder="username" />
			</div>
			
			<div>
				<input type="password" id="login" placeholder="password" />	
			</div>			
			<input type="button" value="Log In"/>			
			
			<a class="close" href="#close"></a>
		</div>	
		<!-- END HEADER-->
		
		<!--content = detail barang-->
		<div class="detailBarang">						
				<ul>
					<center>
						<li> 						
							<img src="
								<?php
									$result = mysqli_query($con,"SELECT * FROM product WHERE product_id = " . $product_id);									
									while($row = mysqli_fetch_array($result))
									{	
										echo SITEURL . '/include/' . $row['image_link'];
										//echo "SELECT * FROM product WHERE product_id = " . $product_id;
									}						
								?>">						
						</li>
					</center>				
					
					<ul>
						<li>
							<p>
								Nama Barang		<br>							
								Harga Barang	<br>
								Stock			<br>
								Deskripsi		<br>
							</p>
						</li>
						
						<li>
							<p align="justify">
								<?php
									$result = mysqli_query($con,"SELECT * FROM product WHERE product_id = " . $product_id);									
									while($row = mysqli_fetch_array($result))
									{	
										echo $row['product_name'] . "<br>";	
										echo $row['price'] . "<br>";
										echo $row['stock_count'] . "<br>";
										echo $row['description'] . "<br>";										
									}						
								?>

							</p>
						</li>
					</ul>
					
					<li>
						<center>
						<form action="<?php echo SITEURL . '/cart/add/' . $product_id ?>" method="post">
							<li>
								<center>
									<p>Quantity <input type="number" name="quantity"><br></p>
									<button type="submit" class="buttonBeli"> BELI </button>
	
								</center>
							</li>	
						</form>
						</center>
					</li>						
				</ul>			
		</div>
		<!--end content-->		
	</body>		
	<!--
	<footer>
		<div id="footer">
			INI FOOTER
		</div>		
	</footer>-->
</html>
