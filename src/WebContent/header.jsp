<%@ include file="koneksi.jsp" %>
<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/main.css" type="text/css" />
	<header id="banner" class="body">
	<span style="float:left"><a href="index.jsp"><img src="images/logo.png" alt="RuSerBa Logo" width="110" height="110"/></a></span>
	<h1><span><a href="index.jsp">RuSerBa<br><br><strong>Ruko Serba Ada</strong></a></span></h1>
 	<nav><ul id="menubar">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="halamanbarang.jsp" onmouseover="slidedown(true)" onmouseup="slidedown(false)">Kategori Barang</a>
			<ul class="sub-menu" id="halbar">
			</ul>
		</li>
		<div id="log"></div>
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
	<form>
		<pre><span id="errorInfo"></span></pre>
		<pre>Username		<input type="text" id="username" name="username"></pre>
		<pre>Password		<input type="password" id="password" name="password"></pre>
		<span id="loginbutton"><input type="button" value="Login" onclick="auth(username.value,password.value)"> <a href="registerform.jsp">Daftar baru!</a></span>
	</form>
	</div>
	<div id="patrick"><img src="images/patrick.gif" width="20%" height="20%"></div>
	<!-- import script dari file javascript -->
	<script src="javascript/header.js"></script>
	<aside id="sidebar" class="body">
	<p>Selamat datang!</p>
	<div id="s_bar">Silakan pilih barang belanjaan Anda! :)</div>
</aside>
<script src="javascript/transaksi.js"></script>
<script>
function getSum(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  if(localStorage.wbduser){
				var currentpage=1;
				var shopping_bag = [];
				var sum_item = parseInt(xmlhttp.responseText);
				var maxpage= (sum_item/10+1);
				var isi,buyitem;
				initialize_bag();
			}
	    	//alert(xmlhttp.responseText);
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/header?_type=plain&type=plain",true);
	xmlhttp.send();
	
}
function getHTML(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  //alert(xmlhttp.responseText);
		  document.getElementById("halbar").innerHTML = xmlhttp.responseText;
	    	
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/header?_type=html&type=html",true);
	xmlhttp.send();}
	
function initHeader()
{
	var i;
	for (i = 0; i < 10; ++i)
	{
		getSum();
		getHTML();
	}
}

initHeader();
</script>