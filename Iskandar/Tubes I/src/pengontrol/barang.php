<?php
class Barang
{

    public function addCart(array $var)
    {
        if (isset($_SESSION['username']))
        {
            if (isset($var['submit']))
            {
				//algoritma apabila barang sudah disubmit
				$m = new Barang_Model();
					
				if (!is_numeric($var['id_barang'])) die("SQL Injection detected");

				$row = $m->getOnlyBarangID($var['id_barang']);
               
				if ($row->jumlah_barang < $var['qty'] || $var['qty'] <= 0)
				{
					echo "Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid.";
				}
				else
				{
                    if (isset($var['deskripsi_tambahan'])) $deskripsi_tambahan = $var['deskripsi_tambahan'];
                    else $deskripsi_tambahan = "";

                    $m->AddCart($var['id_barang'], $var['qty'], $deskripsi_tambahan);
					echo "Success: Transaksi berhasil!";
				}
            }
        }
        else
        {
            echo "Redirect: ".SITE_ROOT.NAME_ROOT."/index.php/user/register"; // kembali ke halaman register
        }
    }
    
    public function updateCart(array $var)
    {
        if (isset($_SESSION['username']))
        {
            if (isset($var['submit']))
            {
				//algoritma apabila barang sudah disubmit
				$m = new Barang_Model();
					
				if (!is_numeric($var['id'])) die("SQL Injection detected");
                
                $row_two = $m->getCart($var['id']);
                $row_three = $m->getOnlyBarangID($row_two->id_barang);               

				$row = $m->getOnlyBarangID($row_two->id_barang);
               
				if ($row->jumlah_barang < $var['qty'] || $var['qty'] <= 0)
				{
					echo "Failure: Transaksi tidak berhasil, qty yang dimasukkan tidak valid.";
				}
				else
				{
                    $m->UpdateCart($var['id'], $var['qty']);
                    
                    $total_price = $var['qty'] * $row_three->harga_barang;
					echo "Success: ". $total_price;
				}
            }
        }
        else
        {
            echo "Redirect: ".SITE_ROOT.NAME_ROOT."/index.php/user/register"; // kembali ke halaman register
        }
    }
    
	public function beli(array $var)
	{
		if (isset($_SESSION['username']))
		{
			if ($_SESSION['isCreditCard'] == 0)
			{
				echo "Anda akan diredirect ke laman kartu kredit untuk membeli barang";
				header("Refresh: 2; url=".SITE_ROOT.NAME_ROOT."/index.php/user/addCreditCard");
			}
			else
			{
				if (isset($var['submit']))
				{
					// Mengubah status menjadi 1, set id_card, dan mengurangi stok
                    $m = new Barang_Model();
                    $m->Beli($var['kartu']);
                    header("Refresh: 0;url=".SITE_ROOT.NAME_ROOT."/index.php/user/cart");
				}
				else
				{
					$m = new Barang_Model();
					$u = new User_Model();
					$v = new View('barang/beli');
                    
                    $v->setData('listCateg',$m->getAllCategory());
                    $v->setData("listBarang",$m->generateCart());
					$v->setData('listCC',$u->lihatCreditCard());

					$v->render();
				}
			}
		}		
		else
		{
			echo "Anda harus login terlebih dahulu, anda akan diredirect ke laman login. . .";
			header("Refresh: 2;url=".SITE_ROOT.NAME_ROOT."/index.php/user");
		}
	}

	public function cari(array $var)
	{
		if (isset($var['search']))
		{
			$m = new Barang_Model();
			$u = new View('barang/search');
            $v = new View ('barang/login');
            $u->setData('loginView', $v->render(false));
			$u->setData('nama_barang',$var['search']);
			$u->setData('kategori',$var['kategori']);
			$u->setData('harga',$var['harga']);
			$u->setData('operator',$var['operator']);
            $u->setData('listCateg',$m->getAllCategory());			

			$u->setData('barang',$m->cariBarang($var['search'],$var['kategori'],$var['harga'],$var['operator'],$var['page']*10));
			$u->setData('jmlPage',(($m->countCariBarang($var['search'],$var['kategori'],$var['harga'],$var['operator'])->JmlBarang)/10));
			$u->render();
		}
		else header("Refresh: 0;url=".SITE_ROOT.NAME_ROOT."/index.php/barang");
	}

	public function detail(array $var)
	{
		$u = new Barang_Model();
		$v = new View('barang/detail');
        $v->setData('listCateg',$u->getAllCategory());
		$v->setData('detail',$u->getBarangID($var['id']));
        $v->setData('id',$var['id']);
		$v->render();
	}

	public function hapusBarang(array $var)
	{
		$m = new Barang_Model();
		$m->deleteBarang($var['id']);
		header("Refresh: 0;url=".SITE_ROOT.NAME_ROOT."/index.php/user/cart");
	}

	public function generatecontent(array $var)
	{
		$json;

		if (isset($var['sort']) && (isset($var['jenisSort'])) && (isset($var['page'])))
		{
			$str = "";
			$m = new Barang_Model();
			$res = $m->getAllBarang($var['sort'], $var['jenisSort'], $var['page']*10);
			while ($row = mysql_fetch_object($res))
			{
				$str = $str.'<div class="baris">';
				$str = $str.'<span class="kolom satu"><a href="'.SITE_ROOT.NAME_ROOT.'/index.php/barang/detail?id='.$row->id.'">'.$row->nama_barang.'</a></span>';
				$str = $str.'<span class="kolom dua"><img src="'.SITE_ROOT.NAME_ROOT.'/gambar_barang/'.$row->gambar.'" height=100px width=100px></span>';
				$str = $str.'<span class="kolom tiga">'.$row->harga_barang.'</span>';
				if ($row->jumlah_barang > 0)
				{
					$url = SITE_ROOT.NAME_ROOT;
					$str = $str. '<span class="kolom empat">'.$row->jumlah_barang.'</span>
				<span class="kolom lima"><input type="text" name="qty" size="8" id="qty_'.$row->id.'" value="0"></span>';
					$str = $str.'<span class="kolom enam">
                <input type="hidden" name="deskripsi_tambahan" id="deskripsi_tambahan"></input>
				<input type="button" value="Tambah ke Cart" id="beli" onClick="onAddToCart(\''.SITE_ROOT.NAME_ROOT.'/index.php/barang/addCart\','.$row->id.'); return false;">
				</span>';
				}
				else
				{
					$str = $str.'<span class="kolom empat">Habis</span>
					<span class="kolom lima"></span>
					<span class="kolom enam"><input type="button" value="Tambah ke Cart" id="beli" onClick="" disabled="true"></span>';
				}
				$str = $str."</div>";
			}
			$json['content'] = $str;
			$json['pageOf'] = $var['page'];
			$json['jmlPage'] = ($m->countBarang()->JmlBarang)/10;
			echo json_encode($json);
		}
		else echo "Tidak boleh dibuka langsung kk :v";
	}

	public function index(array $var)
	{
		//Untuk Auto Generated Content
		$v2 = new View ('home/login');
		$m = new Barang_Model();
		$u = new View('home/gallery');
		$u->setData('loginView', $v2->render(false)); // rendering Login page
		$u->setData('listCateg',$m->getAllCategory());
		$u->render();
	}
}
