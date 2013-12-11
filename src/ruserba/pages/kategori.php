<?php 
	if(!isset($_SESSION['username'])) {
		header("Location: /ruserba");
	} else if ($_SESSION['username'] == 'admin') {
		header("Location: /ruserba/pages/listkategori.php");
	}
?>
<script>var basePageUrl = "<?php echo '/ruserba/kategori/'.$_GET['id']?>";</script>
<script src='/ruserba/scripts/sort.js'></script>
<script src='/ruserba/scripts/addtocart.js'></script>
<?php    
    //mencari banyak data yang ada dalam tabel  
	$result = simplexml_load_file($rest."/kategori/".$_GET['id'].".xml");
	echo '<h3 class="judul_halaman">Kategori: ';
	echo $result->nama_kategori;
	echo '</h3>';
	$barangs = simplexml_load_file($rest."/barang?id_kategori=".$result->id_kategori .".xml");
	$jumlah = $barangs->children();
	$banyakBarang = count($jumlah);
	$page = isset($_GET['p']) ? $_GET['p'] : 1;
	$limit = 10;
	$mulai_dari = $limit * ($page - 1);
	echo '<div id="dropdownsort">';
	$query = "order%20by%20";
	echo 'Urutkan berdasarkan ';
	echo '<select id="selectorder">';
	if (!isset($_GET['orderby']) || (isset($_GET['orderby']) && $_GET['orderby'] == 'name')) {
		echo '<option selected=true>Nama</option>';
		echo '<option>Harga</option>';
		$query .= "nama_barang%20";
	}
	else if (isset($_GET['orderby']) && $_GET['orderby'] == 'price') {
		echo '<option>Nama</option>';
		echo '<option selected=true>Harga</option>';
		$query .= "harga_barang%20";
	}
	echo '</select>';
	echo '<select id="selectsort">';
	if (!isset($_GET['sort']) || (isset($_GET['sort']) && $_GET['sort'] == 'asc')) {
		echo '<option selected=true>Membesar</option>';
		echo '<option>Mengecil</option>';
		$query .= "asc";
	}
	else if (isset($_GET['sort']) && $_GET['sort'] == 'desc') {
		echo '<option>Membesar</option>';
		echo '<option selected=true>Mengecil</option>';
		$query .= "desc";
	}
	echo '</select>';
	echo '</div>';
	echo '<br/>';
	echo '<br/>';
	$barangs = simplexml_load_file($rest."/barang?id_kategori=".$result->id_kategori ."%20".$query."%20limit%20".$mulai_dari.",%20".$limit.".xml");
	foreach($barangs->children() as $child){
		$barang = simplexml_load_file($rest."/barang/".$child."xml");
		echo '<div class="halaman_category_container">';
		echo '<div class="barang_container">';
		echo '<div class="barang">';
		echo '<a href="/ruserba/barang/'.$barang->id_barang.'">';
		echo '<img src="/ruserba/assets/barang/'.$barang->gambar.'" height="100%"/>';
		echo '</a>';
		echo '</div>';
		echo '<div class="barang">';
		echo '<span class="barang_nama">';
		echo '<a href="/ruserba/barang/'.$barang->id_barang.'">';
		echo $barang->nama_barang;
		echo '</a>';
		echo '</span>';
		echo '<br>';
		if($barang->tersedia==0){
			echo '<span class="barang_tersedia">';
			echo 'Barang tidak tersedia';
			echo '</span>';
			echo '<br>';
		}
		else{
			echo '<span class="barang_tersedia">';
			echo 'Barang tersedia ('.$barang->tersedia.' 	unit)';
			echo '</span>';
			echo '<br>';
		}
		echo '<span class="barang_harga">';
		echo 'Rp '.$barang->harga_barang.',00';
		echo '</span>';
		echo '<br>';
		echo '</div>';
		if ($barang->tersedia > 0) {
			echo '<a class="button beli" name="'.$barang->id_barang.'" href="javascript:void(0)"><div>Pesan Barang</div></a>';
		}
		echo '</div>';
		echo '</div>';
		echo '<hr>';
	}   
	//membuat pagination
	$banyakHalaman = ceil($banyakBarang / $limit);  
	if ($banyakHalaman > 1) {
		echo '<div class="paginasi">';
		echo 'Halaman: ';
		for($i = 1; $i <= $banyakHalaman; $i++){  
			if($page != $i){  
				echo '<a href="/ruserba/kategori/'.$_GET['id'].'/'.$i.'">['.$i.']</a> ';  
			}
			else {  
				echo "[$i] ";  
			}  
		}
		echo '</div>';
	}
?>  