package com.frexescwebservice.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.simple.JSONObject;

import com.frexescwebservice.controller.DbConnection;

public class BarangUserBean {
	private long id;
	private long id_item;
	private long id_user;
	private int status;
	private int total_item;
	private String description;

	public BarangUserBean() {
	}

	public BarangUserBean(long id, long id_item, long id_user, int status,
			int total_item, String description) {
		super();
		this.id = id;
		this.id_item = id_item;
		this.id_user = id_user;
		this.status = status;
		this.total_item = total_item;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_item() {
		return id_item;
	}

	public void setId_item(long id_item) {
		this.id_item = id_item;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotal_item() {
		return total_item;
	}

	public void setTotal_item(int total_item) {
		this.total_item = total_item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressWarnings("unchecked")
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("id", id);
			json.put("id_item", id_item);
			json.put("id_user", id_user);
			json.put("status", status);
			json.put("total_item", total_item);
			json.put("description", description);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	public void save() {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();

		String query = "INSERT INTO barang_user (id_barang,id_user,status,jumlah_barang,deskripsi_tambahan) VALUES ("
				+ id_item
				+ ", "
				+ id_user
				+ ", 0, "
				+ total_item
				+ ", \""
				+ description + "\")";

		try {
			connection.createStatement().executeUpdate(query);
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
