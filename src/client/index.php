<!DOCTYPE html>
<html>
<head>
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
				






<script>
		function RefreshCartandShow(){
			//REFRESH CART
				var obj = document.getElementById('cart_frame');
				obj.src=obj.src;
			//SHOW
				if (document.getElementById('content_frame').style.opacity<1){
					// CONTENT FADE IN
					var n = 10;
					var m = 1;
					for (x=0;x<=11;x++){
						setTimeout(function(){
							document.getElementById('content_frame').style.opacity = 0.1*n;
							n++;
						}, (500+(50*(m+1))));
					m++;
					}
					// LOGO FADE OUT
					var o = 0;
					var p = 1;
					for (x=0;x<=11;x++){
						setTimeout(function(){
							document.getElementById('trans').style.opacity = (0.1*p);
							p--;
						}, (400+(50*(o+1))));
						o++;
					}
				}
		}
		
		function fadein(){
			//---- WELCOME PROCESS ----\\
				var n = 0;
				var m = 1;
				// WELCOME FADE IN
				for (x=0;x<=20;x++){
					setTimeout(function(){
						document.getElementById('starter').style.opacity = 0.05*n;
						n++;
					}, ((50*(m+1))));
				m++;
				}
				// WELCOME FADE OUT
				m=0;
				for (x=0;x<=21;x++){
					setTimeout(function(){
						document.getElementById('starter').style.opacity = (0.05*n);
						n--;
					}, (3000+(50*(m+1))));
				m++;
				}
			//---- PREFACE PROCESS ----\\
			var b = 0;
			var a = 1;
				// PREFACE FADE IN
				for (x=0;x<=20;x++){
					setTimeout(function(){
						document.getElementById('starter2').style.opacity = 0.05*b;
						b++;
					}, (4000+(50*(a+1))));
				a++;
				}
				// PREFACE FADE OUT
				a=0;
				for (x=0;x<=21;x++){
					setTimeout(function(){
						document.getElementById('starter2').style.opacity = (0.05*b);
						b--;
					}, (10000+(50*(a+1))));
				a++;
				}
			// CONTENT FADE IN
			var o = 0;
			var p = 1;
			for (x=0;x<=20;x++){
				setTimeout(function(){
					document.getElementById('content').style.opacity = (0.05*p);
					p++;
				}, (12000+(50*(o+1))));
			o++;
			}
		}
		
		function transition(link){
			var n = 10;
			var m = 1;
			// CONTENT FADE OUT
			for (x=0;x<=10;x++){
				setTimeout(function(){
					document.getElementById('content_frame').style.opacity = 0.1*n;
					n--;
				}, (50*(m+1)));
			m++;
			}
			// LOGO FADE IN
			var o = 0;
			var p = 1;
			for (x=0;x<=10;x++){
				setTimeout(function(){
					document.getElementById('trans').style.opacity = (0.1*p);
					p++;
				}, (300+(50*(o+1))));
				o++;
			}
			//CHANGE LINK
				setTimeout(function(){
					document.getElementById('content_frame').src=link;
				}, 2000);
		}
	</script>
	
	
		
		<div id="cont1" class="home_categori " onmouseout="setRun(true,1)" onmouseover="setRun(false,1)">
			<h1 class="header">Ladies Dress</h1>
			<div class="triplebest">
				
				
				
					<a href="barang/detail?id=12">
						<div class="best">
							<img width="150" height="150" src="img/barang/12.jpg" onload="fitBest(this)" title="Short V-Neck Black Dress   (520000)" alt="" style="margin-left: 35px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=9">
						<div class="best">
							<img width="150" height="150" src="img/barang/9.jpg" onload="fitBest(this)" title="Fringe Black Mini Dress  (560000)" alt="" style="margin-left: 35px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=14">
						<div class="best">
							<img width="84" height="150" src="img/barang/14.jpg" onload="fitBest(this)" title="Short V-Neck Black Dress   (350000)" alt="" style="margin-left: 67.9202px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=13">
						<div class="best">
							<img width="166" height="150" src="img/barang/13.jpg" onload="fitBest(this)" title="Fitted Short Sleeveless D  (430000)" alt="" style="margin-left: 26.5008px;">
						</div>
					</a>	
				
			</div>
		</div>
		
	
		
		<div id="cont2" class="home_categori hidden" onmouseout="setRun(true,2)" onmouseover="setRun(false,2)">
			<h1 class="header">Ladies Shoes</h1>
			<div class="triplebest">
				
				
				
					<a href="barang/detail?id=22">
						<div class="best">
							<img width="220" height="150" src="img/barang/22.jpg" onload="fitBest(this)" title="Olivia Heels  (480000)" alt="">
						</div>
					</a>	
				
					<a href="barang/detail?id=18">
						<div class="best">
							<img width="139" height="150" src="img/barang/18.jpg" onload="fitBest(this)" title="Chaterine Purple Wedges  (650000)" alt="" style="margin-left: 40.5px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=19">
						<div class="best">
							<img width="150" height="150" src="img/barang/19.jpg" onload="fitBest(this)" title="Monica Purple Heels  (550000)" alt="" style="margin-left: 35px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=20">
						<div class="best">
							<img width="220" height="150" src="img/barang/20.jpg" onload="fitBest(this)" title="White Cristal Heels  (700000)" alt="">
						</div>
					</a>	
				
			</div>
		</div>
		
	
		
		<div id="cont3" class="home_categori hidden" onmouseout="setRun(true,3)" onmouseover="setRun(false,3)">
			<h1 class="header">Men Shirt</h1>
			<div class="triplebest">
				
				
				
					<a href="barang/detail?id=34">
						<div class="best">
							<img width="112" height="150" src="img/barang/34.jpg" onload="fitBest(this)" title="Brown  Shirt  (450000)" alt="" style="margin-left: 53.7148px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=39">
						<div class="best">
							<img width="152" height="150" src="img/barang/39.jpg" onload="fitBest(this)" title="Blue Stripped Shirt  (450000)" alt="" style="margin-left: 33.68px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=36">
						<div class="best">
							<img width="150" height="150" src="img/barang/36.jpg" onload="fitBest(this)" title="St. Michael Black Shirt  (600000)" alt="" style="margin-left: 35px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=41">
						<div class="best">
							<img width="150" height="150" src="img/barang/41.jpg" onload="fitBest(this)" title="Black Squared Shirt  (500000)" alt="" style="margin-left: 35px;">
						</div>
					</a>	
				
			</div>
		</div>
		
	
		
		<div id="cont4" class="home_categori hidden" onmouseout="setRun(true,4)" onmouseover="setRun(false,4)">
			<h1 class="header">Men Shoes</h1>
			<div class="triplebest">
				
				
				
					<a href="barang/detail?id=56">
						<div class="best">
							<img width="220" height="111" src="img/barang/56.jpg" onload="fitBest(this)" title="Cerase Paciotti Brown  (500000)" alt="" style="margin-top: 19.4554px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=54">
						<div class="best">
							<img width="220" height="150" src="img/barang/54.jpg" onload="fitBest(this)" title="Pointy Toed  (480000)" alt="">
						</div>
					</a>	
				
					<a href="barang/detail?id=51">
						<div class="best">
							<img width="220" height="150" src="img/barang/51.jpg" onload="fitBest(this)" title="Leisure Black-Red  (760000)" alt="">
						</div>
					</a>	
				
					<a href="barang/detail?id=48">
						<div class="best">
							<img width="220" height="150" src="img/barang/48.jpg" onload="fitBest(this)" title="Bally Brown   (450000)" alt="">
						</div>
					</a>	
				
			</div>
		</div>
		
	
		
		<div id="cont5" class="home_categori hidden" onmouseout="setRun(true,5)" onmouseover="setRun(false,5)">
			<h1 class="header">Men Hat</h1>
			<div class="triplebest">
				
				
				
					<a href="barang/detail?id=64">
						<div class="best">
							<img width="189" height="150" src="img/barang/64.jpg" onload="fitBest(this)" title="Atef  (140000)" alt="" style="margin-left: 15.2632px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=65">
						<div class="best">
							<img width="118" height="150" src="img/barang/65.jpg" onload="fitBest(this)" title="Baby Stuart Cap  (75000)" alt="" style="margin-left: 50.9px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=66">
						<div class="best">
							<img width="189" height="150" src="img/barang/66.jpg" onload="fitBest(this)" title="Baigneuse  (120000)" alt="" style="margin-left: 15.4622px;">
						</div>
					</a>	
				
					<a href="barang/detail?id=67">
						<div class="best">
							<img width="189" height="150" src="img/barang/67.jpg" onload="fitBest(this)" title="Cartwheel  (110000)" alt="" style="margin-left: 15.4622px;">
						</div>
					</a>	
				
			</div>
		</div>
		
	
	
	
	<div class="howto">
		<h4>
			how to get our product?
		</h4>
		<ol>
			<li>Before you get transaction with us, you must register as member.</li>
			<li>Browse our product by category or search it.</li>
			<li>Click add to cart if you want to buy our product.</li>
			<li>Check out and give us your credit card data</li>
			<li>Submit and wait us in front your home :)</li>
		</ol>
		<img src="img/site/howto.jpg" alt="">
		<img src="img/site/store.jpg" alt="">
	</div>


