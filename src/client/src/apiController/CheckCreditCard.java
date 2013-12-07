package apiController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class CheckCreditCard
 */
@WebServlet("/api/checkCreditCard")
public class CheckCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCreditCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String credit_number = request.getParameter("credit_number");
		String name_of_card = request.getParameter("name_of_card");
		DatabaseAdapter DBA = new DatabaseAdapter();
		String query = "select * from kredit where card_number = '" + credit_number + "' or name_of_card = '" + name_of_card + "' limit 1";
		DBA.executeQuery(query);
		ResultSet RS = DBA.getQueryResult();
		try {
			if (!RS.isBeforeFirst()) {
				JSONObject json = new JSONObject();
				json.put("success", true);
				out.write(json.toString());
			} else {
				JSONObject json = new JSONObject();
				json.put("success", false);
				json.put("error", "Card Number atau Name of Card sudah dipakai");
				out.write(json.toString());
			}
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
