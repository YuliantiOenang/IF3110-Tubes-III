package com.frexesc.model;

public class BarangUserBean {
	private int id;
	private int id_barang;
	private int id_user;
	private int status;
	private int jumlah_barang;
	private String tanggal_pembelian;
	private String deskripsi_tambahan;

	public BarangUserBean(int id, int id_barang, int id_user, int status, int jumlah_barang, String tanggal_pembelian, String deskripsi_tambahan) {
		super();
		this.id = id;
		this.id_barang = id_barang;
		this.id_user = id_user;
		this.status = status;
		this.jumlah_barang = jumlah_barang;
		this.tanggal_pembelian = tanggal_pembelian;
		this.deskripsi_tambahan = deskripsi_tambahan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_barang() {
		return id_barang;
	}

	public void setId_barang(int id_barang) {
		this.id_barang = id_barang;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getJumlah_barang() {
		return jumlah_barang;
	}

	public void setJumlah_barang(int jumlah_barang) {
		this.jumlah_barang = jumlah_barang;
	}

	public String getTanggal_pembelian() {
		return tanggal_pembelian;
	}

	public void setTanggal_pembelian(String tanggal_pembelian) {
		this.tanggal_pembelian = tanggal_pembelian;
	}

	public String getDeskripsi_tambahan() {
		return deskripsi_tambahan;
	}

	public void setDeskripsi_tambahan(String deskripsi_tambahan) {
		this.deskripsi_tambahan = deskripsi_tambahan;
	}

}
