package dto;

import java.util.ArrayList;

public class Kategori {
	private int id;
	private String name;
	private ArrayList<Barang> itemList;

	public Kategori(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.itemList = new ArrayList<Barang>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Barang> getItemList() {
		return itemList;
	}

	public Barang getItemList(int x) {
		return itemList.get(x);
	}

	public void setItemList(ArrayList<Barang> itemList) {
		this.itemList = itemList;
	}

	public void setItemList(Barang itemList) {
		this.itemList.add(itemList);
	}

}
