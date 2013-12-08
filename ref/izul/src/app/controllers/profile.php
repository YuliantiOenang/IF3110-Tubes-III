<?php

/**
 * Controller untuk penanganan profile
 */
Class ProfileController Extends BaseController {

	/**
	 * Menampilkan profile seseorang jika login
	 */	
	public function index() {
		if (session_id() == '') session_start();

		if(!isset($_SESSION['logged_userid'])) {
		    //redirect ke registrasi user
		    header("Location: " . SITEURL . "/register/customer"); die();
		} else {
			$id = $_SESSION['logged_userid'];

			$customer = Customer::getById($this->registry, $id);
			if (!empty($customer)) {
				//passing value ke template dan show
				$this->registry->template->customer = $customer;
				$this->registry->template->show('profile/customer');
			}
		}
	}

	/** 
	 * Untuk mengedit profile
	 */
	public function edit() {
		if (session_id() == '') session_start();

		if (!isset($_SESSION['logged_userid'])) {
			//redirect ke home jika belum login
		    header("Location: " . SITEURL); die();
		} else {
			$customer = Customer::getById($this->registry, $_SESSION['logged_userid']);
			$this->registry->template->customer = $customer;
			$this->registry->template->show('profile/edit');
		}
	}
}