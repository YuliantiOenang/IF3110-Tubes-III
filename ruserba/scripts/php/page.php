<?php
	$pages = array('register' => 'Pendaftaran', 'search' => ' - Hasil Pencarian', 'profile' => 'Profil', 'registerkartu' => 'Pendaftaran Kartu Kredit', 'kategori' => '', 'barang' => '', 'cart' => 'Keranjang Belanja');
	$appName = 'Ruko Serba Ada';

	if (isset($_GET['page']) && $_GET['page'] == 'kategori') {
		$query = 'select nama_kategori from kategori where id_kategori=?';
		$params = array($_GET['id']);
		include 'query.php';
		$pages['kategori'] = $result[0]['nama_kategori'];
	}

	if (isset($_GET['page']) && $_GET['page'] == 'barang') {
		$query = 'select nama_barang from barang where id_barang=?';
		$params = array($_GET['id']);
		include 'query.php';
		$pages['barang'] = $result[0]['nama_barang'];
	}

	if (isset($_GET['page']) && $_GET['page'] == 'search') {
		$pages['search'] = urldecode($_GET['q']) . $pages['search'];
	}
	
	function getPageTitle() {
		global $pages, $appName;
		$suffix = ' | ' . $appName;
		if (isset($_GET['page'])) {
			if (array_key_exists($_GET['page'], $pages)) {
				return $pages[$_GET['page']] . $suffix;
			}
			else {
				return '404' . $suffix;
			}
		}
		else {
			return 'Beranda' . $suffix;
		}
	}
	
	function getPageContent() {
		global $pages;
		if (isset($_GET['page'])) {
			if (array_key_exists($_GET['page'], $pages)) {
				return 'pages/' . $_GET['page'] . '.php';
			}
			else {
				return 'pages/error.php';
			}
		}
		else {
			return 'pages/home.php';
		}
	}
?>