<script type="text/javascript">
	function fitBest(obj) {
		fitimg(obj,220,150,true,true,false);
	}
</script>

<script type="text/javascript">
function showCategory() {
	var n = 1;
	while (document.querySelectorAll('#cont'+n).length) {
		if (!document.querySelectorAll('#cont'+n+'.hidden').length) return n;
		n++;
	}
	return 0;
}

var show = showCategory();
var items = document.querySelectorAll('.home_categori').length;
var run = true;
function setRun(isrun,id) {
	if (id==show) {
		run = isrun;
		console.log('setRun by '+id+' -> '+isrun);
	}
}

setTimeout(function(){
 		effect();
 	}, 5000);

function effect() {
	if (run) {
		var x,y,vara,varb,varc,vard;
		vara = 0;
		varb = 0;
		console.log('hide : '+show);
		for (x=0;x<=11;x++){
			setTimeout(function(){
				document.getElementById('cont'+show).style.opacity = 1-(0.1*vara);
				if (vara==10) addClass(document.getElementById('cont'+show), " hidden");
				vara++;
			}, (30*(varb+1)));
			varb++;
		}
		setTimeout(function(){
			if (show<items) {
				show++;
			}
			else {
				show=1;
			}
			console.log('show : '+show);
			varc = 0;
			vard = 0;
			for (y=0;y<=11;y++){
				setTimeout(function(){
					if (varc==0) removeClass(document.getElementById('cont'+show), "hidden");
					document.getElementById('cont'+show).style.opacity = 0.1*varc;
					varc++;
				}, ((30*(vard+1))));
				vard++;
			}
		},400);
	}
	setTimeout(function(){
 		effect();
 	}, 5000);
}
</script>
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
