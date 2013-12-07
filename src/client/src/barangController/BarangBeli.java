package barangController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;


/**
 * Servlet implementation class BarangBeli
 */
@WebServlet("/barang/beli")
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
		//Debug agar ridho punya library
		try
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
//				System.out.println(id_barang + " " + exist);
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
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			json.put("content", "OKE");
			out.write(json.toString());
			out.close();
		}catch (Exception e){}
	}

}
