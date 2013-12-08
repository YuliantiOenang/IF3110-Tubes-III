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
		
		
		<!-- CONTENT -->
		<div class="searchResult">
			<?php 
				error_reporting(0);
				if(!empty($keyword)){										
					$query ="SELECT * FROM product WHERE category='";
					if(strcasecmp($keyword,"Elektronik")==0){
							$query=$query . "Elektronik";
						}else if(strcasecmp($keyword,"Fashion")==0){
							$query=$query . "Fashion";
						}else if(strcasecmp($keyword,"Otomotif")==0){
							$query=$query . "Otomotif";
						} else if(strcasecmp($keyword,"Properti")==0){
							$query=$query . "Properti";
						}else if(strcasecmp($keyword,"Musik")==0){
							$query=$query . "Musik";
						}		
					
					$query=$query . "' OR product_name LIKE '%" . $keyword . "%';";
					
					if ($stmt=mysqli_prepare($con,$query)){

						/* execute query */
						mysqli_stmt_execute($stmt);

						/* store result */
						mysqli_stmt_store_result($stmt);
						
						$count=mysqli_stmt_num_rows($stmt);
						echo "Ditemukan <b>". $count . "</b> hasil pencarian untuk &quot;<b>" . $keyword . "</b>&quot;<br>";
						
						/* close statement */
						mysqli_stmt_close($stmt);
					}																							
				}else if(!empty($category)){
					$arrCat=array("Elektronik", "Otomotif", "Sandang");					
					$query ="SELECT * FROM product WHERE category=";
					$query=$query . "'". $category . "'". ";";																	
					echo "Berikut barang yang tersedia pada kategori <b>" . $category . "</b>";
				} else {
					//echo 'AAAAAAAAA';
				}					
				
				//echo $query;
				$result=mysqli_query($con,$query);;

				if (!$result) {
					printf("Error: %s\n", mysqli_errno($con));
					//exit();
				}
				
				echo "<ul>";										
				while($row=mysqli_fetch_array($result)){					
					echo "	<ul>
								<li> 
									
									<a href=" . SITEURL . "/product/detail/" . $row['product_id'] . "><img src=" . SITEURL . '/include/' . $row['image_link']  . "></a>
								</li>
								
								<li>
									Nama Barang<br>
									Harga<br>
									Jumlah Stock<br>
								</li>
																	
								<li>							
									: " . $row['product_name'] . "<br>
									: " . $row['price'] . "<br>
									: " . $row['stock_count'] . "<br>								
								</li>

								<li>					

									<form action=" . SITEURL . "/cart/add/" . $product_id . " method=post>
										<li>
											<center>
												<p>Quantity <input type=number name=quantity><br></p>
												<button type=submit class=buttonBeli> BELI </button>
				
											</center>
										</li>	
									</form>
								</li>

							</ul>";		
				}									
				echo "</ul>";
			?>
		</div>
	</body>
</html>