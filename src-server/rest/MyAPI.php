<?php
require_once 'API.class.php';
class MyAPI extends API
{
    public function __construct($request) {
        parent::__construct($request);
    }

    /**
     * Example of an Endpoint
     */
    protected function example($args) {
        if ($this->method == 'GET') {
            return "Your name is ".$args[0]." ".$args[1];
        } else {
            return "Only accepts GET requests";
        }
    }
	
	protected function tesdb() {
        if ($this->method == 'GET') {
			// Establish connection
			$pg_connection_string = "dbname=d5216j2nufkt99 host=ec2-54-235-99-46.compute-1.amazonaws.com port=5432 user=nulxwejlynnksi password=J17_WbbObzQJuwEGmDoR7avViM sslmode=require";
			$con = pg_connect($pg_connection_string);
			// Check connection
			if (!$con) {
				return "Failed to connect to MySQL: " . pg_last_error($con);
			}
			// Query
			$result = pg_query($con,"SELECT * FROM data_barang");
			// Close connection
			pg_close($con);
			// Return value
			return pg_fetch_all ($result);
        } else {
            return "Only accepts GET requests";
        }
    }
	
	protected function query($args) {
		    if ($this->method == 'GET') {
			// Establish connection
			$pg_connection_string = "dbname=d5216j2nufkt99 host=ec2-54-235-99-46.compute-1.amazonaws.com port=5432 user=nulxwejlynnksi password=J17_WbbObzQJuwEGmDoR7avViM sslmode=require";
			$con = pg_connect($pg_connection_string);
			// Check connection
			if (!$con) {
				return "Failed to connect to MySQL: " . pg_last_error($con);
			}
			// Query
			$sql = preg_replace("([^]+)","%",$args[0]);
			$result = pg_query($con,$sql);
			// Close connection
			pg_close($con);
			// Return value
			return pg_fetch_all ($result);
        } else {
            return "Only accepts GET requests";
        }
	}
}

try {
    $API = new MyAPI($_REQUEST['request']);
    echo $API->processAPI();
} catch (Exception $e) {
    echo json_encode(Array('error' => $e->getMessage()));
}
?>