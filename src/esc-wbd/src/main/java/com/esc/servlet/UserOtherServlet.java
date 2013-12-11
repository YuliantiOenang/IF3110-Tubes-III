package com.esc.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.esc.util.DbConnection;
import com.esc.util.JSONMessage;
import com.google.gson.GsonBuilder;

public class UserOtherServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONMessage jsonMessage = null;
		if (req.getParameter("action").equals("login")) {
			String username = (String)req.getParameter("username");
			String password = (String)req.getParameter("password");
			String selectQuery = "SELECT * FROM \"user\" WHERE username='" + username + "' AND password='" + password + "' LIMIT 1";
			try {
				Statement stmt = DbConnection.getConnection().createStatement();
				ResultSet rs = stmt.executeQuery(selectQuery);
				if (rs.next()) {
					jsonMessage = new JSONMessage(200, "login,"+rs.getString("id"));
					HttpSession session = req.getSession(true);
					session.setAttribute("id", rs.getString("id"));
					session.setAttribute("role", rs.getString("role"));
				} else {
					jsonMessage = new JSONMessage(200, "failed");
				}
			} catch (Exception e) {
				jsonMessage = new JSONMessage(500);
				e.printStackTrace();
			}
		} else if (req.getParameter("action").equals("check")) {
			String method = (String)req.getParameter("method");
			String value = (String)req.getParameter("value");
			String selectQuery = "SELECT " + method + " FROM \"user\" WHERE " + method + "='" + value + "' LIMIT 1";
			try {
				Statement stmt = DbConnection.getConnection().createStatement();
				ResultSet rs = stmt.executeQuery(selectQuery);
				if (rs.next()) {
					jsonMessage = new JSONMessage(200, "unavailable");
				} else {
					jsonMessage = new JSONMessage(200, "available");
				}
			} catch (Exception e) {
				jsonMessage = new JSONMessage(500);
				e.printStackTrace();
			}
		}
		resp.getWriter().print(new GsonBuilder().setPrettyPrinting().create().toJson(jsonMessage));
	}
}
