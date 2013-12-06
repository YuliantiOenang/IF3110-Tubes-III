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

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		PrintWriter out = response.getWriter();
		
		String value = request.getParameter("value");
		String method = request.getParameter("method");
		System.out.println(value + " " + method);
		try {
			if (method.equals("number")) {
				String query = "SELECT nomor_kartu FROM user WHERE nomor_kartu='" + value + "' LIMIT 1";
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				if (rs.next()) {
					out.print(method + " has been taken!");
				} else {
					out.print(method + " is available.");
				}
			} else if (method.equals("name")) {
				String query = "SELECT nama_kartu FROM user WHERE nama_kartu='" + value + "' LIMIT 1";
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				if (rs.next()) {
					out.print(method + " has been taken!");
				} else {
					out.print(method + " is available.");
				}
			} else {
				String query = "SELECT "+ method + " FROM user WHERE " + method + "='" + value + "' LIMIT 1";
				System.out.println(query);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				if (rs.next()) {
					out.print(method + " has been taken!");
					System.out.println(method + " has been taken!");
				} else {
					out.print(method + " is available.");
					System.out.println(method + " has been taken!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
