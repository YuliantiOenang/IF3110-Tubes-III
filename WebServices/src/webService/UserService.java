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
import dto.User;

@Path("/userservice")
public class UserService
{	
	@GET
	@Path("/user/{paramID}")
	@Produces("application/json")
	public String userById(@PathParam("paramID") int paramID)
	{
		String user = null;
		ArrayList<User> userList = new ArrayList<User>();
		try
		{
			userList = new AccessManager().getUsersById(paramID);
			Gson gson = new Gson();
			user = gson.toJson(userList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return user;
	}
	
	@GET
	@Path("/userlimit1/{paramID}")
	@Produces("application/json")
	public String userByIdlimit1(@PathParam("paramID") int paramID)
	{
		String user = null;
		ArrayList<User> userList = new ArrayList<User>();
		try
		{
			userList = new AccessManager().getUsersByIdlimit1(paramID);
			Gson gson = new Gson();
			user = gson.toJson(userList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return user;
	}
	
	@GET
	@Path("/username/{paramName}/{paramPass}")
	@Produces("application/json")
	public String userByNamePass(@PathParam("paramName") String paramName,@PathParam("paramPass") String paramPass)
	{
		String user = null;
		ArrayList<User> userList = new ArrayList<User>();
		try
		{
			userList = new AccessManager().getUsersByNamePass(paramName,paramPass);
			Gson gson = new Gson();
			user = gson.toJson(userList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return user;
	}
	
	@GET
	@Path("/nomorkartu/{noKartu}")
	@Produces("application/json")
	public String userByNoKartu(@PathParam("noKartu") String noKartu)
	{
		String user = null;
		ArrayList<User> userList = new ArrayList<User>();
		try
		{
			userList = new AccessManager().getUserByNoKartu(noKartu);
			Gson gson = new Gson();
			user = gson.toJson(userList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return user;
	}
	
	
	@GET
	@Path("/namakartu/{namaKartu}")
	@Produces("application/json")
	public String userByNamaKartu(@PathParam("namaKartu") String namaKartu)
	{
		String user = null;
		ArrayList<User> userList = new ArrayList<User>();
		try
		{
			userList = new AccessManager().getUserByNamaKartu(namaKartu);
			Gson gson = new Gson();
			user = gson.toJson(userList);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return user;
	}
	
}
