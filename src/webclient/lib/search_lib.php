<?php
	//fungsi-fungsi pengambilan data (SELECT) barang
	include(dirname(__FILE__)."/db.php");
	include(dirname(__FILE__)."/rest_request.php");
	
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
		$array = sendRestRequest("GET","populer",array());
		if ($array["status"] == "ok") {
			return $array["hasil"];
		} else {
			return $array["desc"];
		}
	}
	
	function searchAll($keyword, $page){
		// mengambil barang yg punya keyword tertentu (entah nama, kategori, deskripsi, dll).
		// page dimulai dari 0, 1 page 10 barang
		// kembalian: array of Barang
		$data["page"] = $page;
		$array = sendRestRequest("GET","search/".$keyword, $data);
		if ($array["status"] == "ok") {
			return $array["hasil"];
		} else {
			return $array["desc"];
		}
	}
	
	function searchCategory($category, $page, $srt, $ord){
		// mengambil data barang dengan kategori tertentu, dengan pengurutan berdasarkan $sort dengan order $order
		// page dimulai dari 0, 1 page 10 barang
		// kembalian: array of Barang
		$data["page"] = $page;
		$data["sort"] = $srt;
		$data["order"] = $ord;
		
		$array = sendRestRequest("GET","kategori/".$category, $data);
		if ($array["status"] == "ok") {
			return $array["hasil"];
		} else {
			return $array["desc"];
		}
		
	}

	function searchId($id_barang){
		// mengambil data barang dengan id tertentu (spesifik)
		// kembalian: Barang
		
		$array = sendRestRequest("GET","barang/".$id_barang, array());
		if ($array["status"] == "ok") {
			return $array["barang"];
		} else {
			return $array["desc"];
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