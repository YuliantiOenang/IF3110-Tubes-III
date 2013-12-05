<?php
class User
{
	public function index(array $var)
	{
		if (isset($_SESSION['username']))
		{
			$v = new View('user/home');
            $m = new Barang_Model();
            $v->setData('listCateg',$m->getAllCategory());
			$v->render();
		}
		else
		{
			header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user/login");
		}
	}

	public function change(array $var)
	{
		if (isset($_SESSION['username']))
		{
			if (isset($var['submit']))
			{
                $isChanged = false;
                
                if ($_SESSION['nama_lengkap'] != $var['nama_lengkap'] || $_SESSION['password'] != $var['password'] ||
                    $_SESSION['HP'] != $var['HP'] || $_SESSION['alamat'] != $var['alamat'] || $_SESSION['provinsi'] != $var['provinsi'] ||
                    $_SESSION['kodepos'] != $var['kodepos'] || $_SESSION['kota'] != $var['kota']) $isChanged = true;
                
                if (!$isChanged) {
                    echo "Failure: Isi field tidak berubah!";
                } else {
                    $_SESSION['nama_lengkap'] = $var['nama_lengkap']; //nama lengkap
                    $_SESSION['password'] = $var['password'];
                    $_SESSION['HP'] = $var['HP'];
                    $_SESSION['alamat'] = $var['alamat'];
                    $_SESSION['provinsi'] = $var['provinsi'];
                    $_SESSION['kodepos'] = $var['kodepos'];
                    $_SESSION['kota'] = $var['kota'];
                    
                    $m = new User_Model();
                    $m->updateInfo($_SESSION['username'],$var['password'],$var['nama_lengkap'],$var['HP'],$var['alamat'],$var['provinsi'],$var['kota'],$var['kodepos'],$_SESSION['email']);
                    
                    echo "Success: ".SITE_ROOT.NAME_ROOT."/index.php/user";
                }
			}
			else
			{
				$v = new View('user/change');
                $m = new Barang_Model();
                $v->setData('listCateg',$m->getAllCategory());
				$v->render();
			}
		}
		else header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user/login");
	}

	public function register(array $var)
	{
		if (!isset($_SESSION['username']))
		{
            if (isset($var['submit'])) {
                $u = new User_Model();
                $u->addUser($var['username'],$var['password'],$var['nama_lengkap'],$var['HP'],$var['alamat'],$var['provinsi'],$var['kota'],$var['kodepos'],$var['email'],0);
                $ret = $u->isUserExists($var['username'],$var['password']); // tidak null karena baru ditambahkan
                $_SESSION['id'] = $ret->id;
				$_SESSION['username'] = $ret->username; //username akan disimpan
				$_SESSION['nama_lengkap'] = $ret->nama_lengkap; //nama lengkap
				$_SESSION['HP'] = $ret->HP;
				$_SESSION['alamat'] = $ret->alamat;
				$_SESSION['provinsi'] = $ret->provinsi;
				$_SESSION['kodepos'] = $ret->kodepos;
				$_SESSION['email'] = $ret->email;
				$_SESSION['password'] = $ret->password;
				$_SESSION['kota'] = $ret->kota;
				$_SESSION['isCreditCard'] = $ret->isCreditCard;
                echo "Success: ".SITE_ROOT.NAME_ROOT."/index.php/user/firstcreditcard";	
            } else {
				$v = new View('user/register');
                $v2 = new View ('user/login');
                $m = new Barang_Model();
                $v->setData('listCateg',$m->getAllCategory());
                $v->setData('loginView', $v2->render(false)); // rendering Login page
				$v->render();
            }
		}
		else header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user");
	}
    
