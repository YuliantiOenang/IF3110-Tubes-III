<html><head>
<title>Calvin and Salvy</title>
<link href="css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	function hasClass(ele, cls) {
		return ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
	}

	function addClass(ele, cls) {
		if (!this.hasClass(ele, cls))
			ele.className += " " + cls;
	}

	function removeClass(ele, cls) {
		if (hasClass(ele, cls)) {
			var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
			ele.className = ele.className.replace(reg, ' ');
		}
	}
	function fitbarang(obj) {
		fitimg(obj,230,226,true,true,false);
	}
	function fitimg(obj, width, height, xfit, yfit, overlay) {
		var objheight = obj.offsetHeight;
		var objwidth = obj.offsetWidth;
		var screen = objheight / objwidth;
		var fit = height / width;
		if (Math.abs(screen - fit) <= 0.1) {
			obj.width = width;
			obj.height = height;
		} else if (((screen < fit) && overlay) || ((screen > fit) && !overlay)) {
			obj.height = height;
			if (xfit) {
				obj.width = ((height * 1.0) / (screen * 1.0));
				obj.style.marginLeft = (((1.0 * width) - ((1.0 * height) / (1.0 * screen))) / 2)
						.toString()
						+ "px";
			} else {
				obj.width = width;
			}
		} else {
			obj.width = width;
			if (yfit) {
				obj.height = (width * screen);
				obj.style.marginTop = ((height - (width * screen)) / 2)
						.toString()
						+ "px";
			} else {
				obj.height = height;
			}
		}
	}
	function showLogin() {
		document.getElementById('login_cont').style.opacity = 0;
		document.getElementById('login_cont').style.top = "0px";
		document.getElementById('login_username').focus();
		var x, aa, bb;
		aa = 0;
		bb = 0;
		for (x = 0; x <= 11; x++) {
			setTimeout(function() {
				document.getElementById('login_cont').style.opacity = 0.1 * aa;
				aa++;
			}, (50 * (bb + 1)));
			bb++;
		}
	}
	function hideLogin() {
		document.getElementById('login_cont').style.opacity = 1;
		var x, aa, bb;
		aa = 0;
		bb = 0;
		for (x = 0; x <= 11; x++) {
			setTimeout(
					function() {
						document.getElementById('login_cont').style.opacity = 1 - (0.1 * aa);
						if (aa >= 10)
							document.getElementById('login_cont').style.top = "-100%";
						aa++;
					}, (50 * (bb + 1)));
			bb++;
		}
	}
</script>
<script type="text/javascript" src="js/generatedContent.js"></script>
<script type="text/javascript" src="js/suggest.js"></script>
<script type="text/javascript" src="js/shop.js"></script>
</head>
<body>
	
	
		<div class="conctr">
			<div class="head">
				<a href="home"><div class="logo"></div></a>
				<div class="status">
					
						<p class="left"> welcome, <a href="profile/index">sonny</a>! (<a href="logout">Logout</a>)
						 (<a href="admin">Admin</a>)
						</p>
						<p class="right">
							<a href="cart">Shopping Cart</a> <img style="margin-right:5px;" src="img/site/cart_white.png" alt="">
						</p>
					
				</div>
				<div class="menu">
					
					
					<a href="barang?kategori=Ladies%20Dress">
						<div class="permenu per5">
							<div class="menuborder"></div>
							<div class="menutxt">
								<h1 class="menu">Ladies Dress</h1>
							</div>
							<div class="menuborder"></div>
						</div> 
					</a>
					
					
					<a href="barang?kategori=Ladies%20Shoes">
						<div class="permenu per5">
							<div class="menuborder"></div>
							<div class="menutxt">
								<h1 class="menu">Ladies Shoes</h1>
							</div>
							<div class="menuborder"></div>
						</div> 
					</a>
					
					
					<a href="barang?kategori=Men%20Shirt">
						<div class="permenu per5">
							<div class="menuborder"></div>
							<div class="menutxt">
								<h1 class="menu">Men Shirt</h1>
							</div>
							<div class="menuborder"></div>
						</div> 
					</a>
					
					
					<a href="barang?kategori=Men%20Shoes">
						<div class="permenu per5">
							<div class="menuborder"></div>
							<div class="menutxt">
								<h1 class="menu">Men Shoes</h1>
							</div>
							<div class="menuborder"></div>
						</div> 
					</a>
					
					
					<a href="barang?kategori=Men%20Hat">
						<div class="permenu per5">
							<div class="menuborder"></div>
							<div class="menutxt">
								<h1 class="menu">Men Hat</h1>
							</div>
							<div class="menuborder"></div>
						</div> 
					</a>
					
				</div>
				<div class="footer">
					<h2 id="footer_txt">
						<b>www.calvinsalvy.com Official Website</b><br>Karena rasa
						adalah segalanya.
					</h2>
					<a href="https://twitter.com/darksta5"><img id="footer_img" src="img/site/twitter.png" title="@calvinsalvy" alt=""></a>
				</div>
			</div>
			<div onload="RefreshCartandShow()" id="content_frame">
				<script type="text/javascript" src="js/cekUnik.js"></script>

