<script src='/ruserba/scripts/session.js'></script>
<script src='/ruserba/scripts/search.js'></script>
<div id='logo'>
	<a href='/ruserba'><img src='/ruserba/assets/logo.png' /></a>
</div>
<div id='loggedout'>
	<a id='loginbutton' class='button' href='javascript:void(0)'><div>Masuk</div></a>
	<form id='loginform' method='post'>
		Username<input type='text' name='loginuser' /><br /><br />
		Kata sandi<input type='password' name='loginpass' /><br /><br />
		<span id='loginerror'>Username atau kata sandi salah</span>
		<input type='submit' name='loginsubmit' />
		<a id='loginsubmit' class='button' name='loginsubmit' href='javascript:void(0)'><div>Masuk</div></a>
		<br />
	</form>
	<a id='registerbutton' class='button' href='javascript:void(0)'><div>Daftar</div></a>
</div>
<div id='loggedin'>
	<div id='welcome'>Selamat datang, <a id='user'></a>!</div>
	<a id='logoutbutton' class='button' href='javascript:void(0)'><div>Keluar</div></a>
	<br />
	<a id='cartbutton' class='button' href='/ruserba/cart'><div>
		<img src='/ruserba/assets/cart.png' />
		<span id='totalbarang'><?php
			if (isset($_SESSION['cart'])) {
				$total = 0;
				foreach ($_SESSION['cart'] as $id => $amount) {
					$total += $amount;
				}
				echo $total;
			}
			else {
				echo 0;
			}
		?></span> barang
	</div></a>
</div>
<div id='searchbar'>
	<form id='searchform' method='post'>
		<input type='text' name='searchinput' placeholder='Cari' />
		<input type='submit' name='searchsubmit' />
		<a id='searchbutton' href='javascript:void(0)'><img src="/ruserba/assets/search.png" /></a>
	</form>
</div>