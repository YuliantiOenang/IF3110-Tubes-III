package com.frexesc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getAttribute("ref") != null) {
			response.sendRedirect("index");
		} else {
			/* Emptying session */
			HttpSession session = request.getSession();
			session.setAttribute("user_id", null);
			session.setAttribute("username", null);
			session.setAttribute("role", null);
			session.invalidate();

			/* Emptying cookie */
			Cookie idCookie = new Cookie("user_id", null);
			Cookie usernameCookie = new Cookie("username", null);
			idCookie.setMaxAge(0);
			usernameCookie.setMaxAge(0);
			response.addCookie(idCookie);
			response.addCookie(usernameCookie);

			request.setAttribute("ref", "y");

			getServletContext().getRequestDispatcher("/logout").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Emptying session */
		doGet(request, response);
	}

}
