<?php
	/*class User{
		var $Username;
		var $Password;
		var $NamaLengkap;
		var $EMail;
		function __construct($UserN,$Pass,$NL,$EM){
			$this->Username=$UserN;
			$this->Password=$Pass;
			$this->NamaLengkap=$NL;
			$this->EMail=$EM;}
		function DisplayUser(){
			echo " Username : $this->Username<br>";
			echo " Password : $this->Password<br>";
			echo " Nama Lengkap : $this->NamaLengkap<br>";
			echo " Email : $this->EMail<br>";}
		function GetUsername(){
			return $this->Username;}
	}*/
	class Barang{
		var $id;
		var $NamaBarang;
		var $Kategori;
		var $Jumlah;
		var $Harga;
		var $img;
		function __construct($id,$NamaBar,$Har,$Cat,$Jum,$image="NULL"){
			$this->id=$id;
			$this->NamaBarang = $NamaBar;
			$this->Kategori = $Cat;
			$this->Jumlah = $Jum;
			$this->Harga = $Har;
			$this->img = $image;}
		function GetIdBarang(){
			return $this->id;}
		function GetNamaBarang(){
			return $this->NamaBarang;}
		function GetHarga(){
			return $this->Harga;}
		function GetKategori(){
			return $this->Kategori;}
		function GetJumlah(){
			return $this->Jumlah;}
		function setJumlah($Jum){
			$this->Jumlah=$Jum;}
		function DisplayBarang(){
			echo " Nama Barang : $this->NamaBarang<br>";
			echo " Kategori : $this->Kategori<br>";
			echo " Jumlah : $this->Jumlah<br>";
			echo " Harga : $this->Harga<br>";
		}
	}
?>