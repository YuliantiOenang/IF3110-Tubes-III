<div class="header-wrapper">
	
	
	<div id="hfloat" class="header-float"></div>
	
	<script>
		var loginfo = getLoginInfo();
		var hfloat = document.getElementById("hfloat");
		if(loginfo){
			hfloat.innerHTML = "Hello, <a href='edit_profile.php'>"+loginfo.user+"</a> |<a href='javascript:logout();'>Logout</a>|<a href='cart.php'>Cart</a>";
		}else{
			hfloat.innerHTML = "<a href='javascript:login();'>Login</a>|<a href='registration.php'>Signup</a>";
		}
	</script>
	
	
	<div class="header">
		<div class="htitle"><a href="index.php">Ruko Serba Ada</a></div>
		<div class="menu">
		
		
		
		<div class="menu-wrapper">
			<a href="category.php?cat=Makanan" class="item">Makanan</a><a href="category.php?cat=Peralatan%20Sekolah" class="item">Peralatan Sekolah</a><a href="category.php?cat=Peralatan%20Rumah" class="item">Peralatan Rumah</a><a href="category.php?cat=Peralatan%20Serbaguna" class="item">Peralatan Serbaguna</a><a href="category.php?cat=Mainan" class="item">Mainan</a>
		</div>		
		<div class="search-wrapper">
			<form method="GET" id="searchform" action="search.php">
				<input type="text" name="q" class="search search-grey" onfocus="searchBoxFocus(this)" onblur="searchBoxBlur(this)" value="Search" />
			</form>
		</div>
		
		</div>	
	</div>
</div>
