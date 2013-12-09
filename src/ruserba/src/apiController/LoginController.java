package apiController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javaModel.Account;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class Login
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		// response.setCharacterEncoding("UTF-8");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		// response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (!username.isEmpty() && !password.isEmpty()) {
				Account user = Account.find("SELECT * FROM account WHERE username = '" + username + "' and password = '" + password + "'");
				try {
					if (user == null) {
						JSONObject json = new JSONObject();
						json.put("success", false);
						out.write(json.toString());
					} else {
						JSONObject json = new JSONObject();
						json.put("success", true);
						out.write(json.toString());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				JSONObject json = new JSONObject();
				try {
					json.put("success", false);
					json.put("fail", true);
					json.put("failno", 1);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				out.write(json.toString());
			}
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("success", false);
				json.put("fail", true);
				json.put("failno", 2);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			out.write(json.toString());
		}
		out.close();
	}

}
