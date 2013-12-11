package com.frexesc.model;

public class BarangBean {
	private int id;
	private int id_kategori;
	private String nama_barang;
	private String gambar;
	private int harga_barang;
	private String keterangan;
	private int jumlah_barang;

	public BarangBean(int id, int id_kategori, String nama_barang, String gambar, int harga_barang, String keterangan, int jumlah_barang) {
		super();
		this.id = id;
		this.id_kategori = id_kategori;
		this.nama_barang = nama_barang;
		this.gambar = gambar;
		this.harga_barang = harga_barang;
		this.keterangan = keterangan;
		this.jumlah_barang = jumlah_barang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_kategori() {
		return id_kategori;
	}

	public void setId_kategori(int id_kategori) {
		this.id_kategori = id_kategori;
	}

	public String getNama_barang() {
		return nama_barang;
	}

	public void setNama_barang(String nama_barang) {
		this.nama_barang = nama_barang;
	}

	public String getGambar() {
		return gambar;
	}

	public void setGambar(String gambar) {
		this.gambar = gambar;
	}

	public int getHarga_barang() {
		return harga_barang;
	}

	public void setHarga_barang(int harga_barang) {
		this.harga_barang = harga_barang;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public int getJumlah_barang() {
		return jumlah_barang;
	}

	public void setJumlah_barang(int jumlah_barang) {
		this.jumlah_barang = jumlah_barang;
	}

}
