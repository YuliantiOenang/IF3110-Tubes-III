<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.frexesc.model.BarangBean"%>
<%@ page import="com.frexesc.model.KategoriBean"%>

<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="header.jsp" />
<%
	if (request.getAttribute("login") != null) {
%>
<script>alert("Login failed!")</script>
<%
	}
%>
</head>
<body>
	<jsp:include page="layout.jsp" />
	<!-- content di sini -->
	<%
		@SuppressWarnings("unchecked")
			ArrayList<KategoriBean> kategoriBean = (ArrayList<KategoriBean>) request
			.getAttribute("items");
	%>
	<%
		if (kategoriBean == null)
		kategoriBean = new ArrayList<KategoriBean>();
	%>
	<div id='content_frame' name='page' onLoad="RefreshCartandShow()">

		<!-- Added by @freedomofkeima -->
		<%
			for (int i = 0; i < kategoriBean.size(); i++) {
				ArrayList<BarangBean> barangBean = kategoriBean.get(i).getItemList();
				if (i == 0) {
		%>
		<div onmouseover='setRun(false, <%=kategoriBean.get(i).getId()%>)'
			onmouseout='setRun(true, <%=kategoriBean.get(i).getId()%>)'
			class='home_categori' id='cont<%=kategoriBean.get(i).getId()%>'>
			<%
				} else {
			%>
			<div onmouseover='setRun(false, <%=kategoriBean.get(i).getId()%>)'
				onmouseout='setRun(true, <%=kategoriBean.get(i).getId()%>)'
				class='home_categori hidden'
				id='cont<%=kategoriBean.get(i).getId()%>'>
				<%
					}
				%>
				<h1 class='header'><%=kategoriBean.get(i).getName()%></h1>
				<div class='triplebest'>
					<%
						for (int j = 0; j < 4; j++) {
					%>
					<a href='./barang/detail?id=<%=barangBean.get(j).getId()%>'>
						<div class='best'>
							<img
								title='<%=barangBean.get(j).getName()%> (IDR <%=barangBean.get(j).getPrice()%>)'
								onload='fitBest(this)'
								src='./img/barang/<%=barangBean.get(j).getPicture()%>' />
						</div>
					</a>
					<%
						}
					%>
				</div>
			</div>
			<%
				}
			%>


			<div class='howto'>
				<h4>how to get our product?</h4>
				<ol>
					<li>Before you get transaction with us, you must register as
						member.</li>
					<li>Browse our product by category or search it.</li>
					<li>Click add to cart if you want to buy our product.</li>
					<li>Check out and give us your credit card data</li>
					<li>Submit and wait us in front your home :)</li>
				</ol>
				<img src='${pageContext.request.contextPath}/img/site/howto.jpg' />
				<img src='${pageContext.request.contextPath}/img/site/store.jpg' />
			</div>
			<!-- test -->
		</div>
		<jsp:include page="footer.jsp" />
</body>
</html>
<script>
	function fitBest(obj) {
		fitimg(obj,220,150,true,true,false);
	}
</script>

<script>
function showCategory() {
	var n = 1;
	while (document.querySelectorAll('#cont'+n).length) {
		if (!document.querySelectorAll('#cont'+n+'.hidden').length) return n;
		n++;
	}
	return 0;
}

var show = showCategory();
var items = document.querySelectorAll('.home_categori').length;
var run = true;
function setRun(isrun,id) {
	if (id==show) {
		run = isrun;
		console.log('setRun by '+id+' -> '+isrun);
	}
}

setTimeout(function(){
 		effect();
 	}, 5000);

function effect() {
	if (run) {
		var x,y,vara,varb,varc,vard;
		vara = 0;
		varb = 0;
		console.log('hide : '+show);
		for (x=0;x<=11;x++){
			setTimeout(function(){
				document.getElementById('cont'+show).style.opacity = 1-(0.1*vara);
				if (vara==10) addClass(document.getElementById('cont'+show), " hidden");
				vara++;
			}, (30*(varb+1)));
			varb++;
		}
		setTimeout(function(){
			if (show<items) {
				show++;
			}
			else {
				show=1;
			}
			console.log('show : '+show);
			varc = 0;
			vard = 0;
			for (y=0;y<=11;y++){
				setTimeout(function(){
					if (varc==0) removeClass(document.getElementById('cont'+show), "hidden");
					document.getElementById('cont'+show).style.opacity = 0.1*varc;
					varc++;
				}, ((30*(vard+1))));
				vard++;
			}
		},400);
	}
	setTimeout(function(){
 		effect();
 	}, 5000);
}
</script>