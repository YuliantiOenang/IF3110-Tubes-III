package barangController;

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class DetailBarang
 */
@WebServlet("/barang/detail")
public class DetailBarang extends HttpServlet {
	//Debug agar ridho punya library
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailBarang() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			String detail = request.getParameter("id");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			if (detail == null)
			{
				json.put("status", false);
			}
			else
			{
				Barang B = new Barang(DBA);
				B.executeQuery("select * from barang where id="+detail);
				json.put("status", false);
				json.put("id", B.id.get(0));
				json.put("nama", B.nama.get(0));
				json.put("stok", B.stok.get(0));
				json.put("harga", B.harga.get(0));
				json.put("keterangan", B.keterangan.get(0));
			}
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
