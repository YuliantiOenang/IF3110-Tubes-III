<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Category</title>
<jsp:include page="header.jsp" />
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
	<jsp:include page="layout.jsp" />


	<!-- content -->

	<div class='header_divider'>
		<h1 class='header'>NAMA KATEGORI</h1>
	</div>
	
	<div class='header_divider'>
			<div class="sorting">
				Urutan :
	
				<!-- KOde PHP1 -->
				<!--  
						<?php 
							$query['sort'] = 'sort=nama asc';
							if (isset($_GET['sort'])) if ($_GET['sort'] == 'nama asc') $query['sort'] = 'sort=nama desc';
						?>
						<a href="?<?php echo implode('&', array_filter($query)) ?>" class="btn small">Nama</a> 
						<?php 
							$query['sort'] = 'sort=harga asc';
							if (isset($_GET['sort'])) if ($_GET['sort'] == 'harga asc') $query['sort'] = 'sort=harga desc';
						?>
						-->
				<!-- KOde PHP1 -->
	
				<a href="" class="btn small">Harga</a>
			</div>
		
			<div class="pagination">
				<!--  <?php echo $paging; ?>-->
			</div>
	</div>


	<!-- Kode PHP2 -->
	<!--  
	
	<?php
		if ($model == null) $model = array();
		foreach ($model as $key=>$value) {
			if (($key==0)||(($key%2)==0)){
				echo "<div class='vertdiv'>";
			}
			echo "<div class='itembox'>
						<div class='pict' id='item".$value->id."'>
							<div title='";
			if ($value->stok>0) echo "Ready Stock"; else echo "Out of Stock";
			echo "' class='itembox_img'>
								<img onload='fitbarang(this)' src='".$this->getBaseUrl()."/img/barang/".$value->gambar."'/>
							</div>
							<div class='minicart_icon'>
								<a href=# onclick='goToCart(".$value->id.")'><img src='".$this->getBaseUrl()."/img/site/cart_black.png'/></a>
							</div>
							<div class='item_name'><a href='".$this->getBaseUrl()."/barang/".$value->id."'>".$value->nama."</a><br/>IDR ".$this->toCurrency($value->harga)."</div>
						</div>
						<div class='minicart hidden' id='cart".$value->id."'>
							<form action = ".$this->makeUrl("barang/update")." id='form-shop-".$value->id."' method='post' onsubmit='cekQuantity(".$value->id."); return false;'>
								<label class='qty small'>Quantity</label>
								<input type='number' name='quantity' id='quantity_".$value->id."' class='qty' value=1></input>
								<input type='hidden' name='id_barang' id='id_barang_".$value->id."' value='".$value->id."'>
								<p>Request Message :</p>
								<textarea class='req_msg small' name='req_msg'></textarea>
								<input type='submit' class='cart small' value = 'Add to Cart'></input>
								<p class='back' href=# onclick='backToPict(".$value->id.")'>back</p>
							</form>
						</div>
					</div>";
			// VERTICAL DIV CLOSER
			if (($key%2)==1||($key==(count($model)-1))||($key==9))echo "</div>";
		}
	?>
	
	-->

	<!-- Kode PHP2 -->


	<jsp:include page="footer.jsp" />


</body>
</html>

