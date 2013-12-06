package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Account;
import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	        String username = request.getParameter("username");
    	        String password = request.getParameter("password");
                Account user = Account.find("SELECT * FROM account WHERE username = '" + username + "' AND password = '" + password + "'");
                if (user != null) {
                    JSONObject json = new JSONObject();
                    json.put("status", "true");
                    json.put("data", user.toJSON());
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

}
