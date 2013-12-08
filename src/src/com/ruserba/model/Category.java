package com.ruserba.model;

public class Category implements java.io.Serializable	{
	
	private int id_kategori;
	private String nama_kategori;

	public int getIdKategori(){
		return this.id_kategori;
	}
	public void setIdKategori(int id_kategori){
		this.id_kategori = id_kategori;
	}
	
	public String getNamaKategori(){
		return this.nama_kategori;
	}
	public void setNamaKategori(String nama_kategori){
		this.nama_kategori = nama_kategori;
	}

}