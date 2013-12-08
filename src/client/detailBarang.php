<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				

<script type="text/javascript">
	function fitpict(obj) {
		fitimg(obj,340,340,true,true,false);
	}
</script>
<h1 class="small-header">St. Gabrielle Red Party D</h1>
<div class="item_pict">
	<img width="340" height="340" onload="fitpict(this)" src="images/barang/8.jpg">
</div>

<div class="item_detail">
	<h4>product description</h4>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent elit lorem, scelerisque sed sapien non, vestibulum venenatis nisi. Nullam in arcu eleifend nunc volutpat venenatis a sed massa. Nullam eget congue eros. Donec tincidunt dui arcu. Aliquam erat volutpat.<br>Vivamus ullamcorper massa facilisis orci sodales imperdiet. Suspendisse aliquet sodales eros, sit amet tincidunt eros pulvinar et. Etiam id nibh enim. Nullam turpis enim, lacinia a dictum vitae, posuere non risus. Maecenas interdum augue eget nisl consectetur, in rhoncus ligula eleifend.<br>Nullam non ligula consequat, consequat dolor et, vulputate nisl. Nunc varius mollis enim, euismod posuere quam malesuada at. </p>
</div>

<div class="item_price">
		<p>get it for :</p>
		<h4>IDR 890000</h4>
		<p>stok : 2</p>
	<!-- <form method="post" onSubmit="Stok(); return false;" >  -->
	 <form id="form-shop" action="barang/update" onsubmit="pertanyaan(8,2); return false;" method="post"> 
		<label class="qty">Quantity</label>
		<input type="number" value="1" class="qty" id="quantity_8" name="quantity">
		<input type="hidden" id="keterangan_8" name="id_barang">
		<p>Request Message :</p>
		<textarea name="req_msg" class="req_msg"></textarea>
		<input type="submit" value="Add to Cart" class="cart">
	 </form>
</div>

<script src="js/validasiBarang.js"></script>
<script>
	var server = "";
</script>


			</div>
		</div>
		<?php
require_once('footer.php');
?>
