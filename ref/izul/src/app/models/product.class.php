<?php

/**
 * Class untuk penanganan model/tabel product
 */

class Product {

	/**
	 * Membuat tabel produk
	 */
	public static function createTable($registry) {
		$sql = "CREATE TABLE IF NOT EXISTS `product` (
					`product_id` INT(9) NOT NULL AUTO_INCREMENT,
					`product_name` VARCHAR(32) NOT NULL,
					`category` VARCHAR(16) NOT NULL ,
					`price` INT(12) NOT NULL ,
					`stock_count` INT(9) NOT NULL ,
					`image_link` VARCHAR(64) ,
					`description` TEXT ,
					`sold` INT(9) ,
					PRIMARY KEY (`product_id`)
				)";
		try {
			$dbh = $registry->database;
			if ($dbh->exec($sql) !== false) {
				echo '</br> The product table is created';
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Menambahkan data dummy
	 */
	public static function insertDummy($registry) {
		$data = array(
					array('Altec Lansing VS4261', 'Elektronik', 800000, 10, 'images/barang1.jpg', 'Sebuah speaker system yang memiliki banyak kelebihan. Selain walaupun harganya tidak terlalu mahal, speaker ini memiliki kelebihan pada banyak sisi, seperti kejelasan suara dan desainnya yang unik', 1),
					array('Fiat 500', 'Otomotif', 1500000, 5, 'images/barang2.jpg', 'Mobil mini menarik dan unik', 1),
					array('Jack Wolfskin', 'Fashion', 1500000, 10, 'images/barang3.jpg', 'Jaket tebal dengan desain yang sangat menarik ini cocok sekali digunakan didaerah kutub dan di dataran tinggi.', 1),
					array('Acer 4652 G', 'Elektronik', 5000000, 10, 'images/barang4.jpg', 'Sebuah laptop handal yang mampu memenami anda dalam menjelajahi semua multimedia yang ada. Didukung dengan processor super cepat up to 3.1GHz, sangat cocok bagi anda yang menyukai dunia Game. Produk ini tersedia dalam beberapa warna', 5),
					array('Rumah Mewah Bogor Tipe 21', 'Properti', 1000000000, 1, 'images/barang5.jpg', 'Rumah mewah yang terletak di Bogor ini mempunyai 4 buah ruangan yang sangat nyaman dan full furnish', 0), 
					array('Gitar Yamaha YZR 200',  'Musik', 600000, 8, 'images/barang6.jpg', 'Gitar yamaha ini adalah gitar paling terkenal dikelasnya, setiap pembelian gitar ini akan diberikan garansi 3 bulan. Selain itu gitar ini terdapat pada bermacam-macam warna yang menarik.', 3)
				);
		try {
			$dbh = $registry->database;
			$sth = $dbh->prepare("INSERT INTO product (product_name, category, price, stock_count, image_link,description, sold) values (?, ?, ?, ?, ?, ?, ?)"); 

			foreach ($data as $value) {
				if ($sth->execute($value) !== false) {
					echo '</br> Inserted => ' . implode(' | ',$value);
				}
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Menghapus tabel
	 */
	public static function dropTable($registry) {
		$sql = "DROP TABLE IF EXISTS `product`";
		try {
			$dbh = $registry->database;
			if ($dbh->exec($sql) !== false) {
				echo '</br> The product table is droped';
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Mendapatkan seluruh baris produk dengan kategori tertentu
	 */
	public static function getByCategory($category) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT * FROM product WHERE category = :category');
    		$smh->execute(array('category' => $category));
 		
 			//return array of all
   			return $smh->fetchAll();
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Mendapatkan seluruh baris produk dengan nama tertentu
	 */
	public static function getBySearch($registry, $keyword) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT * FROM product WHERE MATCH(product_name, description) AGAINST (:keyword IN BOOLEAN MODE)');
    		$smh->execute(array('keyword' => $keyword));
 		
 			//return array of all
   			return $smh->fetchAll();
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Mendapatkan seluruh baris produk dengan id tertentu
	 */
	public static function getById($registry, $id) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT * FROM product WHERE product_id = :id');
    		$smh->execute(array('id' => $id));
 		
 			//return array of all
   			return $smh->fetch(PDO::FETCH_ASSOC);
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

} /*** end of class ***/