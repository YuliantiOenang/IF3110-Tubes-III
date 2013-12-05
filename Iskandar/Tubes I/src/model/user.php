<?php
class User_Model
{
	private $database;

	public function __construct()
	{
		$this->database = new SQL();
	}

	public function isUserExists($username,$password)
	{
		$username = mysql_real_escape_string(stripslashes($username));
		$password = mysql_real_escape_string(stripslashes($password));
		$query = "SELECT * FROM user where username='".$username."' and password='".$password."'";
		$this->database->query($query);
		return $this->database->fetch();
	}

	public function isBolehDaftarUsername($username)
	{
		$username = mysql_real_escape_string(stripslashes($username));
		$query = "SELECT * FROM user where username='".$username."'";
		$this->database->query($query);
		$ret = $this->database->fetch();
		if ($ret->username != null) return false;
		else return true; //boleh daftar karena username tidak ada
	}
    
	public function isBolehDaftarEmail($email)
	{
		$email = mysql_real_escape_string(stripslashes($email));
		$query = "SELECT * FROM user where email='".$email."'";
		$this->database->query($query);
		$ret = $this->database->fetch();
		if ($ret->email != null) return false;
		else return true; //boleh daftar karena username tidak ada
	}

	public function addUser($username, $password, $nama_lengkap, $HP, $alamat, $provinsi, $kota, $KodePos, $email,$isCreditCard)
	{
		$query = "INSERT INTO user (username,nama_lengkap,HP,alamat,provinsi,kota,kodepos,email,password,isCreditCard) VALUES ('".$username."','".$nama_lengkap."','".$HP."','".$alamat."','".$provinsi."','".$kota."','".$KodePos."','".$email."','".$password."','".$isCreditCard."')";
		$this->database->query($query);
		$_SESSION['id'] = mysql_insert_id(); //session ID ditanam
	}
	
	public function updateInfo($username, $password, $nama_lengkap, $HP, $alamat, $provinsi, $kota, $KodePos, $email)
	{
		$query = "UPDATE user SET username='".$username."', password='".$password."', nama_lengkap='".$nama_lengkap."', HP='".$HP."', alamat='".$alamat."', provinsi='".$provinsi."', kota='".$kota."', kodepos='".$KodePos."', email='".$email."' where id=".$_SESSION['id'];
		$this->database->query($query);
	}

	public function addCreditCard($card_number,$name,$expired_date)
	{
		$query = "INSERT INTO card (id_user,card_number,name,expired_date) VALUES ('".$_SESSION['id']."','".$card_number."','".$name."','".$expired_date."')";
		$this->database->query($query);

		$query = "UPDATE user SET isCreditCard=1 where id=".$_SESSION['id'];
		$this->database->query($query);
		$_SESSION['isCreditCard'] = 1;
	}

	public function lihatCreditCard()
	{
		$query = "SELECT * FROM card where id_user=".$_SESSION['id'];
		return $this->database->query($query);
	}
}

