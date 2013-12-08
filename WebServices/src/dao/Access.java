package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Category;
import dto.Course;
import dto.User;

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
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE id="+id+" LIMIT 1");
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
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE nomor_kartu="+noKartu+" LIMIT 1");
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
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE nama_kartu="+namaKartu+" LIMIT 1");
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
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE username="+paramName+"and password="+paramPass+" LIMIT 1");
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
	
	
	
	
}
