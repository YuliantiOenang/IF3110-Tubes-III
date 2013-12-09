package transactionController;

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;


/**
 * Servlet implementation class UpdateCart
 */
@WebServlet("/cart/update")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static DatabaseAdapter DBA = new DatabaseAdapter();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String idBarang = request.getParameter("id");
		
		Barang B = new Barang (DBA);
		B.executeQuery("select * from barang where id = "+idBarang);
		Integer stok = Integer.parseInt(B.stok.get(0));
		String value = request.getParameter("value");
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		
		if (Integer.parseInt(value) > stok)
		{
			try {
				json.put("status", false);
				json.put("stok", stok);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write(json.toString());
			out.close();
		}
		else
		{
			session.setAttribute(idBarang, value);
			response.setContentType("application/json");
			try {
				json.put("status", true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write(json.toString());
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
