package javafiles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class BarangManager {
	static final String sqlURL = "jdbc:mysql://localhost:3306/waserda";
	
	// di server MySQLnya, buat username "java" dengan inang "localhost"
	static final String username = "java";
	static final String password = "java";
	
	public BarangManager(){
		// do nothing
	}
	
	public static void Tambah (String nama, String harga, String stok, String kategori, String img_dir){
		
		
		try {
			String query = "INSERT INTO data_barang(nama, harga, stok, kategori, img_dir) " + 
					"VALUES (?,?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(sqlURL, username, password);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nama);
			ps.setString(2, harga);
			ps.setString(3, stok);
			ps.setString(4, kategori);
			ps.setString(5, img_dir);
			System.out.println("mencoba menambah!!");
			ps.executeUpdate();
			System.out.println("data telah ditambah!!");
			//JOptionPane.showMessageDialog(new JFrame(), "Data berhasil ditambah");
			System.out.println("dialog telah keluar!!");
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (e.getMessage().contains("Duplicate entry"))
				JOptionPane.showMessageDialog(null, "Entri '" + nama + "' sudah ada");
			e.printStackTrace();
		}
	}
	
	public static void Ubah (String id, String nama, String harga, String stok, String kategori, String img_dir){
		
	
		try {
			String query = "UPDATE data_barang " + 
					"SET nama=?,harga=?,stok=?,kategori=?,img_dir=? WHERE id_barang=?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(sqlURL, username, password);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nama);
			ps.setString(2, harga);
			ps.setString(3, stok);
			ps.setString(4, kategori);
			ps.setString(5, img_dir);
			ps.setString(6, id);
			ps.executeUpdate();
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Hapus (String id){
		try {
			String query = "DELETE from data_barang " + 
					"WHERE id_barang=?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(sqlURL, username, password);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			
			/* ini harus ditempatkan di adminhapus.jsp
			Object[] options = { "Yes", "No" };
			int n = JOptionPane.showOptionDialog(new JFrame(), "Apakah Anda ingin menghapus data yang dipilih?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
			if (n == JOptionPane.YES_OPTION){
				hapus data yang dipilih!
			}
			*/
			
			ps.executeUpdate();
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List lihatEntri(String id){
		List<String> list = new ArrayList<String>();
		
		try {
			String query = "SELECT * FROM data_barang WHERE id_barang=?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(sqlURL, username, password);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			//Statement stmt = con.createStatement();
			
	        //ResultSet result = stmt.executeQuery("SELECT * FROM data_barang");
			ResultSet result = ps.executeQuery();
			
	        while(result.next())
	        {
	           list.add(result.getString("id_barang"));
	           list.add(result.getString("nama"));
	           list.add(result.getString("harga"));
	           list.add(result.getString("stok"));
               list.add(result.getString("kategori"));
               list.add((String)result.getString("img_dir"));
	        } 

	        con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List lihatDaftar(){
		List<String> list = new ArrayList<String>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(sqlURL, username, password);
			
			Statement stmt = con.createStatement();

	        ResultSet result = stmt.executeQuery("SELECT * FROM data_barang");

	        while(result.next())
	        {
	           list.add(result.getString("id_barang"));
	           list.add(result.getString("nama"));
	           list.add(result.getString("harga"));
	           list.add(result.getString("stok"));
               list.add(result.getString("kategori"));
               list.add((String)result.getString("img_dir"));
	        } 

	        con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
