<?php

	class db_connector {
	        var $host = "localhost";
	        var $user = "root";
	        var $pass = "";
	        var $dbname = "ruserba";
	        var $db_link = false;
	
	        function db_connector()
	        {
				$services_json = json_decode(getenv("VCAP_SERVICES"),true);
				$mysql_config = $services_json["mysql-5.1"][0]["credentials"];
				
				$username = $mysql_config["username"];
				$password = $mysql_config["password"];
				$hostname = $mysql_config["hostname"];
				$port = $mysql_config["port"];
				$db = $mysql_config["name"];
	            $this->db_connect($hostname,$username,$password,$db,$port);
				$this->db_link->set_charset('utf8');
	        }
	
	        function db_connect($host,$user,$pass,$dbname,$port)
	        {
	                if (!$this->db_link = new mysqli($host,$user,$pass,$dbname))
	                        return new SoapFault('db_error', 'no database link', 'db_connector', '');
	                if (!$this->db_choose($dbname))
	                         new SoapFault('db_error', 'non existing database', 'db_connector', '');
	        }
	
	        function db_choose($dbname) 
	        {
				return $this->db_link->select_db($dbname);
	        }
	
	        function db_query($query)
	        {
	                if (!$this->db_link) {
	                        return new SoapFault('db_error', 'no database connection available', 'db_connector', '');
	                }
	                if ($this->db_link->real_query($query))
	                {
	                        if ($result = $this->db_link->store_result()) {
		                        $i = 0;
		                        while($row=$result->fetch_object()) {
		                                $val[$i] = $row;
		                                $i++;
		                        }
		                        if ($i==1)
		                                return json_encode($val[0]);
		                        else
		                                return json_encode($val);
	                        } elseif (preg_match("/insert/i", $query) > 0) {
					return json_encode(array('status'=>'success','id' =>$this->db_link->insert_id));
				} else
				return json_encode(array('status'=>'failed'));
	                }
	                return new SoapFault('db_error', "the query is faulty : $query ", 'db_connector', '');
	        }
			
			
	        public function __destruct() {
			$this->db_link->close();
	        }
	
	}
	
	
	class ServerSoap {
		
		var	$class_db;
		
		public function __construct() {
			$this->class_db = new db_connector;
		}
		
		public function __destruct() {
			unset($this->class_db);
		}
		
		public function echo_test($test) {
			return "you wrote: ".$test;
		}
		
		public function create_barang($nama_barang,$category,$harga,$imageName,$tersedia) {
			$query = "insert into barang (nama_barang,id_kategori,harga_barang,gambar,dibeli,tersedia) values ('$nama_barang',$category,$harga,'$imageName',0,$tersedia)";
			return $this->class_db->db_query($query);
		}
		
	}
	
	$server = new SoapServer(null, array('uri' => "http://azon04.ap01.aws.af.cm/services/soap_server.php"));
	$server->setClass("ServerSoap");
	$server->handle();
?>