package userController;

import java.io.IOException;
import java.io.PrintWriter;
import javaModel.Profile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseAdapter DBA = new DatabaseAdapter();
    
    public ProfileController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		System.out.println(username);
		String q = "select * from account where username = '" + username  + "' limit 1";
		Profile P = new Profile(DBA);
		P.executeQuery(q);
		String result = null;
		try {
			JSONObject json = new JSONObject().put("nama_lengkap", P.nama.get(0));
			json.put("username", P.username.get(0));
			json.put("email", P.email.get(0));
			json.put("provinsi", P.provinsi.get(0));
			json.put("kota", P.kota.get(0));
			json.put("no_telp", P.telepon.get(0));
			json.put("alamat", P.alamat.get(0));
			json.put("kode_pos", P.kodepos.get(0));
			json.put("transaksi", P.transaksi.get(0));
			result = json.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.print(result);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
