<?php

/**
 * Class untuk penanganan model/tabel product
 */

class Customer {

	/**
	 * Mengisi dummy dari tabel produk
	 */
	public static function createTable($registry) {
		$sql = "CREATE TABLE IF NOT EXISTS `customer` (
					`customer_id` INT(9) NOT NULL AUTO_INCREMENT,
					`username` VARCHAR(16) NOT NULL,
					`email` VARCHAR(32) NOT NULL ,
					`password` CHAR(64) NOT NULL ,
					`fullname` VARCHAR(64) NOT NULL ,
					`phone` VARCHAR(16) ,
					`address` VARCHAR(128) ,
					`city` VARCHAR(32) ,
					`province` VARCHAR(32) ,
					`postcode` CHAR(5) ,
					`transaction` INT(5) NOT NULL ,
					`card_number` VARCHAR(16) ,
					`card_name` VARCHAR(32) ,
					`card_expired` DATE ,
					PRIMARY KEY (`customer_id`),
					UNIQUE (`username`),
					UNIQUE (`email`)
				)";
		try {
			$dbh = $registry->database;
			if ($dbh->exec($sql) !== false) {
				echo '</br> The customer table is created';
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	public static function dropTable($registry) {
		$sql = "DROP TABLE IF EXISTS `customer`";
		try {
			$dbh = $registry->database;
			if ($dbh->exec($sql) !== false) {
				echo '</br> The customer table is droped';
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Mendapatkan customer dengan id tertentu
	 */
	public static function getById($registry, $id) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT * FROM customer WHERE customer_id = :id');
    		$smh->execute(array('id' => $id));
 		
 			//pasti cuma ada satu
   			return $smh->fetch(PDO::FETCH_ASSOC);
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Memeriksa apakah user tersebut ada dan password sesuai
	 */
	public static function isValid($registry, $user, $pass) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT customer_id FROM customer WHERE username = :username AND password = :password');
    		$smh->execute(array('username' => $user, 'password' => $pass));
 			
   			return $smh->fetchColumn();
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Memeriksa apakah user tersebut ada
	 */
	public static function isExistUsername($registry, $user) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT customer_id FROM customer WHERE username = :username');
    		$smh->execute(array('username' => $user));
 			
   			return $smh->fetchColumn();
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Memeriksa apakah email tersebut ada
	 */
	public static function isExistEmail($registry, $email) {
		try {
			$dbh = $registry->database;
			$smh = $dbh->prepare('SELECT customer_id FROM customer WHERE email = :email');
    		$smh->execute(array('email' => $email));
 			
   			return $smh->fetchColumn();
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Menambah customer baru
	 * Mereturn id dari customer
	 */
	public static function addCustomer($registry, $customer) {
		try {
			$dbh = $registry->database;
			$sth = $dbh->prepare("INSERT INTO customer (username, email, password, fullname, phone, address, city, province, postcode, transaction) values (:username, :email, :password, :fullname, :phone, :address, :city, :province, :postcode, :transaction)"); 

			if ($sth->execute($customer) !== false) {
				return $dbh->lastInsertId(); 
			} else {
				return 0;
			}
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}

	/**
	 * Mengupdate credit card
	 */
	public static function updateCreditcard($registry, $customer) {
		try {
			$dbh = $registry->database;
			$sth = $dbh->prepare("UPDATE customer SET card_number = :card_number, card_name = :card_name, card_expired = :card_expired	WHERE customer_id = :customer_id"); 
			return $sth->execute($customer) !== false;
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
	}


} /*** end of class ***/