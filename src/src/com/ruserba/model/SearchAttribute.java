package com.ruserba.model;

public class SearchAttribute implements java.io.Serializable	{

	private String nama_barang; // tidak ada = empty string.
	private int id_kategori; // Semua kategori dicari = 0.
	private int harga; // Tidak ada harga = (< 0).
	private int id_perbandingan; // <, <=, >, <=; 0 jika tidak ada harga.
	private int id_pengurutan; // Id product name, id harga; 1 (product name) default.
	private int id_metode_pengurutan; // Ascending, descending; 1 (ascending) default.
	private int indeks; // Indeks awal yang ditampilkan pada hasil query; 0 default.
	private int jumlah; // Jumlah record yang ditampilkan; 3 default.

	public String getNamaBarang(){
		return this.nama_barang;
	}
	public void setNamaBarang(String nama_barang){
		this.nama_barang = nama_barang;
	}

	public int getIdKategori(){
		return this.id_kategori;
	}
	public void setIdKategori(int id_kategori){
		this.id_kategori = id_kategori;
	}

	public int getHarga(){
		return this.harga;
	}
	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getIdPerbandingan(){
		return this.id_perbandingan;
	}
	public void setIdPerbandingan(int id_perbandingan){
		this.id_perbandingan = id_perbandingan;
	}

	public int getIdPengurutan(){
		return this.id_pengurutan;
	}
	public void setIdPengurutan(int id_pengurutan){
		this.id_pengurutan = id_pengurutan;
	}

	public int getIdMetodePengurutan(){
		return this.id_metode_pengurutan;
	}
	public void setIdMetodePengurutan(int id_metode_pengurutan){
		this.id_metode_pengurutan = id_metode_pengurutan;
	}

	public int getIndeks(){
		return this.indeks;
	}
	public void setIndeks(int indeks){
		this.indeks = indeks;
	}

	public int getJumlah(){
		return this.jumlah;
	}
	public void	setJumlah(int jumlah){
		this.jumlah = jumlah;
	}


}