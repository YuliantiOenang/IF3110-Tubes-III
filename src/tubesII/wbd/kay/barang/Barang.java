package tubesII.wbd.kay.barang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Barang {
	public int id_barang, harga_barang, kategori_barang, n_beli, stok;
	public String nama_barang, gambar_barang, keterangan;

	public static Connection con = null;
	public static Statement state = null;
	public static ResultSet result = null;
	public static String user = "root";
	public static String pass = "";
	public static String url = "jdbc:mysql://localhost/progin_13511059";

	public Barang() {
		id_barang = -1;
	}

	public static void startDbCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("Cannot connect to database " + e.getMessage());
		}
	}

	public static void closeDbCon() {
		try {
			con.close();
			state.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// find 1 row data of barang based on query
	public static Barang find(String query) {
		startDbCon();
		Barang barang = null;
		try {
			state = con.createStatement();
			result = state.executeQuery(query);
			if (result.next()) {
				barang = new Barang();
				barang.id_barang = Integer.parseInt(result.getString(1));
				barang.nama_barang = result.getString(2);
				barang.gambar_barang = result.getString(3);
				barang.harga_barang = Integer.parseInt(result.getString(4));
				barang.kategori_barang = Integer.parseInt(result.getString(5));
				barang.n_beli = Integer.parseInt(result.getString(6));
				barang.keterangan = result.getString(7);
				barang.stok = Integer.parseInt(result.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDbCon();
		return barang;
	}

	// find 1 row data of barang based on primary key
	public static Barang findByPk(int id) {
		return find("SELECT * FROM barang WHERE id_barang=" + id);
	}

	// find all data of barang based on query
	public static ArrayList<Barang> findAll(String query) {
		startDbCon();
		ArrayList<Barang> barangs = new ArrayList<Barang>();
		try {
			state = con.createStatement();
			result = state.executeQuery(query);
			while (result.next()) {
				Barang barang = new Barang();
				barang.id_barang = Integer.parseInt(result.getString(1));
				barang.nama_barang = result.getString(2);
				barang.gambar_barang = result.getString(3);
				barang.harga_barang = Integer.parseInt(result.getString(4));
				barang.kategori_barang = Integer.parseInt(result.getString(5));
				barang.n_beli = Integer.parseInt(result.getString(6));
				barang.keterangan = result.getString(7);
				barang.stok = Integer.parseInt(result.getString(8));
				barangs.add(barang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDbCon();
		return barangs;
	}

	// save barang to db
	public void save() {
		startDbCon();
		try {
			state = con.createStatement();
			String query;
			if (id_barang == -1) // new
				query = "INSERT INTO barang (nama_barang, gambar_barang, harga_barang, kategori_barang, n_beli, keterangan, stok) VALUES ('" + nama_barang + "','" + gambar_barang + "','" + harga_barang + "','" + kategori_barang + "','" + n_beli + "','" + keterangan + "','" + stok + "')";
			else
				query = "UPDATE barang SET nama_barang='" + nama_barang + "', gambar_barang='" + gambar_barang + "', harga_barang=" + harga_barang + ", kategori_barang=" + kategori_barang + ", n_beli=" + n_beli + ", keterangan='" + keterangan + "', stok=" + stok + " WHERE id_barang=" + id_barang;
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDbCon();
	}

	// delete barang from db
	public void delete() {
		startDbCon();
		try {
			state = con.createStatement();
			String query = "DELETE FROM barang WHERE id_barang=" + id_barang;
			state.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDbCon();
	}
}
