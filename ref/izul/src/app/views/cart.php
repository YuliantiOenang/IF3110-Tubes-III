<?php require SITEPATH . '/app/views/head.php' ?>

<body> 
    <?php require SITEPATH . '/app/views/header.php' ?>

    <div id="container">
        <h2>Shopping Cart</h2>
        <?php
	        if (empty($items)) {
	        	echo '<p>Shopping Bag/Cart Kosong, Silahkan Berkunjung Ke Halaman Produk Untuk Membeli</p>';
	        } else {
	        	$i = 0;
	        	foreach ($items as $item) {
	        		$product = Product::getById($registry,  $item['product_id']);
	        		echo '</br> ';
	        		echo '</br> Barang ke-' . $i;
	        		echo '</br> Nama Barang: ' . $product['product_name'];
	        		echo '</br> Deskripsi: ' . $product['description'];
	        		echo '</br> Jumlah Barang: ' . $item['request_count'];
	        		$i++;
	        	}
	        }
	    ?>

        <form method="post" action="<?php echo SITEURL . "/cart/checkout/" ?>">
             <button  class="btn">Checkout</button>
        </form>
        
	</div>
</body>
</html>