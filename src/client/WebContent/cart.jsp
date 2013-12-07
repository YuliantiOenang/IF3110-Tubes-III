<%@page import="java.util.Vector"%>
<%@page import="model.Model"%>
<%@page import="model.ShoppingCart"%>

<jsp:include page="contentBegin.jsp"></jsp:include>

		<h1 class='header'>Shopping Cart</h1>
<div class='orderdata'>
			<div class="wrapV_m">
				<div class='orderdetail'><h4>Order details</h4></div>
			<div id="contentV_m">
				<div>
					<div class='row'>
						<div class='list_head' id='no'><h6>No</h6></div>
						<div class='list_head' id='item'><h6>Item</h6></div>
						<div class='list_head' id='price'><h6>Price</h6></div>
						<div class='list_head' id='qty'><h6>Qty.</h6></div>
						<div class='list_head' id='subtotal'><h6>Sub Total</h6></div>
						<div class='list_head' id='remove'><h6>X</h6></div>
					</div>
					<% 
					ShoppingCart shop = (ShoppingCart)request.getAttribute("shoppingcart");
					int ind = 1;
					if (shop.isEmpty())
					{
						out.print("<p>Shopping cart kosong</p>");
					}
					else
					{
						Vector<Integer> keys = shop.getKeySet();
						
						for (int i = 0; i < keys.size();i++)
						{
							out.print("	<div class='row'>");
							out.print("		<div class='list_body' id='no'><p>"+ (i+1) +".</p></div>");
							out.print("		<div class='list_body' id='item'><p><b>" + shop.getKategori(keys.elementAt(i)) + " :</b><br/> &nbsp &nbsp &nbsp" + shop.getNamaBarang(keys.elementAt(i)) + "</p></div>");
							out.print("		<div class='list_body' id='price'><p>IDR " + Model.rupiahFormatter(shop.getPrice(keys.elementAt(i)).toString()) + "</p></div>");
							out.print("		<div class='list_body' id='qty'><input id='quantity_" + keys.elementAt(i) + "' type='number' onkeyup='cekCart(" + keys.elementAt(i) + ")' value='" + shop.getJumlah(keys.elementAt(i)) + "'></input></div>");
							out.print("		<input type='hidden' id='id_barang_" + keys.elementAt(i) + "' value='" + shop.getJumlah(keys.elementAt(i)) + "'>");
							out.print("		<div class='list_body' id='subtotal'><p>IDR " + Model.rupiahFormatter(shop.getSubTotal(keys.elementAt(i)).toString()) + "</p></div>");
							out.print("		<div class='list_body' id='remove'><a href='" + request.getContextPath() + "/cart/delete?id=" + keys.elementAt(i) + "' title='Remove " + shop.getNamaBarang(keys.elementAt(i)) + " from your Shopping Cart'>x</a></div>");
							out.print("	</div>");
						}
					}
					%>
						<div class='row'>
							<div class='list_foot' id='totallabel'><h6>TOTAL</h6></div>
							<div class='list_foot' id='total'><p>IDR <%= Model.rupiahFormatter(shop.getTotalPrice().toString()) %></p></div>
						</div>
					<h2>Free delivery cost. :)</h2>
				</div>
			</div></div>
			<div class='formcontainer'>
				<div class='buyerdetail'><h4>Term and Condition</h4>
				<ul>
					<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus neque nisl, aliquam ac mi ut, imperdiet consequat odio. Mauris suscipit laoreet dignissim.</li>
					<li>Urabitur convallis varius lectus, vitae congue mauris adipiscing eu. Vivamus id ultrices mi. Aenean eget erat id massa fringilla gravida.</li>
					<li>Aenean eu augue aliquet, congue nisl vitae, mattis quam. Quisque eu urna cursus, semper turpis in, ultricies est.</li>
					<li>Proin ullamcorper vehicula dolor, volutpat euismod leo cursus varius.</li>
					<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus neque nisl, aliquam ac mi ut, imperdiet consequat odio. Mauris suscipit laoreet dignissim.</li>
					<li>Urabitur convallis varius lectus, vitae congue mauris adipiscing eu. Vivamus id ultrices mi. Aenean eget erat id massa fringilla gravida.</li>
					
				</ul>
				<a href='${pageContext.request.contextPath}/cart/process'><input type="btn"  name="submit" value="Check Out" class="button"></a>
				<a href='${pageContext.request.contextPath}/home'><input type="btn" name="submit" value="Continue Shopping" class="button"></a>
				</div>
			</div>
		</div>
<script src="${pageContext.request.contextPath}/js/validasiBarang.js"></script>

<jsp:include page="contentEnd.jsp"></jsp:include>