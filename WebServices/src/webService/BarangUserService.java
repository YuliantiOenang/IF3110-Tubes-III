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
	@POST
	@Path("/updatecard")
	public void updateCard(@FormParam("name") String name, @FormParam("num") String num, @FormParam("date") String date, @FormParam("id") String id)
	{
		try
		{
			new AccessManager().updateCard(name, num, date, id);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
	}
	
	@GET
	@Path("/role")
	@Produces("application/json")
	public String role(@QueryParam("id") String id)
	{
		
		String result = null;
		ArrayList<Integer> role = new ArrayList<Integer>();
		try
		{
			role = new AccessManager().getRole(Integer.parseInt(id));
			Gson gson = new Gson();
			result = gson.toJson(role);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/user")
	@Produces("application/json")
	public String user(@QueryParam("name") String name, @QueryParam("pass") String pass)
	{
		
		String result = null;
		ArrayList<UserBean> user = new ArrayList<UserBean>();
		try
		{
			user = new AccessManager().getUserByNamePass(name, pass);
			Gson gson = new Gson();
			result = gson.toJson(user);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/userid")
	@Produces("application/json")
	public String user(@QueryParam("id") String id)
	{
		
		String result = null;
		ArrayList<UserBean> user = new ArrayList<UserBean>();
		try
		{
			user = new AccessManager().getUserById(id);
			Gson gson = new Gson();
			result = gson.toJson(user);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/nocard")
	@Produces("application/json")
	public String nocard(@QueryParam("no") String no)
	{
		
		String result = null;
		ArrayList<String> card = new ArrayList<String>();
		try
		{
			card = new AccessManager().getNoCard(no);
			Gson gson = new Gson();
			result = gson.toJson(card);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/namecard")
	@Produces("application/json")
	public String namecard(@QueryParam("name") String name)
	{
		
		String result = null;
		ArrayList<String> card = new ArrayList<String>();
		try
		{
			card = new AccessManager().getNameCard(name);
			Gson gson = new Gson();
			result = gson.toJson(card);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/method")
	@Produces("application/json")
	public String method(@QueryParam("method") String method, @QueryParam("value") String value)
	{
		
		String result = null;
		ArrayList<String> card = new ArrayList<String>();
		try
		{
			card = new AccessManager().getMethod(method, value);
			Gson gson = new Gson();
			result = gson.toJson(card);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	
	
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
