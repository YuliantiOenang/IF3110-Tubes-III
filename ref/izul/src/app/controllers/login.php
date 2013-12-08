<?php

/**
 * Controller untuk penanganan login.
 * Memeriksa apakah user dan password benar.
 *		Jika benar, maka kembali ke halaman sebelumnya (atau cukup home)
 *					dengan status sudah login
 *		Jika salah, maka tampilkan halaman yang menunjukkan login salah
 */
Class LoginController Extends BaseController {

	public function index() {
		if (session_id() == '') session_start();

		$user = filter_var($_POST['login-user'], FILTER_SANITIZE_STRING);
		$pass = hash('sha256', filter_var($_POST['login-pass'], FILTER_SANITIZE_STRING));

		$id = Customer::isValid($this->registry, $user, $pass);

		if ($id == false) {
			header("Location: " . SITEURL . "/login/failed" ); die();
		} else {
			$_SESSION['logged_userid'] = $id;
			$_SESSION['logged_username'] = $user;
			header("Location: " . SITEURL . "/login/success/"); die();
		}
	}

	/**
	 * fungsi LOGOUT
	 */
	public function destroy() {
		if (session_id() == '') session_start();
		// Unset all of the session variables.
		$_SESSION = array();
		//and destroy
		session_destroy();
		//redirect
		header("Location: " . SITEURL); die();
	}

	public function success() {
		$this->registry->template->message = "Login berhasil.";
		$this->registry->template->show('common');
	}

	public function failed() {
		$this->registry->template->message = "Login gagal";
		$this->registry->template->show('common');
	}
}