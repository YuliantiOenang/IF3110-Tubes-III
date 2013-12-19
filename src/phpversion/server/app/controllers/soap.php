<?php

require '../models/customer.class.php';
//Class SoapController extends BaseController {

//	public function index() {

		if(!extension_loaded("soap")){
		  dl("php_soap.dll");
		}
		 
		ini_set("soap.wsdl_cache_enabled","0");
		$location = "http://localhost/IF3110-Tubes-III/src/phpversion/server/wsdl/customer.wsdl";
		$server = new SoapServer($location);
		 
		function add_customer($username, $email, $password, $fullname, $phone, $address, $city, $province, $postcode, $transaction){
			$customer['username'] = $username;
			$customer['email'] = $email;
			$customer['password'] = $password;
			$customer['fullname'] = $fullname;
			$customer['phone'] = $phone;
			$customer['address'] = $address;
			$customer['city'] = $city;
			$customer['province'] = $province;
			$customer['postcode'] = $postcode;
			$customer['transaction'] = $transaction;

			return Customer::addCustomer($customer);
			echo '\n' . $customer['username'] = $username;
			echo '\n' . $customer['email'] = $email;
			echo '\n' . $customer['password'] = $password;
			echo '\n' . $customer['fullname'] = $fullname;
			echo '\n' . $customer['phone'] = $phone;
			echo '\n' . $customer['address'] = $address;
			echo '\n' . $customer['city'] = $city;
			echo '\n' . $customer['province'] = $province;
			echo '\n' . $customer['postcode'] = $postcode;
			echo '\n' . $customer['transaction'] = $transaction;
			//die();
		}

		$server->addFunction("add_customer");
		$server->handle();
//	}
//}
