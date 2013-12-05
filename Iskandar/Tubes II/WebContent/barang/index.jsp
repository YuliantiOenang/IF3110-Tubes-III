<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.frexesc.model.BarangBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../header.jsp" />
<script src="../js/ajaxShop.js"></script>
<title>Gallery</title>

<script type="text/javascript">
	var run = false;
	function fitbarang(obj) {
		fitimg(obj, 180, 175, true, true, false);
	}
	function backToPict(id) {
		if (!run) {
			var x, y, vara, varb, varc, vard;
			vara = 0;
			varb = 0;
			for (x = 0; x <= 11; x++) {
				setTimeout(
						function() {
							if (x == 0)
								run = true;
							document.getElementById('cart' + id).style.opacity = 1 - (0.1 * vara);
							if (vara == 10)
								addClass(document.getElementById('cart' + id),
										" hidden");
							vara++;
							console.log(x + ' : cart' + id);
						}, (50 * (varb + 1)));
				varb++;
			}
			setTimeout(
					function() {
						varc = 0;
						vard = 0;
						for (y = 0; y <= 11; y++) {
							setTimeout(
									function() {
										if (varc == 0)
											removeClass(
													document
															.getElementById('item'
																	+ id),
													"hidden");
										document.getElementById('item' + id).style.opacity = 0.1 * varc;
										varc++;
										console.log(y + ' : item' + id);
										if (varc == 11)
											run = false;
									}, (120 + (50 * (vard + 1))));
							vard++;
						}
					}, 600);
		}
	}
	function goToCart(id) {
		if (!run) {
			var x, y, vara, varb, varc, vard;
			vara = 0;
			varb = 0;
			for (x = 0; x <= 11; x++) {
				setTimeout(
						function() {
							if (vara == 0)
								run = true;
							document.getElementById('item' + id).style.opacity = 1 - (0.1 * vara);
							if (vara == 10)
								addClass(document.getElementById('item' + id),
										" hidden");
							vara++;
							console.log(x + ' : item' + id);
						}, (50 * (varb + 1)));
				varb++;
			}
			setTimeout(
					function() {
						varc = 0;
						vard = 0;
						for (y = 0; y <= 11; y++) {
							setTimeout(
									function() {
										if (varc == 0)
											removeClass(
													document
															.getElementById('cart'
																	+ id),
													"hidden");
										document.getElementById('cart' + id).style.opacity = 0.1 * varc;
										varc++;
										console.log(y + ' : cart' + id);
										if (varc == 11)
											run = false;
									}, (120 + (50 * (vard + 1))));
							vard++;
						}
					}, 600);
		}
	}
</script>

