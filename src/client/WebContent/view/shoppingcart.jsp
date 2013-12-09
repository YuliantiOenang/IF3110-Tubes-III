<%@ page import="javaModel.Barang" %>
<%@page import="java.util.ArrayList" %>

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
						ArrayList <String> arrayn = (ArrayList <String>) request.getAttribute("namabeli");
						ArrayList <String> arrayc = (ArrayList <String>) request.getAttribute("katbeli");
						ArrayList <String> arrayid = (ArrayList <String>) request.getAttribute("idbeli");
						ArrayList <String> arrayp = (ArrayList <String>) request.getAttribute("hargabeli");
						ArrayList <String> arrayq = (ArrayList <String>) request.getAttribute("jumlahbeli");
						ArrayList <String> arrayst = (ArrayList <String>) request.getAttribute("stbeli");
						for(int i = 0; i < arrayn.size(); i++) { %>
							<div class='row'>
							<div class='list_body' id='no'><p><%= i + 1 %></p></div>
							<div class='list_body' id='item'><p><b><%= arrayc.get(i) %> :</b><br/> &nbsp &nbsp &nbsp<%= arrayn.get(i) %></p></div>
							<div class='list_body' id='price'><p>IDR <%= arrayp.get(i) %></p></div>
							<div class='list_body' id='qty'><input id='quantity_<%= arrayid.get(i) %>' type='number' onchange='updateCart(<%= arrayid.get(i) %>)' value='<%= arrayq.get(i) %>'></input></div>
							<input type='hidden' id='id_barang_<%= arrayn.get(i) %>' value='<%= arrayn.get(i) %>'>
							<div class='list_body' id='subtotal'><p>IDR <%= arrayst.get(i) %></p></div>
							<div class='list_body' id='remove'><a href='cart/delete?id=<%= arrayid.get(i) %>' title='Remove <%= arrayn.get(i) %> from your Shopping Cart'>x</a></div>
							</div>
						<% } %>
						<div class='row'>
							<div class='list_foot' id='totallabel'><h6>TOTAL</h6></div>
							<div class='list_foot' id='total'><p>IDR <%=request.getAttribute("total_shopping") %></p></div>
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
				<a href='/ruserba/cart/payment'><input type="btn"  name="submit" value="Process to payment" class="button"></a>
				<a href='/ruserba/home'><input type="btn" name="submit" value="Add Item" class="button"></a>
				</div>
			</div>
		</div>
<script src="js/updatecart.js"></script>
