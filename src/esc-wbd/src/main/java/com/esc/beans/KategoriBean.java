package com.esc.beans;

public class KategoriBean {
	private int id;
	private String nama;

	public KategoriBean(int id, String nama) {
		this.id = id;
		this.nama = nama;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

}