    public function validation(array $var)
    {
        $isValid = true; // inisialisasi
        $u = new User_Model();
        
        switch($var['method']) {
            case 'checkEmail': // validasi untuk email
            $atPositionOne = strpos($var['value'], '@');
            if ($atPositionOne <= 0) $isValid = false; // @ di posisi pertama atau tidak ditemukan
            
            $restStringOne = substr($var['value'], $atPositionOne + 1);
            $atPositionTwo = strpos($restStringOne, '.');
            if ($atPositionTwo <= 0) $isValid = false; // . di posisi pertama atau tidak ditemukan
            
            $restStringTwo = substr($restStringOne, $atPositionTwo + 1);
            if (strpos($restStringOne, '@') === true|| strpos($restStringTwo, '.') === true) $isValid = false;
            if (strlen($restStringTwo) < 2) $isValid = false; // jika panjang karakter setelah '.' kurang dari 2
            
            if ($isValid) { // kondisi benar
                if ($var['value'] == $var['valueTwo']) echo "Failure: Email dan Password harus berbeda!";
                else if (!$u->isBolehDaftarEmail($var['value']) && $var['value'] != $_SESSION['email']) echo "Failure: Email sudah pernah digunakan!";
                else echo "Success: Email bernilai benar!";
            } else {
                echo "Failure: '".$var['value']."' bukanlah email yang valid!";
            }
            break;
            
            case 'checkUsername': // validasi untuk username
            
            if (strlen($var['value']) >= 5) { // kondisi benar
                if ($var['value'] == $var['valueTwo']) echo "Failure: Username dan Password harus berbeda!";
                else if (!$u->isBolehDaftarUsername($var['value']) && $var['value'] != $_SESSION['username']) echo "Failure: Username sudah pernah digunakan!";
                else echo "Success: Username bernilai benar!";
            } else {
                echo "Failure: '".$var['value']."' kurang dari 5 karakter!";
            }
            break;
            
            case 'checkPassword': // validasi untuk password
            if (strlen($var['value']) < 8) {
                echo "Failure: Password kurang dari 8 karakter!";
            } else if ($var['value'] == $var['valueTwo']) {
                echo "Failure: Email dan Password harus berbeda!";
            } else if ($var['value'] == $var['valueThree']) {
                echo "Failure: Username dan Password harus berbeda!";
            } else {
                echo "Success: Password bernilai benar!";
            }
            break;
            
            case 'checkConfirm': // validasi untuk konfirmasi password
            if ($var['value'] == $var['valueTwo']) {
                echo "Success: Password konfirmasi bernilai benar!";
            } else {
                echo "Failure: Konfirmasi password berbeda dengan password awal!";
            }
            break;
            
            case 'checkNamaLengkap': // validasi untuk nama lengkap
            if (strpos($var['value'], ' ') === false) $isValid = false; // spasi tidak ditemukan
            
            if ($isValid) {
                $restString = substr($var['value'], strpos($var['value'], ' ') + 1);
                if (strlen($restString) <= 0 || !preg_match("/^[a-z]$/i", $restString[0])) $isValid = false; // menjamin adanya karakter lain dibelakang
            }
            
            if ($isValid) {
                echo "Success: Nama lengkap bernilai benar!";           
            } else {
                echo "Failure: Nama lengkap harus terdiri atas minimal dua karakter!";  
            }
            break;
            
            default: exit;
        }
    }
    
	public function login(array $var)
	{
		if (isset($_SESSION['username']))
		{
			//jika sudah login
			header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user");
		}
		else
		{
			$u = new User_Model();
			$ret = $u->isUserExists($var['username'],$var['password']);
			if ($ret->username != null) //jika objek username tidak null
			{
				$_SESSION['id'] = $ret->id;
				$_SESSION['username'] = $ret->username; //username akan disimpan
				$_SESSION['nama_lengkap'] = $ret->nama_lengkap; //nama lengkap
				$_SESSION['HP'] = $ret->HP;
				$_SESSION['alamat'] = $ret->alamat;
				$_SESSION['provinsi'] = $ret->provinsi;
				$_SESSION['kodepos'] = $ret->kodepos;
				$_SESSION['email'] = $ret->email;
				$_SESSION['password'] = $ret->password;
				$_SESSION['kota'] = $ret->kota;
				$_SESSION['isCreditCard'] = $ret->isCreditCard;
                echo "Success: ".SITE_ROOT.NAME_ROOT."/index.php/user";
			} else {
                echo "Failure: Username / Password anda salah!";
            }
		}
	}

	public function logout(array $var)
	{
		session_destroy();
		header("Location: ".SITE_ROOT.NAME_ROOT."/index.php");
	}
    
