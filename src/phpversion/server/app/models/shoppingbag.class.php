<?php

/**
 * Class untuk penanganan model/tabel product
 */

class ShoppingBag {

	/**
	 * Mengisi dummy dari tabel produk
	 */
	public static function createTable($registry) {
		$sql = "CREATE TABLE IF NOT EXISTS `shopping_bag` (
					`customer_id` INT(9) NOT NULL,
					`product_id` INT(9) NOT NULL,
					`request_count` INT(9) NOT NULL ,
					`request_description` TEXT ,
					`is_purchased` INT(1) NOT NULL
				)";
		try {
			$dbh = $registry->database;
			if ($dbh->exec($sql) !== false) {
				echo '</br> The Shopping_Bag table is created';
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	public static function dropTable($registry) {
		$sql = "DROP TABLE IF EXISTS `shopping_bag`";
		try {
			$dbh = $registry->database;
			if ($dbh->exec($sql) !== false) {
				echo '</br> The Shopping_Bag table is droped';
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Mendapatkan shopping dengan customer id tertentu yang belum terbeli
	 */
	public static function getNotPurchasedByCustomerId($registry, $id) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT * FROM shopping_bag WHERE customer_id = :id AND is_purchased = 0');
    		$smh->execute(array('id' => $id));
 		
 			//pasti cuma ada satu
   			return $smh->fetchAll(PDO::FETCH_ASSOC);
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	public static function updatePurchasedByCustomerId($registry, $id) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('UPDATE shopping_bag SET is_purchased = 1 WHERE customer_id = :id');
    		$smh->execute(array('id' => $id));
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	public static function addItem($registry, $customer_id, $product_id) {
		try {
    		$dbh = $registry->database;
			$sth = $dbh->prepare("INSERT INTO shopping_bag (customer_id, product_id, request_count, is_purchased) values (:customer_id, :product_id, 1, 0)"); 
			return $sth->execute(array('customer_id' => $customer_id, 'product_id' => $product_id));
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

} /*** end of class ***/