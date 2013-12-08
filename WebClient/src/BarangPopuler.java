

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
 * Servlet implementation class BarangPopuler
 */
public class BarangPopuler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarangPopuler() {
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
		// TODO Auto-generated method stub
		
		JSONObject jsonResponse = null;
		
		JSONObject data = new JSONObject();
		data.put("action", "favourite");
		
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
		
		String kategori = null;
		JSONArray arrayBarangs = (JSONArray) jsonResponse.get("data");
		int i=0;
		
		System.out.println("JSON RESPONSE: " + jsonResponse);
		
		for(Object oo: arrayBarangs){
			ArrayList<Barang> barangKategori = new ArrayList<Barang>();
			JSONObject objKategori = (JSONObject) oo;
			JSONArray arrayBarang = (JSONArray) objKategori.get("data");
			for(Object o: arrayBarang){
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
				barangKategori.add(brg);
			}
			request.setAttribute("namaKategori" + i, formalify((String) objKategori.get("kategori")));
			request.setAttribute("barangKategori" + i, barangKategori);
			i++;
		}
			
				
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
