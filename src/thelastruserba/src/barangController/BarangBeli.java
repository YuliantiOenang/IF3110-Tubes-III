package barangController;

//URL MAP : /barang/beli
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;


/**
 * Servlet implementation class BarangBeli
 */

public class BarangBeli extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarangBeli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String id_barang = request.getParameter("id_barang");
		String jumlah = request.getParameter("jumlah");
		String keterangan = request.getParameter("keterangan");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		//Debug agar ridho punya library
		try
		{
			PrintWriter out = response.getWriter();
			if (session.getAttribute("isLogin")!=null)
			{
				if (session.getAttribute("dibeli")==null) {
					ArrayList<String> dibeli = new ArrayList<>();
					dibeli.add(id_barang);
					session.setAttribute("dibeli", dibeli);
					session.setAttribute(id_barang, jumlah);				
				} else {				
					ArrayList<String> dibeli = (ArrayList<String>) session.getAttribute("dibeli");
					boolean exist = false;
					for (int i = 0; i < dibeli.size (); i ++) 
						if (dibeli.get(i).equals(id_barang)) {
							exist = true;
							break;
						}

					if (exist) {
						Integer jml = Integer.parseInt((String)session.getAttribute(id_barang));
						int jml2 = 0;
						for (int i = 0; i < jumlah.length(); i ++)
							jml2 = jml2 * 10 + (int) (jumlah.charAt(i) - '0');
						jml += jml2;
						session.setAttribute(id_barang,jml+"");
					} else {
						session.setAttribute(id_barang,jumlah);
						dibeli.add(id_barang);
						session.setAttribute("dibeli",dibeli);
					}
				}
				JSONObject json = new JSONObject();
				json.put("content", "OKE");
				out.write(json.toString());
			}
			else
			{
				JSONObject json = new JSONObject();
				json.put("content", "LOGIN");
				out.write(json.toString());
			}
			out.close();
		}catch (Exception e){}
	}

}
