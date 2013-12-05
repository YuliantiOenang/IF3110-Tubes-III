<?php
class Barang_Model
{
	private $database;
	public function __construct()
	{
		$this->database = new SQL();
	}

	public function getAllCategory()
	{
		$query = "SELECT * FROM kategori";
		return $this->database->query($query);
	}

	public function get3BestBarang($id_kategori)
	{
		$query = "select barang.gambar, barang.nama_barang, barang.id from barang_card JOIN barang JOIN kategori ON barang_card.id_barang = barang.id AND barang.id_kategori = kategori.id AND kategori.id=".$id_kategori." OR barang.id_kategori = ".$id_kategori." GROUP BY barang.id order by count(barang.id) DESC LIMIT 0,3";
		return $this->database->query($query);
	}

	public function countBarang()
	{
		$query = "SELECT COUNT(id) AS JmlBarang from barang";
		$this->database->query($query);
		return $this->database->fetch();		
	}

	public function countCariBarang($nama_barang,$kategori,$harga,$operator)
	{
		$partial1; $partial2; $partial3;

		if ($nama_barang != "") $partial1 = " AND barang.nama_barang LIKE '%$nama_barang%' ";
		else $partial1 = "";

		if ($kategori != "") $partial2 = " AND kategori.name = '".$kategori."' ";
		else $partial2 = "";

		if (is_numeric($harga))
		{
			if ($operator == "L")
				$partial3 = " AND barang.harga_barang < ".$harga." ";
			else if ($operator == "E")
				$partial3 = " AND barang.harga_barang = ".$harga." ";
			else if ($operator == "G")
				$partial3 = " AND barang.harga_barang > ".$harga." ";
			else die("Sistem mendeteksi adanya keanehan");
		}
		else $partial3 = "";

		$query = "SELECT COUNT(id) AS JmlBarang from barang where id=id ".$partial1.$partial2.$partial3;
		$this->database->query($query);
		return $this->database->fetch();		
	}

	public function cariBarang($nama_barang,$kategori,$harga,$operator,$offset)
	{
		$partial1; $partial2; $partial3;

		if ($nama_barang != "") $partial1 = " AND barang.nama_barang LIKE '%$nama_barang%' ";
		else $partial1 = "";

		if ($kategori != "") $partial2 = " AND kategori.name = '".$kategori."' ";
		else $partial2 = "";

		if (is_numeric($harga))
		{
			if ($operator == "L")
				$partial3 = " AND barang.harga_barang < ".$harga." ";
			else if ($operator == "E")
				$partial3 = " AND barang.harga_barang = ".$harga." ";
			else if ($operator == "G")
				$partial3 = " AND barang.harga_barang > ".$harga." ";
			else die("Sistem mendeteksi adanya keanehan");
		}
		else $partial3 = "";

		
		//LIMIT 0, 10 
		$query = "select barang.gambar, kategori.name, barang.id, barang.nama_barang, barang.harga_barang, barang.jumlah_barang from barang join kategori on barang.id_kategori=kategori.id ".$partial1.$partial2.$partial3." LIMIT ".$offset.",10";
		//die($query);
		return $this->database->query($query);
	}

	public function getAllBarang($sort, $jenisSort, $offset)
	{
		//LIMIT 0, 10
		if (isset($sort))
		{
			if ($sort=="nama")
				$partial1 = " ORDER BY barang.nama_barang ";
			else if ($sort=="kategori")
				$partial1 = " ORDER BY kategori.name ";
			else
				$partial1 = " ORDER BY barang.harga_barang ";
		}
		else $partial1=" ";

		if (isset($jenisSort)){
			if ($jenisSort == "ASC")
				$partial2 = " ASC ";
			else
				$partial2 = " DESC ";		
		}
		else $partial2=" ";
 
		$query = "select kategori.name, barang.gambar, barang.id, barang.nama_barang, barang.harga_barang, barang.jumlah_barang from barang join kategori on barang.id_kategori=kategori.id ".$partial1.$partial2." limit ".$offset.",10";
		return $this->database->query($query);
	}

	public function getBarangID($id)
	{
		$query = "select * from barang join kategori on barang.id_kategori=kategori.id and barang.id=".$id;
		return $this->database->query($query);
	}

	public function getOnlyBarangID($id)
	{
		$query = "select * from barang where id=".$id;
		$this->database->query($query);
		return $this->database->fetch();
	}

	public function Beli($id_card)
	{
        $query = "SELECT * FROM barang_card WHERE status=0 AND id_user=".$_SESSION['id'];
        $rows = $this->database->query($query);
        
        while ($row = mysql_fetch_object($rows)) {
            $rows = $this->getOnlyBarangID($row->id_barang);
            $hasil = ($rows->jumlah_barang) - $row->jumlah_barang;
            
            $query = "UPDATE barang SET jumlah_barang=".$hasil." where id =".$row->id_barang;
		    $this->database->query($query);
        }
        
        $query = "UPDATE barang_card SET status=1, id_card='".$id_card."' where status=0 AND id_user=".$_SESSION['id'];
		$this->database->query($query);
	}
    
    public function AddCart($id_barang, $jumlah_barang, $deskripsi_tambahan)
    {
        $query = "INSERT INTO barang_card (id_barang,id_card,status,jumlah_barang,id_user,deskripsi_tambahan) VALUES ('".$id_barang."','"."0"."','"."0"."','".$jumlah_barang."','".$_SESSION['id']."','".$deskripsi_tambahan."')";
		$this->database->query($query);
    }
    
    public function UpdateCart($id, $jumlah_barang)
    {
        $query = "UPDATE barang_card SET jumlah_barang=". $jumlah_barang ." WHERE id=". $id;
        $this->database->query($query);
    }
    
    public function getCart($id)
    {
        $query = "SELECT * FROM barang_card WHERE id=". $id;
        $this->database->query($query);
        return $this->database->fetch();
    }

	public function generateCart()
	{
		$query = "SELECT barang_card.id, barang_card.tgl_pembelian, barang_card.status, barang_card.jumlah_barang, barang_card.deskripsi_tambahan,barang.nama_barang, barang.harga_barang from barang JOIN barang_card ON barang_card.id_user=".$_SESSION['id']." AND barang_card.id_barang = barang.id";
		return $this->database->query($query);
	}

	public function deleteBarang($id)
	{
		//delete from artikel where id=4;
		$query = "delete from barang_card where id=".$id;
		$this->database->query($query);
	}
}
		
