<div id="login_cont">
			<div id="login_box">
				<h1>LOGIN</h1>
				<a onclick="hideLogin()" class="exit">x</a>
				<div id="loading"></div>
				<form method="post">
					<label>Username</label><input type="text" name="Login[username]" id="login_username"><br> <label>Password</label><input type="password" name="Login[password]" id="login_password"><br>
					<button class="btn right" onclick="login('<?=URLService;?>'); return false;" type="submit">Login</button>
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
		<form method="get" action="barang.php">
			<h4>Search</h4>
			<p onclick="closesearch()">x</p>
			<div onclick="document.getElementById('suggestions').classList.add('hidden')">
				<input type="text" onkeyup="searchSuggestions('<?=URLService;?>',this);" autocomplete="off" placeholder="Nama Barang" value="" name="nama_barang" id="suggestName">
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
