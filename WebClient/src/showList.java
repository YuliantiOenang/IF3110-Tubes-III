
import java.awt.List;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import kelas.Barang;
import kelas.Database;

/**
 * Servlet implementation class showList
 */
public class showList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showList() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String formalify(String name){
    	return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject jsonResponse = null;
		
		JSONObject data = new JSONObject();
		data.put("action", "list");
		data.put("category", request.getParameter("cat"));
		data.put("sort_mode",  request.getParameter("mode"));
		data.put("sort_type", request.getParameter("type"));
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://localhost:8080/KLK-WebService/Actions");
		
		httppost.setEntity(new StringEntity(data.toString()));
		CloseableHttpResponse httpresp = httpclient.execute(httppost);
		try {
			HttpEntity entity = httpresp.getEntity();
		    if (entity != null) {
		    	String jsonresp = EntityUtils.toString(entity);
	            jsonResponse = (JSONObject) JSONValue.parse(jsonresp);
		    }
		} finally {
		    httpresp.close();
		    httpclient.close();
		}
		
		ArrayList<Barang> barangs = new ArrayList<Barang>();

		try {
			/*
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+db, Database.getUser(), Database.getPass());
			System.out.println (db+ "database successfully opened.");
			
			Statement state = con.createStatement();
			String query = "SELECT * FROM inventori JOIN kategori ON inventori.id_kategori = kategori.id_kategori AND kategori.nama_kategori = \"" + barangCat + "\"";
			
			if(sortingMode != null && sortingType != null){
				query += "ORDER BY " + sortingMode + " " + sortingType;
			}
			
			System.out.println("Query: " + query);
			
			ResultSet rs = state.executeQuery(query);
			
			*/
			for(Object o: (JSONArray) jsonResponse.get("data")){
				JSONObject tmp = (JSONObject) o;
				
				String name = (String) tmp.get("nama_inventori");
				Barang brg = new Barang(name);
				
				//System.out.println("Data: " + tmp.get("id_kategori") + " " + tmp.get("id_inventori"));
				brg.setId_cat(  ((Long) tmp.get("id_kategori")).intValue() );
				brg.setId_inven(  ((Long) tmp.get("id_inventori")).intValue()  );
				brg.setDesc((String) tmp.get("description"));
				brg.setHarga( ((Long) tmp.get("harga")).intValue() );
				brg.setGambar((String) tmp.get("gambar"));
				brg.setJumlah( ((Long) tmp.get("jumlah")).intValue() );
				barangs.add(brg);
				//request.setAttribute("name", name);
			}
			
			request.setAttribute("barangs", barangs);
		}
		catch(Exception e) {
			System.out.println("SQLException caught: " +e.getMessage());
		}
		
		request.setAttribute("kategori", formalify(request.getParameter("cat")));
		request.getRequestDispatcher("showList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
