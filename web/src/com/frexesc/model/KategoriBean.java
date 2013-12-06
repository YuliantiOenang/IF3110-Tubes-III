package com.frexesc.model;

import java.util.ArrayList;

public class KategoriBean {
	private int id;
	private String name;
	private ArrayList<BarangBean> itemList;

	public KategoriBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.itemList = new ArrayList<BarangBean>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<BarangBean> getItemList() {
		return itemList;
	}

	public BarangBean getItemList(int x) {
		return itemList.get(x);
	}

	public void setItemList(ArrayList<BarangBean> itemList) {
		this.itemList = itemList;
	}

	public void setItemList(BarangBean itemList) {
		this.itemList.add(itemList);
	}

}
