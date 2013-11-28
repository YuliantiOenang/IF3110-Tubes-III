<?php
class SQL
{
	private $connection;
	private $result;
	private $db;

	public function __construct()
	{
		//buka koneksi
		$host = HOST_SQL;
		$user = USER_SQL;
		$password = PASS_SQL;

		$this->db = SQL_NAME;
		$this->connection = mysql_connect($host,$user,$password);	
		return TRUE;
	}

	public function query($query)
	{
		if (isset($query))
		{
			mysql_select_db($this->db, $this->connection);
			$this->result = mysql_query($query);
			return $this->result;
		}
		return FALSE;        
	}

	public function fetch($type = 'object')
	{
		if (isset($this->result))
		{
			$row = false;
			switch ($type)
			{
				case 'array':
					$row = mysql_fetch_array($this->result);
				break;

				case 'object':
				default:
					$row = mysql_fetch_object($this->result);   
				break;
			}
			return $row;
		}
		else
			return FALSE; //jika tidak bisa fetch
	}

	public function __destruct()
	{
		//tutup koneksi
		//Dtor, otomatis dipanggil apabila tidak dipakai lagi
		mysql_close($this->connection);
	}
}
