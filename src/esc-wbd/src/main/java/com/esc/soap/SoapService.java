package com.esc.soap;

import java.sql.Connection;
import java.sql.Statement;

import com.esc.util.DbConnection;

public class SoapService {
	public String createUser(int id, String username, String password, String handphone, String alamat, String provinsi, String kota, String kodepos, String email, int role, String nama, String nomor_kartu, String nama_kartu, String expire_kartu, int transaksi) {
		String insertQuery = "INSERT INTO \"user\" (nama, username, password, email, handphone, alamat, kota, provinsi, kodepos, transaksi) VALUES ('" + nama + "','" + username + "','" + password + "','" + email + "','" + handphone + "','" + alamat + "','" + kota + "','" + provinsi + "','" + kodepos + "',0)";
		try {
			Connection connection = DbConnection.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(insertQuery);
			return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ERROR";
	}

	public String createBarang(int id, int id_kategori, String nama, String gambar, int harga_barang, String keterangan, int jumlah_barang) {
		String insertQuery = "INSERT INTO barang (id_kategori, nama_barang, gambar, harga_barang, keterangan, jumlah_barang) VALUES ('" + id_kategori + "','" + nama + "','" + gambar + "','" + harga_barang + "','" + keterangan + "','" + jumlah_barang + "')";
		try {
			Connection connection = DbConnection.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(insertQuery);
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}

	public String createBarangUser(int id, int id_barang, int id_user, int status, int jumlah_barang, String tanggal_pembelian, String deskripsi_tambahan) {
		String insertQuery = "INSERT INTO barang_user (id_barang,id_user,status,jumlah_barang,deskripsi_tambahan) VALUES (" + id_barang + ", " + id_user + ", 0, " + jumlah_barang + ", \"" + deskripsi_tambahan + "\")";
		try {
			Connection connection = DbConnection.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(insertQuery);
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}
}
