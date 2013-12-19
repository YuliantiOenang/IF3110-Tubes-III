<?php

Class CustomerController Extends BaseController {

	public function index() {
	}

	public function id($id) {
		$json = json_encode(Customer::getById($this->registry, $id));
		echo $json;
	}

	public function valid($user, $pass) {
		$json = json_encode(Customer::isValid($this->registry, $user, $pass));
		echo $json;
	}

	public function user_exist($user) {
		$json = json_encode(Customer::isExistUsername($this->registry, $user));
		echo $json;
	}

	public function email_exist ($email) {
		$json = json_encode(Customer::isExistEmail($this->registry, $email));
		echo $json;
	}
}