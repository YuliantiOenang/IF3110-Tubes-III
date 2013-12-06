package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class BarangController
 */
public class BarangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BarangController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        PrintWriter out = response.getWriter();
	    String action = request.getParameter("action");
	    try {
    	    if (action.equals("read")) {
    	        Integer id = Integer.parseInt(request.getParameter("id"));
    	        Barang barang = Barang.findByPk(id);
    	        if (barang != null) {
    	            JSONObject json = new JSONObject();
    	            json.put("status", "true");
    	            json.put("data", barang.toJSON());
    	            out.println(json.toString());
    	        } else {
    	            out.println("{\"status\":\"false\"}");
    	        }
    	    } else if (action.equals("readAll")) {
    	        String id_kategori = request.getParameter("id_kategori");
                ArrayList<Barang> barangs = Barang.findAll("SELECT * FROM barang WHERE id_kategori = '" + id_kategori + "'");
                if (barangs.size() > 0) {
                	ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();
					for (Barang barang : barangs)
						jsons.add(barang.toJSON());
					JSONObject json = new JSONObject();
					json.put("status", "true");
					json.put("data", new JSONArray(jsons));
                    out.println(json.toString());
                } else {
                    out.println("{\"status\":\"false\"}");
                }
    	    }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String input = in.readLine();
        String[] datas = input.split("&");
        HashMap<String, String> map = new HashMap<String, String>();
        for (String data : datas)
        {
        	System.out.println(data);
        	String[] tuple = data.split("=");
        	map.put(tuple[0], tuple[1]);
        }
        Integer id = Integer.parseInt(map.get("id"));
        
        Barang barang = Barang.findByPk(id);
        try {
            if (barang != null) {
                //parameter atribut account
                barang.id_kategori = Integer.parseInt(map.get("id_kategori"));
                barang.nama = map.get("nama");
                barang.harga = Integer.parseInt(map.get("harga"));
                barang.gambar = map.get("gambar");
                barang.stok = Integer.parseInt(map.get("stok"));
                barang.counter = Integer.parseInt(map.get("counter"));
                barang.keterangan = map.get("keterangan");
                barang.save();
                JSONObject json = new JSONObject();
                json.put("status", "true");
                out.println(json.toString());
            } else {
                out.println("{\"status\":\"false\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String[] tuple = in.readLine().split("=");
        int id = Integer.parseInt(tuple[1]);
        
        Barang barang = Barang.findByPk(id);
        try{
        	if (barang != null)
        	{
        		barang.delete();
        		JSONObject json = new JSONObject();
        		json.put("status","true");
        		out.println(json.toString());
        	}
        	else
        		out.println("{\"status\":\"false\"}");
        }
        catch (Exception e){
        	e.printStackTrace();
        }
        out.close();
	}
}
