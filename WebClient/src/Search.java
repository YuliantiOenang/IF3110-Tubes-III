

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
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Barang> barangs = new ArrayList<Barang>();
		String query_name, query_category, query_price;
		
		query_name = request.getParameter("query_name");
		query_category = request.getParameter("query_category");
		query_price = request.getParameter("query_price");
		
		JSONObject jsonResponse = null;
		
		JSONObject data = new JSONObject();
		data.put("action", "search");
		
		data.put("query_name",request.getParameter("query_name"));
		data.put("query_category", request.getParameter("query_category"));
		data.put("query_price", request.getParameter("query_price"));
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(Database.WebServiceURL + "Actions");
		
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
		
		JSONArray arrayBarang = (JSONArray) jsonResponse.get("data");
		
		if(arrayBarang != null){
			for(Object o: arrayBarang){
				JSONObject tmp = (JSONObject) o;
				
				String name = (String) tmp.get("nama_inventori");
				Barang brg = new Barang(name);
				brg.setId_cat(((Long) tmp.get("id_kategori")).intValue());
				brg.setId_inven(((Long) tmp.get("id_inventori")).intValue());
				brg.setDesc((String) tmp.get("description"));
				brg.setHarga(((Long) tmp.get("harga")).intValue());
				brg.setGambar((String) tmp.get("gambar"));
				brg.setJumlah(((Long) tmp.get("jumlah")).intValue());
				barangs.add(brg);
			}
		}
					
		request.setAttribute("barangs", barangs);	
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
