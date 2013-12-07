package com.frexesc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.frexesc.model.KategoriBean;
import com.frexesc.model.UserBean;
import com.frexesc.service.WebService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = "http://ruko.ap01.aws.af.cm/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username;
		String password;
		PrintWriter out = response.getWriter();
		if (request.getAttribute("register") == null) {
			username = request.getParameter("username");
			password = request.getParameter("password");
		} else {
			username = (String)request.getAttribute("username");
			password = (String)request.getAttribute("password");
		}
		//DbConnection dbConnection = new DbConnection();
		//Connection connection = dbConnection.mySqlConnection();
		
		/** Set WebService (REST) for retrieving list of User */
		WebService _user = new WebService(hostname + "user");
		_user.addParam("action", "login");
		_user.addParam("username", username);
		_user.addParam("password", password);
		_user.addHeader("GData-Version", "2");

		HttpSession session = request.getSession(true);
		
		try {
			_user.execute(WebService.REQUEST_METHOD.POST);
			String user = _user.getResponse();
			out.println(user);
			out.println("jamban");
			JSONParser parser = new JSONParser();
			JSONObject mainJSON = null;
			try {
				mainJSON = (JSONObject) parser.parse(user);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (mainJSON.get("status").toString().equals("true")) {
				JSONObject data = (JSONObject) mainJSON.get("data"); // Get
				
				session.setAttribute("user_id", data.get("id"));
				session.setAttribute("username", data.get("username"));
				session.setAttribute("role", data.get("role"));
				
				out.println(data.get("id"));
				out.println(data.get("username"));
				out.println(data.get("role"));
				
				/* Creating cookies */
				Cookie idCookie = new Cookie("user_id", data.get("id").toString());
				Cookie usernameCookie = new Cookie("username", (String) data.get("username"));
				Cookie roleCookie = new Cookie ("role", data.get("role").toString());
				idCookie.setMaxAge(60 * 60 * 24 * 30);
				usernameCookie.setMaxAge(60 * 60 * 24 * 30);
				roleCookie.setMaxAge(60 * 60 * 24 * 30);
				
				/* Adding cookies to response */
				response.addCookie(idCookie);
				response.addCookie(usernameCookie);
				response.addCookie(roleCookie);
				if (request.getAttribute("register") == null) {
					response.sendRedirect("login");
				} else {
					response.sendRedirect("card");
				}
		} else 
			response.sendRedirect("index?login=gagal");

//		try {
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE username='" + username + "' and password='" + password + "' LIMIT 1");
//			if (rs.next()) {
//				session.setAttribute("user_id", rs.getInt("id"));
//				session.setAttribute("username", rs.getString("username"));
//				session.setAttribute("role", rs.getString("role"));
//				
//				/* Creating cookies */
//				Cookie idCookie = new Cookie("user_id", rs.getString("id"));
//				Cookie usernameCookie = new Cookie("username", rs.getString("username"));
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
//			} else {
//				response.sendRedirect("index?login=gagal");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
