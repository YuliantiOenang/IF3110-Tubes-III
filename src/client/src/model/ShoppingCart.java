package model;

import java.awt.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.sun.org.apache.xml.internal.security.keys.content.KeyValue;

public class ShoppingCart {
	private HashMap<Integer, Integer> jumlahBarang;
	private HashMap<Integer,String> keterangan;
	private HashMap<Integer,String> kategori;
	
	public ShoppingCart()
	{
		jumlahBarang = new HashMap<Integer,Integer>();
		keterangan = new HashMap<Integer,String>();
		kategori = new HashMap<Integer,String>();
	}
	
	public void addData(int id_barang, int jumlah, String ktrg)
	{
		if (jumlahBarang.containsKey(id_barang))
			deleteData(id_barang);
		jumlahBarang.put(id_barang, jumlah);
		keterangan.put(id_barang,ktrg);
		Kategori kat = new Kategori();
		Barang barang = new Barang();
		barang.findById(id_barang);
		kat.findById(Integer.parseInt(barang.getDataVector().firstElement().get("id_kategori")));
		kategori.put(id_barang, kat.getDataVector().firstElement().get("nama_kategori"));
	}
	
	public Vector<Integer> getKeySet()
	{	
		Set<Integer> key = jumlahBarang.keySet();
		Vector<Integer> data = new Vector<Integer>();
		for (Integer d : key)
			data.add(d);
		return data;
	}
	
	public Integer getJumlah(Integer key)
	{	
		return jumlahBarang.get(key);
	}
	
	public String getKeterangan(Integer key)
	{	
		return keterangan.get(key);
	}
	
	public String getKategori(Integer key)
	{	
		return kategori.get(key);
	}
	
	public String getNamaBarang(Integer key)
	{	
		Barang barang = new Barang();
		return barang.findById(key).get("nama");
	}
	
	public boolean isEmpty()
	{	
		return (keterangan.size()==0);
	}
	
	public Integer getPrice(Integer key)
	{
		Barang model = new Barang();
		return Integer.parseInt(model.findById(key).get("harga"));
	}
	
	public Integer getSubTotal(Integer key)
	{
		return getPrice(key)*getJumlah(key);
	}
	
	public Integer getTotalPrice()
	{
		Integer total = 0;
		Set<Integer> key = jumlahBarang.keySet();
		for (Integer d : key)
			total = total + getSubTotal(d);
		return total;
	}
	
	public void debug()
	{
		for (Integer obj : getKeySet()) {
			System.out.print(obj + " : ");
			System.out.print(jumlahBarang.get(obj) + ", ");
			System.out.println(keterangan.get(obj) + ", ");
		}
	}
	
	public void deleteData(int id_barang)
	{
		jumlahBarang.remove(id_barang);
		keterangan.remove(id_barang);
		kategori.remove(id_barang);
	}
	
	public boolean changeQuantity(int id_barang, int quantity)
	{
		if (jumlahBarang.containsKey(id_barang)) {
			jumlahBarang.remove(id_barang);
			jumlahBarang.put(id_barang, quantity);
			return true;
		}
		return false;
	}
}
