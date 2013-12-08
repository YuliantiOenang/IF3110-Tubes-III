package apiController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class TransactionProcess
 */
//@WebServlet("/api/transaction")
public class TransactionProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA = new DatabaseAdapter();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			response.setContentType("application/json");
			response.setHeader("Access-Control-Allow-Origin", "*");
			String signal = request.getParameter("signal");
			if (signal.equals("selesai"))
			{
				String IDUser = request.getParameter("IDUser");
				DBA.insertQuery("update account set transaksi = transaksi + 1 where id = " + IDUser);
			}
			else
			{
				String ID = request.getParameter("IDBarang");
				String Stok = request.getParameter("stok");
				String Query = "update barang set stok = stok - "+Stok+" where id = " + ID;
				DBA.insertQuery(Query);
				System.out.println(Query);
			}
			JSONObject json = new JSONObject();
			json.put("content", "sesuatu");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			out.close();
		}catch (Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
