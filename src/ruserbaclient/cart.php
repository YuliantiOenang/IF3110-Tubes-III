<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				


		<h1 class="header">Shopping Cart</h1>
<div class="orderdata">
			<div class="wrapV_m">
				<div class="orderdetail"><h4>Order details</h4></div>
			<div id="contentV_m">
				<div>
					<div class="row">
						<div id="no" class="list_head"><h6>No</h6></div>
						<div id="item" class="list_head"><h6>Item</h6></div>
						<div id="price" class="list_head"><h6>Price</h6></div>
						<div id="qty" class="list_head"><h6>Qty.</h6></div>
						<div id="subtotal" class="list_head"><h6>Sub Total</h6></div>
						<div id="remove" class="list_head"><h6>X</h6></div>
					</div>
					
							<div class="row">
							<div id="no" class="list_body"><p>1</p></div>
							<div id="item" class="list_body"><p><b>Ladies Shoes :</b><br> &nbsp; &nbsp; &nbsp;Chaterine Purple Wedges</p></div>
							<div id="price" class="list_body"><p>IDR 650000</p></div>
							<div id="qty" class="list_body"><input type="number" value="1" onchange="updateCart(18)" id="quantity_18"></div>
							<input type="hidden" value="Chaterine Purple Wedges" id="id_barang_Chaterine Purple Wedges">
							<div id="subtotal" class="list_body"><p>IDR 650000</p></div>
							<div id="remove" class="list_body"><a title="Remove Chaterine Purple Wedges from your Shopping Cart" href="cart/delete?id=18">x</a></div>
							</div>
						
						<div class="row">
							<div id="totallabel" class="list_foot"><h6>TOTAL</h6></div>
							<div id="total" class="list_foot"><p>IDR 650000</p></div>
						</div>
					<h2>Free delivery cost. :)</h2>
				</div>
			</div></div>
			<div class="formcontainer">
				<div class="buyerdetail"><h4>Term and Condition</h4>
				<ul>
					<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus neque nisl, aliquam ac mi ut, imperdiet consequat odio. Mauris suscipit laoreet dignissim.</li>
					<li>Urabitur convallis varius lectus, vitae congue mauris adipiscing eu. Vivamus id ultrices mi. Aenean eget erat id massa fringilla gravida.</li>
					<li>Aenean eu augue aliquet, congue nisl vitae, mattis quam. Quisque eu urna cursus, semper turpis in, ultricies est.</li>
					<li>Proin ullamcorper vehicula dolor, volutpat euismod leo cursus varius.</li>
					<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus neque nisl, aliquam ac mi ut, imperdiet consequat odio. Mauris suscipit laoreet dignissim.</li>
					<li>Urabitur convallis varius lectus, vitae congue mauris adipiscing eu. Vivamus id ultrices mi. Aenean eget erat id massa fringilla gravida.</li>
					
				</ul>
				<a href="cart/payment"><input type="btn" class="button" value="Process to payment" name="submit"></a>
				<a href="barang.php"><input type="btn" class="button" value="Add Item" name="submit"></a>
				</div>
			</div>
		</div>
<script src="js/updatecart.js"></script>

			</div>
		</div>
		<?php
require_once('footer.php');
?>
