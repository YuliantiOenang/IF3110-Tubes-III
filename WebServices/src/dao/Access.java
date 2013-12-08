package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Category;
import dto.Course;

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
	
	
}
