package adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class CekBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();

	public CekBarang() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String result = null;
		try
		{
			JSONObject json = new JSONObject();
			DBA.executeQuery("select * from barang where nama='"+name+"'");
			if (!DBA.getQueryResult().next())
				json.put("content", "UNIK");
			else 
				json.put("content", "TIDAK UNIK"); 
			
			//System.out.println(DBA.getQueryResult().getObject(0));
			result = json.toString();
		}catch (Exception e){
			result = "{\"status\":\"" + e.getMessage() + "\", \"content\":\"TIDAK UNIK\"}";
			System.out.println("ERROR"+e.getMessage());
		}
		out.write(result);
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
