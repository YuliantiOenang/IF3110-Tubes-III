<div class="header-wrapper">
	
	
	<div id="hfloat" class="header-float"></div>
	
	<script>
		var loginfo = getLoginInfo();
		var hfloat = document.getElementById("hfloat");
		if(loginfo){
			s = "";
			
			if (is_admin()) s = "<a href='admin_barang.php?cat=Makanan'>Admin Page</a> | ";
		
			hfloat.innerHTML = s + "Hello, <a href='profile.php?u="+loginfo.user+"&t="+loginfo.id+"'>"+loginfo.user+"</a> |<a href='javascript:logout();'>Logout</a>|<a href='cart.php'>Cart</a>";
		}else{
			hfloat.innerHTML = "<a href='javascript:login();'>Login</a>|<a href='registration.php'>Signup</a>";
		}
	</script>
	
	
	<div class="header">
		<div class="htitle"><a id="indexlink" href="index.php">Ruko Serba Ada</a></div>
		<div class="menu">
		
		
		
		<div id="menubar" class="menu-wrapper">
			<a href="category.php?cat=Makanan" class="item">Makanan</a><a href="category.php?cat=Peralatan%20Sekolah" class="item">Peralatan Sekolah</a><a href="category.php?cat=Peralatan%20Rumah" class="item">Peralatan Rumah</a><a href="category.php?cat=Peralatan%20Serbaguna" class="item">Peralatan Serbaguna</a><a href="category.php?cat=Mainan" class="item">Mainan</a>
		</div>
		
		<script>
			if(is_admin()){
				document.getElementById("menubar").innerHTML = '<a href="admin_barang.php?cat=Makanan" class="item">Makanan</a><a href="admin_barang.php?cat=Peralatan%20Sekolah" class="item">Peralatan Sekolah</a><a href="admin_barang.php?cat=Peralatan%20Rumah" class="item">Peralatan Rumah</a><a href="admin_barang.php?cat=Peralatan%20Serbaguna" class="item">Peralatan Serbaguna</a><a href="admin_barang.php?cat=Mainan" class="item">Mainan</a>';
				
				document.getElementById("indexlink").href = "admin_barang.php?cat=Makanan";
			}
		</script>
		
		<div class="search-wrapper">
			<form method="GET" id="searchform" action="search.php">
				<input type="text" name="q" class="search search-grey" onfocus="searchBoxFocus(this)" onblur="searchBoxBlur(this)" value="Search" />
			</form>
		</div>
		
		</div>	
	</div>
</div>
