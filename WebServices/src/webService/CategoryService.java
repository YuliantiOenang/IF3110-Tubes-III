package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import model.AccessManager;

import dto.Category;
import dto.Course;

@Path("/categoryservice")
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
	@Path("/categories/{paramID}")
	@Produces("application/json")
	public String categoriesById(@PathParam("paramID") int paramID)
	{
		String categories = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		try
		{
			categoryList = new AccessManager().getCategoriesById(paramID);
			Gson gson = new Gson();
			categories = gson.toJson(categoryList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return categories;
	}
}
