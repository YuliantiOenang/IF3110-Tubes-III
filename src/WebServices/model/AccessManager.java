package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Access;
import dao.Database;
import dto.Category;
import dto.Course;
import dto.User;
import dto.BarangUserBean;
import dto.UserBean;


public class AccessManager
{
	Database db = null;
	Connection con = null;
	public AccessManager() {
		// TODO Auto-generated constructor stub
		super();
		db = new Database();
		try {
			con = db.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return con;
	}
	public ArrayList<Course> getCourses() throws Exception
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		Access access = new Access();
		courseList = access.getCourses(con);
		return courseList;
	}

	public ArrayList<Category> getCategories() throws Exception {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		Access access = new Access();
		categoryList = access.getCategories(con);
		return categoryList;
	}
	
	public ArrayList<Category> getCategoriesById(int id) throws Exception {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		Access access = new Access();
		categoryList = access.getCategoriesById(con,id);
		return categoryList;
	}

	public ArrayList<User> getUsersById(int id) throws Exception{
		ArrayList<User> userList = new ArrayList<User>();
		Access access = new Access();
		userList = access.getUsersById(con,id);
		return userList;
	}

	public ArrayList<User> getUserByNoKartu(String noKartu) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		Access access = new Access();
		userList = access.getUserByNoKartu(con,noKartu);
		return userList;

	}
	
	public ArrayList<User> getUserByNamaKartu(String namaKartu) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		Access access = new Access();
		userList = access.getUserByNamaKartu(con,namaKartu);
		return userList;

	}

	public ArrayList<User> getUsersByIdlimit1(int id) throws Exception{
		ArrayList<User> userList = new ArrayList<User>();
		Access access = new Access();
		userList = access.getUsersById(con,id);
		return userList;
	}

	public ArrayList<User> getUsersByNamePass(String paramName, String paramPass) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		Access access = new Access();
		userList = access.getUserByNamePass(con,paramName,paramPass);
		return userList;
	}
	
	//BARANG_USER
	public void insertBarangUser(String id_barang, String user_id, String qty, String desc) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.insertBarangUser(con, id_barang, user_id, qty, desc);
	}
	
	public ArrayList<BarangUserBean> getBarangUserById(String id) throws Exception
	{
		ArrayList<BarangUserBean> user = new ArrayList<BarangUserBean>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		user = access.getBarangUserById(con, id);
		return user;
	}
	
	public ArrayList<BarangUserBean> getStatusZero(String id) throws Exception
	{
		ArrayList<BarangUserBean> user = new ArrayList<BarangUserBean>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		user = access.getStatusZero(con, id);
		return user;
	}
	
	public void deleteBarangUser(String id) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.deleteBarangUser(con, id);
	}
	
	public void updateStatusBarangUser(String id) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.updateStatusBarangUser(con, id);
	}
	
	public void updateJumlahBarangUser(String qty, String id) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.updateJumlahBarangUser(con, qty, id);
	}
	
	//USER UPDATE
	public void updateCard(String name, String num, String date, String id) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.updateCard(con, name, num, date, id);
	}
	
	public void updateTransaction(String num, String id) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.updateTransaction(con, num, id);
	}
	
	public void updateUser(String  name ,String password ,String email ,String  telephone ,String address ,String city ,String province ,String postal ,String id) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.updateUser(con, name, password, email, telephone, address, city, province, postal, id);
	}
	
	public void insertUser(String  name , String username, String password ,String email ,String  telephone ,String address ,String city ,String province ,String postal) throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		access.insertUser(con, name, username, password, email, telephone, address, city, province, postal);
	}
	public ArrayList<UserBean> getUsersById2(int id) throws Exception{
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		Access access = new Access();
		userList = access.getUsersById2(con,id);
		return userList;
	}
}
