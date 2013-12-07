package com.frexescwebservice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static String hostname = "http://ruko.ap01.aws.af.cm/";
       
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
		String vcapServices = java.lang.System.getenv("VCAP_SERVICES");
		PrintWriter out = response.getWriter();
		out.print(vcapServices);
		
		HttpSession session = request.getSession(true);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE username='" + username + "' and password='" + password + "' LIMIT 1");
			if (rs.next()) {
				session.setAttribute("user_id", rs.getInt("id"));
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("role", rs.getString("role"));
				//RequestDispatcher dispatcher;
				//dispatcher = getServletContext().getRequestDispatcher("/masuk.jsp");
				//dispatcher.forward(request, response);
			} else {
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
