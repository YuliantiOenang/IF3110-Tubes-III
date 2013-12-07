<?php
	if (isset($_COOKIE['isLogin']))
	{
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
<div class="center">
<div class="register_div">
	<h1 class="header">Profil</h1>
	<div class="per_form">
		<label>Nama Lengkap:</label><p>habibie faried</p>
	</div>
	<div class="per_form">
		<label>Username:</label><p>habibie</p>
	</div>
	<div class="per_form">
		<label>Email:</label><p>sdasdas@as.com</p>
	</div>
	<div class="per_form">
		<label>Alamat:</label><p>Jl. pelesiran 6</p>
	</div>
	<div class="per_form">
		<label>Provinsi:</label><p>Aceh</p>
	</div>
	<div class="per_form">
		<label>Kota:</label><p>kenangan</p>
	</div>
	<div class="per_form">
		<label>Kode Pos:</label><p>11111</p>
	</div>
	<div class="per_form">
		<label>Telepon:</label><p>08213121</p>
	</div>
	<div class="per_form">
		<label>Transaksi:</label><p>4</p>
	</div>
	<a class="btn" href="editProfil.php">Edit Profile</a>
</div>

</div>
			</div>
		</div>
		<?php
require_once('footer.php');
}else
{
	header("Location: register.php");
}
?>