<form enctype="multipart/form-data" method="POST" action="admin/addbarang">
<div class="register_div">
	<h1 class="header">Tambah Barang</h1>
	<div class="per_form">
		<label>Nama</label>
		<input type="text" autocomplete="off" name="nama_barang" onkeyup="cekUnik(this.value)" id="nama_barang"> <span id="message"></span>
	</div>
	<div class="per_form">
		<label>Kategori</label>
		 
		<select name="kategori">
			<option value="">--Pilih Kategori--</option>
			
				<option value="1"> Ladies Dress</option>
			
				<option value="2"> Ladies Shoes</option>
			
				<option value="3"> Men Shirt</option>
			
				<option value="4"> Men Shoes</option>
			
				<option value="5"> Men Hat</option>
			
			
		</select>
	</div>
	<div class="per_form">
		<label>Harga</label>
		<input type="text" name="harga_barang">
	</div>
	<div class="per_form">
		<label>Stok</label>
		<input type="text" name="stok">
	</div>
	<div class="per_form">
		<label>Keterangan</label>
		<input type="text" name="keterangan">
	</div>
	<div class="per_form">
		<label>Gambar</label>
		<input type="file" name="file">
	</div>
	<button class="btn small full" name="submit" id="submitEditBarang" type="submit">Tambah Barang</button>
</div>
</form>
			</div>
		</div>
		<div id="login_cont">
			<div id="login_box">
				<h1>LOGIN</h1>
				<a onclick="hideLogin()" class="exit">x</a>
				<div id="loading"></div>
				<form method="post">
					<label>Username</label><input type="text" name="Login[username]" id="login_username"><br> <label>Password</label><input type="password" name="Login[password]" id="login_password"><br>
					<button class="btn right" onclick="login(); return false;" type="submit">Login</button>
				</form>
			</div>
			<script src="js/login.js"></script>
			<script>
				var server = "";
			</script>
		</div>
	

	<script type="text/javascript">
		function _opensearchbox(margin) {
			if (margin <= 0) {
				document.getElementById('search-popup-content').style.marginLeft = margin
						.toString()
						+ "px";
				setTimeout(function() {
					_opensearchbox(margin + 2);
				}, 5);
			}
		}
		function _closesearchbox(margin) {
			if (margin >= -200) {
				document.getElementById('search-popup-content').style.marginLeft = margin
						.toString()
						+ "px";
				setTimeout(function() {
					_closesearchbox(margin - 2);
				}, 5);
			} else {
				setTimeout(function() {
					_showicon(-75);
				}, 100);
			}
		}
		function _hideicon(margin) {
			if (margin >= -70) {
				document.getElementById('search-popup').style.marginLeft = margin
						.toString()
						+ "px";
				setTimeout(function() {
					_hideicon(margin - 2);
				}, 5);
			} else {
				setTimeout(function() {
					_opensearchbox(-200);
				}, 100);
			}
		}
		function _showicon(margin) {
			if (margin <= 0) {
				document.getElementById('search-popup').style.marginLeft = margin
						.toString()
						+ "px";
				setTimeout(function() {
					_showicon(margin + 2);
				}, 5);
			}
		}
		function opensearch() {
			_hideicon(0);
		}
		function closesearch() {
			_closesearchbox(0);
		}
	</script>
	<div onclick="opensearch()" class="search-popup" id="search-popup"></div>
	<div class="search-popup-content" id="search-popup-content">
		<form method="get" action="barang">
			<h4>Search</h4>
			<p onclick="closesearch()">x</p>
			<div onclick="document.getElementById('suggestions').classList.add('hidden')">
				<input type="text" onkeyup="searchSuggestions(this);" autocomplete="off" placeholder="Nama Barang" value="" name="nama_barang" id="suggestName">
				<div class="hidden" id="suggestions">
				</div>
			</div>
			<select name="kategori">
				<option value="">All Categories</option>
				
					<option value="Ladies Dress"> Ladies Dress </option>
				
					<option value="Ladies Shoes"> Ladies Shoes </option>
				
					<option value="Men Shirt"> Men Shirt </option>
				
					<option value="Men Shoes"> Men Shoes </option>
				
					<option value="Men Hat"> Men Hat </option>
				
			</select>
			<input type="number" placeholder="Harga" value="" name="harga">
			<select id="operator" name="operator">
			<option value="">--Pilih--</option>
			<option value="L">Less than</option>
			<option value="E">Equal </option>
			<option value="G">Greater </option> 
			</select>
			<button class="btn small" type="submit">Search</button>
		</form>
	</div>

</body></html>
