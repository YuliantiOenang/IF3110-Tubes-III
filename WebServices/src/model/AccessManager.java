package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Access;
import dao.Database;
import dto.Category;
import dto.Course;
import dto.User;

public class AccessManager
{
	public ArrayList<Course> getCourses() throws Exception
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		courseList = access.getCourses(con);
		return courseList;
	}

	public ArrayList<Category> getCategories() throws Exception {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		categoryList = access.getCategories(con);
		return categoryList;
	}
	
	public ArrayList<Category> getCategoriesById(int id) throws Exception {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		categoryList = access.getCategoriesById(con,id);
		return categoryList;
	}

	public ArrayList<User> getUsersById(int id) throws Exception{
		ArrayList<User> userList = new ArrayList<User>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		userList = access.getUsersById(con,id);
		return userList;
	}

	public ArrayList<User> getUserByNoKartu(String noKartu) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		userList = access.getUserByNoKartu(con,noKartu);
		return userList;

	}
	
	public ArrayList<User> getUserByNamaKartu(String namaKartu) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		userList = access.getUserByNamaKartu(con,namaKartu);
		return userList;

	}

	public ArrayList<User> getUsersByIdlimit1(int id) throws Exception{
		ArrayList<User> userList = new ArrayList<User>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		userList = access.getUsersById(con,id);
		return userList;
	}

	public ArrayList<User> getUsersByNamePass(String paramName, String paramPass) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		userList = access.getUserByNamePass(con,paramName,paramPass);
		return userList;
	}
}
