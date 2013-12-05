<!DOCTYPE html>
<%@page import="javaModel.Helper"%>
<%@page import="databaseLib.DatabaseAdapter"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="javaModel.Kategori" %>
<%@ page import="javaModel.Barang" %>
<html>
<head>
<title>Calvin and Salvy</title>
<link rel='stylesheet' type='text/css' href='/ruserba/css/style.css' />
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
<script src="/ruserba/js/generatedContent.js" type="text/javascript"></script>
<script src="/ruserba/js/suggest.js" type="text/javascript"></script>
<script src="/ruserba/js/shop.js" type="text/javascript"></script>
</head>
<body>
	<%
		Kategori K = Helper.findAllKategori();
	%>
	<% if (request.getAttribute("effect")!=null && (Boolean)request.getAttribute("effect")) { %>
		<img alt='' class='loader' id='starter' src='/ruserba/img/site/logo_b.png' />
		<div class='prolog' id='starter2'>
			<p>
				We are here to provide you with a brand new aura in our country
				through fashion, creativity, and innovative designs with world class
				quality. We always provide the best for our consumers by giving the
				best quality of our products. We will bring to you products made out
				of best chosen materials. We collaborate with the experts who have
				years and years of experience in the fashion and design industry. We
				will excite you with our new and creative concept to be more
				fashionable. And we guarantee you no dissatisfaction because we are
				sure that you will be satisfied at any cost whatsoever.<br />
				<br />Best Regards,<br />Calvin Valentino and Salvy Reynalv
			</p>
		</div>
		<div class='background' id='content'>
	<% } %>
		<div class='conctr'>
			<div class='head'>
				<a href='/ruserba/home'><div class='logo'></div></a>
				<div class='status'>
					<% 
					String userlogged = Helper.getUserLogged(session);
					Integer userRole = Helper.getUserRole(session);
					if (!userlogged.isEmpty()) { %>
						<p class="left"> welcome, <a href='/ruserba/profile/index'><%= userlogged %></a>! (<a href='/ruserba/logout'>Logout</a>)
						<% if (userRole == 2) { %> (<a href='/ruserba/admin'>Admin</a>)<% } %>
						</p>
						<p class="right">
							<a href="/ruserba/cart">Shopping Cart</a> <img alt='' src='/ruserba/img/site/cart_white.png' style='margin-right:5px;'/>
						</p>
					<% } else { %>
						<p>
							You are not login. (<a href='#' onclick='showLogin()'>Login</a> or
							<a href='/ruserba/register'>Register now</a>)
						</p>
					<% } %>
				</div>
				<div class="menu">
					<% for (int i = 0; i < K.id.size(); i++) { %>
					<% String link = K.nama_kategori.get(i).replace(" ", "%20"); %>
					<a href="/ruserba/barang?kategori=<%= link %>">
						<div class="permenu per5">
							<div class="menuborder"></div>
							<div class="menutxt">
								<h1 class="menu"><%= K.nama_kategori.get(i) %></h1>
							</div>
							<div class="menuborder"></div>
						</div> 
					</a>
					<% } %>
				</div>
				<div class="footer">
					<h2 id='footer_txt'>
						<b>www.calvinsalvy.com Official Website</b><br />Karena rasa
						adalah segalanya.
					</h2>
					<a href='https://twitter.com/darksta5'><img alt=''
						title='@calvinsalvy' src='/ruserba/img/site/twitter.png' id='footer_img' /></a>
				</div>
			</div>
			<div id='content_frame' onLoad="RefreshCartandShow()">
				<jsp:include
					page='<%=(String) request.getAttribute("includeJspContent")%>' />
			</div>
		</div>
		<div id='login_cont'>
			<div id='login_box'>
				<h1>LOGIN</h1>
				<a class='exit' onclick='hideLogin()'>x</a>
				<div id="loading"></div>
				<form method="post">
					<label>Username</label><input type='text' id="login_username"
						name="Login[username]"><br /> <label>Password</label><input
						type='password' id="login_password" name="Login[password]"><br />
					<button type='submit' onclick="login(); return false;"
						class='btn right'>Login</button>
				</form>
			</div>
			<script src="/ruserba/js/login.js"></script>
			<script>
				var server = "";
			</script>
		</div>
	<% if (request.getAttribute("effect")!=null && (Boolean)request.getAttribute("effect")) { %>
		</div> 
	<% } %>

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
	<div id='search-popup' class='search-popup' onclick='opensearch()'></div>
	<div id='search-popup-content' class='search-popup-content'>
		<form action="/ruserba/barang" method="get">
			<h4>Search</h4>
			<p onclick='closesearch()'>x</p>
			<div onclick="document.getElementById('suggestions').classList.add('hidden')">
				<input type="text" id="suggestName" name="nama_barang" value="" placeholder="Nama Barang" autocomplete="off" onkeyup="searchSuggestions(this);">
				<div id="suggestions" class="hidden">
				</div>
			</div>
			<select name="kategori">
				<option value="">All Categories</option>
				<% for (int i = 0; i < K.id.size(); i++) { %>
					<option value='<%=K.nama_kategori.get(i)%>'> <%=K.nama_kategori.get(i)%> </option>
				<% } %>
			</select>
			<input type="number" name="harga" value="" placeholder="Harga">
			<select name="operator" id="operator">
			<option value="">--Pilih--</option>
			<option value="L">Less than</option>
			<option value="E">Equal </option>
			<option value="G">Greater </option> 
			</select>
			<button type="submit" class="btn small">Search</button>
		</form>
	</div>
</body>
</html>