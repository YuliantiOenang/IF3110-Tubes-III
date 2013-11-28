<?php
class Home
{
	public function index(array $var)
	{
        $v = new View('home/index');
        $v2 = new View ('home/login');
        $m = new Barang_Model();
        $v->setData('listCateg',$m->getAllCategory());
        $v->setData('loginView', $v2->render(false)); // rendering Login page
		  $v->setData('Sembako',$m->get3BestBarang(1));
		  $v->setData('HP',$m->get3BestBarang(2));
		  $v->setData('Listrik',$m->get3BestBarang(3));
		  $v->setData('Komputer',$m->get3BestBarang(4));
		  $v->setData('Rumah',$m->get3BestBarang(5));
		  $v->setData('Tulis',$m->get3BestBarang(6));
        $v->render();
	}

	public function gallery(array $var)
	{
		header("Location: ".SITE_ROOT.NAME_ROOT."/index.php/barang");
	}
}

