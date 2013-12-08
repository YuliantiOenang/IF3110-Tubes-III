

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
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import kelas.Database;

/**
 * Servlet implementation class addToCart
 */
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
        super();
        int ohoho;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonResponse = null;
		
		int id = Integer.parseInt(request.getParameter("id_barang"));
		int jml = Integer.parseInt(request.getParameter("jumlah"));
		
		JSONObject data = new JSONObject();
		
		data.put("action", "get_jumlah");
		data.put("id", new Integer(id));
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://heroku-postgres-8655a651.herokuapp.com/Actions");
		
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

		
		int jumlahDiDatabaseWow = 0;
		if(jsonResponse.get("jumlah") != null){
			jumlahDiDatabaseWow = ((Long) jsonResponse.get("jumlah")).intValue();
		} 
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("cart") == null){
			System.out.println("masuk ke yg kosong");
			ArrayList<Point> cart = new ArrayList<Point>();
			cart.add(new Point(id, jml));
			response.getWriter().write("Sukses!");
			session.setAttribute("cart", cart);
		} else {
			System.out.println("masuk ke yg udah ada");
			boolean found = false;
			ArrayList<Point> cart = (ArrayList<Point>) session.getAttribute("cart");
			for(Point p: cart){
				if(p.x == id){
					found = true;
					if(p.y + jml <= jumlahDiDatabaseWow){
						response.getWriter().write("Sukses!");
						p.y += jml;
					} else {
						response.getWriter().write("Jumlah barang tidak mencukupi! Tinggal tersisa " + jumlahDiDatabaseWow + " buah");
					}
					break;
				}
			}
			if(!found){
				response.getWriter().write("Sukses!");
				cart.add(new Point(id, jml));
			} 
			session.setAttribute("cart", cart);
		}		
	}
}
