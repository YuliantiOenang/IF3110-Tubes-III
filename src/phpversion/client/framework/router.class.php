<?php

class Router {
	
	/*
	 */
	private $registry;

	/*
	 * controller path
	 */
	private $path;
	private $args = array();
	public $file;
	public $controller;
	public $action; 
	public $param;

	function __construct($registry) {
		$this->registry = $registry;
	}

	/**
	 * @set controller directory path
	 * @param string $path
	 * @return void
	 */
	function setPath($path) {
		if (is_dir($path) == false) {
			throw new Exception ('Invalid controller path: `' . $path . '`');
		}
		
		//set path
	 	$this->path = $path;
	}


	/**
	* @load the controller
	* @access public
	* @return void
	*/
	public function loader() {

		//check route
		$this->getController();
	
		//jika file gak ada
		if (is_readable($this->file) == false)
		{
			$this->file = $this->path.'/error/404.php';
	        $this->controller = 'Error404';
		}
	
		//include controller
		require $this->file;
	
		//buat instance baru
		$class = $this->controller . 'Controller';
		$controller = new $class($this->registry);
	
		//periksa apakah action bisa dipanggil
		if (is_callable(array($controller, $this->action)) == false) {
			$action = 'index';
		} else {
			$action = $this->action;
		}
		
		//jalankan action
		$controller->$action($this->param);
	 }

	/**
	*
	* @get the controller
	* @access private
	* @return void
	*/
	private function getController() {
	
		//dapatkan route dari url
		$route = (empty($_GET['route'])) ? '' : $_GET['route'];
	
		if (empty($route)) {
			$route = 'index';
		} else {
			//ambil potongan2 dari route
			$parts = explode('/', $route);
			$this->controller = $parts[0];
			if(isset( $parts[1])) {
				$this->action = $parts[1];
			}

			if(isset( $parts[2])) {
				$this->param = $parts[2];
			}
		}
	
		if (empty($this->controller)) {
			$this->controller = 'index';
		}
	
		//get action
		if (empty($this->action)) {
			$this->action = 'index';
		}
	
		//set file path
		$this->file = $this->path .'/'. $this->controller . '.php';
	}
}