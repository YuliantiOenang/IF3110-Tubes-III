<?php
	if (isset($_COOKIE['isLogin']))
	{
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
		<h1 class="header">Shopping Cart</h1>
		<script src="js/deletecart.js"></script>
		<script src="js/updatecart.js"></script>
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
					<?php
					$TopCart = $_COOKIE['topCart'];
					$total = 0;					
					for ($i=1;$i<=$TopCart;$i++)
					{
						$cook = $_COOKIE[$i];
						$pieces = explode("-", $cook);
						$id = $pieces[0];
						$jml = $pieces[1];
						$harga = $pieces[2];
						$nama = $pieces[3];
						$stok = $pieces[4];
						$total = $total + ($jml*$harga);
					?>
							<div class="row">
							<div id="no" class="list_body"><p><?=$i;?></p></div>
							<div id="item" class="list_body"><p>&nbsp; &nbsp; &nbsp;<?=$nama;?></p></div>
							<div id="price" class="list_body"><p>IDR <?=$harga;?></p></div>
							<div id="qty" class="list_body"><input type="number" value="<?=$jml;?>" onchange="updateCart(<?=$i;?>,<?=$stok;?>,<?=$id;?>,<?=$harga;?>,'<?=$nama;?>')" id="quantity_<?=$i;?>"></div>
							<input type="hidden" value="<?=$nama;?>" id="id_barang_<?=$nama;?>">
							<div id="subtotal" class="list_body"><p>IDR <?=$harga*$jml;?></p></div>
							<div id="remove" class="list_body"><a onclick="deleteCart(<?=$i;?>);return false;" title="Remove <?=$nama;?> from your Shopping Cart" href="#">x</a></div>
							</div>
					<?php
					}
					?>
						<div class="row">
							<div id="totallabel" class="list_foot"><h6>TOTAL</h6></div>
							<div id="total" class="list_foot"><p>IDR <?=$total;?></p></div>
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
				<a href="cartPayment.php"><input type="btn" class="button" value="Process to payment" name="submit"></a>
				<a href="barang.php"><input type="btn" class="button" value="Add Item" name="submit"></a>
				</div>
			</div>
		</div>
			</div>
		</div>
		<?php
require_once('footer.php');
}
else
{
	header("Location: register.php");
}
?>
