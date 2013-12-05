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
				
<script type="text/javascript" src="js/deleteBarang.js"></script>
<h1 class="header">Administrator</h1><br>
<a class="btn" href="admin/addbarang">+ Tambah Barang</a> 
Kategori : 

	<a class="btn small" href="admin/index?kateg=1"> Ladies Dress</a>

	<a class="btn small" href="admin/index?kateg=2"> Ladies Shoes</a>

	<a class="btn small" href="admin/index?kateg=3"> Men Shirt</a>

	<a class="btn small" href="admin/index?kateg=4"> Men Shoes</a>

	<a class="btn small" href="admin/index?kateg=5"> Men Hat</a>


<br><br>		

		<div class="itembox">
			<div id="item1" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="179" height="226" src="images/barang/1.jpg" onload="fitbarang(this)" style="margin-left: 25.0299px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=1">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(1)" href="#1">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=1">Sonny Red Dress</a><br>IDR 6530000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item2" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/2.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=2">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(2)" href="#2">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=2">Black Lace Cocktail Dress</a><br>IDR 550000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item3" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="147" height="226" src="images/barang/3.jpg" onload="fitbarang(this)" style="margin-left: 41.3364px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=3">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(3)" href="#3">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=3">Black Strapless Dress </a><br>IDR 420000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item4" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="171" height="226" src="images/barang/4.jpg" onload="fitbarang(this)" style="margin-left: 29.0684px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=4">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(4)" href="#4">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=4">Red Velvet Mini Dress</a><br>IDR 600000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item5" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="180" height="226" src="images/barang/5.jpg" onload="fitbarang(this)" style="margin-left: 24.6px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=5">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(5)" href="#5">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=5">Black Dotted Dress</a><br>IDR 380000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item6" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="173" height="226" src="images/barang/6.jpg" onload="fitbarang(this)" style="margin-left: 28.3667px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=6">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(6)" href="#6">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=6">Slim Suit Dress</a><br>IDR 350000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item7" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="158" height="226" src="images/barang/7.jpg" onload="fitbarang(this)" style="margin-left: 35.8827px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=7">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(7)" href="#7">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=7">Valentino Grey Dress</a><br>IDR 420000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item8" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/8.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=8">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(8)" href="#8">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=8">St. Gabrielle Red Party D</a><br>IDR 890000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item9" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/9.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=9">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(9)" href="#9">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=9">Fringe Black Mini Dress</a><br>IDR 560000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item10" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/10.gif" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=10">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(10)" href="#10">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=10">Gold Shiny Sequined Dress</a><br>IDR 480000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item11" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="196" src="images/barang/11.jpg" onload="fitbarang(this)" style="margin-top: 14.6813px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=11">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(11)" href="#11">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=11">Silver Shiny Sequined Dre</a><br>IDR 480000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item12" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/12.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=12">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(12)" href="#12">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=12">Short V-Neck Black Dress </a><br>IDR 520000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item13" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/13.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=13">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(13)" href="#13">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=13">Fitted Short Sleeveless D</a><br>IDR 430000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item14" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="126" height="226" src="images/barang/14.jpg" onload="fitbarang(this)" style="margin-left: 51.5998px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=14">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(14)" href="#14">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=14">Short V-Neck Black Dress </a><br>IDR 350000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item15" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="169" height="226" src="images/barang/15.jpg" onload="fitbarang(this)" style="margin-left: 30.2092px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=15">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(15)" href="#15">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=15">Jump One Blue Dress</a><br>IDR 380000</div>
			</div>
		</div>

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
