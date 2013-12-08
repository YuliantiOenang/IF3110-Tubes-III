package com.frexescwebservice.soap;

import com.frexescwebservice.model.BarangBean;

public class BarangSoap {
	public void addBarang(long id_category, String name, String picture,
			int price, String description, int total_item) {
		BarangBean barang = new BarangBean();
		barang.setId_category(id_category);
		barang.setName(name);
		barang.setPicture(picture);
		barang.setPrice(price);
		barang.setDescription(description);
		barang.setTotal_item(total_item);
		barang.save();
	}
}
