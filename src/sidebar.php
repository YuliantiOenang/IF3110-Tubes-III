<aside id="sidebar" class="body">
	<p>Selamat datang!</p>
	<div id="s_bar">Silakan pilih barang belanjaan Anda! :)</div>
</aside>
<script src="javascript/transaksi.js"></script>
<script>
if(localStorage.wbduser){
	var currentpage=1;
	var shopping_bag = [];
	var sum_item = 40;
	var maxpage= (sum_item/10+1);
	var isi,buyitem;
	initialize_bag();
}
</script>
