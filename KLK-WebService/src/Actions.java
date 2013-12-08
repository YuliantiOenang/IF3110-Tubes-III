

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.postgresql.Driver;

import kelas.Barang;

/**
 * Servlet implementation class listBarang
 */
@WebServlet("/Actions")
public class Actions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("getpage.jsp").forward(request, response);
	}
	
	public String getContent(HttpServletRequest req) throws IOException{
		
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = req.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	    } finally {
	        reader.close();
	    }
		
		return sb.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    JSONObject JSONresp = new JSONObject();
	    JSONObject data = (JSONObject) JSONValue.parse(getContent(request));
	    
	    System.out.println("Data yang didapat: " + data.toString());
	    
	    Driver asdf = new Driver();
        Connection koneksion;
		try {
			koneksion = asdf.connect("jdbc:postgresql://ec2-107-22-234-129.compute-1.amazonaws.com:5432/dd5q059l0v49cm?user=igsiblnhyllajh&password=aFEyJCyJ4bES-kRZV_bKZrCI6f&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", null);
        
		    if(data.get("action").equals("list")){
		    	System.out.println("Add list action here!!!");
		    	try {	    		
		            String query = "SELECT * FROM inventori JOIN kategori ON inventori.id_kategori = kategori.id_kategori AND kategori.nama_kategori = '" + data.get("category") + "'";
		            
		            String sortingMode = (String) data.get("sort_mode");
		            String sortingType = (String) data.get("sort_type");
		            
		            if(sortingMode != null && sortingType != null){
						query += " ORDER BY " + sortingMode + " " + sortingType;
					}
		            
		            System.out.println("Query: " + query);
		            PreparedStatement asd = koneksion.prepareStatement(query);
		            ResultSet f = asd.executeQuery();
		            JSONArray array = new JSONArray();
		            while(f.next()){
		            	JSONObject tmp = new JSONObject();
		            	tmp.put("id_inventori", new Integer(f.getInt("id_inventori")));
		            	tmp.put("id_kategori", new Integer(f.getInt("id_kategori")));
		            	tmp.put("nama_inventori", f.getString("nama_inventori"));
		            	tmp.put("jumlah", f.getInt("jumlah"));
		            	tmp.put("gambar", f.getString("gambar"));
		            	tmp.put("description", f.getString("description"));
		            	tmp.put("harga", f.getInt("harga"));
		            	tmp.put("total_transaksi", f.getInt("total_transaksi"));
		            	array.add(tmp);
		            }
		            
		            JSONresp.put("data", array);
		            System.out.println("Data in servlet: " + JSONresp.toString());
		        } catch (SQLException ex) {
		            //Logger.getLogger(JavaApplication3.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    	
		    } else if(data.get("action").equals("favourite")){
		    	System.out.println("Add favourite action here!!!");
		    	try {	           	
		            JSONArray arrayBarangs = new JSONArray();
		            for(int i=0;i<5;i++){
		            	String query = "SELECT * FROM inventori, kategori WHERE inventori.id_kategori = kategori.id_kategori AND inventori.id_kategori = " + (i+1) + " ORDER BY inventori.total_transaksi DESC LIMIT 3";
		            	String kategori = null;
		            	PreparedStatement asd = koneksion.prepareStatement(query);
			            ResultSet f = asd.executeQuery();
			            JSONObject barangs = new JSONObject();
			            JSONArray arrayBarang = new JSONArray();
			            while(f.next()){
			            	if(kategori == null){
			            		kategori = f.getString("nama_kategori");
			            	}
							JSONObject brg = new JSONObject();
							brg.put("nama_inventori", f.getString("nama_inventori"));
							brg.put("id_kategori", f.getInt("id_kategori"));
							brg.put("id_inventori", f.getInt("id_inventori"));
							brg.put("description", f.getString("description"));
							brg.put("harga", f.getInt("harga"));
							brg.put("gambar", f.getString("gambar"));
							brg.put("jumlah", f.getInt("jumlah"));
							arrayBarang.add(brg);
			            }
			            barangs.put("kategori", kategori);
			            barangs.put("data", arrayBarang);
			            arrayBarangs.add(barangs);
		            }
		            	            
		            JSONresp.put("data", arrayBarangs);
		            System.out.println("Data in servlet: " + JSONresp.toString());
		        } catch (SQLException ex) {
		            //Logger.getLogger(JavaApplication3.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    } else if(data.get("action").equals("view_cart")){
		    	System.out.println("Add view_cart action here!!!");
		    	JSONArray points = (JSONArray) data.get("data");
		    	int total = 0;
		    	if(points != null){
			    	try {		            
			            JSONArray array = new JSONArray();
			            for(Object o: points){
			            	JSONObject tmp = (JSONObject) o;
			            	String query = "SELECT * FROM inventori JOIN kategori ON inventori.id_kategori = kategori.id_kategori AND inventori.id_inventori = '" + ((Long) tmp.get("x")).intValue() + "'";
			            	
			            	PreparedStatement asd = koneksion.prepareStatement(query);
				            ResultSet f = asd.executeQuery();
				            
				            JSONObject tmp2 = new JSONObject();
				            while(f.next()){
				            	tmp2.put("nama_inventori", f.getString("nama_inventori"));
				            	tmp2.put("id_kategori", f.getInt("id_kategori"));
				            	tmp2.put("id_inventori", f.getInt("id_inventori"));
				            	tmp2.put("description", f.getString("description"));
				            	tmp2.put("harga", f.getInt("harga"));
				            	tmp2.put("gambar", f.getString("gambar"));
				            	tmp2.put("jumlah", ((Long) tmp.get("y")).intValue());
		   						total += f.getInt("harga") * ((Long) tmp.get("y")).intValue();
				            }
				            array.add(tmp2);
			            }
			            
			            JSONresp.put("data", array);
			             	
		            } catch(Exception e){
		            	e.printStackTrace();
		            }
		    	}
		    	JSONresp.put("total", (Integer) total);   
		    } else if(data.get("action").equals("detail")){
		    	try{
		            int barangId = ((Long) data.get("gid")).intValue();
			    	String query = "SELECT * FROM inventori NATURAL JOIN kategori WHERE id_inventori = " + barangId;
		        	PreparedStatement asd = koneksion.prepareStatement(query);
		            ResultSet f = asd.executeQuery();
		            
		            JSONObject tmp2 = new JSONObject();
		            while(f.next()){
		            	tmp2.put("nama_inventori", f.getString("nama_inventori"));
		            	tmp2.put("id_kategori", f.getInt("id_kategori"));
		            	tmp2.put("id_inventori", f.getInt("id_inventori"));
		            	tmp2.put("description", f.getString("description"));
		            	tmp2.put("harga", f.getInt("harga"));
		            	tmp2.put("gambar", f.getString("gambar"));
		            	tmp2.put("jumlah", f.getInt("jumlah"));
		            }
		            
		            JSONresp.put("data", tmp2);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    } else if(data.get("action").equals("get_jumlah")){
		    	try{
		            int id = ((Long) data.get("id")).intValue();
		            String query = "SELECT * FROM inventori WHERE id_inventori = " + id;
		        	PreparedStatement asd = koneksion.prepareStatement(query);
		            ResultSet f = asd.executeQuery();
		            
		            int result = 0;
		            while(f.next()){
		            	result = f.getInt("jumlah");
		            }
		            
		            JSONresp.put("jumlah", result);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    } else if(data.get("action").equals("decrease_inventori")){ 
		    	try{
		            int id = ((Long) data.get("id")).intValue();
		            int jumlah = ((Long) data.get("jumlah")).intValue();
		            String query = "UPDATE inventori SET jumlah=jumlah - " + jumlah + " WHERE id_inventori=" + id;
		        	Statement asd = koneksion.createStatement();
		            asd.executeUpdate(query);
		            
		            JSONresp.put("status", "Success!");
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    } else if(data.get("action").equals("increase_transaction_user")){ 
		    	try{
		            String id_user = (String) data.get("id_user");
		            int jumlah = ((Long) data.get("jumlah")).intValue();
		            String query = "UPDATE userr SET transaction = transaction + " + jumlah +  " WHERE id='" + id_user +"'";
		        	Statement asd = koneksion.createStatement();
		            asd.executeUpdate(query);
		            
		            JSONresp.put("status", "Success!");
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    } else if(data.get("action").equals("increase_transaction_inv")){
		    	try{		    	
		            int id = ((Long) data.get("id")).intValue();
		            int jumlah = ((Long) data.get("jumlah")).intValue();
		            String query = "UPDATE inventori SET total_transaksi=total_transaksi + " + jumlah + " WHERE id_inventori=" + id;
		        	Statement asd = koneksion.createStatement();
		            asd.executeUpdate(query);
		            
		            JSONresp.put("status", "Success!");
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    } else if(data.get("action").equals("jumlah_transaksi_user")){
		    	try{
		            String id_user = (String) data.get("id_user");
		            String query = "SELECT * FROM userr WHERE id = '" + id_user + "'";
		        	PreparedStatement asd = koneksion.prepareStatement(query);
		            ResultSet f = asd.executeQuery();
		            
		            int result = 0;
		            while(f.next()){
		            	result = f.getInt("transaction");
		            }
		            
		            JSONresp.put("jumlah", result);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    } else if(data.get("action").equals("search")){
		    	try{
		    		System.out.println("Searching...");
		    		String query_name = (String) data.get("query_name");
		    		String query_category = (String) data.get("query_category");
		    		String query_price = (String) data.get("query_price");
		    		
		            String query = "SELECT * FROM inventori, kategori WHERE inventori.id_kategori = kategori.id_kategori";
		        	
		            if(!query_name.equals("")){
						query += " AND inventori.nama_inventori LIKE '%" + query_name + "%'";
					}
					
					if(!query_category.equals("")){
						query += " AND kategori.nama_kategori LIKE '%" + query_category + "%'";
					}
					
					if(!query_price.equals("")){
						query += " AND inventori.harga = " + query_price;
					}
					
					System.out.println("Query: " + query);
					
					PreparedStatement asd = koneksion.prepareStatement(query);
		            ResultSet f = asd.executeQuery();
					JSONArray array = new JSONArray();
					while(f.next()){
						JSONObject tmp = new JSONObject();
						tmp.put("nama_inventori", f.getString("nama_inventori"));
						tmp.put("id_kategori", new Integer(f.getInt("id_kategori")));
						tmp.put("id_inventori", new Integer(f.getInt("id_inventori")));
						tmp.put("description", (String) f.getString("description"));
						tmp.put("harga", new Integer(f.getInt("harga")));
						tmp.put("gambar", (String) f.getString("gambar"));
						tmp.put("jumlah", new Integer(f.getInt("jumlah")));
							
						array.add(tmp);
					}
					
					//request.setAttribute("barangs", barangs);		            
		            JSONresp.put("data", array);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    } else if(data.get("action").equals("edit_barang")){
		    	Barang barang = (Barang) data.get("barang");
		    	int id = ((Long) data.get("id")).intValue();
		    	StringBuilder query = new StringBuilder();
		    	
		    	System.out.println("Nama barang baru: " + barang.getNama());
		    	
		    	query.append("UPDATE inventori SET ");
				query.append("id_kategori = ").append(barang.getId_cat()).append(",");
				query.append("nama_inventori = '").append(barang.getNama()).append("',");
				query.append("jumlah = ").append(barang.getJumlah()).append(",");
				query.append("description = '").append(barang.getDesc()).append("',");
				query.append("harga = ").append(barang.getHarga());
				query.append(" WHERE id_inventori = ").append(id);
				
				//String query = "UPDATE inventori SET total_transaksi=total_transaksi + " + jumlah + " WHERE id_inventori=" + id;
	        	Statement asd = koneksion.createStatement();
	            asd.executeUpdate(query.toString());
		    }
		    koneksion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.getWriter().write(JSONresp.toString());
		
		/*
		String query = "SELECT * FROM inventori JOIN kategori ON inventori.id_kategori = kategori.id_kategori AND kategori.nama_kategori = \"" + barangCat + "\"";
		
		System.out.println("Query: " + query);
		
		ResultSet rs = state.executeQuery(query);
		
		while(rs.next()){
			String name = rs.getString("nama_inventori");
			Barang brg = new Barang(name);
			brg.setId_cat(rs.getInt("id_kategori"));
			brg.setId_inven(rs.getInt("id_inventori"));
			brg.setDesc(rs.getString("description"));
			brg.setHarga(rs.getInt("harga"));
			brg.setGambar(rs.getString("gambar"));
			brg.setJumlah(rs.getInt("jumlah"));
			barangs.add(brg);
			//request.setAttribute("name", name);
		}
		
		ArrayList<Barang> barangs = new ArrayList<Barang>();
		String barangCat = null;
		String sortingMode = null; //harga/nama_inventori?
		String sortingType = null; //DESC/ASC?
		
		
		try{
			barangCat = request.getParameter("cat");
			sortingMode = request.getParameter("mode");
			sortingType = request.getParameter("type");
		} catch(Exception e){
			e.printStackTrace();
		}
		*/
	}

}
