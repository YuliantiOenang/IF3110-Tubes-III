package com.frexesc.controller;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBarangUser {
	public void insertBarangUser(String id, String user, String qty, String desc) throws SQLException{
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();
		
		String query2 = "INSERT INTO barang_user (id_barang,id_user,status,jumlah_barang,deskripsi_tambahan) VALUES ("
				+ id
				+ ", "
				+ user
				+ ", 0, "
				+ qty
				+ ", \""
				+ desc + "\")";
		
		connection.createStatement().executeUpdate(query2);
	}
}
