<?php

Abstract Class BaseController {

	/*
	 * obyek registry
	 */
	protected $registry;

	function __construct($registry) {
		$this->registry = $registry;
	}

	/**
	 * setiap controller harus mengimplementasikan fungsi index
	 */
	abstract function index();

}
