package com.esc.beans;

public class UserBean {
	private int id;
	private String username;
	private String password;
	private String handphone;
	private String alamat;
	private String provinsi;
	private String kota;
	private String kodepos;
	private String email;
	private int role;
	private String nama;
	private String nomor_kartu;
	private String nama_kartu;
	private String expire_kartu;
	private int transaksi;

	public UserBean(int id, String username, String password, String handphone, String alamat, String provinsi, String kota, String kodepos, String email, int role, String nama, String nomor_kartu, String nama_kartu, String expire_kartu, int transaksi) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.handphone = handphone;
		this.alamat = alamat;
		this.provinsi = provinsi;
		this.kota = kota;
		this.kodepos = kodepos;
		this.email = email;
		this.role = role;
		this.nama = nama;
		this.nomor_kartu = nomor_kartu;
		this.nama_kartu = nama_kartu;
		this.expire_kartu = expire_kartu;
		this.transaksi = transaksi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHandphone() {
		return handphone;
	}

	public void setHandphone(String handphone) {
		this.handphone = handphone;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getKodepos() {
		return kodepos;
	}

	public void setKodepos(String kodepos) {
		this.kodepos = kodepos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNomor_kartu() {
		return nomor_kartu;
	}

	public void setNomor_kartu(String nomor_kartu) {
		this.nomor_kartu = nomor_kartu;
	}

	public String getNama_kartu() {
		return nama_kartu;
	}

	public void setNama_kartu(String nama_kartu) {
		this.nama_kartu = nama_kartu;
	}

	public String getExpire_kartu() {
		return expire_kartu;
	}

	public void setExpire_kartu(String expire_kartu) {
		this.expire_kartu = expire_kartu;
	}

	public int getTransaksi() {
		return transaksi;
	}

	public void setTransaksi(int transaksi) {
		this.transaksi = transaksi;
	}

}
