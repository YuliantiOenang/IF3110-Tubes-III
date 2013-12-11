<?php
	//fungsi-fungsi pengambilan data (SELECT) barang
	include(dirname(__FILE__)."/db.php");
	
	class Barang{
		public $id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi;
		
		function buildJSON(){
			$arr = array();
			$arr["id"] = $this->id; $arr["nama"] = $this->nama; $arr["stok"] = $this->stok; $arr["harga"] = $this->harga;
			$arr["jumlah_beli"] = $this->jumlah_beli; $arr["kategori"] = $this->kategori; $arr["deskripsi"] = $this->deskripsi;
			
			return $arr;
		}
		
		function set($id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi){
			$this->id = $id; $this->nama = $nama; $this->stok = $stok; 
			$this->harga = $harga; $this->jumlah_beli = $jumlah_beli; 
			$this->kategori = $kategori; $this->deskripsi = $deskripsi;
		}
	}
	
	function formatCurrency($cash){
		$cash = (string) $cash;
		$str = "";
		$l = strlen($cash);
		
		for($i = 0; $i < $l; $i++){
			$str = $cash[$l - $i -1].$str;
			
			if (($i % 3 == 2) && ($i != $l-1))
				$str = ".".$str;
		}
		
		return $str;
		
	}
	
	function searchHome(){
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		$statement = $conn->prepare("SELECT * FROM barang ORDER BY jumlah_terbeli DESC LIMIT 0, 10");
		
		$statement->execute();
		$statement->bind_result($id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi);
		
		$result = array();
		while($statement->fetch()){
			$barang = new Barang();
			$barang->set($id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi);
			array_push($result, $barang);
		}
		
		$statement->close();
		$conn->close();
		
		return $result;
	}
	
	function searchAll($keyword, $page){
		// mengambil barang yg punya keyword tertentu (entah nama, kategori, deskripsi, dll).
		// page dimulai dari 0, 1 page 10 barang
		// kembalian: array of Barang
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		$statement = $conn->prepare("SELECT * FROM barang WHERE nama_barang REGEXP ? OR kategori REGEXP ? OR deskripsi REGEXP ? OR harga = ? LIMIT ?, 10");
		
		$oldkeyword = $keyword;
		$keyword = str_replace(" ", "|", $keyword);	
		
		$page *= 10;
		
		$statement->bind_param("ssssi", $keyword, $keyword, $keyword, $oldkeyword, $page);
		
		$statement->execute();
		$statement->bind_result($id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi);
		
		$result = array();
		while($statement->fetch()){
			$barang = new Barang();
			$barang->set($id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi);
			array_push($result, $barang);
		}
		
		$statement->close();
		$conn->close();
		
		return $result;
	}
	
	function searchCategory($category, $page, $srt, $ord){
		// mengambil data barang dengan kategori tertentu, dengan pengurutan berdasarkan $sort dengan order $order
		// page dimulai dari 0, 1 page 10 barang
		// kembalian: array of Barang
		
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		
		$sort = ($srt == "harga") ? "harga" : "nama_barang";
		$order = ($ord == "desc") ? "DESC" : "ASC";
				
		$statement = $conn->prepare("SELECT * FROM barang WHERE kategori = ? ORDER BY ".$sort." ".$order." LIMIT ?, 10");
		
		$page = $page * 10;
		
		$statement->bind_param("si", $category, $page);
		
		$statement->execute();
		
		$statement->bind_result($id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi);
		$result = array();
		while($statement->fetch()){
			$barang = new Barang();
			$barang->set($id, $nama, $stok, $harga, $jumlah_beli, $kategori, $deskripsi);
			array_push($result, $barang);
		}
		
		$statement->close();
		$conn->close();
		
		return $result;
	}

	function searchId($id_barang){
		// mengambil data barang dengan id tertentu (spesifik)
		// kembalian: Barang
		
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
		
		$statement = $conn->prepare("SELECT * FROM barang WHERE id_barang = ?");
		
		$statement->bind_param("i", $id_barang);
		
		$statement->execute();
		
		$barang = new Barang();
		
		$statement->bind_result($barang->id, $barang->nama, $barang->stok, $barang->harga, $barang->jumlah_beli, $barang->kategori, $barang->deskripsi);
		if($statement->fetch()){
			$statement->close();
			$conn->close();
		
			return $barang;
		}else{
			$statement->close();
			$conn->close();
			
			return null;
		}
	}
	
	function searchIds($ids){
		$hasil = array();
		
		global $DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME;
		$conn = new mysqli($DB_HOST, $DB_USERNAME, $DB_PASSWORD, $DB_NAME);
	
		foreach ($ids as $id){
			$statement = $conn->prepare("SELECT * FROM barang WHERE id_barang = ?");
			$statement->bind_param("i", $id);
			$statement->execute();
			
			$barang = new Barang();
			$statement->bind_result($barang->id, $barang->nama, $barang->stok, $barang->harga, $barang->jumlah_beli, $barang->kategori, $barang->deskripsi);
			
			if(!$statement->fetch()){
				$barang = null;
			}
			
			array_push($hasil, $barang);
			$statement->close();
		}
		
		$conn->close();
		
		return $hasil;
	}
	
	function handleSearchAjax(){
		// handle ajax untuk aksi2 search
		// syarat: $_POST["ajax"] terdefinisi
		
		$request = json_decode($_POST["ajax"], true);
		$response = array("status" => "error");
		
		switch($request["action"]){
			case "cart":
				$response["status"] = "ok";
				$hasil = searchIds($request["ids"]);
				
				$response["barang"] = array();
				foreach($hasil as $barang){
					if($barang!=null){
						array_push($response["barang"], $barang->buildJSON());
					}else{
						array_push($response["barang"], null);
					}
				}
				
			break;
			case "category":
				$hasil = searchCategory($request["cat"], $request["page"], $request["sort"], $request["order"]);
				
				if (count($hasil) > 0){
					$response["status"] = "ok";
					$response["barang"] = array();
					
					foreach($hasil as $barang){
						if($barang!=null){
							array_push($response["barang"], $barang->buildJSON());
						}else{
							array_push($response["barang"], null);
						}
					}
				}
				
			break;
			case "search":
				$hasil = searchAll($request["q"], $request["page"]);
				if (count($hasil) > 0){
					$response["status"] = "ok";
					$response["barang"] = array();
					
					foreach($hasil as $barang){
						if($barang!=null){
							array_push($response["barang"], $barang->buildJSON());
						}else{
							array_push($response["barang"], null);
						}
					}
				}
			break;
			default:
				return null;
			break;
		}
		
		return json_encode($response);
	}

?>