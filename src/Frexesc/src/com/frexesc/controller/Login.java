package com.frexesc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frexesc.model.UserBean;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username;
		String password;
		if (request.getAttribute("register") == null) {
			username = request.getParameter("username");
			password = request.getParameter("password");
		} else {
			username = (String) request.getAttribute("username");
			password = (String) request.getAttribute("password");
		}
		HttpSession session = request.getSession(true);

		try {
			String resp = HttpRequest.sendGet("/other?action=login&username=" + username + "&password=" + password);
			String status = new JsonParser().parse(resp).getAsJsonObject().get("detail").getAsString();
			if (status.contains("login")) {
				String[] splits = status.split(",");
				
				String uresp = HttpRequest.sendGet("/user?id=" + splits[1]);
				UserBean userBean = new Gson().fromJson(new JsonParser().parse(uresp).getAsJsonObject().get("content").getAsJsonObject(), UserBean.class);
				
				session.setAttribute("user_id", userBean.getId() + "");
				session.setAttribute("username", userBean.getUsername());
				session.setAttribute("role", userBean.getRole() + "");

				/* Creating cookies */
				Cookie idCookie = new Cookie("user_id", userBean.getId()+"");
				Cookie usernameCookie = new Cookie("username", userBean.getUsername());
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
			} else {
				response.sendRedirect("index?login=gagal");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
