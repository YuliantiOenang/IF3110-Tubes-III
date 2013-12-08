package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Category;
import dto.Course;
import dto.User;
import dto.UserBean;
import dto.BarangUserBean;

public class Access
{
	public ArrayList<Course> getCourses(Connection con) throws SQLException
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM courses");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Course courseObj = new Course();
				courseObj.setId(rs.getInt("id"));
				courseObj.setName(rs.getString("name"));
				courseObj.setDuration(rs.getString("duration"));
				courseObj.setFee(rs.getDouble("fee"));
				courseList.add(courseObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return courseList;
	}

	public ArrayList<Category> getCategories(Connection con) throws SQLException {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM kategori");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Category courseObj = new Category(rs.getInt("id"), rs.getString("nama"));
				categoryList.add(courseObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return categoryList;
	}

	public ArrayList<Category> getCategoriesById(Connection con, int id) throws SQLException {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM kategori WHERE id="+id);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Category courseObj = new Category(rs.getInt("id"), rs.getString("nama"));
				categoryList.add(courseObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return categoryList;
	}

	public ArrayList<User> getUsersById(Connection con, int id) throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE id="+id);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("nama"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getInt("role"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), rs.getInt("transaksi"));
				userList.add(user);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return userList;
	}

	public ArrayList<User> getUsersByIdlimit1(Connection con, int id) throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE id= "+id+" LIMIT 1");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("nama"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getInt("role"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), rs.getInt("transaksi"));
				userList.add(user);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return userList;
	}
	
	public ArrayList<User> getUserByNoKartu(Connection con, String noKartu) throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE nomor_kartu= '"+noKartu+"' LIMIT 1");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("nama"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getInt("role"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), rs.getInt("transaksi"));
				userList.add(user);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return userList;
	}
	
	public ArrayList<User> getUserByNamaKartu(Connection con, String namaKartu) throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE nama_kartu= '"+namaKartu+"' LIMIT 1");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("nama"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getInt("role"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), rs.getInt("transaksi"));
				userList.add(user);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return userList;
	}

	public ArrayList<User> getUserByNamePass(Connection con, String paramName,
			String paramPass) throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE username= '"+paramName+"' AND password= '"+paramPass+"' LIMIT 1");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("nama"), rs.getString("handphone"), rs.getString("alamat"), rs.getString("provinsi"), rs.getString("kota"), rs.getString("kodepos"), rs.getInt("role"), rs.getString("nomor_kartu"), rs.getString("nama_kartu"), rs.getString("expire_kartu"), rs.getInt("transaksi"));
				userList.add(user);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return userList;
	}
	
	//BARANG_USER
	public void insertBarangUser(Connection con,  String id_barang, String user_id, String qty, String desc) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("INSERT INTO barang_user (id_barang,id_user,status,jumlah_barang,deskripsi_tambahan) VALUES ("
				+ id_barang
				+ ", "
				+ user_id
				+ ", 0, "
				+ qty
				+ ", \""
				+ desc + "\")");
		stmt.execute();
	}
	
	public ArrayList<BarangUserBean> getBarangUserById(Connection con, String id) throws SQLException
	{
		ArrayList<BarangUserBean> users = new ArrayList<BarangUserBean>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM barang_user WHERE id=" + id);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				BarangUserBean courseObj = new BarangUserBean(rs.getLong("id"), rs.getLong("id_barang"), rs.getLong("id_user"), rs.getInt("status"), rs.getInt("jumlah_barang"), rs.getString("deskripsi_tambahan"));
				users.add(courseObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return users;
		
	}
	
	public ArrayList<BarangUserBean> getStatusZero(Connection con, String id) throws SQLException
	{
		ArrayList<BarangUserBean> users = new ArrayList<BarangUserBean>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM barang_user WHERE id_user=" + id + " AND status=0");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				BarangUserBean courseObj = new BarangUserBean(rs.getLong("id"), rs.getLong("id_barang"), rs.getLong("id_user"), rs.getInt("status"), rs.getInt("jumlah_barang"), rs.getString("deskripsi_tambahan"));
				users.add(courseObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return users;
		
	}
	
	public void deleteBarangUser(Connection con,  String id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("DELETE FROM barang_user WHERE id=" + id);
		stmt.execute();
	}
	
	public void updateStatusBarangUser(Connection con,  String id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("UPDATE barang_user SET status=1 WHERE id_user=" + id);
		stmt.execute();
	}
	
	public void updateJumlahBarangUser(Connection con,  String qty, String id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("UPDATE barang_user SET jumlah_barang=" + Integer.parseInt(qty) + " WHERE id=" + id);
		stmt.execute();
	}
	
	//USER UPDATE
	public void updateCard(Connection con, String name, String num, String date, String id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("UPDATE user SET nama_kartu='" + name + "', nomor_kartu='" + num + "', expire_kartu='" + date + "' WHERE id='" + id + "'");
		stmt.execute();
	}
	
	public void updateTransaction(Connection con, String num, String id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("UPDATE user SET transaksi="+ Integer.parseInt(num) + " WHERE id=" + id);
		stmt.execute();
	}
	
	public void updateUser(Connection con,String  name ,String password ,String email ,String  telephone ,String address ,String city ,String province ,String postal ,String id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("UPDATE user SET nama='" + name + "', password='" + password + "', email='" + email + "', handphone='" + telephone + "', alamat='" + address + "', kota='" + city + "', provinsi='" + province + "', kodepos='" + postal + "' WHERE id='" + id + "'");
		stmt.execute();
	}
	
	public void insertUser(Connection con,String  name , String username, String password ,String email ,String  telephone ,String address ,String city ,String province ,String postal) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("INSERT INTO user (nama, username, password, email, handphone, alamat, kota, provinsi, kodepos) VALUES ('" + name + "','" + username + "','" + password + "','" + email + "','" + telephone + "','" + address + "','" + city + "','" + province + "','" + postal + "')");
		stmt.execute();
	}
	
	
}
