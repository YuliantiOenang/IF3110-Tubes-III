package userController;

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Helper;
import javaModel.Profile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class ProfilEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseAdapter DBA = new DatabaseAdapter();

	public ProfilEditController() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = Helper.getUserLogged(request.getSession());
		if (username.isEmpty()) {
			response.sendRedirect("/ruserba/register");
			return;
		}
		String q = "select * from account where username = '" + username  + "' limit 1";
		Profile P = new Profile(DBA);
		P.executeQuery(q);
		String result = null;
		try {
			JSONObject json = new JSONObject().put("nama", P.nama.get(0));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(result);
		out.close();
//		request.setAttribute("profile", P);
//		request.setAttribute("includeJspContent", "profile_edit.jsp");
//		request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = Helper.getUserLogged(request.getSession());
		String prof_nama = request.getParameter("prof_nama");
		String prof_password = request.getParameter("prof_password");
		String prof_alamat = request.getParameter("prof_alamat");
		String prof_provinsi = request.getParameter("prof_provinsi");
		String prof_kota = request.getParameter("prof_kota");
		String prof_kodepos = request.getParameter("prof_kodepos");
		String prof_telepon = request.getParameter("prof_telepon");

		String Query = "UPDATE account SET nama = '"+prof_nama+"', alamat = '"+prof_alamat+"', provinsi = '"+prof_provinsi+"', kota = '"+prof_kota+"', kodepos = '"+prof_kodepos+"', telepon = '"+prof_telepon+"'";
		
		if (!prof_password.isEmpty()) Query += ", password = '"+prof_password+"'";
        
        Query += " WHERE username = '" + username + "'";
        DBA.insertQuery(Query);
        response.sendRedirect("/ruserba/profile");
	}

}
