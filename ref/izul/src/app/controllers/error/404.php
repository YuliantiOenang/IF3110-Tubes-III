<?php

/**
 * Controller untuk 404 Error
 */
Class Error404Controller Extends BaseController {

	public function index() {
		header("HTTP/1.0 404 Not Found");
	    $this->registry->template->show('error/404');
	}

}