<?php

Class ProductController Extends BaseController {

	public function index() {
	}

	public function category($category) {
		$json = json_encode(Product::getByCategory($this->registry, $category));
		echo $json;
	}

	public function search($keyword) {
		$json = json_encode(Product::getBySearch($this->registry, $keyword));
		echo $json;
	}

	public function id($id) {
		$json = json_encode(Product::getById($this->registry, $id));
		echo $json;
	}
}