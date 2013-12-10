package com.frexesc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.frexesc.Constants;
import com.frexesc.service.WebService;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hostname = Constants.HOSTNAME;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Validate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.mySqlConnection();
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		String value = request.getParameter("value");
		String method = request.getParameter("method");
		System.out.println(value + " " + method);
		
		/** Set WebService (REST) for retrieving list of User */
		WebService _user = new WebService(hostname + "user");
		_user.addParam("action", "validate");
		_user.addParam("method", method);
		_user.addParam("value", value);
		_user.addHeader("GData-Version", "2");

		try {
			_user.execute(WebService.REQUEST_METHOD.POST);
			String user = _user.getResponse();
			JSONParser parser = new JSONParser();
			JSONObject mainJSON = null;
			
			try {
				mainJSON = (JSONObject) parser.parse(user);
				out.print(mainJSON.get("status").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