</head>
<body>
	<jsp:include page="../layout.jsp" />
	<%
		@SuppressWarnings("unchecked")
		ArrayList<BarangBean> barangBean = (ArrayList<BarangBean>) request
				.getAttribute("items");
	%>
	<%
		if (barangBean == null)
			barangBean = new ArrayList<BarangBean>();
	%>

	<div class='header_divider'>
		<%
			if (request.getAttribute("category_name") == null) {
		%>
		<h1 class='header'>All Categories</h1>
		<%
			} else {
		%>
		<h1 class='header'><%=request.getAttribute("category_name")%></h1>
		<%
			}
		%>
	</div>

	<%
		String previous = "";
		String previous2 = "";
		if (request.getParameter("sort") != null) {
			previous = "&sort=" + request.getParameter("sort");
		}
		if (request.getParameter("jenisSort") != null) {
			previous = previous + "&jenisSort="
					+ request.getParameter("jenisSort");
		}
		if (request.getParameter("name") != null) {
			previous = previous + "&name=" + request.getParameter("name");
			previous2 = "&name=" + request.getParameter("name");
		}
		if (request.getParameter("category") != null) {
			previous = previous + "&category="
					+ request.getParameter("category");
			previous2 = previous2 + "&category="
					+ request.getParameter("category");
		}
		if (request.getParameter("price") != null) {
			previous = previous + "&price=" + request.getParameter("price");
			previous2 = previous2 + "&price="
					+ request.getParameter("price");
		}
	%>

	<div class='header_divider'>
		<div class="sorting">
			Sort By (Nama - Kategori - Harga) : <br /> <br /> (<a
				href="?sort=1&jenisSort=1<%=previous2%>" class="btn small">ASC</a>,<a
				href="?sort=1&jenisSort=2<%=previous2%>" class="btn small">DESC</a>)
			(<a href="?sort=2&jenisSort=1<%=previous2%>" class="btn small">ASC</a>,<a
				href="?sort=2&jenisSort=2<%=previous2%>" class="btn small">DESC</a>)
			(<a href="?sort=3&jenisSort=1<%=previous2%>" class="btn small">ASC</a>,<a
				href="?sort=3&jenisSort=2<%=previous2%>" class="btn small">DESC</a>)
			<br />
			<br />
		</div>

	</div>
	
	<br />
	<br />

		<%
			for (int i = 0; i < barangBean.size(); i++) {
			BarangBean b = barangBean.get(i);
		%>
		<%
			if (i % 2 == 0) {
		%>
			<div class='vertdiv'>		
		<%
			}
		%>
		<div class='itembox'>
			<div class='pict' id='item<%= b.getId() %>'>
				<div title='Ready Stock' class='itembox_img'>
					<img onload='fitbarang(this)' src='../img/barang/<%=b.getPicture()%>' />
				</div>
				<div class='minicart_icon'>
					<a href=# onclick='goToCart(<%=b.getId()%>)'><img src='../img/site/cart_black.png'/></a>
				</div>
				<div class='item_name'>
				<a href='./detail?id=<%=b.getId()%>'><%= b.getName() %></a><br />
				IDR <%= b.getPrice() %>
				</div>
			</div>
			
			<div class='minicart hidden' id='cart<%= b.getId() %>'>
			<label class='qty small'>Quantity</label>
			<input type='number' name='qty'
				id='qty_<%=b.getId()%>' class='qty' value=0></input>
			<label class='qty small'>Stock:
			&nbsp;&nbsp;<span id="jumlah_barang_<%=b.getId()%>"><%=b.getTotal_item()%></span>
			</label><br />
			<p><label class='rqmessage'>Request Message :</label></p>
			<textarea class='req_msg small' name='deskripsi_tambahan'
				id='deskripsi_tambahan'></textarea>
			<input type='button' class='cart small' id='beli' value='Add to Cart'
				onClick="onAddToCart('http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/barang/addCart', <%=b.getId()%> ); return false;"></input>
			<p class='back' href=# onclick='backToPict(<%= b.getId() %>)'>
			<label class='qty small'>back</label>
			</p>
			</div>
		</div>
		
		<%
			if (i % 2 != 0 || i == barangBean.size() - 1) {
		%>
			</div>		
		<%
			}
		%>
		<%
			}
		%>

		<div class="pagination">
			<ul class='paginasi'>
				<%
					for (int i = 0; i < Math
							.round(Math.ceil(Double.parseDouble((String) request
									.getAttribute("total_pages")) / 10)); i++) {
				%>
				<li>
					<%
						if (request.getParameter("page") != null) {
								if (Integer.parseInt(request.getParameter("page")) != (i + 1)) {
					%> <a href="?page=<%=i + 1%><%=previous%>"> <%
 	}
 		} else { %>
 		<a href="?page=<%=i + 1%><%=previous%>">	
 	<% }
 %> <%=i + 1%> <%
 	if (request.getParameter("page") != null) {
 			if (Integer.parseInt(request.getParameter("page")) != (i + 1)) {
 %>
				</a> <%
 	}
 		} else { %>
 		</a>
 		<%
 		}
 %>
				</li>
				<%
					}
				%>
				<ul>
		</div>

	<br />
	<jsp:include page="../footer.jsp" />
</body>
</html>