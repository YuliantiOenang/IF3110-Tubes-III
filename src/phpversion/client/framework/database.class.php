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
		/* HEROKU CONNECT
		# This function reads your DATABASE_URL configuration automatically set by Heroku
		# the return value is a string that will work with pg_connect
		function pg_connection_string() {
		  return "dbname=abcdefg host=****.amazonaws.com port=5432 user=**** password=**** sslmode=require";
		}
		 
		# Establish db connection
		$db = pg_connect(pg_connection_string());
		if (!$db) {
		   echo "Database connection error."
		   exit;
		}
		*/
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