<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				
<script type="text/javascript" src="js/deleteBarang.js"></script>
<h1 class="header">Administrator</h1><br>
<a class="btn" href="adminAddBarang.php">+ Tambah Barang</a> 
Kategori : 

	<a class="btn small" href="adminIndex.php?kateg=1"> Ladies Dress</a>

	<a class="btn small" href="adminIndex.php?kateg=2"> Ladies Shoes</a>

	<a class="btn small" href="adminIndex.php?kateg=3"> Men Shirt</a>

	<a class="btn small" href="adminIndex.php?kateg=4"> Men Shoes</a>

	<a class="btn small" href="adminIndex.php?kateg=5"> Men Hat</a>


<br><br>		

		<div class="itembox">
			<div id="item1" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="179" height="226" src="images/barang/1.jpg" onload="fitbarang(this)" style="margin-left: 25.0299px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=1">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(1)" href="#1">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=1">Sonny Red Dress</a><br>IDR 6530000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item2" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/2.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=2">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(2)" href="#2">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=2">Black Lace Cocktail Dress</a><br>IDR 550000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item3" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="147" height="226" src="images/barang/3.jpg" onload="fitbarang(this)" style="margin-left: 41.3364px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=3">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(3)" href="#3">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=3">Black Strapless Dress </a><br>IDR 420000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item4" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="171" height="226" src="images/barang/4.jpg" onload="fitbarang(this)" style="margin-left: 29.0684px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=4">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(4)" href="#4">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=4">Red Velvet Mini Dress</a><br>IDR 600000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item5" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="180" height="226" src="images/barang/5.jpg" onload="fitbarang(this)" style="margin-left: 24.6px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=5">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(5)" href="#5">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=5">Black Dotted Dress</a><br>IDR 380000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item6" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="173" height="226" src="images/barang/6.jpg" onload="fitbarang(this)" style="margin-left: 28.3667px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=6">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(6)" href="#6">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=6">Slim Suit Dress</a><br>IDR 350000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item7" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="158" height="226" src="images/barang/7.jpg" onload="fitbarang(this)" style="margin-left: 35.8827px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=7">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(7)" href="#7">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=7">Valentino Grey Dress</a><br>IDR 420000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item8" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/8.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=8">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(8)" href="#8">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=8">St. Gabrielle Red Party D</a><br>IDR 890000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item9" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/9.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=9">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(9)" href="#9">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=9">Fringe Black Mini Dress</a><br>IDR 560000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item10" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/10.gif" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=10">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(10)" href="#10">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=10">Gold Shiny Sequined Dress</a><br>IDR 480000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item11" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="196" src="images/barang/11.jpg" onload="fitbarang(this)" style="margin-top: 14.6813px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=11">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(11)" href="#11">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=11">Silver Shiny Sequined Dre</a><br>IDR 480000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item12" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/12.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=12">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(12)" href="#12">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=12">Short V-Neck Black Dress </a><br>IDR 520000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item13" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="230" height="226" src="images/barang/13.jpg" onload="fitbarang(this)">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=13">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(13)" href="#13">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=13">Fitted Short Sleeveless D</a><br>IDR 430000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item14" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="126" height="226" src="images/barang/14.jpg" onload="fitbarang(this)" style="margin-left: 51.5998px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=14">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(14)" href="#14">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=14">Short V-Neck Black Dress </a><br>IDR 350000</div>
			</div>
		</div>

		<div class="itembox">
			<div id="item15" class="pict">
				<div class="itembox_img" title="Ready Stock">
					<img width="169" height="226" src="images/barang/15.jpg" onload="fitbarang(this)" style="margin-left: 30.2092px;">
				</div>
				<div class="minicart_menu">
					<a class="btn small" href="admin/editbarang?id=15">Edit</a> 
					<a class="btn small" onclick="deleteBarangConfirm(15)" href="#15">Delete</a>
				</div>
				<div class="item_name"><a href="barang/detail?id=15">Jump One Blue Dress</a><br>IDR 380000</div>
			</div>
		</div>

			</div>
		</div>
		<?php
require_once('footer.php');
?>
