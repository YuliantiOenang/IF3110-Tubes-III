<?php

Class ServerController extends BaseController {

	public function index() {
		if(!extension_loaded("soap")){
		  dl("php_soap.dll");
		}
		 
		ini_set("soap.wsdl_cache_enabled","0");
		$location = "http:" . SITEURL . "/wsdl/hello.wsdl";
		$server = new SoapServer($location);
		 
		function doHello($yourName){
		  return "Hello, ".$yourName;
		}
		 
		$server->AddFunction("doHello");
		$server->handle();
	}
}
