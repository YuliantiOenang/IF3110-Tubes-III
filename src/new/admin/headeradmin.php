<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/mainadmin.css" type="text/css" />
	<header id="banner" class="body">
	<span style="float:left"><a href="index.jsp"><img src="images/logo.png" alt="RuSerBa Logo" width="110" height="110"/></a></span>
	<h1><span><a href="index.jsp">RuSerBa<br><br><strong>Ruko Serba Ada</strong></a></span></h1>
 	<nav><ul id="menubar">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="halamanbarang.jsp" onmouseover="slidedown(true)" onmouseup="slidedown(false)">Kategori Barang</a>
			<ul class="sub-menu">	
		
		<?php
		
			$con=mysqli_connect("localhost","root","","ruserba");
			// Check connection
			if (mysqli_connect_errno()) {
				echo "Failed to connect to MySQL: " . mysqli_connect_error();
			}
			$sql = "SELECT * FROM barang group by kategori";
			$result = mysqli_query($con,$sql);
			
			while ($row = mysqli_fetch_array($result)){
				$kategori = $GET['kategori'];
				<li><a href=\"halamanbarang.php?kategori="+$kategori+"\">"+$kategori+</a></li>;
			}
			
		?>
</ul>
		</li>
		<div id="log"></div>
		<li><a href="shoppingbag">Shopping Bag</a></li>
		<div id="searchbar" style="float:right">
		<li><input type="text" name="search" id="cari" placeholder="Cari Barang" onkeyup="searchsuggest(cari.value)" onblur="resetsuggest()">
			<ul class="suggestion" id="cariyu">	
			</ul>
		</li>
		<li><button type="button" onclick="resetsearch();search(cari.value,1);">Search</button></li>
		</div>
		
		
	</ul></nav>
	</header><!-- /#banner -->
	<!-- buat animasi kotak login user -->
	<div id='mbox' style='display:none;'></div>
	<div id='back_mbox' style='display:none;'></div><div id='fade_mbox' style='display:none;'></div>
	<!-- kotak user login -->
	<div id="userlogin">
	<form method="post">
		<pre><span id="errorInfo"></span></pre>
		<pre>Username		<input type="text" id="username" name="username"></pre>
		<pre>Password		<input type="password" id="password" name="password"></pre>
		<span id="loginbutton"><input type="button" value="Login" onclick="auth(username.value,password.value)"> <a href="registerform.jsp">Daftar baru!</a></span>
	</form>
	</div>
	<div id="patrick"><img src="images/patrick.gif" width="20%" height="20%"></div>
	<!-- import script dari file javascript -->
	<script src="javascript/header.js"></script>
<script src="javascript/transaksi.js"></script>
<script>
if(localStorage.wbduser){
	var currentpage=1;
	var shopping_bag = [];
	var sum_item = parseInt(
	<?php
			$con=mysqli_connect("localhost","root","","ruserba");
			// Check connection
			if (mysqli_connect_errno()) {
				echo "Failed to connect to MySQL: " . mysqli_connect_error();
			}
			
			$sql = "SELECT COUNT (*) FROM barang";
			$result = mysqli_query($con,$sql);
			
			while($row=mysqli_fetch_array($result)){
				$count = $row['COUNT (*)'];
				echo (""+($count-1));
			}
	?>
	var maxpage= (sum_item/10+1);
	var isi,buyitem;
	initialize_bag();
}
</script>