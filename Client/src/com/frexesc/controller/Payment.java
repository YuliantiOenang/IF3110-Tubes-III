package com.frexesc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
 * 
 * Servlet implementation class Payment
 * 
 */
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Payment() {
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
		HttpSession session = request.getSession();

		if (session.getAttribute("username") == null) {
			response.sendRedirect("../register");
		} else {
			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.mySqlConnection();

			/**port*/
			WebServicesKit webkit = new WebServicesKit();
			String json;
			try {
				json = webkit.readUrl("http://localhost:8080/web-services/UserService/userservice/user/"+ session.getAttribute("user_id"));
				Gson gson = new Gson();
				JsonParser jsonParser = new JsonParser();
				JsonArray userArray = jsonParser.parse(json).getAsJsonArray();


			ArrayList<UserBean2> arr_user2 = new ArrayList<UserBean2>();
			for (JsonElement user : userArray)
			{
				UserBean2 userObj = gson.fromJson(user, UserBean2.class);
				arr_user2.add(userObj);
				System.out.println("1.payment-userobj"+userObj.getNacard());
			}
			try {
				int i = 0;
				while (i < arr_user2.size()) {
					if (arr_user2.get(i).getNocard() == null) {
				
			/**port*/
			
			/**old*/
//			String query = "SELECT * FROM user WHERE id="
//					+ session.getAttribute("user_id");
//
//			try {
//				ResultSet rs = connection.createStatement().executeQuery(query);
//
//				while (rs.next()) {
//					if (rs.getString("nomor_kartu") == null) {
			/**old*/
						/** Redirect to Credit Card page */
						response.sendRedirect("../card?from=payment");
					} else {

												// Update status
//						String query2 = "UPDATE barang_user SET status=1 WHERE id_user="
//								+ session.getAttribute("user_id");
//						connection.createStatement().executeUpdate(query2);

						//POST
						String[] param = {"id"};
						String[] val= {"" + session.getAttribute("user_id")};
						ServiceParser.postUrl(ServiceParser.BASE_URL + "BarangUserService/baranguserService/statusbaranguser",param, val);
						
						/**port*/

							json = webkit.readUrl("http://localhost:8080/web-services/UserService/userservice/user/"+ session.getAttribute("user_id"));
							gson = new Gson();
							jsonParser = new JsonParser();
							userArray = jsonParser.parse(json).getAsJsonArray();
							
						arr_user2 = new ArrayList<UserBean2>();
						for (JsonElement user : userArray)
						{
							UserBean2 userObj = gson.fromJson(user, UserBean2.class);
							arr_user2.add(userObj);
							System.out.println("2.payment debug-city"+userObj.getCity());
						}
						String query4 = "UPDATE user SET transaksi="
								+ arr_user2.get(0).getTransaction() + 1
								+ " WHERE id="
								+ session.getAttribute("user_id");
						connection.createStatement().executeUpdate(query4);

						//POST
						//String[] params = {"num", "id"};
						//String[] value= {"" + (Integer.parseInt(rs3.getString("transaksi")) + 1), "" + session.getAttribute("user_id")};
						//ServiceParser.postUrl(ServiceParser.BASE_URL + "UserService/userservice/updatetrans",params, value);
						
						
							
						/**port*/
						
						/**old*/
//						// Update number of transaction
//						String query3 = "SELECT * FROM user WHERE id="
//								+ session.getAttribute("user_id");
//						ResultSet rs3 = connection.createStatement()
//								.executeQuery(query3);
//						rs3.next();
//
//						
//						
//						String query4 = "UPDATE user SET transaksi="
//								+ (Integer.parseInt(rs3.getString("transaksi")) + 1)
//								+ " WHERE id="
//								+ session.getAttribute("user_id");
//						connection.createStatement().executeUpdate(query4);
						/**old*/
						

						
						
						request.setAttribute("response", "Transaksi berhasil!");

						RequestDispatcher dispatcher;
						dispatcher = getServletContext().getRequestDispatcher("/barang/payment.jsp");
						dispatcher.forward(request, response);

						// redirect to gallery

					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
