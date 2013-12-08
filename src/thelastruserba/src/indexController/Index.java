package indexController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javaModel.Barang;
import javaModel.Helper;
import javaModel.Kategori;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

//URL MAP : /index
/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA = new DatabaseAdapter();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		try
		{
			JSONObject json = new JSONObject();
			Kategori K = Helper.findAllKategori();
			for(int i = 0; i < K.id.size(); i++) {
				String q = "select * from barang where id_kategori = "+K.id.get(i)+" order by counter desc limit 0, 4";
				Barang B = new Barang(DBA);
				B.executeQuery(q);
				//topbarangs.put(Integer.parseInt(K.id.get(i)), B);
				JSONArray jsonarray = new JSONArray();
				for (int j = 0; j < B.id.size(); j++) {
					JSONObject type = new JSONObject();
					type.put("id", B.id.get(j));
					type.put("nama", B.nama.get(j));
					type.put("harga", B.harga.get(j));
					type.put("gambar", B.gambar.get(j));
					jsonarray.put(type);
				}
				json.put(K.nama_kategori.get(i),jsonarray);
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
