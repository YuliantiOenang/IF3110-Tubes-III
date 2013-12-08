<%@ include file="koneksi.jsp" %>
<link rel="stylesheet" href="css/header.css" type="text/css" />
<link rel="stylesheet" href="css/main.css" type="text/css" />
	<header id="banner" class="body">
	<span style="float:left"><a href="index.jsp"><img src="images/logo.png" alt="RuSerBa Logo" width="110" height="110"/></a></span>
	<h1><span><a href="index.jsp">RuSerBa<br><br><strong>Ruko Serba Ada</strong></a></span></h1>
 	<nav><ul id="menubar">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="halamanbarang.jsp" onmouseover="slidedown(true)" onmouseup="slidedown(false)">Kategori Barang</a>
			<ul class="sub-menu">	
			<%
			//mengambil dari database barang
			try{
				// Register JDBC driver
			    Class.forName("com.mysql.jdbc.Driver");
            	// Open a connection
		        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Execute SQL query
	          	Statement stmt = conn.createStatement();
	          	String sql = "select * from barang group by kategori";
	          	ResultSet rs = stmt.executeQuery(sql);
	          	// Extract data from result set
	          	while(rs.next()){
	            	//Retrieve by column name
	             	String kategori = rs.getString("kategori");
	             	//Display values
	             	out.println("<li><a href=\"halamanbarang.jsp?kategori="+kategori+"\">"+kategori+"</a></li>");
	          	}
	          	// Clean-up environment
	          	rs.close();
	          	stmt.close();
	          	conn.close();
	       	}catch(SQLException se){
	          	//Handle errors for JDBC
	          	out.println(se.toString());
	       	}catch(Exception e){
	        	//Handle errors for Class.forName
	          	out.println(e.toString());
	       	}//end try
			%>
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
	<form method="post">
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
if(localStorage.wbduser){
	var currentpage=1;
	var shopping_bag = [];
	var sum_item = parseInt(<%
			//mengambil dari database barang
			try{
				// Register JDBC driver
			    Class.forName("com.mysql.jdbc.Driver");
            	// Open a connection
		        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Execute SQL query
	          	Statement stmt = conn.createStatement();
	          	String sql = "select count(*) from barang";
	          	ResultSet rs = stmt.executeQuery(sql);
	          	// Extract data from result set
	          	while(rs.next()){
	            	//Retrieve by column name
	             	int count = rs.getInt("count(*)");
	             	//Display values
	             	out.println(""+(count-1));
	          	}
	          	// Clean-up environment
	          	rs.close();
	          	stmt.close();
	          	conn.close();
	       	}catch(SQLException se){
	          	//Handle errors for JDBC
	          	out.println(se.toString());
	       	}catch(Exception e){
	        	//Handle errors for Class.forName
	          	out.println(e.toString());
	       	}//end try
			%>);
	var maxpage= (sum_item/10+1);
	var isi,buyitem;
	initialize_bag();
}
</script>