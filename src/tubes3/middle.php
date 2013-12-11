	<head>
		<link rel="stylesheet" type="text/css" href="header.css">
	</head>
	<body>
		<!--Header's body-->
		<div id="title">
		<div id="icon">
			<a href="index.php"><img src="logo.png" alt="RuSerBa" width="700" height="160"></a>
		</div>
		
		<div id="head-right">
		<form id="search" action="search.php" method="get">
			Nama : <input type="search" name="keyword"><br>
			Kategori : <select name="kategori">
				<option value="" selected>-</option>
				<option value="beras" >Beras</option>
				<option value="daging">Daging</option>
				<option value="ikan">Ikan</option>
				<option value="sayur">Sayur</option>
				<option value="buah">Buah</option>
			</select><br>
			Harga : <select name="range">
				<option value="0" selected>-</option>
				<option value="<10000">< 10000</option>
				<option value="10000-50000">10000 - 50000</option>
				<option value=">50000">> 50000</option>
			</select><br>
			<input type="submit" value="Search"><br><br>
		</form>
		<div id="account">
			<script>
				renderAccount();
			</script>
		</div>
		</div>
		</div>
		<div id="navcontainer">
		<ul id="kategori">
			<li><a href="product.php?kategori=beras&sort=namaasc">Beras</a>
			<li><a href="product.php?kategori=daging&sort=namaasc">Daging</a>
			<li><a href="product.php?kategori=ikan&sort=namaasc">Ikan</a>
			<li><a href="product.php?kategori=sayur&sort=namaasc">Sayur</a>
			<li><a href="product.php?kategori=buah&sort=namaasc">Buah</a>
		
		</ul>
		</div>
		