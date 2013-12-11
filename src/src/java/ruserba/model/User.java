package com.ruserba.model;

public class User implements java.io.Serializable	{

	private int id_user;
	private String username;
	private String email;
	private String password; // ??!
	private String nama_lengkap;
	private String provinsi;
	private String kota;
	private String alamat;
	private String kode_pos;
	private String kontak;
	private String nomor_kartu;
	private String nama_kartu;
	private String ekspirasi_kartu;
	private boolean admin;

	public int getIdUser(){
		return this.id_user;
	}
	public void setIdUser(int id_user){
		this.id_user = id_user;
	}
	
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}

	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}

	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getNamaLengkap(){
		return this.nama_lengkap;
	}
	public void setNamaLengkap(String nama_lengkap){
		this.nama_lengkap = nama_lengkap;
	}

	public String getProvinsi(){
		return this.provinsi;
	}
	public void setProvinsi(String provinsi){
		this.provinsi = provinsi;
	}

	public String getKota(){
		return this.kota;
	}
	public void setKota(String kota){
		this.kota = kota;
	}

	public String getAlamat(){
		return this.alamat;
	}
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getKodePos(){
		return this.kode_pos;
	}
	public void setKodePos(String kode_pos){
		this.kode_pos = kode_pos;
	}

	public String getKontak(){
		return this.kontak;
	}
	public void setKontak(String kontak){
		this.kontak = kontak;
	}

	public String getNomorKartu(){
		return this.nomor_kartu;
	}
	public void setNomorKartu(String nomor_kartu){
		this.nomor_kartu = nomor_kartu;
	}

	public String getNamaKartu(){
		return this.nama_kartu;
	}
	public void setNamaKartu(String nama_kartu){
		this.nama_kartu = nama_kartu;
	}

	public String getEkspirasiKartu(){
		return this.ekspirasi_kartu;
	}
	public void setEkspirasiKartu(String ekspirasi_kartu){
		this.ekspirasi_kartu = ekspirasi_kartu;
	}

	public boolean getAdmin()	{
		return this.admin;
	}
	public void setAdmin(boolean admin){
		this.admin = admin;
	}

}
