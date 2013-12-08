

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
 * Servlet implementation class ViewCart
 */
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	JSONObject jsonResponse = null;
		
		JSONObject data = new JSONObject();
		data.put("action", "view_cart");
    	
    	HttpSession session = request.getSession(true);
		ArrayList<Point> cart = null;
		//int total = 0;
		
		if(session.getAttribute("cart") != null){
			cart = (ArrayList<Point>) session.getAttribute("cart");
			
			JSONArray array = new JSONArray();
			
			for(Point barangIndex: cart){
				JSONObject point = new JSONObject();
				point.put("x", (Integer) barangIndex.x);
				point.put("y", (Integer) barangIndex.y);
				array.add(point);
			}
			
			data.put("data", array);
		}
		
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
		
		ArrayList<Barang> barangs = new ArrayList<Barang>();
		
		JSONArray array = (JSONArray) jsonResponse.get("data");
		if(array != null){
			for(Object o: array){
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
			}
		}
		
		int total = ((Long) jsonResponse.get("total")).intValue();
		
		request.setAttribute("total", total);
		request.setAttribute("barangs", barangs);
		request.getRequestDispatcher("viewCart.jsp").forward(request, response);
    }
    
    public void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	System.out.println("Clearing...");
    	HttpSession session = request.getSession(true);
    	ArrayList<Barang> barangs = new ArrayList<Barang>();
    	    	
		if(session.getAttribute("cart") != null){
			session.removeAttribute("cart");
			session.setAttribute("cart", new ArrayList<Point>());
		}
		request.setAttribute("total", 0);
		request.setAttribute("barangs", barangs);
		request.getRequestDispatcher("viewCart.jsp").forward(request, response);
    }
    
    public void buyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	System.out.println("Buying...");
    	
    	String id_user = request.getParameter("user_id");
    	//System.out.println("ID user: " + id_user);
    	
    	HttpSession session = request.getSession(true);
		
    	JSONObject jsonResponse = null;
		
		//int id = Integer.parseInt(request.getParameter("id_barang"));
		
		ArrayList<Point> cart = null;
		int total = 0;
		ArrayList<Barang> barangs = new ArrayList<Barang>();
		if(session.getAttribute("cart") != null){
			try {
				cart = (ArrayList<Point>) session.getAttribute("cart");
				
				JSONObject data = new JSONObject();
				
				CloseableHttpClient httpclient = HttpClients.createDefault();
				
				
				for(Point barangIndex: cart){
					HttpPost httppost = new HttpPost(Database.WebServiceURL + "Actions");
					
					data.put("action", "get_jumlah");
					data.put("id", new Integer(barangIndex.x));
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
					}
					
					//Statement state = con.createStatement();
					
					System.out.println("Executing query...");
										
					int jumlah = 0;
					if(jsonResponse != null){
						jumlah = ((Long) jsonResponse.get("jumlah")).intValue();
					}
					
					if(barangIndex.y <= jumlah){
						data.clear();
						data.put("action", "decrease_inventori");
						data.put("id", new Integer(barangIndex.x));
						data.put("jumlah", new Integer(barangIndex.y));
						httppost.setEntity(new StringEntity(data.toString()));
						
						httpresp = httpclient.execute(httppost);
						try {
							HttpEntity entity = httpresp.getEntity();
						    if (entity != null) {
						    	String jsonresp = EntityUtils.toString(entity);
					            jsonResponse = (JSONObject) JSONValue.parse(jsonresp);
						    }    
						} finally {
						    httpresp.close();
						}
						//Update jumlah transaksi yang di inventori
						//state.executeUpdate("UPDATE inventori SET jumlah=jumlah - " + barangIndex.y + " WHERE id_inventori=" + barangIndex.x);
						
						data.clear();
						data.put("action", "increase_transaction_user");
						data.put("id_user", id_user);
						data.put("jumlah", new Integer(barangIndex.y));
						httppost.setEntity(new StringEntity(data.toString()));
						
						httpresp = httpclient.execute(httppost);
						try {
							HttpEntity entity = httpresp.getEntity();
						    if (entity != null) {
						    	String jsonresp = EntityUtils.toString(entity);
					            jsonResponse = (JSONObject) JSONValue.parse(jsonresp);
						    }    
						} finally {
						    httpresp.close();
						}
						//Update jumlah transaksi yang di user
						//state.executeUpdate("UPDATE user SET transaction = transaction + " + barangIndex.y +  " WHERE id='" + id_user +"'");
						
						data.clear();
						data.put("action", "increase_transaction_inv");
						data.put("id", new Integer(barangIndex.x));
						data.put("jumlah", new Integer(barangIndex.y));
						httppost.setEntity(new StringEntity(data.toString()));
						
						httpresp = httpclient.execute(httppost);
						try {
							HttpEntity entity = httpresp.getEntity();
						    if (entity != null) {
						    	String jsonresp = EntityUtils.toString(entity);
					            jsonResponse = (JSONObject) JSONValue.parse(jsonresp);
						    }    
						} finally {
						    httpresp.close();
						}
						//Update jumlah transaksi yang di inventori
						//state.executeUpdate("UPDATE inventori SET total_transaksi=total_transaksi + " + barangIndex.y + " WHERE id_inventori=" + barangIndex.x);
					}
				}
				httpclient.close();
				
				//Clear cart
				session.removeAttribute("cart");
				session.setAttribute("cart", new ArrayList<Point>());
			}
			catch(Exception e) {
				System.out.println("SQLException caught: " +e.getMessage());
			}
		}
		request.setAttribute("total", total);
		request.setAttribute("barangs", barangs);
		request.getRequestDispatcher("viewCart.jsp").forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewCart(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		System.out.println("Mode: " + mode);
		if(mode == null){
			viewCart(request, response);
		} else if(mode.equals("clear")){
			clearCart(request, response);
		} else if(mode.equals("buy")){
			buyCart(request, response);
		}
	}

}
