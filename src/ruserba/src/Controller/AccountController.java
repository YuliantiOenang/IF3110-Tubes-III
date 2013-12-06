package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import javaModel.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("application/json");
        PrintWriter out = response.getWriter();
	    String action = request.getParameter("action");
	    try {
    	    if (action.equals("read")) {
    	        Integer id = Integer.parseInt(request.getParameter("id"));
    	        Account user = Account.findByPk(id);
    	        if (user != null) {
    	            JSONObject json = new JSONObject();
    	            json.put("status", "true");
    	            json.put("data", user.toJSON());
    	            out.println(json.toString());
    	        } else {
    	            out.println("{\"status\":\"false\"}");
    	        }
    	    } else if (action.equals("login")) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
        
        Account user = Account.findByPk(id);
        try {
            if (user != null) {
                //parameter atribut account
                user.username = map.get("username");
                user.password = map.get("password");
                user.nama = map.get("nama");
                user.email = map.get("email");
                user.alamat = map.get("alamat");
                user.provinsi = map.get("provinsi");
                user.kota = map.get("kota");
                user.kodepos = map.get("kodepos");
                user.telepon = map.get("telepon");
                user.role = Integer.parseInt(map.get("role"));
                user.transaksi = Integer.parseInt(map.get("telepon"));
                user.save();
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
}
