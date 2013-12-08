<?php

class Database {
	
	/*** Declare instance ***/
	private static $instance = NULL;
	
	/**
	*
	* the constructor is set to private so
	* so nobody can create a new instance using new
	*
	*/
	private function __construct() {
	  /*** maybe set the db name here later ***/
	}
	
	/**
	*
	* Return DB instance or create intitial connection
	*
	* @return object (PDO)
	*
	* @access public
	*
	*/
	public static function getInstance($registry) {
		if (!self::$instance) {
			try {
				$host = $registry->config['mysql']['host'];
				$dbname = $registry->config['mysql']['database'];
				$user = $registry->config['mysql']['username'];
				$pass = $registry->config['mysql']['password'];
		    	self::$instance = new PDO("mysql:host=" . $host . ";dbname=" . $dbname, $user, $pass);;
		    	self::$instance-> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		    } catch(PDOException $e) {
		    	switch (ENVIRONMENT) {
					case 'production':
						break;
					case 'testing':
					case 'development':
					default:
						echo 'ERROR: ' . $e->getMessage();
						break;
				}
			}
    	}
		return self::$instance;
	}
	
	/**
	*
	* Like the constructor, we make __clone private
	* so nobody can clone the instance
	*
	*/
	private function __clone(){
	}
	
} /*** end of class ***/