<?php

/**
 * Controller untuk penanganan register.
 * Bisa menangani register customer baru dan juga kartu kredit
 */
Class RegisterController Extends BaseController {

	/**
	 * Jika tidak ada parameter yang diberikan, jalankan register customer
	 */
	public function index() {
	    header("Location: " . SITEURL . "/register/customer" ); die();
	}

	/**
	 * Penanganan untuk register user
	 */
	public function customer() {
		if (session_id() == '') session_start();

		if (isset($_SESSION['logged_userid'])) {
			//redirect ke home jika sudah login
		    header("Location: " . SITEURL); die();
		} else {
			$this->registry->template->show('register/customer');
		}
	}

	/**
	 * Penanganan untuk register credit card
	 */
	public function card() {
		if (session_id() == '') session_start();

		if (!isset($_SESSION['logged_userid'])) {
			//redirect ke registrasi user
		    header("Location: " . SITEURL . "/register/customer"); die();
		} else {
			$this->registry->template->show('register/credit_card');
		}
	}

	/**
	 * Asumsi seluruh data sudah valid, sudah divalidasi oleh AJAX
	 * Dalam real world tidak boleh ada asumsi seperti
	 * Selanjutnya masukkan ke database
	 */
	public function new_customer() {
		/*** begin our session ***/
		if (session_id() == '') session_start();

		//validasi sedikit
		if (!isset($_POST["username"], $_POST["email"], $_POST["password"], $_POST["fullname"])
			or $_POST['form_token'] != $_SESSION['form_token'])  {
			header("Location: " . SITEURL . "/register/failed" ); die();
		} else {
			$customer['username'] =  filter_var($_POST["username"], FILTER_SANITIZE_STRING);
			$customer['email'] =  filter_var($_POST["email"], FILTER_SANITIZE_STRING);
			$customer['password'] = hash('sha256', filter_var($_POST["password"], FILTER_SANITIZE_STRING));
			$customer['fullname'] =  filter_var($_POST["fullname"], FILTER_SANITIZE_STRING);
			$customer['phone'] =  filter_var($_POST["phone"], FILTER_SANITIZE_STRING);
			$customer['address'] =  filter_var($_POST["address"], FILTER_SANITIZE_STRING);
			$customer['city'] =  filter_var($_POST["city"], FILTER_SANITIZE_STRING);
			$customer['province'] =  filter_var($_POST["province"], FILTER_SANITIZE_STRING);
			$customer['postcode'] =  filter_var($_POST["postcode"], FILTER_SANITIZE_STRING);
			$customer['transaction'] = 0;
			
			$id = Customer::addCustomer($this->registry, $customer);
			if ($id > 0) {
				//redirect
				$_SESSION['logged_userid'] = $id;
				$_SESSION['logged_userid'] = $_POST["username"];
				header("Location: " . SITEURL . "/register/card/"); die();
				//http_redirect (SITEURL . '/register/card', array ('username' => $customer['username']), true, HTTP_REDIRECT_POST );
			} else {
				header("Location: " . SITEURL . "/register/failed" ); die();
			}
		}
	}

	/**
	 * Registrasi kartu kredit
	 * Asumsi selalu valid
	 */

	public function new_creditcard() {
		if (session_id() == '') session_start();
		//validasi sedikit
		if (!isset($_POST["card_name"], $_POST["card_number"], $_POST["card_expired"], $_SESSION['logged_userid'])
			or $_POST['form_token'] != $_SESSION['form_token']) {
			header("Location: " . SITEURL . "/register/failed" ); die();
		} else {
			$customer['customer_id'] = $_SESSION['logged_userid'];
			$customer['card_name'] = filter_var($_POST["card_name"], FILTER_SANITIZE_STRING);
			$customer['card_number'] = filter_var($_POST["card_number"], FILTER_SANITIZE_STRING);
			$customer['card_expired'] = filter_var($_POST["card_expired"], FILTER_SANITIZE_STRING);
	
			if (Customer::updateCreditCard($this->registry, $customer)) {
				//redirect
				header("Location: " . SITEURL . "/register/success" ); die();
			} else {
				header("Location: " . SITEURL . "/register/failed" ); die();
			}
		}
	}
	public function check_username($username) {
		if (Customer::isExistUsername($this->registry, $username) == false) {
			echo "valid";
		} else {
			echo "notvalid";
		}
	}

	public function check_email($email) {
		if (Customer::isExistEmail($this->registry, $email) == false) {
			echo "valid";
		} else {
			echo "notvalid";
		}
	}

	/**
	 * Message jika sukses
	 */
	public function success() {
		$this->registry->template->message = "Pendaftaran customer baru sukses.";
		$this->registry->template->show('common');
	}

	/**
	 * Message jika gagal
	 */
	public function failed() {
		$this->registry->template->message = "Registrasi gagal, tolong periksa kembali data-data yang diisikan";
		$this->registry->template->show('common');
	}
}