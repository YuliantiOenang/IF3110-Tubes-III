<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				<!--  
<table id="ISI">
</table>
-->

<script type="text/javascript">
	var run = false;
	function fitbarang(obj) {
		fitimg(obj,230,226,true,true,false);
	}
	function backToPict(id) {
		if (!run) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					if (x==0) run=true;
					document.getElementById('cart'+id).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('cart'+id), " hidden");
					vara++;
					console.log(x+' : cart'+id);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('item'+id), "hidden");
						document.getElementById('item'+id).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : item'+id);
						if (varc==11) run=false;
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
	function goToCart(id) {
		if (!run) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					if (vara==0) run=true;
					document.getElementById('item'+id).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('item'+id), " hidden");
					vara++;
					console.log(x+' : item'+id);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('cart'+id), "hidden");
						document.getElementById('cart'+id).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : cart'+id);
						if (varc==11) run=false;
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
</script>

<div class="header_divider">
	<h1 class="header">Ladies Dress</h1>
</div>
<div class="header_divider">
	<div class="sorting">
	<?php
		$var=$_GET['kategori'];
		$nama_barang=$_GET['nama_barang'];
		$kategori = $_GET['kategori'];
		$harga = $_GET['harga'];
		$OP = $_GET['operator'];
	?>
		Sort by : 
		Nama 
		<a class="btn small" onclick="init('<?=BarangService;?>','nama','ASC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">ASC</a> 
		<a class="btn small" onclick="init('<?=BarangService;?>','nama','DESC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">DESC</a> 
		Harga 
		<a class="btn small" onclick="init('<?=BarangService;?>','harga','ASC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">ASC</a> 
		<a class="btn small" onclick="init('<?=BarangService;?>','harga','DESC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')" href="#">DESC</a>
	</div>
</div>

<div id="konten">
</div>
<div id="loader" class="hidden"><img src="images/loader.gif" alt="" onload="init('<?=BarangService;?>','harga','ASC','<?=$nama_barang;?>','<?=$var;?>','<?=$harga;?>','<?=$OP;?>')"></div>

			</div>
		</div>
		<?php
require_once('footer.php');
?>