    public function firstCreditCard(array $var) {
		if (isset($_SESSION['id']))
		{
            if ($_SESSION['isCreditCard'] != 1) {
                if ( (isset($var['submit'])) && ($var['card_number']!='') && ($var['name']!='') && ($var['expired_date']!='') )
                {
                    if (is_numeric($var['card_number']) && (strlen($var['card_number']) >= 13) && (strlen($var['card_number']) <= 19)) {
                        if (strlen($var['name']) <= 26) {
                            $year = intval(substr($var['expired_date'], 0, 4));
                            $month = intval(substr($var['expired_date'], 5, 2));
                            $day = intval(substr($var['expired_date'], 8, 2)); 
                            if (checkdate($month, $day, $year)) {
                                $m = new User_Model();
                                $m->addCreditCard($var['card_number'],$var['name'],$var['expired_date']);
                                
                                if (isset($_SESSION['username'])) //jika sudah login
                                {}
                                else session_destroy(); //jika bukan dari login, hapus semua session temporari

                                echo "Success: ".SITE_ROOT.NAME_ROOT."/index.php/user"; // kembali ke halaman utama
                            } else {
                                echo "Failure: Tanggal yang anda masukkan bukan tanggal yang valid!";
                            }
                        } else {
                            echo "Failure: Panjang nama harus kurang dari sama dengan 26 karakter!";
                        }
                    } else {
                        echo "Failure: Panjang card number harus diantara 13 - 19 digit!";
                    }

                }
                else{
                    $v = new View('user/firstcreditcard');
                    $m = new Barang_Model();
                    $v->setData('listCateg',$m->getAllCategory());
                    $v->render();
                }
            } else {
                header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user");
            }
        }
        else
            header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user/register");
    }

	public function addCreditCard(array $var){ 
		if (isset($_SESSION['id']))
		{
            if ( (isset($var['submit'])) && ($var['card_number']!='') && ($var['name']!='') && ($var['expired_date']!='') )
            {
                if (is_numeric($var['card_number']) && (strlen($var['card_number']) >= 13) && (strlen($var['card_number']) <= 19)) {
                    if (strlen($var['name']) <= 26) {
                        $year = intval(substr($var['expired_date'], 0, 4));
                        $month = intval(substr($var['expired_date'], 5, 2));
                        $day = intval(substr($var['expired_date'], 8, 2)); 
                        if (checkdate($month, $day, $year)) {
                            $m = new User_Model();
                            $m->addCreditCard($var['card_number'],$var['name'],$var['expired_date']);
                            
                            if (isset($_SESSION['username'])) //jika sudah login
                            {}
                            else session_destroy(); //jika bukan dari login, hapus semua session temporari

                            echo "Success: ".SITE_ROOT.NAME_ROOT."/index.php/user"; // kembali ke halaman utama
                        } else {
                            echo "Failure: Tanggal yang anda masukkan bukan tanggal yang valid!";
                        }
                    } else {
                        echo "Failure: Panjang nama harus kurang dari sama dengan 26 karakter!";
                    }
                } else {
                    echo "Failure: Panjang card number harus diantara 13 - 19 digit!";
                }

            } else{
				$v = new View('user/addcreditcard');
                $m = new Barang_Model();
                $v->setData('listCateg',$m->getAllCategory());
				$v->render();
			}
		}
		else
			header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user/register");
	}

	public function lihatCreditCard(array $var)
	{
		if (isset($_SESSION['username']))
		{
			$m = new User_Model();
			$v = new View('user/lihatcreditcard');
            $n = new Barang_Model();
            $v->setData('listCateg',$n->getAllCategory());
			$v->setData('listCC',$m->lihatCreditCard());
			$v->render();
		}
		else header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user/login");		
	}

	public function cart(array $var)
	{
		if (isset($_SESSION['username']))
		{
			$m = new Barang_Model();
			$v = new View('user/cart');
            $n = new Barang_Model();
            $v->setData('listCateg',$n->getAllCategory());
			$v->setData("listBarang",$m->generateCart());
			$v->render();
		}
		else header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/user/login");	
	}
}

