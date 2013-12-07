

import java.awt.Point;
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
import javax.servlet.http.HttpSession;

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
 * Servlet implementation class DetailBarang
 */
public class DetailBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailBarang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonResponse = null;
		
		JSONObject data = new JSONObject();
		
		int barangId = -1;
		try{
			barangId = Integer.parseInt(request.getParameter("gid"));
		} catch(Exception e){
			e.printStackTrace();
		}
		
		data.put("action", "detail");
    	data.put("gid", new Integer(barangId));
    	
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
		
		JSONObject resp = (JSONObject) jsonResponse.get("data");
		
		String name = (String) resp.get("nama_inventori");
		Barang barang = new Barang(name);
		barang.setId_cat(((Long)resp.get("id_kategori")).intValue());
		barang.setId_inven(((Long)resp.get("id_inventori")).intValue());
		barang.setDesc((String) resp.get("description"));
		barang.setHarga(((Long) resp.get("harga")).intValue());
		barang.setGambar((String) resp.get("gambar"));
		barang.setJumlah(((Long) resp.get("jumlah")).intValue());
		
		request.setAttribute("barang", barang);
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
