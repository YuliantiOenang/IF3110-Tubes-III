<?php 
/*
	session_start();
	session_destroy();
*/

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
		
		<!--content-->
		<div class="populer">
				<center>
					<div id="popularFont">
						<p>BARANG TERPOPULER</p>
					</div>
				<ul>
					<li>															
						<?php
							$result = mysqli_query($con,"SELECT * FROM product where (sold = (SELECT Max(sold) from product where category='elektronik')) AND category='elektronik'");					
							while($row = mysqli_fetch_array($result))
							{	
								echo "Kategori <b>Elektronik</b><br>";
								echo '<a href=' . SITEURL . '/product/detail/' . $row['product_id'] . '>';
								echo '<img src=' . SITEURL . '/include/' . $row['image_link'] . '>';
								echo '</a>';
							}						
						?>										
					</li>						
					
					<li>
						<?php
							$result = mysqli_query($con,"SELECT * FROM product where (sold = (SELECT Max(sold) from product where category='otomotif')) AND category='otomotif'");							
							while($row = mysqli_fetch_array($result))
							{	
								echo "Kategori <b>Otomotif</b><br>";
								echo '<a href=' . SITEURL . '/product/detail/' . $row['product_id'] . '>';
								echo '<img src=' . SITEURL . '/include/' . $row['image_link'] . '>';
								echo '</a>';
							}						
						?>				
					</li>
					
					<li> 				
						<?php
							$result = mysqli_query($con,"SELECT * FROM product where (sold = (SELECT Max(sold) from product where category='fashion')) AND category='fashion'");							
							while($row = mysqli_fetch_array($result))
							{	
								echo "Kategori <b>Fashion</b><br>";
								echo '<a href=' . SITEURL . '/product/detail/' . $row['product_id'] . '>';
								echo '<img src=' . SITEURL . '/include/' . $row['image_link'] . '>';
								echo '</a>';
							}						
						?>				
					</li>
					
					<li> 				
						<?php
							$result = mysqli_query($con,"SELECT * FROM product where (sold = (SELECT Max(sold) from product where category='properti')) AND category='properti'");							
							while($row = mysqli_fetch_array($result))
							{	
								echo "Kategori <b>Properti</b><br>";
								echo '<a href=' . SITEURL . '/product/detail/' . $row['product_id'] . '>';
								echo '<img src=' . SITEURL . '/include/' . $row['image_link'] . '>';
								echo '</a>';
							}						
						?>				
					</li>
					
					<li>
						<?php
							$result = mysqli_query($con,"SELECT * FROM product where (sold = (SELECT Max(sold) from product where category='musik')) AND category='musik'");							
							while($row = mysqli_fetch_array($result))
							{	
								echo "Kategori <b>Musik</b><br>";
								echo '<a href=' . SITEURL . '/product/detail/' . $row['product_id'] . '>';
								echo '<img src=' . SITEURL . '/include/' . $row['image_link'] . '>';
								echo '</a>';
							}						
						?>									
					</li>
				</ul>
			</center>
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
