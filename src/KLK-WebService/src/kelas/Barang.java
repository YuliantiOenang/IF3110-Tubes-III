package kelas;


public class Barang {
	private int id_inven, id_cat, jumlah, harga;
	private String gambar, desc, nama;
	
	public int getId_inven() {
		return id_inven;
	}

	public void setId_inven(int id_inven) {
		this.id_inven = id_inven;
	}

	public int getId_cat() {
		return id_cat;
	}

	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public String getGambar() {
		return new StringBuilder().append("barang/").append(id_inven).append(".jpg").toString();
	}

	public void setGambar(String gambar) {
		this.gambar = gambar;
	}
	
	public String getFieldGambar(){
		return gambar;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Barang(String nm){
		nama = nm;
	}
	
	public String getNama(){
		return nama;
	}
}
