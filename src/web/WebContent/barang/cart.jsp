<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.frexesc.model.BarangBean"%>
<%@ page import="com.frexesc.model.BarangUserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../header.jsp" />
<script src="../js/ajaxShop.js"></script>
<title>Shopping Cart</title>
</head>
<body>
	<jsp:include page="../layout.jsp" />
	<%
		@SuppressWarnings("unchecked")
		ArrayList<BarangUserBean> barangUserBean = (ArrayList<BarangUserBean>) request
				.getAttribute("user_items");
	%>
	<%
		if (barangUserBean == null)
			barangUserBean = new ArrayList<BarangUserBean>();
	%>

	<%
		@SuppressWarnings("unchecked")
		ArrayList<BarangBean> barangBean = (ArrayList<BarangBean>) request
				.getAttribute("items");
	%>
	<%
		if (barangBean == null)
			barangBean = new ArrayList<BarangBean>();
	%>

	<div id='content_frame' name='page'>
		<div class='orderdata'>
			<div class="wrapV_m">
				<div class='orderdetail'>
					<h4>Order details</h4>
				</div>
				<div id="contentV_m">
					<div>

						<div class='row'>
							<div class='list_head' id='no'>
								<h6>No</h6>
							</div>
							<div class='list_head' id='item'>
								<h6>Item</h6>
							</div>
							<div class='list_head' id='price'>
								<h6>Price</h6>
							</div>
							<div class='list_head' id='qty'>
								<h6>Qty.</h6>
							</div>
							<div class='list_head' id='subtotal'>
								<h6>Sub Total</h6>
							</div>
							<div class='list_head' id='update'>
								<h6>Update</h6>
							</div>
							<div class='list_head' id='remove'>
								<h6>X</h6>
							</div>
						</div>

						<%
							int totalHarga = 0;

							for (int i = 0; i < barangUserBean.size(); i++) {

								BarangUserBean b = barangUserBean.get(i);
						%>
						<div class='row'>
							<div class='list_body' id='no'>
								<p><%=i + 1%></p>
							</div>
							<%
								for (int j = 0; j < barangBean.size(); j++) {
										BarangBean b2 = barangBean.get(j);
										if (b2.getId() == b.getId_item()) {
											totalHarga = totalHarga + b.getTotal_item()
													* b2.getPrice();
							%>
							<div class='list_body' id='item'>
								<p>
									<b> <%=b2.getName()%>
									</b>
								</p>
							</div>

							<div class='list_body' id='price'>
								<p>
									IDR
									<%=b2.getPrice()%></p>
							</div>

							<div class='list_body' id='qty'>
								<input type="number" name="qty" size="8" id="qty_<%=b.getId()%>"
									value="<%=b.getTotal_item()%>">
							</div>

							<div class='list_body' id='subtotal'>
								<p>
									IDR <span id="harga_<%=b.getId()%>"><%=b.getTotal_item() * b2.getPrice()%>
									</span>
								</p>
							</div>

							<div class='list_body' id='update'>
								<input class="button2" type="button" value="Update Cart"
									id="beli"
									onClick="onUpdateCart('http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/barang/updateCart', <%=b.getId()%> ); return false;">
							</div>

							<div class='list_body' id='remove'>
								<a href="./deleteBarang?id=<%=b.getId()%>"
									title='Remove <%=b2.getName()%> from your Shopping Cart'>&nbsp;&nbsp;&nbsp;x</a>
							</div>

						</div>
						<%
							break;
									}
								}
						%>
						<%
							}
						%>

						<div class='row'>
							<div class='list_foot' id='totallabel'>
								<h6>TOTAL</h6>
							</div>
							<div class='list_foot' id='total'>
								<p>
									IDR <span id="total_harga"><%=totalHarga%></span>
								</p>
							</div>
						</div>
						<h2>Free delivery cost. :)</h2>
					</div>
				</div>
			</div>
			<div class='formcontainer'>
				<div class='buyerdetail'>
					<h4>Term and Condition</h4>
					<ul>
						<li>Press "Process to payment" to finish payment.</li>
						<li>Press "Add Item" to add new Item to Shopping Cart.</li>
					</ul>
					<%
						if (barangUserBean.size() != 0) {
					%>
					<a
						href='./payment'><input
						type="btn" name="submit" value="Process to payment" class="button"></a>
					<%
						}
					%>
					<a href='./'><input
						type="btn" name="submit" value="Add Item" class="button"></a>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../footer.jsp" />
</body>
</html>