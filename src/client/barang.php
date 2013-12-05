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
				<!--  
<table id="ISI">
</table>
-->

<script type="text/javascript">
	var run = false;
	function fitbarang(obj) {
		fitimg(obj,230,226,true,true,false);
	}
	function backToPict(id) {
		if (!run) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					if (x==0) run=true;
					document.getElementById('cart'+id).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('cart'+id), " hidden");
					vara++;
					console.log(x+' : cart'+id);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('item'+id), "hidden");
						document.getElementById('item'+id).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : item'+id);
						if (varc==11) run=false;
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
	function goToCart(id) {
		if (!run) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					if (vara==0) run=true;
					document.getElementById('item'+id).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('item'+id), " hidden");
					vara++;
					console.log(x+' : item'+id);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('cart'+id), "hidden");
						document.getElementById('cart'+id).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : cart'+id);
						if (varc==11) run=false;
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
</script>

<div class="header_divider">
	<h1 class="header">Ladies Dress</h1>
</div>
<div class="header_divider">
	<div class="sorting">
		Sort by : 
		Nama 
		<a class="btn small" onclick="init('barang','nama','ASC','','Ladies Dress','','')" href="#">ASC</a> 
		<a class="btn small" onclick="init('barang','nama','DESC','','Ladies Dress','','')" href="#">DESC</a> 
		Harga 
		<a class="btn small" onclick="init('barang','harga','ASC','','Ladies Dress','','')" href="#">ASC</a> 
		<a class="btn small" onclick="init('barang','harga','DESC','','Ladies Dress','','')" href="#">DESC</a>
	</div>
</div>

<!-- <table id="ISI">
</table> -->
<div id="konten"><div class="itembox">	<div id="item1" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="179" height="226" src="images/barang/1.jpg" onload="fitbarang(this)" style="margin-left: 25.0299px;">		</div>		<div class="minicart_icon">			<a onclick="goToCart(1); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=1">Sonny Red Dress</a><br>IDR 6530000</div>	</div>	<div id="cart1" class="minicart hidden">		<form onsubmit="pertanyaan(1,0); return false;" method="post" id="form-shop-1">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_1" name="quantity">			<input type="hidden" value="1" id="id_barang_1" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_1" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(1)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item8" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="230" height="226" src="images/barang/8.jpg" onload="fitbarang(this)">		</div>		<div class="minicart_icon">			<a onclick="goToCart(8); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=8">St. Gabrielle Red Party D</a><br>IDR 890000</div>	</div>	<div id="cart8" class="minicart hidden">		<form onsubmit="pertanyaan(8,2); return false;" method="post" id="form-shop-8">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_8" name="quantity">			<input type="hidden" value="8" id="id_barang_8" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_8" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(8)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item4" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="171" height="226" src="images/barang/4.jpg" onload="fitbarang(this)" style="margin-left: 29.0684px;">		</div>		<div class="minicart_icon">			<a onclick="goToCart(4); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=4">Red Velvet Mini Dress</a><br>IDR 600000</div>	</div>	<div id="cart4" class="minicart hidden">		<form onsubmit="pertanyaan(4,10); return false;" method="post" id="form-shop-4">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_4" name="quantity">			<input type="hidden" value="4" id="id_barang_4" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_4" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(4)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item9" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="230" height="226" src="images/barang/9.jpg" onload="fitbarang(this)">		</div>		<div class="minicart_icon">			<a onclick="goToCart(9); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=9">Fringe Black Mini Dress</a><br>IDR 560000</div>	</div>	<div id="cart9" class="minicart hidden">		<form onsubmit="pertanyaan(9,8); return false;" method="post" id="form-shop-9">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_9" name="quantity">			<input type="hidden" value="9" id="id_barang_9" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_9" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(9)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item2" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="230" height="226" src="images/barang/2.jpg" onload="fitbarang(this)">		</div>		<div class="minicart_icon">			<a onclick="goToCart(2); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=2">Black Lace Cocktail Dress</a><br>IDR 550000</div>	</div>	<div id="cart2" class="minicart hidden">		<form onsubmit="pertanyaan(2,3); return false;" method="post" id="form-shop-2">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_2" name="quantity">			<input type="hidden" value="2" id="id_barang_2" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_2" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(2)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item12" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="230" height="226" src="images/barang/12.jpg" onload="fitbarang(this)">		</div>		<div class="minicart_icon">			<a onclick="goToCart(12); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=12">Short V-Neck Black Dress </a><br>IDR 520000</div>	</div>	<div id="cart12" class="minicart hidden">		<form onsubmit="pertanyaan(12,14); return false;" method="post" id="form-shop-12">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_12" name="quantity">			<input type="hidden" value="12" id="id_barang_12" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_12" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(12)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item10" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="230" height="226" src="images/barang/10.gif" onload="fitbarang(this)">		</div>		<div class="minicart_icon">			<a onclick="goToCart(10); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=10">Gold Shiny Sequined Dress</a><br>IDR 480000</div>	</div>	<div id="cart10" class="minicart hidden">		<form onsubmit="pertanyaan(10,12); return false;" method="post" id="form-shop-10">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_10" name="quantity">			<input type="hidden" value="10" id="id_barang_10" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_10" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(10)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item11" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="230" height="196" src="images/barang/11.jpg" onload="fitbarang(this)" style="margin-top: 14.6813px;">		</div>		<div class="minicart_icon">			<a onclick="goToCart(11); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=11">Silver Shiny Sequined Dre</a><br>IDR 480000</div>	</div>	<div id="cart11" class="minicart hidden">		<form onsubmit="pertanyaan(11,1); return false;" method="post" id="form-shop-11">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_11" name="quantity">			<input type="hidden" value="11" id="id_barang_11" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_11" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(11)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item13" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="230" height="226" src="images/barang/13.jpg" onload="fitbarang(this)">		</div>		<div class="minicart_icon">			<a onclick="goToCart(13); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=13">Fitted Short Sleeveless D</a><br>IDR 430000</div>	</div>	<div id="cart13" class="minicart hidden">		<form onsubmit="pertanyaan(13,11); return false;" method="post" id="form-shop-13">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_13" name="quantity">			<input type="hidden" value="13" id="id_barang_13" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_13" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(13)" href="#" class="back">back</p>		</form>	</div></div><div class="itembox">	<div id="item3" class="pict">		<div class="itembox_img" title="Ready Stock">			<img width="147" height="226" src="images/barang/3.jpg" onload="fitbarang(this)" style="margin-left: 41.3364px;">		</div>		<div class="minicart_icon">			<a onclick="goToCart(3); return false;" href="#"><img src="img/site/cart_black.png"></a>		</div>		<div class="item_name"><a href="barang/detail?id=3">Black Strapless Dress </a><br>IDR 420000</div>	</div>	<div id="cart3" class="minicart hidden">		<form onsubmit="pertanyaan(3,2); return false;" method="post" id="form-shop-3">			<label class="qty small">Quantity</label>			<input type="number" value="1" class="qty" id="quantity_3" name="quantity">			<input type="hidden" value="3" id="id_barang_3" name="id_barang">			<p>Request Message :</p>			<textarea id="keterangan_3" name="req_msg" class="req_msg small"></textarea>			<input type="submit" value="Add to Cart" class="cart small">			<p onclick="backToPict(3)" href="#" class="back">back</p>		</form>	</div></div></div>

<div class="hidden" id="loader"><img onload="init('barang','harga','DESC','','Ladies Dress','','')" alt="" src="images/loader.gif"></div>

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
