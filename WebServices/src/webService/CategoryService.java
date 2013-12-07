package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import model.AccessManager;

import dto.Category;
import dto.Course;

@Path("/categoriService")
public class CategoryService
{
	@GET
	@Path("/categories")
	@Produces("application/json")
	public String categories()
	{
		String categories = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		try
		{
			categoryList = new AccessManager().getCategories();
			Gson gson = new Gson();
			categories = gson.toJson(categoryList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return categories;
	}
	
	
	@GET
	@Path("/categories/id")
	@Produces("application/json")
	public String categoriesById()
	{
		String categories = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		try
		{
			categoryList = new AccessManager().getCategories();
			Gson gson = new Gson();
			categories = gson.toJson(categoryList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return categories;
	}
}
