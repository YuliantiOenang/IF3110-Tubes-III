package soap;

import javaModel.Barang;

public class BarangSoap {
	
	public void createBarang(Integer id_kategori, String nama, Integer harga, String gbr, Integer stock, Integer ctr, String ket){
		Barang B = new Barang();
		B.id_kategori = id_kategori;
		B.nama = nama;
		B.harga = harga;
		B.gambar = gbr;
		B.stok = stock;
		B.counter = ctr;
		B.keterangan = ket;
		B.save();
	}
}
