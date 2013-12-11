<?php 
	require 'database/getprofil.php';
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Header</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<link href="modal.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="header.js"></script>
	</head>
	<body onLoad="initialize()">
		
		<div id="header-left-side"><a href="index.php"><img src="../image/logo.png" width="222px" height="60px"/></a>
			<div id="header-bottom-side">
				<div id="space"><a href="search_result.php?category=makanan">Makanan</a></div>
				<div id="space"><a href="search_result.php?category=minuman">Minuman</a></div>
				<div id="space"><a href="search_result.php?category=anak">Perawatan Anak-Anak</a></div>
				<div id="space"><a href="search_result.php?category=pribadi">Perawatan Pribadi</a></div>
				<div id="space"><a href="search_result.php?category=rumah">Perlengkapan Rumah</a></div>
			</div>
		</div>
		
		<div id="header-right-side">
			<div id="header-right-search">
				<form action="search_result.php" method="post">
					<select name="modesearch" id="modesearch" onChange="filter()">
						<option value="1">Nama Barang</option>
						<option value="2">Harga</option>
					</select> 
					<input type="text" name="search_text" id="search_text" list="searching-auto" value=""" />
					<input type="text" name="search_pricemin" id="search_pricemin" list="searching-auto" style="display: none;" value=""" />
					<input type="text" name="search_pricemax" id="search_pricemax" list="searching-auto" style="display: none;" value=""" />
					<input type="submit" value="Search"/>
					<div id="list-search"></div> 

				</form>
            
			<?php if(isset($_SESSION['login_user'])) { ?>
							
				<div id="login">
					Welcome, <a href="profile.php"><?php echo $profil_name; ?></a>
				</div>			
				
				<div id="logout">
					<input type="button" value="LOGOUT" onclick="window.location.href='database/logout.php'; return false;" />
					 <a href="cart.php">Keranjang Belanja</a>
				</div>

			<?php } else { ?>
				<div id="login">
					<div id="add-category"><a href="#login_button"><button>LOGIN</button></a>&nbsp;
					
					</div>				
					<!-- popup form #1 -->
							<a href="#x" class="overlay" id="login_button"></a>
							<div class="popup">
								<h2>Login</h2>
								<br>
								<form action="database\checklogin.php" method="post">
								<div>
									<label for="login">Username :</label>
									<input type="text" id="loginusername" value="" name="username"/>
								</div>
								<div>
									<label for="asignee">Password : </label>
									<input type="password" id="loginPassword" value="" name="password"/>
								</div>
								<div>
									<input type="submit" value="Login"/>
									<a href="register.php">Register</a>
								</div>
								</form>

								<a class="close" href="#close"></a>
							</div>
					
				</div>
			<?php } ?>

			</div>
		</div>
	</body>
</html>