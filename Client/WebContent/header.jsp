<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/css/style.css" />
<script>
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
		document.getElementById('username').focus();
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

	function RefreshCartandShow() {
		//REFRESH CART
		var obj = document.getElementById('cart_frame');
		obj.src = obj.src;
		//SHOW
		if (document.getElementById('content_frame').style.opacity < 1) {
			// CONTENT FADE IN
			var n = 10;
			var m = 1;
			for (x = 0; x <= 11; x++) {
				setTimeout(
						function() {
							document.getElementById('content_frame').style.opacity = 0.1 * n;
							n++;
						}, (500 + (50 * (m + 1))));
				m++;
			}
			// LOGO FADE OUT
			var o = 0;
			var p = 1;
			for (x = 0; x <= 11; x++) {
				setTimeout(function() {
					document.getElementById('trans').style.opacity = (0.1 * p);
					p--;
				}, (400 + (50 * (o + 1))));
				o++;
			}
		}
	}

	function fadein() {
		// CONTENT FADE IN
		var o = 0;
		var p = 1;
		for (x = 0; x <= 20; x++) {
			setTimeout(function() {
				document.getElementById('content').style.opacity = (0.05 * p);
				p++;
			}, (12000 + (50 * (o + 1))));
			o++;
		}
	}

	function transition(link) {
		var n = 10;
		var m = 1;
		// CONTENT FADE OUT
		for (x = 0; x <= 10; x++) {
			setTimeout(
					function() {
						document.getElementById('content_frame').style.opacity = 0.1 * n;
						n--;
					}, (50 * (m + 1)));
			m++;
		}
		// LOGO FADE IN
		var o = 0;
		var p = 1;
		for (x = 0; x <= 10; x++) {
			setTimeout(function() {
				document.getElementById('trans').style.opacity = (0.1 * p);
				p++;
			}, (300 + (50 * (o + 1))));
			o++;
		}
		//CHANGE LINK
		setTimeout(function() {
			document.getElementById('content_frame').src = link;
		}, 2000);
	}
	
	<!-- JS for search box-->
	function _opensearchbox(margin) {
		if (margin<=0) {
			document.getElementById('search-popup-content').style.marginLeft = margin.toString()+"px";
			setTimeout(function(){
				_opensearchbox(margin+2);
			}, 5);
		}
	}
	function _closesearchbox(margin) {
		if (margin>=-200) {
			document.getElementById('search-popup-content').style.marginLeft = margin.toString()+"px";
			setTimeout(function(){
				_closesearchbox(margin-2);
			}, 5);
		}
		else {
			setTimeout(function(){
				_showicon(-75);
			}, 100);
		}
	}
	function _hideicon(margin) {
		if (margin>=-70) {
			document.getElementById('search-popup').style.marginLeft = margin.toString()+"px";
			setTimeout(function(){
				_hideicon(margin-2);
			}, 5);
		}
		else {
			setTimeout(function(){
				_opensearchbox(-200);
			}, 100);
		}
	}
	function _showicon(margin) {
		if (margin<=0) {
			document.getElementById('search-popup').style.marginLeft = margin.toString()+"px";
			setTimeout(function(){
				_showicon(margin+2);
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