package apiController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/api/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();

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
				String query = "select * from account where username = '"
						+ username + "' and password = '" + password + "'";
				DBA.executeQuery(query);
				System.out.println(query);
				ResultSet RS = DBA.getQueryResult();
				
				try {
					if (!RS.isBeforeFirst()) {
						JSONObject json = new JSONObject();
						json.put("success", false);
						out.write(json.toString());
					} else {			
						RS.next();			
						HttpSession session = request.getSession();
						session.setAttribute("isLogin", true);
						session.setAttribute("username", username);
						session.setAttribute("role",Integer.parseInt(RS.getObject(12).toString()));
						session.setMaxInactiveInterval(0);
						
						Cookie C = new Cookie("isLogin",username);
						C.setMaxAge(60*60*24*30); //30 Hari
						C.setPath("/");
						response.addCookie(C);
						
						JSONObject json = new JSONObject();
						json.put("success", true);
						out.write(json.toString());
					}
				} catch (SQLException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				JSONObject json = new JSONObject();
				try {
					json.put("success", false);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.write(json.toString());
			}
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("success", false);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			out.write(json.toString());
		}
		out.close();
	}

}
