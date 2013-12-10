package com.ruserba.model;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.ArrayList;
 
public class Database {

	public static final int COMP_LT = 1;
	public static final int COMP_LTE = 2;
	public static final int COMP_GT = 3;
	public static final int COMP_GTE = 4;
	public static final int SORT_ASC = 1;
	public static final int SORT_DESC = 2;
	public static final int ORDERBY_PRODUCTNAME = 1;
	public static final int ORDERBY_PRICE = 2;
	public static final int ORDERBY_SOLDQTY = 3;	
 
	private Connection conn = null;
 
	public Database(String url, String user_name, String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
 			this.conn = DriverManager.getConnection(url, user_name, password);
 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	// Untuk custom query.
	public Connection getConnection()
	{
		return this.conn;
	}
 
	// Untuk custom query.
	// Not recommended. Sebaiknya menggunakan getConnection() + prepared statement.
	public ResultSet runQuery(String sql) throws SQLException
	{
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}

	private Product getProductDataFromResultSet(ResultSet res) throws SQLException
	{
		// Id produk tidak ditemukan.
		if (!res.next()) return null;

		// Dikuli... Semoga nggak ada typo... :p
		Product prod = new Product();
		prod.setIdBarang(res.getInt("id_barang"));
		prod.setIdKategori(res.getInt("id_kategori"));
		prod.setHarga(res.getInt("harga"));
		prod.setJumlahPembelian(res.getInt("jumlah_pembelian"));
		prod.setJumlahStok(res.getInt("jumlah_stok"));
		prod.setNamaBarang(res.getString("nama_barang"));
		prod.setSatuan(res.getString("satuan"));
		prod.setDeskripsi(res.getString("deskripsi"));
		prod.setNamaGambar(res.getString("nama_gambar"));
		prod.setNamaGambarThumb(res.getString("nama_gambar_thumb"));

		return prod;
	}

	private Product getProductDataFromArrayList(ArrayList<String> res)
	{
		// Id produk tidak ditemukan.
		if (res.get(0).equals("error_null")) return null;

		// Dikuli... Semoga nggak ada typo... :p
		Product prod = new Product();
		prod.setIdBarang(Integer.parseInt(res.get(0)));
		prod.setIdKategori(Integer.parseInt(res.get(1)));
		prod.setHarga(Integer.parseInt(res.get(3)));
		prod.setJumlahPembelian(Integer.parseInt(res.get(6)));
		prod.setJumlahStok(Integer.parseInt(res.get(7)));
		prod.setNamaBarang(res.get(2));
		prod.setSatuan(res.get(4));
		prod.setDeskripsi(res.get(5));
		prod.setNamaGambar(res.get(8));
		prod.setNamaGambarThumb(res.get(9));

		return prod;
	}

	// Mengambil seluruh data produk.
	public Product getProductData(int product_id) throws SQLException
	{
		ArrayList<String> res = null;
		try {
			res = Service.httpGet("product_info.php?product_id=" + product_id);
		} catch(Exception ex) {}

		return getProductDataFromArrayList(res);
	}

	private User getUserDataFromResultSet(ResultSet res) throws SQLException	{
		// Id produk tidak ditemukan.
		if (!res.next()) return null;

		// Dikuli... Lagi...
		User user = new User();
		user.setIdUser(res.getInt("id_user"));
		user.setUsername(res.getString("username"));
		user.setEmail(res.getString("email"));
		user.setPassword(res.getString("password"));
		user.setNamaLengkap(res.getString("nama_lengkap"));
		user.setProvinsi(res.getString("provinsi"));
		user.setKota(res.getString("kota"));
		user.setAlamat(res.getString("alamat"));
		user.setKodePos(res.getString("kode_pos"));
		user.setKontak(res.getString("kontak"));
		user.setNomorKartu(res.getString("nomor_kartu"));
		user.setNamaKartu(res.getString("nama_kartu"));
		user.setEkspirasiKartu(res.getString("ekspirasi_kartu"));

		return user;
	}

	private User getUserDataFromArrayList(ArrayList<String> res)	{

		// Id user tidak ditemukan.
		if (res.get(0).equals("error_null")) return null;

		// Dikuli... Lagi...
		User user = new User();
		user.setIdUser(Integer.parseInt(res.get(0)));
		user.setUsername(res.get(1));
		user.setEmail(res.get(2));
		user.setPassword(res.get(3));
		user.setNamaLengkap(res.get(4));
		user.setProvinsi(res.get(5));
		user.setKota(res.get(6));
		user.setAlamat(res.get(7));
		user.setKodePos(res.get(8));
		user.setKontak(res.get(9));
		user.setNomorKartu(res.get(10));
		user.setNamaKartu(res.get(11));
		user.setEkspirasiKartu(res.get(12));
		if (res.get(12).equals("t")) user.setAdmin(true); else user.setAdmin(false);

		return user;
	}


	public User getUserData(int user_id) throws SQLException
	{
		ArrayList<String> res = null;
		try {
			res = Service.httpGet("user_info.php?user_id=" + user_id);
		} catch(Exception ex) {}

		return getUserDataFromArrayList(res);
	}

	public User getUserDataFromUsername(String username) throws SQLException
	{
		PreparedStatement stat = getConnection().prepareStatement("select * from user where username=?");
		stat.setString(1, username);
		ResultSet res = stat.executeQuery();

		return getUserDataFromResultSet(res);
	}

	public Category getCategoryData(int category_id) throws SQLException
	{
		ArrayList<Category> lst = getCategory();

		int i = 0;
		while (i < lst.size())
		{
			if (lst.get(i).getIdKategori() == category_id) return lst.get(i);
			i++;
		}

		return null;
	}

	public ArrayList<Category> getCategory() throws SQLException
	{
		ArrayList<String> res = null;
		try {
			res = Service.httpGet("category_info.php");
		} catch(Exception ex) {}

		ArrayList<Category> lst = new ArrayList<Category>();
		for (int i = 0; i < res.size(); i+=2)
		{
			Category cat = new Category();
			cat.setIdKategori(Integer.parseInt(res.get(i)));
			cat.setNamaKategori(res.get(i+1));
			lst.add(cat);
		}
		return lst;
	}

	private String getComparisonString(int compare_id)
	{
		if (compare_id == COMP_LT) return "<";
		else if (compare_id == COMP_LTE) return "<=";
		else if (compare_id == COMP_GT) return ">";
		else if (compare_id == COMP_GTE) return ">=";
		else return "<";
	}

	// Diasumsikan query sudah sesuai spesifikasi.
	public ArrayList<Product> getProductSearchResult(SearchAttribute attr) throws SQLException
	{
		StringBuilder qb = new StringBuilder();

		qb.append("select * from barang ");
		
		ArrayList<String> query_where_lst = new ArrayList<String>();
		if (!attr.getNamaBarang().equals(""))
			query_where_lst.add("nama_barang like (\'%" + attr.getNamaBarang() + "%\')");
		if (attr.getIdKategori() > 0)
			query_where_lst.add("id_kategori = " + attr.getIdKategori());
		if (attr.getIdPerbandingan() > 0 && attr.getHarga() >= 0)
			query_where_lst.add("harga " + getComparisonString(attr.getIdPerbandingan()) + " " + attr.getHarga());
		
		// Buat query where.
		StringBuilder query_where_strb = new StringBuilder();
		for (int i = 0; i < query_where_lst.size(); i++)
		{
			if (i != 0) query_where_strb.append(" and ");
			query_where_strb.append(query_where_lst.get(i));
		}
		String query_where = query_where_strb.toString();

		ArrayList<String> query_end_lst = new ArrayList<String>();
		String sort_attr;
		if (attr.getIdPengurutan() == ORDERBY_PRODUCTNAME) sort_attr = "nama_barang";
		else if (attr.getIdPengurutan() == ORDERBY_PRICE) sort_attr = "harga";
		else if (attr.getIdPengurutan() == ORDERBY_SOLDQTY) sort_attr = "jumlah_pembelian";
		else sort_attr = "nama_barang";
		query_end_lst.add("order by " + sort_attr);

		String sort_method;
		if (attr.getIdMetodePengurutan() == SORT_DESC) sort_method = "desc";
		else sort_method = "asc";
		query_end_lst.add(sort_method);

		if (attr.getJumlah() < 0) attr.setJumlah(2147483647);
		query_end_lst.add("limit " + attr.getIndeks() + ", " + attr.getJumlah());

		// Buat query end.
		StringBuilder query_end_strb = new StringBuilder();
		for (int i = 0; i < query_end_lst.size(); i++)
		{
			if (i != 0) query_end_strb.append(" ");
			query_end_strb.append(query_end_lst.get(i));
		}
		String query_end = query_end_strb.toString();

		// Append query where.
		if (query_where_lst.size() > 0) qb.append("where " + query_where + " ");

		// Tambahkan akhir query.
		qb.append(query_end);

		// Ambil hasil dari query.
		String final_query = qb.toString();

		//return final_query;

		PreparedStatement stat = getConnection().prepareStatement(final_query);
		ResultSet res = stat.executeQuery();

		ArrayList<Product> prod_list = new ArrayList<Product>();

		while (true)
		{
			Product prod = getProductDataFromResultSet(res);
			if (prod == null) break;
			prod_list.add(prod);
		}

		return prod_list;
	}

}
