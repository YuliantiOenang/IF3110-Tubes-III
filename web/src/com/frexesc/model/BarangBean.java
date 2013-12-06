package com.frexesc.model;

public class BarangBean {
	private long id;
	private long id_category;
	private String name;
	private String picture;
	private int price;
	private String description;
	private int total_item;

	public BarangBean(long id, long id_category, String name, String picture,
			int price, String description, int total_item) {
		super();
		this.id = id;
		this.id_category = id_category;
		this.name = name;
		this.picture = picture;
		this.price = price;
		this.description = description;
		this.total_item = total_item;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_category() {
		return id_category;
	}

	public void setId_category(long id_category) {
		this.id_category = id_category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal_item() {
		return total_item;
	}

	public void setTotal_item(int total_item) {
		this.total_item = total_item;
	}

}
