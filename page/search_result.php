<?php
	if(!isset($_SESSION)){
		session_start();
	}
	
	if(isset($_SESSION['login_user'])) {
		$user_check = $_SESSION['login_user'];
	} else {
		$user_check = "";
	}
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Search Result</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="search_result.js"></script>
	</head>
	<body>
		<!--Header-->
			<div id="header">
				<?php
					include("header.php");
				?>
			</div><hr id="border"></div>
			<!--Body-->
			<div id="search-result-body">
				<?php
					if (isset($_GET['category'])) {
						$category 	= $_GET['category'];
						$mode		= "3";
					} else {
						$mode 		= $_POST['modesearch'];
						if ($mode == "1") {
							$text 		= $_POST['search_text'];
						} else {
							$pricemin	= $_POST['search_pricemin'];
							$pricemax	= $_POST['search_pricemax'];
						}
						
					}

					$con	= getConnection();					
					switch($mode)
					{
						case "1":
							$sql	= "SELECT * FROM goods WHERE goods_detail LIKE '%$text%'";
							break;							
						case "2":
							$sql	= "SELECT * FROM goods";
							break;
						case "3":
							$sql 	= " SELECT goods.* 
										FROM (goods NATURAL JOIN categorymeetup) NATURAL JOIN category
										WHERE cata_name LIKE '%$category%'";
							break;
					}
					
					$result	= mysql_query($sql);
					
					$flagmode2 = true;

					while($row = mysql_fetch_array($result)){
						
						if ($mode == "2") {
							if (!($pricemax == "")) {
								if (($pricemin < $row["goods_price"]) && ($pricemax > $row["goods_price"])) {
									$flagmode2 = true;
								} else {
									$flagmode2 = false;
								}
							} else {
								if ($pricemin < $row["goods_price"]) {
									$flagmode2 = true;
								} else {
									$flagmode2 = false;
								}
							}
							
						}
						
						if ($flagmode2) {
							$path_image = '../img/goods/'.$row["goods_name"].'.jpg';
							echo "<div class=\"goods-category-body\">";
							echo "<div id=\"goods-result\">
										<div id=\"goods-image\">
											<a href=\"detailbarang.php?namabarang=".$row["goods_name"]."&hasil=\">
												<img alt=\"image\" id=\"photo\" src=\"$path_image\" width=\"100\" height=\"120\"/>
											</a>
										</div>
										<div id=\"goods-detail\">
											<div id=\"goods-name\">
												<a href=\"detailbarang.php?namabarang=".$row["goods_name"]."&hasil=\">".$row['goods_detail']."
												</a>
											</div><br>
											Harga : ".$row['goods_price']."
										</div>
									</div>";
							echo "</div>";
						}
					}
					
					mysql_close($con);
			
				?>

			</div>
	</body>
</html>
