package npackage;
import java.util.ArrayList;

public class Barang{
	private int id;
	private String nama;
	private int harga;
	private String kategori;
	private int jumlah;
	private String deskripsi;
	
	
	public Barang(){
		id=-1;
		nama="";
		harga=-1;
		kategori="";
		jumlah=-1;
		deskripsi="";
	}
	
	public Barang(int id_,String nama_, int harga_,String kategori_,int jumlah_){
		id=id_;
		nama=nama_;
		harga=harga_;
		kategori=kategori_;
		jumlah=jumlah_;
		deskripsi="";
	}
	
	public int getId(){
		return id;
	}
	
	public String getNama(){
		return nama;
	}
	
	public int getHarga(){
		return harga;
	}
	
	public String getKategori(){
		return kategori;
	}
	
	public String getDeskripsi(){
		return deskripsi;
	}
	
	public int getJumlah(){
		return jumlah;
	}

	public void setId(int id_){
		id=id_;
	}
	public void setNama(String nama_){
		nama=nama_;
	}
	public void setHarga(int harga_){
		harga=harga_;
	}
	
	public void setDeskripsi(String deskripsi_){
		deskripsi=deskripsi_;
	}
	public void setKategori(String kategori_){
		kategori=kategori_;
	}
	public void setJumlah(int jumlah_){
		jumlah=jumlah_;
	}
	
}