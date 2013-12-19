<?php

/**
 * Controller untuk penanganan instalasi database pertama kali.
 * Satu untuk menghapus tabel
 * Satu lagi untuk menciptakan tabel
 */
Class InstallController Extends BaseController {

	public function index() {
		//do nothing
	}

	public function make() {
		if (session_id() == '') session_start();
		session_destroy();

		Product::createTable($this->registry);
		Product::insertDummy($this->registry);

		Customer::createTable($this->registry);

		ShoppingBag::createTable($this->registry);
	}

	public function clean() {
		if (session_id() == '') session_start();
		session_destroy();

		Product::dropTable($this->registry);

		Customer::dropTable($this->registry);

		ShoppingBag::dropTable($this->registry);
	}

}