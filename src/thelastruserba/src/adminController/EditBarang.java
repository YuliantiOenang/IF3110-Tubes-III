package adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class EditBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();

	public EditBarang() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("id"));
		DBA.executeQuery("select * from barang where id="+request.getParameter("id"));
		ResultSet q_result = DBA.getQueryResult();
		String result = null;
		try {
			q_result.next();
			JSONObject json = new JSONObject().put("nama_barang", q_result.getString(3));
			json.put("harga_barang", q_result.getString(4));
			json.put("url_barang", q_result.getString(5));
			json.put("status", "success");
			result = json.toString();
		} catch (JSONException | SQLException e) {
			result = "{\"status\":\"Something error\"}";
			e.printStackTrace();
		}
		out.print(result);
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
	    String nama_barang = request.getParameter("nama_barang");
	    String harga_barang = request.getParameter("harga_barang");
	    
	    String Query = "UPDATE barang SET nama='"+nama_barang+"', harga='"+harga_barang+"'";
	    Query += " WHERE id="+request.getParameter("id")+";";
	    
	    System.out.println(Query);
	    
	    DBA.insertQuery(Query);
	    
	    out.print("{\"status\":\"updated\"}");
	    // response.sendRedirect("/ruserba/admin/");
	    out.close();
	}

}
