package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javaModel.Kategori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class KategoriController
 */
@WebServlet("/KategoriController")
public class KategoriController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KategoriController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter out = response.getWriter();
	    String action = request.getParameter("action");
	    if (action == null) action = "";
	    try {
    	    if (action.equals("read")) {
    	        Integer id = Integer.parseInt(request.getParameter("id"));
    	        Kategori kategori = Kategori.findByPk(id);
    	        if (kategori != null) {
    	            JSONObject json = new JSONObject();
    	            json.put("status", "true");
    	            json.put("data", kategori.toJSON());
    	            out.println(json.toString());
    	        } else {
    	            out.println("{\"status\":\"false\"}");
    	        }
    	    } else if (action.equals("readAll")) {
                ArrayList<Kategori> kategoris = Kategori.findAll("SELECT * FROM kategori");
                if (kategoris.size() > 0) {
                	ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();
					for (Kategori kategori : kategoris)
						jsons.add(kategori.toJSON());
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
