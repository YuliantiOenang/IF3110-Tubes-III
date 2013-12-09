	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- Header Section -->
		
		<div id="header" class="frame">
			<div class="kolom-7">
				<a href="home.jsp"><img src="res/img/logo.png" alt="" id="logo"/></a>
			</div>
			<div class="kolom-4">
				<div id="user-panel">
					
					<div id="user" class="frame">
						<img id="user-pict" class="kolom-5" src="res/img/userpict_h.png" alt=""/>
						<div id="user-text" class="kolom-7">
							<c:choose>
							<c:when test="${not empty cookie.username.value}">
							<p id="user-control">
								<h3><span class="user-name"><a href="edit-profile.jsp" id="member">Welcome, <c:out value="${cookie.username.value}"/>!</a></span></h3>
							</p>
							<p id="user-control">
								<span class="edit-logout">	<a href='Logout' id='logout2'>Logout</a></span>
							</p>
							</c:when>
							<c:when test="${empty cookie.username.value}">
							<div id = "logreg">
							<p id="user-control">
								
									<span class="edit-logout">	<a id="login2" href="javascript:login('show')">Login</a></span>
									&nbsp;or&nbsp;
									<span class="edit-logout">	<a id="register2" href="registrasi.jsp">Register</a></span>
								
							</p>
							<br/></div>
							</c:when>
							</c:choose>
							
							<c:if test="${cookie.username.value != 'admin'}">
							<a href="Cart.jsp" class="btn">Check Your Cart</a>
							<c:if test="${empty cookie.creditcard.value}">
							<c:if test="${not empty cookie.username.value}">
							<a href="credit-card.jsp" class="btn">Register credit card</a>
							</c:if>
							</c:if>
							</c:if>


							<c:if test="${cookie.username.value == 'admin'}">
							<a href="AddBarang.jsp" class="btn"> Add Barang </a>
							</c:if>
							
						</div>
					</div>
					
					<div id="search-bar" class="frame">
						<form name="search-form" action="Search?Page=0" onsubmit="return validateForm('search-form', 'src', 'Ketikkan barang yang dicari...')">
							<input type='hidden' name='Page' id='Page' value="0" />
							<input id="search-box" class="kolom-9" type="text" name="Query" value="Ketikkan barang yang dicari..." onfocus="checkclear(this)" onblur="checkempty(this, 'Ketikkan barang yang dicari...')">
							<input id="search-button" class="kolom-1" type="submit" value="">
						</form>					
					</div>
				</div>
			</div>			
		</div>
		<!-- Navbar Section -->
		<div id="navbar" class="frame">
			<ul>
				<li><a href="Barang?Kategori=Beras">Beras</a></li>
				<li><a href="Barang?Kategori=Daging">Daging</a></li>
				<li><a href="Barang?Kategori=Sayuran">Sayuran</a></li>
				<li><a href="Barang?Kategori=Frozen Food">Frozen Food</a></li>
			</ul>
		</div>
		<!-- End of Navbar -->
		
		<br/>
		<div id="popupbox" class="popupbox"> 
			<form name="login" id="login" onSubmit="return adminvalidate();" action="ValidateLogin" method="post">
				<a href="javascript:login('hide')" id ="close">[X] close</a> 
				Username:
				<input name="username" size="14" />
				Password:
				<input name="password" type="password" size="14" />
				<input id="loginbutton" type="submit" value="Login">
			</form>
		</div> 
		
		

		<!-- End of Header -->