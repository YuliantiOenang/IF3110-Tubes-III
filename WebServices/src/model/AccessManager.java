package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Access;
import dao.Database;
import dto.Category;
import dto.Course;

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
}
