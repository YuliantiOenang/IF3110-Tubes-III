package com.ruserba.model;

public class Product implements java.io.Serializable	{

	private int id_barang;
	private int id_kategori;
	private String nama_barang;
	private int harga;
	private String satuan;
	private String deskripsi;
	private int jumlah_pembelian;
	private int jumlah_stok;
	private String nama_gambar;
	private String nama_gambar_thumb;

	public int getIdBarang(){
		return this.id_barang;
	}
	public void setIdBarang(int id_barang){
		this.id_barang = id_barang;
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

	public int getJumlahPembelian(){
		return this.jumlah_pembelian;
	}
	public void setJumlahPembelian(int jumlah_pembelian){
		this.jumlah_pembelian = jumlah_pembelian;
	}

	public int getJumlahStok(){
		return this.jumlah_stok;
	}
	public void setJumlahStok(int jumlah_stok){
		this.jumlah_stok = jumlah_stok;
	}

	public String getNamaBarang(){
		return this.nama_barang;
	}
	public void setNamaBarang(String nama_barang){
		this.nama_barang = nama_barang;
	}

	public String getSatuan(){
		return this.satuan;
	}
	public void setSatuan(String satuan){
		this.satuan = satuan;
	}
	
	public String getDeskripsi(){
		return this.deskripsi;
	}
	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getNamaGambar(){
		return this.nama_gambar;
	}
	public void setNamaGambar(String nama_gambar){
		this.nama_gambar = nama_gambar;
	}
	
	public String getNamaGambarThumb(){
		return this.nama_gambar_thumb;
	}
	public void setNamaGambarThumb(String nama_gambar_thumb){
		this.nama_gambar_thumb = nama_gambar_thumb;
	}

}