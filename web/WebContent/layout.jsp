<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class='conctr'>
	<div class='head'>
		<a href='${pageContext.request.contextPath}'><div class='logo'></div></a>
		<div class='menu'>
			<a href='${pageContext.request.contextPath}/barang/?category=1'><div
					class='permenu per5'>
					<div class='menuborder'></div>
					<div class='menutxt'>
						<h1 id='txtmenu1' class='menu'>Ladies Dress</h1>
					</div>
					<div class='menuborder'></div>
				</div> </a> <a href='${pageContext.request.contextPath}/barang/?category=2'><div
					class='permenu per5'>
					<div class='menuborder'></div>
					<div class='menutxt'>
						<h1 id='txtmenu1' class='menu'>Ladies Shoes</h1>
					</div>
					<div class='menuborder'></div>
				</div> </a> <a href='${pageContext.request.contextPath}/barang/?category=3'><div
					class='permenu per5'>
					<div class='menuborder'></div>
					<div class='menutxt'>
						<h1 id='txtmenu1' class='menu'>Man Shirt</h1>
					</div>
					<div class='menuborder'></div>
				</div> </a> <a href='${pageContext.request.contextPath}/barang/?category=4'><div
					class='permenu per5'>
					<div class='menuborder'></div>
					<div class='menutxt'>
						<h1 id='txtmenu1' class='menu'>Man Shoes</h1>
					</div>
					<div class='menuborder'></div>
				</div> </a> <a href='${pageContext.request.contextPath}/barang/?category=5'><div
					class='permenu per5'>
					<div class='menuborder'></div>
					<div class='menutxt'>
						<h1 id='txtmenu1' class='menu'>Man Hat</h1>
					</div>
					<div class='menuborder'></div>
				</div> </a>
		</div>

		<div class='status'>
			<%
				if (request.getSession(true).getAttribute("role") == null) {
			%>
			<p class="left">
				You are not login. (<a onclick="showLogin()">Login</a> or <a
					href='${pageContext.request.contextPath}/register'>Register now</a>)
			</p>
			<%
				} else if (request.getSession(true).getAttribute("role")
						.equals("0")) {
			%>
			<p class="left">
				welcome, <a
					href="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/user?id=<%=request.getSession(true).getAttribute("user_id")%>"><%=request.getSession(true).getAttribute("username")%></a>!
				(<a href="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/logout">Logout</a>)
			</p>
			<p class="right">
				<a href="${pageContext.request.contextPath}/barang/cart">Shopping
					Cart</a> <img
					src='${pageContext.request.contextPath}/img/site/cart_white.png'
					class='img_layout' />
			</p>
			<%
				} else if (request.getSession(true).getAttribute("role")
						.equals("1")) {
			%>
			<p class="left">
				welcome, <a
					href="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/user?id=<%=request.getSession(true).getAttribute("user_id")%>"><%=request.getSession(true).getAttribute("username")%></a>!
				(<a href="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/admin?action=main">Admin</a> | <a href="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/logout">Logout</a>)
			</p>
			<p class="right">
				<a href="${pageContext.request.contextPath}/barang/cart">Shopping
					Cart</a> <img
					src='${pageContext.request.contextPath}/img/site/cart_white.png'
					class='img_layout' />
			</p>
			<%
				}
			%>
		</div>
	</div>