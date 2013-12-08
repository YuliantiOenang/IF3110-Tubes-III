package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.UserBean2;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     WebServicesKit webkit = new WebServicesKit();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username;
		String password;
		if (request.getAttribute("register") == null) {
			username = request.getParameter("username");
			password = request.getParameter("password");
		} else {
			username = (String)request.getAttribute("username");
			password = (String)request.getAttribute("password");
		}
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();
		
		HttpSession session = request.getSession(true);
		
		try {
			
			/**PORT*/

//			String json = webkit.readUrl("http://localhost:8080/web-services/UserService/userservice/username/"+username+"/"+password);
//			Gson gson = new Gson();
//			JsonParser jsonParser = new JsonParser();
//			JsonArray userArray = jsonParser.parse(json).getAsJsonArray();
//			UserBean2 userObj = gson.fromJson(userArray.get(0), UserBean2.class);
//			
//			if (userObj != null){
//				session.setAttribute("user_id", userObj.getID());
//				session.setAttribute("username", userObj.getUsername());
//				session.setAttribute("role", userObj.getRole());
//				
//				/* Creating cookies */
//				Cookie idCookie = new Cookie("user_id", String.valueOf(userObj.getID()));
//				Cookie usernameCookie = new Cookie("username", userObj.getUsername());
//				idCookie.setMaxAge(60 * 60 * 24 * 30);
//				usernameCookie.setMaxAge(60 * 60 * 24 * 30);
//				
//				/* Adding cookies to response */
//				response.addCookie(idCookie);
//				response.addCookie(usernameCookie);
//				if (request.getAttribute("register") == null) {
//					response.sendRedirect("login");
//				} else {
//					response.sendRedirect("card");
//				}

			
			
			/**PORT*/
			
			
			/**old*/
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE username='" + username + "' and password='" + password + "' LIMIT 1");
			if (rs.next()) {
				session.setAttribute("user_id", rs.getInt("id"));
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("role", rs.getString("role"));
				
				/* Creating cookies */
				Cookie idCookie = new Cookie("user_id", rs.getString("id"));
				Cookie usernameCookie = new Cookie("username", rs.getString("username"));
				idCookie.setMaxAge(60 * 60 * 24 * 30);
				usernameCookie.setMaxAge(60 * 60 * 24 * 30);
				
				/* Adding cookies to response */
				response.addCookie(idCookie);
				response.addCookie(usernameCookie);
				if (request.getAttribute("register") == null) {
					response.sendRedirect("login");
				} else {
					response.sendRedirect("card");
				}
 
			/**old*/
			}else {
				response.sendRedirect("index?login=gagal");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
