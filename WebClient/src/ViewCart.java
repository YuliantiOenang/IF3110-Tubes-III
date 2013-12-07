

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
    	System.out.println("ID user: " + id_user);
    	
    	HttpSession session = request.getSession(true);
		String db = "toko_imba";
		java.sql.Connection con = null;
		ArrayList<Point> cart = null;
		int total = 0;
		ArrayList<Barang> barangs = new ArrayList<Barang>();
		if(session.getAttribute("cart") != null){
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/"+db, Database.getUser(), Database.getPass());
				
				cart = (ArrayList<Point>) session.getAttribute("cart");
				for(Point barangIndex: cart){
					Statement state = con.createStatement();
					
					System.out.println("Executing query...");
					
					ResultSet rs = state.executeQuery("SELECT * FROM inventori WHERE id_inventori = " + barangIndex.x);
					
					int jumlah = 0;
					while(rs.next()){
						jumlah = rs.getInt("jumlah");
					}
					
					if(barangIndex.y <= jumlah){
						//Update jumlah transaksi yang di inventori
						state.executeUpdate("UPDATE inventori SET jumlah=jumlah - " + barangIndex.y + " WHERE id_inventori=" + barangIndex.x);
						
						//Update jumlah transaksi yang di user
						state.executeUpdate("UPDATE user SET transaction = transaction + " + barangIndex.y +  " WHERE id='" + id_user +"'");
						
						//Update jumlah transaksi yang di inventori
						state.executeUpdate("UPDATE inventori SET total_transaksi=total_transaksi + " + barangIndex.y + " WHERE id_inventori=" + barangIndex.x);
					}
				}
				
				//Clear cart
				session.removeAttribute("cart");
				session.setAttribute("cart", new ArrayList<Point>());
			}
			catch(SQLException | ClassNotFoundException e) {
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
