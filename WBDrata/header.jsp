		<!-- Header Section -->
		<div id="header" class="frame">
			<div class="kolom-7">
				<a href="index.jsp"><img src="res/img/logo.png" alt="" id="logo"/></a>
			</div>
			<div class="kolom-4">
				<div id="user-panel">
					
					<div id="user" class="frame">
						<img id="user-pict" class="kolom-5" src="res/img/userpict_h.png" alt=""/>
						<div id="user-text" class="kolom-7">
						
							<%
								String name="";
								String value="";
								String valuelagi=null;
								Cookie[] cookies = request.getCookies();
								if (cookies!=null){
								for (int i = 0; i < cookies.length; i++) {
									Cookie c = cookies[i];
									name = c.getName();
									value = c.getValue();
									
									if (name.equals("username")){
										valuelagi=value;
									}
									session.setAttribute(name, value); 
								}
								}
								
								if(valuelagi!=null){ 
									
							%>
							
							
							<h3>Welcome, <span class="user-name"><a href="getdatamember" id="member"><% out.println(valuelagi); %></a></span>!</h3>
							<p id="user-control">
								<span class="edit-logout">	<a href='logout.jsp' id='logout2'>Logout</a></span>
							</p>
							<% }else {
								
								
							%>
							<div id = "logreg">
							<p id="user-control">
								
									<span class="edit-logout">	<a id="login2" href="javascript:login('show')">Login</a></span>
									&nbsp;or&nbsp;
									<span class="edit-logout">	<a id="register2" href="registrasi.jsp">Register</a></span>
								
							</p>
							<br/></div>
							<% } %>
							<a href="ShoppingBag.jsp" class="btn">Check Your Cart</a>
						</div>
					</div>
					
					<div id="search-bar" class="frame">
						<form name="search-form" action="getsearch" onsubmit="return validateForm('search-form', 'src', 'ketikkan yang ingin dicari..')">
							<input id="search-box" class="kolom-9" type="text" name="src" value="ketikkan yang ingin dicari.." onfocus="checkclear(this)" onblur="checkempty(this, 'ketikkan yang ingin dicari..')">

							<input id="search-button" class="kolom-1" type="submit" value="">
							<select id="search-kategori" name="search-kategori">
								<option value = "%">- kategori -</option>
								<option value = "Beras">Beras</option>
								<option value = "Daging">Daging</option>
								<option value = "Sayuran">Sayuran</option>
								<option value = "Frozen Food">Frozen Food</option>
								<option value = "Snack">Snack</option>
							</select><br/>
							<select id="search-harga1" name="search-harga1">
								<option value = "-1">- harga -</option>
								<option value = "0">0</option>
								<option value = "10000">10.000</option>
								<option value = "25000">25.000</option>
								<option value = "50000">50.000</option>
								<option value = "100000">100.000</option>
								<option value = "250000">250.000</option>
								<option value = "500000">500.000</option>
							</select>
							<a> &nbsp; - &nbsp; </a>
							<select id="search-harga2" name="search-harga2">
								<option value = "999999999">- harga -</option>
								<option value = "0">0</option>
								<option value = "10000">10.000</option>
								<option value = "25000">25.000</option>
								<option value = "50000">50.000</option>
								<option value = "100000">100.000</option>
								<option value = "250000">250.000</option>
								<option value = "500000">500.000</option>
																
							</select>
							
						</form>					
					</div>
				</div>
			</div>			
		</div>
		
			<form name="login" id="login" method="post">
			<div id="popupbox"> 
				<a href="javascript:login('hide')" id ="close">[X] close</a> <br/><br/>
				Username:
				<input id= "username" type="text" name="username" /><br/>
				Password:
				<input id="password" name="password" type="password"  /><br/><br/>
				<input type="button" name="button" id= "sbmtlogin" onclick="forLogin()" value="login" />
				</div> 
			
			</form>
		
		
		<!-- End of Header -->
		
			<!-- Navbar Section -->
		<div id="navbar" class="frame">
			<ul>
				<li><a href="getberas">Beras</a></li>
				<li><a href="getdaging">Daging</a></li>
				<li><a href="getsayuran">Sayuran</a></li>
				<li><a href="getfrozen">Frozen Food</a></li>
				<li><a href="getsnack">Snack</a></li>
				<% if (valuelagi !=null){if(valuelagi.equals("admin")){%>
				<li><a href="getadmin">Halaman Admin</a></li>
				<%}}%>
			</ul>
		</div>
		<!-- End of Navbar -->
		
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 
	<script>
	function forLogin(){
		
		var username = AJAXPost();
		
		if (username!="1"){
			
			document.getElementById('sbmtlogin').value="Login\nLogin Sukses";
			var newhtml =		'<h3>Welcome, <span class="user-name"><a href="getdatamember" id="member">'+username+'</a></span>!</h3><p id="user-control"><span class="edit-logout">	<a href="logout.jsp" id="logout2">Logout</a></span></p>';
			document.getElementById("logreg").innerHTML=newhtml;
			if(username=="admin"){
				var newhtml2 =		'<ul><li><a href="getberas">Beras</a></li><li><a href="getdaging">Daging</a></li><li><a href="getsayuran">Sayuran</a></li><li><a href="getfrozen">Frozen Food</a></li><li><a href="getsnack">Snack</a></li><li><a href="getadmin">Halaman Admin</a></li></ul>';
				document.getElementById("navbar").innerHTML=newhtml2;
			}
	
		}else{
			document.getElementById('sbmtlogin').value="Login\nusername/password salah";
		}
		
		
	}
	</script>	