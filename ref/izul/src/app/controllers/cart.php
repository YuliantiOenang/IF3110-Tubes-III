<?php

Class CartController Extends BaseController {

	public function index() {
	    if (session_id() == '') session_start();

		if(!isset($_SESSION['logged_userid'])) {
		    //redirect ke registrasi user
		    header("Location: " . SITEURL . "/register/customer"); die();
		} else {
			$customer_id = $_SESSION['logged_userid'];

			$items = ShoppingBag::getNotPurchasedByCustomerId($this->registry, $customer_id);
			$this->registry->template->registry = $this->registry;
			$this->registry->template->items = $items;
			$this->registry->template->show('cart');
		}
	}

	public function add($product_id) {
		if (session_id() == '') session_start();

		if(!isset($_SESSION['logged_userid'])) {
		    //redirect ke registrasi user
		    header("Location: " . SITEURL . "/register/customer"); die();
		} else {
			$customer_id = $_SESSION['logged_userid'];

			ShoppingBag::addItem($this->registry, $customer_id, $product_id);
			header("Location: " . SITEURL . "/cart"); die();
		}
	}

	public function checkout() {
		if (session_id() == '') session_start();

		if(!isset($_SESSION['logged_userid'])) {
		    //redirect ke registrasi user
		    header("Location: " . SITEURL . "/register/customer"); die();
		} else {
			$customer_id = $_SESSION['logged_userid'];

			ShoppingBag::updatePurchasedByCustomerId($this->registry, $customer_id);

			$this->registry->template->message = "Terimakasih telah berbelanja bersama kami";
			$this->registry->template->show('common');
		}
	}
}