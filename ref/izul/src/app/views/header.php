<!--header-->
<div id="header">
	<div>
		<nav class="dropdownHeader"> <!-- untuk link-->
			<center>
				<ul>
					<li><a id="logo" href="<?php echo SITEURL ?>"><img src="<?php echo SITEURL . '/include/images/logo.png'?>" ></a></li> <!-- ganti dengan gambar logo ya-->
					
					<li><a href="#">Kategori Barang</a> <!-- # = masuk ke katogori barang-->
						<ul>
							<li><a href="<?php echo SITEURL . '/product/category/elektronik' ?>">Elektronik</a></li>
							<li><a href="<?php echo SITEURL . '/product/category/sandang' ?>">Sandang</a></li>	
							<li><a href="<?php echo SITEURL . '/product/category/otomotif' ?>">Otomotif</a></li>		
							<li><a href="<?php echo SITEURL . '/product/category/properti' ?>">Properti</a></li>	
							<li><a href="<?php echo SITEURL . '/product/category/musik' ?>">Musik</a></li>								
						</ul>
					</li>

				<?php 
					//periksa apakah sedang login atau tidak
					if (session_id() == '') session_start();
			
					if (!isset($_SESSION['logged_userid'])) {
						echo '<li><a href="' . SITEURL . '/register/">Register</a></li>';
						echo '<li><a href="#login_form">Login</a></li>	';
					} else {
						echo '<li><a>Welcome ' . $_SESSION['logged_username'] . '</a></li>';
						echo '<li><a href="' . SITEURL . '/profile/">Profile</a></li>';
						echo '<li><a href="' . SITEURL . '/login/destroy/">Logout</a></li>';			
					}
				?>
											
					<li>
						<center>
							<form id="search" action="<?php echo SITEURL . '/product/search'?>">
								<input name="keyword" type="text" size="40" placeholder="Cari barang..." />
							</form>
						</center>
						
					<!--
						<center><form id="cariBarang">					
							<input type="type" placeholder="Pencarian">
						</form></center> -->
					</li>
					<li><a href="#" id="keranjang">Keranjang</a></li>	
				</ul>
			</center>
		</nav>
	</div>
</div>	

<!-- BAGIAN POP UP MESSAGE-->
<a href="#x" class="overlay" id="login_form"></a>
<div class="popup">
	<h2>Selamat Datang disitus kami</h2>
	<p>Silahkan masukan username dan password</p>
	
	<form name="loginForm" method="post" action="<?php echo SITEURL . '/login' ?>">
		<div>
			<input type="text" id="login-user" name="login-user" placeholder="username" />
		</div>
		
		<div>
			<input type="password" id="login-pass" name="login-pass" placeholder="password" />	
		</div>			
		<input type="submit" name="Submit" value="Login"/>
	</form>	
		<br>
		Belum Punya Account ? <a href="#"> DAFTAR </a>
	<a class="close" href="#close"></a>
</div>	
<!-- END HEADER-->		