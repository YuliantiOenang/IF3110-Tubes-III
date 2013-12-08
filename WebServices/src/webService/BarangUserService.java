package webService;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dto.BarangUserBean;
import dto.UserBean;
import com.google.gson.Gson;
import model.AccessManager;

@Path("/baranguserService")
public class BarangUserService
{
	//BARANG_USER
	@POST
	@Path("/insertbaranguser")
	public void insertbaranguser(@FormParam("id") String id,  @FormParam("user") String user, @FormParam("qty") String qty , @FormParam("desc") String desc)
	{
		try
		{
			new AccessManager().insertBarangUser(id, user, qty, desc);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
	}
	
	@GET
	@Path("/baranguserid")
	@Produces("application/json")
	public String baranguser(@QueryParam("id") String id)
	{
		String result = null;
		ArrayList<BarangUserBean> user = new ArrayList<BarangUserBean>();
		try
		{
			user = new AccessManager().getBarangUserById(id);
			Gson gson = new Gson();
			result = gson.toJson(user);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/statuszero")
	@Produces("application/json")
	public String statuszero(@QueryParam("id") String id)
	{
		String result = null;
		ArrayList<BarangUserBean> user = new ArrayList<BarangUserBean>();
		try
		{
			user = new AccessManager().getStatusZero(id);
			Gson gson = new Gson();
			result = gson.toJson(user);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	@POST
	@Path("/deletebaranguser")
	public void deletebaranguser( @FormParam("id") String id)
	{
		try
		{
			new AccessManager().deleteBarangUser(id);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
	}
	
	@POST
	@Path("/statusbaranguser")
	public void statusbaranguser(@FormParam("id") String id)
	{
		try
		{
			new AccessManager().updateStatusBarangUser(id);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
	}
	
	@POST
	@Path("/jumlahbaranguser")
	public void jumlahbaranguser(@FormParam("qty") String qty , @FormParam("id") String id)
	{
		try
		{
			new AccessManager().updateJumlahBarangUser(qty, id);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
	}
	
	
	
	
}
