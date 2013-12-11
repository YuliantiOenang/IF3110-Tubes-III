<aside id="sidebar" class="body">
	<p>Selamat datang!</p>
	<div id="s_bar">Silakan pilih barang belanjaan Anda! :)</div>
</aside>
<script src="javascript/transaksi.js"></script>
<script>
if(localStorage.wbduser){
	var currentpage=1;
	var shopping_bag = [];
	var sum_item = parseInt(<?php 
		$hasil3 = mysql_query("select count(*) from barang",$koneksi);
		$num =  mysql_fetch_array($hasil3);
		echo $num["count(*)"]-1; ?>);
	var maxpage= (sum_item/10+1);
	var isi,buyitem;
	initialize_bag();
}
</script>
