<?php
class Admin
{
	public function index(array $var)
	{
		if (isset($_SESSION['isAdminLogin']))
		{
			$v = new View('admin/index');
			$v->render();
		}
		else
			header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/admin/login");		
	}

	public function login(array $var)
	{
		if (isset($_SESSION['isAdminLogin']))
		{
			header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/admin");
		}
		else
		{
			if (isset($var['submit']))
			{
				if (($var['username'] == "admin") && ($var['password'] == "admin"))
				{
					$_SESSION['isAdminLogin'] = true;
					header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/admin");		
				}
				header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/login");
	
			}
			else
			{
				$v = new View('admin/login');
				$v->render();
			}
		}
	}

	public function logout(array $var)
	{
		session_destroy();
		echo "Anda sudah logout dari laman admin";
	}
}
