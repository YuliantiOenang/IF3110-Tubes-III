		<h2 id='footer_txt'><b>www.jayset.com Oficial Website</b></br>Cause jay & set is something.</h2>
		<a href='https://twitter.com/dave_rex'><img title='@calvinsalvy' src='${pageContext.request.contextPath}/img/site/twitter.png' id='footer_img'/></a>
	</div>

	<div id='login_cont'>
		<div id='login_box'>
			<h1>LOGIN</h1>
			<a class='exit' onclick='hideLogin()'>x</a>
			<div id="loading"></div>
			<form action="login" method="post">
				<label>Username</label><input type='text' id="username" name="username"></input><br/>
				<label>Password</label><input type='password' id="password" name="password"></input><br/>
				<button type="submit" onclick="login(); return false;" class="btn right">Login</button>
<!--  				<button type="submit" class="btn right"></button>-->
			</form>
		</div>
	</div>
	
	
	<!-- FOR SEARCH BAR -->	
	<%
		if (request.getParameter("search") != null) {
	%>
		<div id = 'search-popup' class='search-popup left-hide' onclick='opensearch()'></div>
		<div id = 'search-popup-content' class='search-popup-content left-show'>
	<%
		} else {
	%>
		<div id = 'search-popup' class='search-popup' onclick='opensearch()'></div>
		<div id = 'search-popup-content' class='search-popup-content'>
	<%
		}
	%>
	
	<%
		String temp_name = "";
		int temp_category = 0;
		int temp_price = 0;
		if (request.getParameter("name") != null) {
			temp_name = request.getParameter("name");
		}
		if (request.getParameter("category") != null) {
			temp_category = Integer.parseInt(request.getParameter("category"));
		}
		if (request.getParameter("price") != null) {
			temp_price = Integer.parseInt(request.getParameter("price"));
		}
	%>
			<form method="get" action="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/barang/">
			<h4>Search</h4>
			<p onclick='closesearch()'>x</p>
			<input type="text" name="name" value="<%= temp_name %>" placeholder="Nama Barang" id="name">
			<select name="category" value="<%= temp_category %>" required id="category">
				<option value="0" <% if (temp_category == 0) %>selected<% ; %>>All Categories</option>
				<option value="1" <% if (temp_category == 1) %>selected<% ; %>>Ladies Dress</option>
				<option value="2" <% if (temp_category == 2) %>selected<% ; %>>Ladies Shoes</option>
				<option value="3" <% if (temp_category == 3) %>selected<% ; %>>Man Shirt</option>
				<option value="4" <% if (temp_category == 4) %>selected<% ; %>>Man Shoes</option>
				<option value="5" <% if (temp_category == 5) %>selected<% ; %>>Man Hat</option>
			</select>
			<input type="number" name="price" value="<%= temp_price %>" placeholder="Harga" id="price">
			<input type="hidden" name="search" value="true">
			<button type="submit" class="btn">Search</button>
			</form>
	</div>