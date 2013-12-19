<?php

Class SoapController extends BaseController {

	public function index() {
		if(!extension_loaded("soap")){
		  dl("php_soap.dll");
		}
		 
		ini_set("soap.wsdl_cache_enabled","0");
		$location = "http:" . SITEURL . "/wsdl/customer.wsdl";
		$server = new SoapServer($location);
		 
		function add_customer($username, $email, $password, $fullname, $phone, $address, $city, $province, $postcode, $transaction){
			return 0;
		}

		$server->addFunction("add_customer");
		$server->handle();
	}
}
