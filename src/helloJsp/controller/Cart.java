package helloJsp.controller;

import helloJsp.object.Item;
import helloJsp.object.ShoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/Cart")
public class Cart extends HttpServlet {

	public Cart() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int quantity = 0, idItem = 0, stock = 0, price = 0, type = 0;
		String desc = "";

		type = Integer.parseInt(request.getParameter("type"));
		String sresponse = request.getParameter("json");
		if (sresponse.charAt(0) == '\''){
			sresponse = sresponse.substring(1, sresponse.length()-1);
		}
		
		ShoppingCart sc = new ShoppingCart();
		if (type == 3) {
			try {
			JSONObject jobj = new JSONObject(sresponse);
			System.out.println("local jobj = "+jobj.toString());
			JSONArray j2 = jobj.getJSONArray("items");
			System.out.println("local j2 = "+j2.toString());
			sc = new ShoppingCart();
			for (int i=0; i<j2.length(); i++){
				JSONObject json = j2.getJSONObject(i);
				//Item barang = new Item();
				Item barang = new Item(json.getInt("quantity"),json.getInt("idItem"),json.getInt("price"),json.getString("description"));
				//barang.setIdItem(json.getInt("idItem"));
				//barang.setQuantity(json.getInt("quantity"));
				//barang.setPrice(json.getInt("price"));
				//barang.setDescription(json.getString("description"));
				sc.getItems().add(barang);
			}
			} catch (JSONException e){
				out.println(-1);
			}
			boolean transactionFinished = false;
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for (int i = 0; i < sc.getItems().size(); i++) {
					// syntax
					DbConnector dbconnector = new DbConnector();
					Connection connection = dbconnector.mySqlConnection();
					try {
						Statement statement = connection.createStatement();
						String query = "SELECT * FROM inventori WHERE id_inventori=" + sc.getItems().get(i).getIdItem();
						ResultSet rs = statement.executeQuery(query);

						if (rs.next()) {
							Integer jumlah = Integer.parseInt(rs.getString("jumlah"));
							if (jumlah >= sc.getItems().get(i).getQuantity()) {
								query = "UPDATE inventori SET jumlah =" + (jumlah - sc.getItems().get(i).getQuantity()) + " WHERE id_inventori=" + sc.getItems().get(i).getIdItem();
								statement.executeUpdate(query);

								arr.add(i);
							} else {
								break;
							}
						} else {
							break;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						out.println(-1);
						e.printStackTrace();
					}
					String query = "";
					if (i == sc.getItems().size() - 1)
						transactionFinished = true;
				}
				if (!transactionFinished) {
					for (int j = 0; j < arr.size(); j++) {
						sc.getItems().remove(arr.get(j));
					}
				}
				if (transactionFinished) {
					String query = "";
					DbConnector dbconnector = new DbConnector();
					Connection connection = dbconnector.mySqlConnection();
					Statement statement2;
					
					String username = "genta";
					query = "SELECT * FROM pengguna WHERE username = '" + username + "';";
					
					ResultSet rs;
					try {
						statement2 = connection.createStatement();
						rs = statement2.executeQuery(query);
						if (rs.next()) {
							Integer total_transaksi = Integer.parseInt(rs.getString("total_transaksi"));
							query = "UPDATE pengguna SET total_transaksi = " + (total_transaksi + 1) + " WHERE username = '" + username + "';";
							statement2.executeUpdate(query);
							out.println(1);
						} else{
							out.println(0);
						}
						out.println(1);
					} catch (Exception X) {
						out.println(-1);
					}
				} else
					out.println(0);
			} else {
				out.println(-1);
			}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
