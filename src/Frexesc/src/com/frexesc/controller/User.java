package com.frexesc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.esc.soap.SoapServiceProxy;
import com.frexesc.model.UserBean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession(true).getAttribute("user_id") == null) {
			response.sendRedirect("register");
		} else {
			if (request.getParameter("action") == null) {
				String id = request.getParameter("id");
				try {
					String resp = HttpRequest.sendGet("user?id=" + id);
					JsonElement jsonElement = new JsonParser().parse(resp);
					UserBean userBean = new Gson().fromJson(jsonElement.getAsJsonObject().get("content"), UserBean.class);
					request.setAttribute("user", userBean);
					request.setAttribute("id", id);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				String id = request.getParameter("id");
				try {
					String resp = HttpRequest.sendGet("user?id=" + id);
					JsonElement jsonElement = new JsonParser().parse(resp);
					UserBean userBean = new Gson().fromJson(jsonElement.getAsJsonObject().get("content"), UserBean.class);
					request.setAttribute("user", userBean);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editprofile.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String password = request.getParameter("password1");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String postal = request.getParameter("postal");
		if (action.equals("register")) {
			String username = request.getParameter("username");
			SoapServiceProxy ssp = new SoapServiceProxy();
			ssp.createUser(0, username, password, telephone, address, province, city, postal, email, 0, name, null, null, null, 0);
			//String insertQuery = "INSERT INTO user (nama, username, password, email, handphone, alamat, kota, provinsi, kodepos) VALUES ('" + name + "','" + username + "','" + password + "','" + email + "','" + telephone + "','" + address + "','" + city + "','" + province + "','" + postal + "')";
			try {
				//Statement statement = connection.createStatement();
				//statement.executeUpdate(insertQuery);
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("register", "y");
			} catch (Exception e) {
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/login").forward(request, response);
		} else if (action.equals("edit")) {
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("action", "profil"));
				params.add(new BasicNameValuePair("password", password));
				params.add(new BasicNameValuePair("email", email));
				params.add(new BasicNameValuePair("name", name));
				params.add(new BasicNameValuePair("telephone", telephone));
				params.add(new BasicNameValuePair("address", address));
				params.add(new BasicNameValuePair("province", province));
				params.add(new BasicNameValuePair("city", city));
				params.add(new BasicNameValuePair("postal", postal));
				HttpRequest.sendPut("/user", params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("user?id=" + request.getSession(true).getAttribute("user_id"));
		}
	}
}
