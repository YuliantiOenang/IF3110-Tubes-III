package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
        Integer id = Integer.parseInt(req.getParameter("id"));
        
        Account user = Account.findByPk(id);
        try {
            if (user != null) {
                //parameter atribut account
                user.username = req.getParameter("username");
                user.password = req.getParameter("password");
                user.nama = req.getParameter("nama");
                user.email = req.getParameter("email");
                user.alamat = req.getParameter("alamat");
                user.provinsi = req.getParameter("provinsi");
                user.kota = req.getParameter("kota");
                user.kodepos = req.getParameter("kodepos");
                user.telepon = req.getParameter("telepon");
                user.role = Integer.parseInt(req.getParameter("role"));
                user.transaksi = Integer.parseInt(req.getParameter("telepon"));
                user.save();
                JSONObject json = new JSONObject();
                json.put("status", "true");
                json.put("data", user.toJSON());
                out.println(json.toString());
            } else {
                out.println("{\"status\":\"false\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
	    super.doPut(req, resp);
	}
	
}
