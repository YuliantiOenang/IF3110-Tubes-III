package com.esc.beans;

import java.util.ArrayList;

public class TopfourBean {
	private int id;
	private ArrayList<Integer> ids;

	public TopfourBean(int id, ArrayList<Integer> ids) {
		super();
		this.id = id;
		this.ids = ids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getIds() {
		return ids;
	}

	public void setIds(ArrayList<Integer> ids) {
		this.ids = ids;
	}

}